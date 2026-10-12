# j2html-toolkit

A collection of extensions for the [j2html](https://j2html.com) library, used for building HTML with java code.

![Maven Central Version](https://img.shields.io/maven-central/v/io.github.teggr/j2html-toolkit)

# What's in the box?

* [essentials](/docs/j2html-extensions-core.md) - Extensions for the core j2html classes and creators
* [integration/tools](/docs/j2html-extensions-tools.md) - Standalone module with utilities for generating code
* [UI test documentation helpers](/docs/rebel-ui-test.md) - Test-scoped documentation helpers; not a toolkit module
* [ai components](/components/ai/README.md) - Reusable Bootstrap-compatible j2html components for AI chat and agent-style UIs
* [integration/bootstrap](/docs/bootstrap-j2html-extension.md) - Bootstrap lib
* [integration/htmx](/docs/htmx-j2html-extension.md) - HTMX attributes
* [spring/boot-starter](/docs/j2html-template-engine.md) - Spring Boot starter for the template engine
* [template-engine](/docs/j2html-template-engine.md) - Template engine and Spring integrations for j2html

## Published modules

These standalone artifacts are managed by `j2html-toolkit-bom`. The listed path is the module's Maven directory.

| Maven coordinate | Module path |
| --- | --- |
| `io.github.teggr:j2html-toolkit-components-ai` | `components/ai` |
| `io.github.teggr:j2html-toolkit-essentials` | `essentials` |
| `io.github.teggr:j2html-toolkit-integration-bootstrap` | `integration/bootstrap` |
| `io.github.teggr:j2html-toolkit-integration-htmx` | `integration/htmx` |
| `io.github.teggr:j2html-toolkit-integration-tools-api` | `integration/tools/api` |
| `io.github.teggr:j2html-toolkit-integration-tools-plugin` | `integration/tools/plugin` |
| `io.github.teggr:j2html-toolkit-preview` | `preview` |
| `io.github.teggr:j2html-toolkit-spring-boot-starter` | `spring/boot-starter` |
| `io.github.teggr:j2html-toolkit-spring-template-engine` | `spring/template-engine` |
| `io.github.teggr:j2html-toolkit-template-engine` | `template-engine` |

The parent POMs, BOM, and examples are reactor modules but are not standalone library artifacts in this table.

# Quick Start

Add the following to your Maven `pom.xml` file.

```xml

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>io.github.teggr</groupId>
            <artifactId>j2html-toolkit-bom</artifactId>
            <version>0.0.5</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

...

<dependency>
    <groupId>io.github.teggr</groupId>
    <artifactId>j2html-toolkit-spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>io.github.teggr</groupId>
    <artifactId>j2html-toolkit-integration-bootstrap</artifactId>
</dependency>
<dependency>
    <groupId>io.github.teggr</groupId>
    <artifactId>j2html-toolkit-integration-htmx</artifactId>
</dependency>

```

With the Spring Boot starter on the classpath, views are Spring beans that implement `HtmlComponent`. The starter auto-configures a `J2HtmlEngine` (scanning your application's packages for components) and a `J2HtmlViewResolver`, so a controller just returns the component's view name — derived from the class name in kebab-case, or set explicitly with `@HtmlTemplate("...")`.

```java

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "home"; // resolves the HomeView component below
    }

}

...

@Component
@HtmlTemplate("home")
public class HomeView implements HtmlComponent {

    @Override
    public DomContent render(RenderContext ctx) {

        return div().withClasses(Bootstrap.container).with(
                p("Hello World")
        );

    }

}

```

See the [examples webapp](/examples/webapp) for a complete working application, and the [template engine docs](/docs/j2html-template-engine.md) for engine configuration options such as `j2html.base-packages`.

## Integration smoke test

The examples webapp is the end-to-end integration surface for Spring Boot, j2html, HTMX, and Bootstrap. Its HTTP smoke test starts the application and checks the rendered pages:

```bash
./mvnw --no-transfer-progress -pl examples/webapp -am test
```

The project targets Java 17 or newer, uses j2html 1.6.0, and currently manages Spring Boot 4.0.7 through the `spring.boot.version` property in the root POM.

# Build and release

JDK 17 or newer is required to build and test this repository.

```bash
./mvnw --no-transfer-progress test
jbang jbang/checkProjectConsistency.java
```

[RELEASE.md](/docs/RELEASE.md)

# JBang init script

A JBang setup script is available at `/jbang/j2htmlInit.java`.

Interactive mode (asks for confirmation and updates `./pom.xml`):

```bash
jbang /path/to/j2html-toolkit/jbang/j2htmlInit.java
```

Non-interactive mode:

```bash
jbang /path/to/j2html-toolkit/jbang/j2htmlInit.java --pom /path/to/project/pom.xml --yes
```

Use `--help` to see all CLI options.
