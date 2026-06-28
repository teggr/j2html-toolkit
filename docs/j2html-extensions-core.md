# j2html-extensions

Support for some missing tags: `PathTag`, `SvgTag`, `SymbolTag`, `UseTag`. The `ExtendedTagCreator` makes those available in the same way as the j2html library.

```java
ExtendedTagCreator.svg();
ExtendedTagCreator.path();
ExtendedTagCreator.use();
ExtendedTagCreator.symbok();
```

Support for [Aria Roles, States and Properties](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques)

```java
TagCreator.div()
    .attr(AriaRoles.roleButton) // <div role="button" />
TagCreate.div()
    ,attr(AriaStatesAndProperties.aria_current("page")) // <div aria-current="page" />
```