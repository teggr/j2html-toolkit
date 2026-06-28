///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 21

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class j2htmlInit {

    private static final String GROUP_ID = "dev.rebelcraft";
    private static final String BOM_ARTIFACT_ID = "j2html-extensions-bom";
    private static final List<String> DEFAULT_ARTIFACTS = List.of(
            "j2html-extensions-spring-boot-starter",
            "bootstrap-j2html-extension",
            "htmx-j2html-extension"
    );
    private static final String FALLBACK_VERSION = "0.0.3";

    public static void main(String[] args) throws Exception {
        Options options = Options.parse(args);
        if (options.help) {
            printUsage();
            return;
        }

        Path pomPath = Path.of(options.pomPath).toAbsolutePath().normalize();
        if (!Files.exists(pomPath)) {
            System.err.println("pom.xml not found: " + pomPath);
            System.exit(1);
        }

        boolean confirmed = options.yes;
        if (!options.yes && !options.no) {
            confirmed = promptForConfirmation(pomPath);
        }

        if (!confirmed || options.no) {
            System.out.println("No changes made.");
            return;
        }

        String version = options.version;
        if (version == null || version.isBlank()) {
            version = findLatestBomVersion();
        }

        if (version == null || version.isBlank()) {
            System.err.println("Unable to determine j2html-toolkit BOM version.");
            System.exit(1);
        }

        Document document = parsePom(pomPath);
        boolean changed = upsertDependencies(document, version);
        if (changed) {
            writePom(document, pomPath);
            System.out.println("Updated " + pomPath);
        } else {
            System.out.println("No dependency changes required for " + pomPath);
        }
    }

    private static boolean promptForConfirmation(Path pomPath) {
        String question = "Add the latest j2html libraries to " + pomPath + "? [y/N]: ";
        System.out.print(question);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
        return "y".equals(input) || "yes".equals(input);
    }

    private static Document parsePom(Path pomPath) throws Exception {
        DocumentBuilderFactory factory = newSecureDocumentBuilderFactory(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(Files.newInputStream(pomPath));
        document.getDocumentElement().normalize();
        return document;
    }

    private static boolean upsertDependencies(Document document, String version) {
        Element project = document.getDocumentElement();
        String namespace = project.getNamespaceURI();
        boolean changed = false;

        Element dependencyManagement = ensureDirectChild(project, "dependencyManagement", namespace);
        Element managedDependencies = ensureDirectChild(dependencyManagement, "dependencies", namespace);
        Element bomDependency = ensureDependency(managedDependencies, GROUP_ID, BOM_ARTIFACT_ID, namespace);
        changed |= upsertTextChild(bomDependency, "version", version, namespace);
        changed |= upsertTextChild(bomDependency, "type", "pom", namespace);
        changed |= upsertTextChild(bomDependency, "scope", "import", namespace);

        Element dependencies = ensureDirectChild(project, "dependencies", namespace);
        for (String artifact : DEFAULT_ARTIFACTS) {
            if (!hasDependency(dependencies, GROUP_ID, artifact)) {
                ensureDependency(dependencies, GROUP_ID, artifact, namespace);
                changed = true;
            }
        }

        return changed;
    }

    private static Element ensureDependency(Element dependencies, String groupId, String artifactId, String namespace) {
        for (Element dependency : directChildren(dependencies, "dependency")) {
            String existingGroupId = getDirectChildText(dependency, "groupId");
            String existingArtifactId = getDirectChildText(dependency, "artifactId");
            if (groupId.equals(existingGroupId) && artifactId.equals(existingArtifactId)) {
                return dependency;
            }
        }
        Element dependency = createElement(dependencies.getOwnerDocument(), "dependency", namespace);
        dependency.appendChild(createTextElement(dependencies.getOwnerDocument(), "groupId", groupId, namespace));
        dependency.appendChild(createTextElement(dependencies.getOwnerDocument(), "artifactId", artifactId, namespace));
        dependencies.appendChild(dependency);
        return dependency;
    }

    private static boolean hasDependency(Element dependencies, String groupId, String artifactId) {
        for (Element dependency : directChildren(dependencies, "dependency")) {
            String existingGroupId = getDirectChildText(dependency, "groupId");
            String existingArtifactId = getDirectChildText(dependency, "artifactId");
            if (groupId.equals(existingGroupId) && artifactId.equals(existingArtifactId)) {
                return true;
            }
        }
        return false;
    }

    private static Element ensureDirectChild(Element parent, String localName, String namespace) {
        for (Element child : directChildren(parent, localName)) {
            return child;
        }
        Element created = createElement(parent.getOwnerDocument(), localName, namespace);
        parent.appendChild(created);
        return created;
    }

    private static List<Element> directChildren(Element parent, String localName) {
        List<Element> result = new ArrayList<>();
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Element element = (Element) node;
            String nodeLocalName = element.getLocalName() != null ? element.getLocalName() : element.getNodeName();
            if (localName.equals(nodeLocalName)) {
                result.add(element);
            }
        }
        return result;
    }

    private static String getDirectChildText(Element parent, String localName) {
        for (Element child : directChildren(parent, localName)) {
            return child.getTextContent().trim();
        }
        return null;
    }

    private static boolean upsertTextChild(Element parent, String localName, String value, String namespace) {
        for (Element child : directChildren(parent, localName)) {
            String existing = child.getTextContent();
            if (value.equals(existing)) {
                return false;
            }
            child.setTextContent(value);
            return true;
        }
        parent.appendChild(createTextElement(parent.getOwnerDocument(), localName, value, namespace));
        return true;
    }

    private static Element createElement(Document document, String localName, String namespace) {
        if (namespace != null && !namespace.isBlank()) {
            return document.createElementNS(namespace, localName);
        }
        return document.createElement(localName);
    }

    private static Element createTextElement(Document document, String localName, String value, String namespace) {
        Element element = createElement(document, localName, namespace);
        element.setTextContent(value);
        return element;
    }

    private static void writePom(Document document, Path pomPath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.transform(new DOMSource(document), new StreamResult(Files.newOutputStream(pomPath)));
    }

    private static String findLatestBomVersion() {
        List<String> metadataUrls = List.of(
                "https://repo1.maven.org/maven2/dev/rebelcraft/j2html-extensions-bom/maven-metadata.xml",
                "https://repo.maven.apache.org/maven2/dev/rebelcraft/j2html-extensions-bom/maven-metadata.xml"
        );

        for (String metadataUrl : metadataUrls) {
            try (InputStream stream = openStream(metadataUrl)) {
                String resolved = extractVersionFromMetadata(stream);
                if (resolved != null && !resolved.isBlank()) {
                    return resolved.trim();
                }
            } catch (Exception ex) {
                System.err.println("Warning: could not resolve metadata from " + metadataUrl + ": " + ex.getMessage());
            }
        }

        System.out.println("Could not resolve latest BOM version from Maven Central, using fallback " + FALLBACK_VERSION);
        return FALLBACK_VERSION;
    }

    private static InputStream openStream(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.connect();
        if (connection.getResponseCode() >= 400) {
            throw new IllegalStateException("Failed to fetch metadata from " + urlString);
        }
        return connection.getInputStream();
    }

    private static String extractVersionFromMetadata(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = newSecureDocumentBuilderFactory(false);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document metadata = builder.parse(inputStream);
        metadata.getDocumentElement().normalize();

        String release = textFromFirstTag(metadata, "release");
        if (release != null && !release.isBlank()) {
            return release;
        }

        String latest = textFromFirstTag(metadata, "latest");
        if (latest != null && !latest.isBlank()) {
            return latest;
        }

        NodeList versions = metadata.getElementsByTagName("version");
        if (versions.getLength() > 0) {
            return versions.item(versions.getLength() - 1).getTextContent().trim();
        }
        return null;
    }

    private static String textFromFirstTag(Document document, String tagName) {
        NodeList nodes = document.getElementsByTagName(tagName);
        if (nodes.getLength() == 0) {
            return null;
        }
        return nodes.item(0).getTextContent().trim();
    }

    private static DocumentBuilderFactory newSecureDocumentBuilderFactory(boolean namespaceAware)
            throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(namespaceAware);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        return factory;
    }

    private static void printUsage() {
        System.out.println("j2htmlInit - add/update j2html dependencies in a Maven pom.xml");
        System.out.println();
        System.out.println("Usage:");
        System.out.println("  jbang j2htmlInit.java [options]");
        System.out.println();
        System.out.println("Options:");
        System.out.println("  --pom <path>           Path to pom.xml (default: ./pom.xml)");
        System.out.println("  --version <version>    Explicit BOM version to use");
        System.out.println("  --yes, -y              Apply changes without prompting");
        System.out.println("  --no, -n               Do not apply changes");
        System.out.println("  --non-interactive      Require --yes or --no and skip prompt");
        System.out.println("  --help, -h             Show this help");
    }

    private static final class Options {
        private String pomPath = "pom.xml";
        private String version;
        private boolean yes;
        private boolean no;
        private boolean nonInteractive;
        private boolean help;

        private static Options parse(String[] args) {
            Options options = new Options();
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                switch (arg) {
                    case "--pom" -> {
                        options.pomPath = requireValue(args, i + 1, "--pom");
                        i++;
                    }
                    case "--version" -> {
                        options.version = requireValue(args, i + 1, "--version");
                        i++;
                    }
                    case "--yes", "-y" -> options.yes = true;
                    case "--no", "-n" -> options.no = true;
                    case "--non-interactive" -> options.nonInteractive = true;
                    case "--help", "-h" -> options.help = true;
                    default -> {
                        System.err.println("Unknown option: " + arg);
                        printUsage();
                        System.exit(2);
                    }
                }
            }

            if (options.yes && options.no) {
                System.err.println("Cannot use --yes and --no together.");
                System.exit(2);
            }

            if (options.nonInteractive && !options.yes && !options.no) {
                System.err.println("--non-interactive requires either --yes or --no.");
                System.exit(2);
            }

            return options;
        }

        private static String requireValue(String[] args, int index, String optionName) {
            if (index >= args.length) {
                System.err.println("Missing value for " + optionName);
                System.exit(2);
            }
            return args[index];
        }
    }
}
