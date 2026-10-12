///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class syncReleaseDocumentation {

    private static final Pattern RELEASE_VERSION = Pattern.compile("\\d+(?:\\.\\d+)+");
    private static final String BOM_VERSION_PATTERN =
            "(<artifactId>j2html-toolkit-bom</artifactId>\\s*<version>)[^<]+(</version>)";
    private static final String DEV_VERSION_PATTERN =
            "(?m)^(The current development version of the toolkit is `)[^`\\r\\n]+(`, as declared by the root POM\\.)";
    private static final String JBANG_FALLBACK_PATTERN =
            "(private static final String FALLBACK_VERSION = \")[^\"]+(\";\\s*)";

    public static void main(String[] args) throws Exception {
        if (args.length == 1 && "--self-test".equals(args[0])) {
            selfTest();
            return;
        }
        if (args.length != 1 || args[0].isBlank()) {
            throw new IllegalArgumentException("Usage: jbang syncReleaseDocumentation.java <release-version> | --self-test");
        }

        String releaseVersion = args[0];
        if (!RELEASE_VERSION.matcher(releaseVersion).matches()) {
            throw new IllegalArgumentException("Expected a stable release version, got: " + releaseVersion);
        }

        Path root = findRepositoryRoot();
        String snapshotVersion = readRootVersion(root.resolve("pom.xml"));
        if (!snapshotVersion.endsWith("-SNAPSHOT")) {
            throw new IllegalStateException("The root POM must contain the next -SNAPSHOT version before syncing documentation");
        }

        List<Path> paths = List.of(
                root.resolve("README.md"),
                root.resolve("docs/RELEASE.md"),
                root.resolve("jbang/j2htmlInit.java")
        );
        List<String> content = new ArrayList<>();
        for (Path path : paths) {
            content.add(Files.readString(path));
        }

        List<String> updated = List.of(
                replaceExactlyOnce(content.get(0), BOM_VERSION_PATTERN, releaseVersion, "README BOM import"),
                replaceExactlyOnce(content.get(1), DEV_VERSION_PATTERN, snapshotVersion, "release guide development version"),
                replaceExactlyOnce(content.get(2), JBANG_FALLBACK_PATTERN, releaseVersion, "JBang fallback version")
        );

        for (int i = 0; i < paths.size(); i++) {
            Files.writeString(paths.get(i), updated.get(i));
            System.out.println("Synchronized " + root.relativize(paths.get(i)));
        }
    }

    private static Path findRepositoryRoot() {
        Path path = Path.of("").toAbsolutePath().normalize();
        while (path != null) {
            if (Files.isRegularFile(path.resolve("pom.xml")) && Files.isRegularFile(path.resolve("README.md"))) {
                return path;
            }
            path = path.getParent();
        }
        throw new IllegalStateException("Run this script from within the toolkit repository.");
    }

    private static String readRootVersion(Path pomPath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        Element project = factory.newDocumentBuilder().parse(pomPath.toFile()).getDocumentElement();
        NodeList children = project.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child instanceof Element element && "version".equals(element.getLocalName() == null
                    ? element.getNodeName()
                    : element.getLocalName())) {
                return element.getTextContent().trim();
            }
        }
        throw new IllegalStateException("The root POM has no project version.");
    }

    private static String replaceExactlyOnce(String content, String expression, String version, String label) {
        Matcher matcher = Pattern.compile(expression).matcher(content);
        if (!matcher.find()) {
            throw new IllegalStateException("Could not find the version reference for " + label);
        }
        String prefix = matcher.group(1);
        String suffix = matcher.group(2);
        int start = matcher.start();
        int end = matcher.end();
        if (matcher.find()) {
            throw new IllegalStateException("Found multiple version references for " + label);
        }
        return content.substring(0, start) + prefix + version + suffix + content.substring(end);
    }

    private static void selfTest() {
        String readme = "<artifactId>j2html-toolkit-bom</artifactId><version>stale</version>";
        String releaseDoc = "The current development version of the toolkit is `stale`, as declared by the root POM.";
        String jbang = "private static final String FALLBACK_VERSION = \"stale\";";

        requireContains(replaceExactlyOnce(readme, BOM_VERSION_PATTERN, "1.2.3", "test README"), "<version>1.2.3</version>");
        requireContains(replaceExactlyOnce(releaseDoc, DEV_VERSION_PATTERN, "1.2.4-SNAPSHOT", "test development docs"),
                "`1.2.4-SNAPSHOT`");
        requireContains(replaceExactlyOnce(jbang, JBANG_FALLBACK_PATTERN, "1.2.3", "test JBang fallback"),
                "FALLBACK_VERSION = \"1.2.3\"");

        try {
            replaceExactlyOnce(readme + readme, BOM_VERSION_PATTERN, "1.2.3", "duplicate test");
            throw new IllegalStateException("The self-test did not reject duplicate version references.");
        } catch (IllegalStateException expected) {
            if (!expected.getMessage().contains("multiple")) {
                throw expected;
            }
        }
        System.out.println("Documentation version synchronization self-test passed.");
    }

    private static void requireContains(String content, String expected) {
        if (!content.contains(expected)) {
            throw new IllegalStateException("Documentation synchronization self-test failed: " + expected);
        }
    }
}
