# j2html-template-engine
A template engine for the j2html library.

Repository module locations:

- Core engine module: `j2html-template-engine/j2html-engine-core`
- Spring modules: `spring/j2html-engine-spring` and `spring/j2html-engine-spring-boot-starter`

## Install

Use the artifact that matches your stack:

### Core engine

```xml
<dependency>
  <groupId>dev.rebelcraft</groupId>
  <artifactId>j2html-engine-core</artifactId>
  <version>${j2html-engine.version}</version>
</dependency>
```

### Spring MVC integration

```xml
<dependency>
  <groupId>dev.rebelcraft</groupId>
  <artifactId>j2html-engine-spring</artifactId>
  <version>${j2html-engine.version}</version>
</dependency>
```

### Spring Boot starter

```xml
<dependency>
  <groupId>dev.rebelcraft</groupId>
  <artifactId>j2html-engine-spring-boot-starter</artifactId>
  <version>${j2html-engine.version}</version>
</dependency>
```

## Quick start (core template engine)

```java
import dev.rebelcraft.engine.HtmlComponent;
import dev.rebelcraft.engine.J2HtmlEngine;
import dev.rebelcraft.engine.RenderContext;
import j2html.tags.DomContent;

import static j2html.TagCreator.div;
import static j2html.TagCreator.text;

public class QuickStart {
    public static class GreetingComponent implements HtmlComponent {
        @Override
        public DomContent render(RenderContext ctx) {
            return div(text("Hello " + ctx.require("name", String.class)));
        }
    }

    public static void main(String[] args) {
        J2HtmlEngine engine = J2HtmlEngine.builder()
                .register("greeting", GreetingComponent.class)
                .build();

        String html = engine.process("greeting", RenderContext.of("name", "Sam"));
        System.out.println(html); // <div>Hello Sam</div>
    }
}
```

## Template examples and `RenderContext` usage

See [`docs/template-examples.md`](docs/template-examples.md) for practical template snippets that demonstrate `RenderContext` methods (`require`, `find`, `has`, `locale`, `message`, `include`, and `childContext`).

## Spring MVC follow-up

When using Spring MVC (without Boot), register templates in the engine and expose `J2HtmlViewResolver`.

```java
@Configuration
public class WebConfig {
    @Bean
    J2HtmlEngine j2HtmlEngine() {
        return J2HtmlEngine.builder()
                .register("greeting", GreetingComponent.class)
                .build();
    }

    @Bean
    J2HtmlViewResolver j2HtmlViewResolver(J2HtmlEngine engine) {
        return new J2HtmlViewResolver(engine);
    }
}
```

Return `"greeting"` from your controller method and the resolver will render that template.

## Spring Boot follow-up

Add the starter and configure package scanning:

```properties
j2html.base-packages=com.example.views
```

Define components in scanned packages (for example with `@HtmlTemplate("home/index")`) and return that view name from your MVC controllers.

If `j2html.base-packages` is not set, the starter defaults to Spring Boot's auto-configuration packages (typically the package of your `@SpringBootApplication` class).

The starter uses Spring Framework's built-in `ClassPathScanningCandidateComponentProvider` for classpath scanning, which integrates cleanly with Spring Boot and avoids external classpath-scanning libraries.

## Logging and diagnostics

The engine now emits useful SLF4J logs for:

- Effective startup configuration (base packages, cache, locale, encoding, naming suffix)
- Component discovery and template registration
- MVC view resolution decisions (`viewName -> template found/not found`)
- Template render flow (`viewName -> component class -> rendered output length`)

Recommended Spring Boot logging levels:

```properties
logging.level.dev.rebelcraft.engine=DEBUG
logging.level.dev.rebelcraft.engine.spring=DEBUG
logging.level.dev.rebelcraft.engine.spring.boot=INFO
```

For deep cache diagnostics (template descriptor cache hit/miss), enable:

```properties
logging.level.dev.rebelcraft.engine=TRACE
```

## Known limitation
`j2html.Config` is global/static in j2html 1.6.0. If multiple `J2HtmlEngine` instances are built with different `.j2html(...)` settings in the same JVM, the latest build wins.

Recommendation: use a single shared `J2HtmlEngine` instance per application.
