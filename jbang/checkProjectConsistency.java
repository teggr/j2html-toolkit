///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class checkProjectConsistency {

    private static final String GROUP_ID = "io.github.teggr";
    private static final Pattern ARTIFACT_PATTERN =
            Pattern.compile("\\b(j2html-toolkit(?:-[a-z0-9-]+)?)\\b");
    private static final Pattern COORDINATE_PATTERN = Pattern.compile(
            "<groupId>\\s*io\\.github\\.teggr\\s*</groupId>\\s*<artifactId>\\s*"
                    + "([a-z0-9.-]+)\\s*</artifactId>|io\\.github\\.teggr\\s*:\\s*([a-z0-9.-]+)");
    private static final Pattern MARKDOWN_LINK_PATTERN =
            Pattern.compile("!?\\[[^\\]]*\\]\\(([^)]+)\\)");
    private static final Pattern MODULE_ROW_PATTERN = Pattern.compile(
            "^\\|\\s*`io\\.github\\.teggr:(j2html-toolkit-[a-z0-9-]+)`\\s*\\|\\s*`([^`]+)`\\s*\\|$");

    public static void main(String[] args) throws Exception {
        Path root = findRepositoryRoot();
        Map<String, String> artifacts = new HashMap<>();
        Map<String, String> published = new HashMap<>();
        inventoryProjects(root, artifacts, published);

        List<String> errors = new ArrayList<>();
        Map<String, List<String>> bomArtifacts = readBomArtifacts(root);
        compareBom(published, bomArtifacts, errors);
        checkReadmeTable(root, published, errors);
        int markdownCount = checkDocumentation(root, artifacts, errors);

        if (!errors.isEmpty()) {
            errors.forEach(error -> System.err.println("ERROR: " + error));
            System.exit(1);
        }
        System.out.printf("Project consistency check passed: %d published modules, %d Markdown files.%n",
                published.size(), markdownCount);
    }

    private static Path findRepositoryRoot() {
        Path path = Path.of("").toAbsolutePath().normalize();
        while (path != null) {
            if (Files.isRegularFile(path.resolve("pom.xml"))
                    && Files.isRegularFile(path.resolve("README.md"))
                    && Files.isDirectory(path.resolve("bom"))) {
                return path;
            }
            path = path.getParent();
        }
        throw new IllegalStateException("Run this script from within the toolkit repository.");
    }

    private static void inventoryProjects(
            Path root, Map<String, String> artifacts, Map<String, String> published) throws Exception {
        try (Stream<Path> paths = Files.walk(root)) {
            for (Path pom : paths.filter(path -> path.getFileName().toString().equals("pom.xml"))
                    .filter(path -> !path.toString().contains(".git"))
                    .filter(path -> !path.toString().contains("target"))
                    .sorted(Comparator.naturalOrder()).toList()) {
                Element project = parseXml(pom).getDocumentElement();
                String artifactId = childText(project, "artifactId");
                if (artifactId == null || artifactId.isBlank()) {
                    continue;
                }
                String packaging = childText(project, "packaging");
                if (packaging == null || packaging.isBlank()) {
                    packaging = "jar";
                }
                String relativePath = root.relativize(pom.getParent()).toString().replace('\\', '/');
                artifacts.put(artifactId, relativePath);
                if ("jar".equals(packaging) && !relativePath.equals("examples")
                        && !relativePath.startsWith("examples/")) {
                    published.put(artifactId, relativePath);
                }
            }
        }
    }

    private static Map<String, List<String>> readBomArtifacts(Path root) throws Exception {
        Document document = parseXml(root.resolve("bom").resolve("pom.xml"));
        NodeList dependencies = document.getElementsByTagNameNS("*", "dependency");
        Map<String, List<String>> artifacts = new HashMap<>();
        for (int i = 0; i < dependencies.getLength(); i++) {
            Element dependency = (Element) dependencies.item(i);
            if (GROUP_ID.equals(childText(dependency, "groupId"))) {
                String artifactId = childText(dependency, "artifactId");
                artifacts.computeIfAbsent(artifactId, ignored -> new ArrayList<>())
                        .add(childText(dependency, "version"));
            }
        }
        return artifacts;
    }

    private static void compareBom(
            Map<String, String> published, Map<String, List<String>> bomArtifacts, List<String> errors) {
        Set<String> missing = new HashSet<>(published.keySet());
        missing.removeAll(bomArtifacts.keySet());
        missing.stream().sorted().forEach(id -> errors.add("BOM is missing published module " + id));

        Set<String> extra = new HashSet<>(bomArtifacts.keySet());
        extra.removeAll(published.keySet());
        extra.stream().sorted().forEach(id -> errors.add("BOM manages non-published module " + id));

        for (String artifactId : published.keySet()) {
            List<String> versions = bomArtifacts.get(artifactId);
            if (versions != null && !versions.equals(List.of("${project.version}"))) {
                errors.add("BOM version for " + artifactId + " should be ${project.version} exactly once, found "
                        + versions);
            }
        }
    }

    private static void checkReadmeTable(Path root, Map<String, String> published, List<String> errors)
            throws Exception {
        Path readme = root.resolve("README.md");
        Map<String, String> listed = new HashMap<>();
        for (String line : Files.readAllLines(readme, StandardCharsets.UTF_8)) {
            Matcher matcher = MODULE_ROW_PATTERN.matcher(line);
            if (matcher.matches()) {
                listed.put(matcher.group(1), matcher.group(2));
            }
        }
        for (String artifactId : difference(published.keySet(), listed.keySet())) {
            errors.add("README.md is missing published module " + artifactId);
        }
        for (String artifactId : difference(listed.keySet(), published.keySet())) {
            errors.add("README.md lists non-published module " + artifactId);
        }
        for (String artifactId : published.keySet()) {
            if (listed.containsKey(artifactId) && !published.get(artifactId).equals(listed.get(artifactId))) {
                errors.add("README.md maps " + artifactId + " to " + listed.get(artifactId)
                        + ", expected " + published.get(artifactId));
            }
        }
    }

    private static int checkDocumentation(Path root, Map<String, String> artifacts, List<String> errors)
            throws Exception {
        List<Path> markdownFiles;
        try (Stream<Path> paths = Files.walk(root)) {
            markdownFiles = paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".md"))
                    .filter(path -> !path.toString().contains(".git"))
                    .filter(path -> !path.toString().contains("target"))
                    .sorted(Comparator.naturalOrder()).toList();
        }

        for (Path markdown : markdownFiles) {
            String content = Files.readString(markdown, StandardCharsets.UTF_8);
            String relativePath = root.relativize(markdown).toString().replace('\\', '/');
            Matcher artifactMatcher = ARTIFACT_PATTERN.matcher(content);
            while (artifactMatcher.find()) {
                String artifactId = artifactMatcher.group(1);
                if (!artifacts.containsKey(artifactId)) {
                    errors.add(relativePath + " mentions unknown artifact " + artifactId);
                }
            }
            Matcher coordinateMatcher = COORDINATE_PATTERN.matcher(content);
            while (coordinateMatcher.find()) {
                String artifactId = coordinateMatcher.group(1) != null
                        ? coordinateMatcher.group(1) : coordinateMatcher.group(2);
                if (!artifacts.containsKey(artifactId)) {
                    errors.add(relativePath + " uses unknown coordinate " + GROUP_ID + ":" + artifactId);
                }
            }

            Matcher linkMatcher = MARKDOWN_LINK_PATTERN.matcher(content);
            while (linkMatcher.find()) {
                String target = linkMatcher.group(1).trim();
                int titleSeparator = target.indexOf(' ');
                if (titleSeparator >= 0) {
                    target = target.substring(0, titleSeparator);
                }
                target = target.replace("<", "").replace(">", "");
                URI uri = URI.create(target.replace(" ", "%20"));
                if (uri.getScheme() != null || uri.getAuthority() != null || uri.getPath() == null
                        || uri.getPath().isEmpty()) {
                    continue;
                }
                String linkPath = uri.getPath().replace("%20", " ");
                Path destination = linkPath.startsWith("/")
                        ? root.resolve(linkPath.substring(1))
                        : markdown.getParent().resolve(linkPath);
                if (!Files.exists(destination.normalize())) {
                    errors.add(relativePath + " links to missing path " + uri.getPath());
                }
            }
        }
        return markdownFiles.size();
    }

    private static List<String> difference(Set<String> left, Set<String> right) {
        Set<String> difference = new HashSet<>(left);
        difference.removeAll(right);
        return difference.stream().sorted().toList();
    }

    private static String childText(Element parent, String name) {
        for (Node child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == Node.ELEMENT_NODE && name.equals(child.getLocalName())) {
                return child.getTextContent().trim();
            }
        }
        return null;
    }

    private static Document parseXml(Path path) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
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
}
