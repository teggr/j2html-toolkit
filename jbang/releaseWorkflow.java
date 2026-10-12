///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class releaseWorkflow {

    private static final String SETTINGS_NAMESPACE = "http://maven.apache.org/SETTINGS/1.2.0";

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Usage: jbang releaseWorkflow.java configure-settings | determine-release-version");
        }
        switch (args[0]) {
            case "configure-settings" -> configureSettings();
            case "determine-release-version" -> determineReleaseVersion();
            default -> throw new IllegalArgumentException("Unknown release workflow action: " + args[0]);
        }
    }

    private static void configureSettings() throws Exception {
        String username = requireEnvironment("CENTRAL_USERNAME");
        String password = requireEnvironment("CENTRAL_PASSWORD");
        Path settingsPath = Path.of(System.getProperty("user.home"), ".m2", "settings.xml");
        Files.createDirectories(settingsPath.getParent());

        Document document = Files.exists(settingsPath)
                ? parseXml(settingsPath)
                : newSettingsDocument();
        Element root = document.getDocumentElement();
        String namespace = root.getNamespaceURI();
        Element servers = ensureChild(root, "servers", namespace);
        Element server = findServer(servers, namespace);
        setChildText(server, "username", username, namespace);
        setChildText(server, "password", password, namespace);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        var transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(document), new StreamResult(settingsPath.toFile()));
    }

    private static void determineReleaseVersion() throws Exception {
        String snapshotVersion = childText(parseXml(Path.of("pom.xml")).getDocumentElement(), "version");
        String suffix = "-SNAPSHOT";
        if (snapshotVersion == null || !snapshotVersion.endsWith(suffix)) {
            throw new IllegalStateException("The root POM version must end in -SNAPSHOT.");
        }
        String outputPath = requireEnvironment("GITHUB_OUTPUT");
        Files.writeString(Path.of(outputPath), "release=" + snapshotVersion.substring(0,
                        snapshotVersion.length() - suffix.length()) + System.lineSeparator(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    private static String requireEnvironment(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Required environment variable is missing: " + name);
        }
        return value;
    }

    private static Document newSettingsDocument() throws Exception {
        Document document = newDocument();
        Element settings = document.createElementNS(SETTINGS_NAMESPACE, "settings");
        settings.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns", SETTINGS_NAMESPACE);
        document.appendChild(settings);
        return document;
    }

    private static Element findServer(Element servers, String namespace) {
        for (Element server : childElements(servers, "server")) {
            if ("central".equals(childText(server, "id"))) {
                return server;
            }
        }
        Element server = createElement(servers.getOwnerDocument(), "server", namespace);
        Element id = createElement(servers.getOwnerDocument(), "id", namespace);
        id.setTextContent("central");
        server.appendChild(id);
        servers.appendChild(server);
        return server;
    }

    private static Element ensureChild(Element parent, String name, String namespace) {
        for (Element child : childElements(parent, name)) {
            return child;
        }
        Element child = createElement(parent.getOwnerDocument(), name, namespace);
        parent.appendChild(child);
        return child;
    }

    private static void setChildText(Element parent, String name, String value, String namespace) {
        Element child = ensureChild(parent, name, namespace);
        child.setTextContent(value);
    }

    private static Element createElement(Document document, String name, String namespace) {
        return namespace == null || namespace.isBlank()
                ? document.createElement(name)
                : document.createElementNS(namespace, name);
    }

    private static List<Element> childElements(Element parent, String name) {
        List<Element> elements = new ArrayList<>();
        for (Node node = parent.getFirstChild(); node != null; node = node.getNextSibling()) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (name.equals(element.getLocalName())) {
                    elements.add(element);
                }
            }
        }
        return elements;
    }

    private static String childText(Element parent, String name) {
        List<Element> elements = childElements(parent, name);
        return elements.isEmpty() ? null : elements.get(0).getTextContent().trim();
    }

    private static Document parseXml(Path path) throws Exception {
        var factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        return factory.newDocumentBuilder().parse(path.toFile());
    }

    private static Document newDocument() throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    }
}
