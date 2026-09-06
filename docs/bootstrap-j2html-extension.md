# j2html-toolkit-integration-bootstrap

This module now lives under `integration/bootstrap` in the Maven reactor.

This brings the [Bootstrap](https://getbootstrap.com/) UI kit into the j2html ecosystem.

* `Bootstrap` for CSS classes declared in the UI toolkit
* `BootstrapConfig` for useful URLs for CDN and Webjar locations
* `BootstrapIcons` for CSS classes supporting the Bootstrap Icons
* `BootstrapTagCreator` for common templates for Bootstrap components

```xml
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>j2html-toolkit-integration-bootstrap</artifactId>
</dependency>
```

Usage:
```java
import dev.rebelcraft.j2html.toolkit.integration.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.attributes.aria.AriaRoles;
import static j2html.TagCreator.*;

div()
    .withClasses(Bootstrap.alert, Bootstrap.alert_primary)
    .attr(AriaRoles.roleAlert)
    .with(
      text("A simple primary alert—check it out!")
    )
```