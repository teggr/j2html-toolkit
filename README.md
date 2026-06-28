# j2html-extensions

A collection of extensions for the [j2html](https://j2html.com) library, used for building HTML with java code.

![Maven Central Version](https://img.shields.io/maven-central/v/dev.rebelcraft/j2html-extensions)

# What's in the box?

* [j2html-extensions-core](/docs/j2html-extensions-core.md) - Extensions for the core j2html classes and creators
* [j2html-extensions-tools](/docs/j2html-extensions-tools.md) - Standalone module with utilities for generating code
* [rebel-ui-test](/docs/rebel-ui-test.md) - Standalone module for testing UI rendering
* [integrations/bootstrap](/docs/bootstrap-j2html-extension.md) - Bootstrap lib
* [integrations/htmx](/docs/htmx-j2html-extension.md) - HTMX attributes
* [j2html-template-engine](/docs/j2html-template-engine.md) - Template engine and Spring integrations for j2html

The browser-focused integration modules now live under `integrations/` in the Maven reactor.

# Quick Start

Add the following to your Maven `pom.xml` file.

```xml

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>dev.rebelcraft</groupId>
            <artifactId>j2html-extensions-bom</artifactId>
            <version>0.0.3</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

...

<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>j2html-extensions-spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>bootstrap-j2html-extension</artifactId>
</dependency>
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>htmx-j2html-extension</artifactId>
</dependency>

```

Use the provided `J2HtmlView` objects to start building out your webmvc application.

```java

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "homeView";
    }

}

...

@Component
public class HomeView extends J2HtmlView {

    @Override
    protected DomContent renderMergedOutputModelDomContent(
            Map<String, Object> model,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return div().withClasses(Bootstrap.container).with(
                p("Hello World")
        );

    }

}

```


# Build and release

JDK 21 or newer is required to build and test this repository.

```bash
./mvnw --no-transfer-progress test
```

[RELEASE.md](/docs/RELEASE.md)

# JBang init script

A JBang setup script is available at `/jbang/j2htmlInit.java`.

Interactive mode (asks for confirmation and updates `./pom.xml`):

```bash
jbang /path/to/j2html-extensions/jbang/j2htmlInit.java
```

Non-interactive mode:

```bash
jbang /path/to/j2html-extensions/jbang/j2htmlInit.java --pom /path/to/project/pom.xml --yes
```

Use `--help` to see all CLI options.
