# j2html-toolkit-integration-htmx

This module now lives under `integration/htmx` in the Maven reactor.

This brings the [HTMX](https://htmx.org/) tools for HTML into the j2html ecosystem.

* `HtmxAttributes` for attributes
* `HtmxTagCreator` for tags

```xml
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>j2html-toolkit-integration-htmx</artifactId>
</dependency>
```

Usage:
```java
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.*;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.Htmx.*;
import static j2html.TagCreator.*;

// add as attributes
button()
        .attr(hxPost("/clicked"))
        .attr(hxTrigger(click))
        .attr(hxTarget("#parent-div"))
        .attr(hxSwap(outerHTML))
        .with(
            text("Click Me!")
        )

// use the fluent approach
hx(button(), (hx) -> hx
        .post("/clicked")
        .trigger(click)
        .target("#parent-div")
        .swap(outerHTML))
        .with(
            text("Click Me!")
        )
```
