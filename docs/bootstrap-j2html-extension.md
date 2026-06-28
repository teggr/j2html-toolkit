# bootstrap-j2html-extension

This module now lives under `integrations/bootstrap` in the Maven reactor.

This brings the [Bootstrap](https://getbootstrap.com/) UI kit into the j2html ecosystem.

* `Bootstrap` for CSS classes declared in the UI toolkit
* `BootstrapConfig` for useful URLs for CDN and Webjar locations
* `BootstrapIcons` for CSS classes supporting the Bootstrap Icons
* `BootstrapTagCreator` for common templates for Bootstrap components

```xml
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>bootstrap-j2html-extension</artifactId>
    <version>0.0.3</version>
</dependency>
```

Usage:
```java
import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import static j2html.TagCreator.*;

div()
    .withClasses(Bootstrap.alert, Bootstrap.alert_primary)
    .attr(AriaRoles.roleAlert)
    .with(
      text("A simple primary alert—check it out!")
    )
```