package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.layouts.PageLayout;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

import static j2html.TagCreator.a;
import static j2html.TagCreator.div;
import static j2html.TagCreator.nav;

public class WebappPageLayout {

    public DomContent layout(String title, DomContent body) {
        ContainerTag<?> navbar = nav().withClasses("navbar", "navbar-expand-lg", "navbar-light", "bg-white", "border-bottom")
                .with(
                        div().withClasses("container").with(
                                a("j2html toolkit").withHref("/").withClasses("navbar-brand", "fw-bold"),
                                div().withClasses("navbar-nav", "ms-auto").with(
                                        a("Home").withHref("/").withClasses("nav-link"),
                                        a("AI").withHref("/ai").withClasses("nav-link"),
                                        a("Streaming").withHref("/ai/stream").withClasses("nav-link"),
                                        a("Health").withHref("/ai/health").withClasses("nav-link"),
                                        a("Bootstrap").withHref("/bootstrap").withClasses("nav-link")
                                )
                        )
                );

        WebappPageLayoutConfigurer configurer = new WebappPageLayoutConfigurer(title);
        return new PageLayout().layout(
                title,
                body,
                navbar,
                configurer,
                configurer
        );
    }
}
