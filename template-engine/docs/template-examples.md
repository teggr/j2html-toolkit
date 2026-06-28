# Template examples with `RenderContext`

This guide shows common ways to use `RenderContext` from inside templates (`HtmlComponent#render`).

## `require(name, type)` for mandatory input

```java
@HtmlTemplate("profile/header")
public class ProfileHeaderTemplate implements HtmlComponent {
    @Override
    public DomContent render(RenderContext ctx) {
        String displayName = ctx.require("displayName", String.class);
        return h1("Welcome, " + displayName);
    }
}
```

Use this when the template cannot render correctly without a value.

## `find(name, type)` for optional input

```java
@HtmlTemplate("profile/bio")
public class ProfileBioTemplate implements HtmlComponent {
    @Override
    public DomContent render(RenderContext ctx) {
        String bio = ctx.find("bio", String.class).orElse("No bio yet.");
        return p(bio);
    }
}
```

Use this for optional data with a fallback.

## `has(name)` to gate sections

```java
@HtmlTemplate("profile/badges")
public class ProfileBadgesTemplate implements HtmlComponent {
    @Override
    public DomContent render(RenderContext ctx) {
        return div(
                h2("Badges"),
                ctx.has("isMaintainer") ? span("Maintainer") : span("Community Member")
        );
    }
}
```

Use this for simple presence checks before rendering conditional blocks.

## `locale()` and `message(key, args...)` for i18n

```java
@HtmlTemplate("dashboard/title")
public class DashboardTitleTemplate implements HtmlComponent {
    @Override
    public DomContent render(RenderContext ctx) {
        return h1(ctx.message("dashboard.title", ctx.locale().getDisplayLanguage(ctx.locale())));
    }
}
```

`locale()` gives the active locale, and `message(...)` resolves localized text through the configured `MessageResolver`.

## `include(templateName)` for composition

```java
@HtmlTemplate("layout/page")
public class PageLayoutTemplate implements HtmlComponent {
    @Override
    public DomContent render(RenderContext ctx) {
        return div(
                header(ctx.include("layout/header")),
                main(ctx.include("content/home")),
                footer(ctx.include("layout/footer"))
        );
    }
}
```

Use this to compose bigger views from reusable templates.

## `include(templateName, vars)` for child overrides

```java
@HtmlTemplate("catalog/list")
public class CatalogListTemplate implements HtmlComponent {
    @Override
    public DomContent render(RenderContext ctx) {
        return ul(
                li(ctx.include("catalog/item", Map.of("name", "Keyboard", "price", "$89"))),
                li(ctx.include("catalog/item", Map.of("name", "Mouse", "price", "$39")))
        );
    }
}
```

Use this when included templates need additional or overridden variables.

## `include(templateName, child -> ...)` for fluent child context setup

```java
@HtmlTemplate("order/summary")
public class OrderSummaryTemplate implements HtmlComponent {
    @Override
    public DomContent render(RenderContext ctx) {
        return section(
                ctx.include("order/line-items", child -> child
                        .with("items", ctx.require("items", List.class))
                        .with("showTotals", true))
        );
    }
}
```

Use this when child context setup is easier in a fluent lambda than in a pre-built map.

## `childContext()` for advanced branching

```java
@HtmlTemplate("emails/wrapper")
public class EmailWrapperTemplate implements HtmlComponent {
    @Override
    public DomContent render(RenderContext ctx) {
        RenderContext promoCtx = ctx.childContext()
                .with("variant", "promo")
                .build();
        RenderContext transactionalCtx = ctx.childContext()
                .with("variant", "transactional")
                .build();

        return div(
                h2("Preview"),
                div("Promo variant: " + promoCtx.require("variant", String.class)),
                div("Transactional variant: " + transactionalCtx.require("variant", String.class))
        );
    }
}
```

Use `childContext()` when you need derived contexts that inherit parent values/locale and then diverge for branch-specific logic.
