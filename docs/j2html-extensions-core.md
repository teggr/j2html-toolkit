# j2html-essentials

Support for some missing tags: `PathTag`, `SvgTag`, `SymbolTag`, `UseTag`. The `ExtendedTagCreator` makes those available in the same way as the j2html library.

```java
import dev.rebelcraft.j2html.ExtendedTagCreator;

ExtendedTagCreator.svg();
ExtendedTagCreator.path();
ExtendedTagCreator.use();
ExtendedTagCreator.symbol();
```

Support for [Aria Roles, States and Properties](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques)

```java
import dev.rebelcraft.j2html.attributes.aria.AriaRoles;
import dev.rebelcraft.j2html.attributes.aria.AriaStatesAndProperties;

import static j2html.TagCreator.div;

div()
    .attr(AriaRoles.roleButton) // <div role="button" />

div()
    .attr(AriaStatesAndProperties.ariaCurrent("page")) // <div aria-current="page" />
```