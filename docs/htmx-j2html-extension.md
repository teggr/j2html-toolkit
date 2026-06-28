# htmx-j2html-extension

This module now lives under `integrations/htmx` in the Maven reactor.

This brings the [HTMX](https://htmx.org/) tools for HTML into the j2html ecosystem.

* `HtmxAttributes` for attributes
* `HtmxTagCreator` for tags

```xml
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>htmx-j2html-extension</artifactId>
    <version>0.0.3</version>
</dependency>
```

Usage:
```java
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static dev.rebelcraft.j2html.htmx.Htmx.*;
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
