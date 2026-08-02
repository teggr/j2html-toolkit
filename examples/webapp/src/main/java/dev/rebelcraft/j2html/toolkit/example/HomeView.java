package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.toolkit.integration.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import j2html.tags.DomContent;

import org.springframework.stereotype.Component;

import static j2html.TagCreator.a;
import static j2html.TagCreator.div;
import static j2html.TagCreator.p;

@Component
public class HomeView implements HtmlComponent {

    @Override
    public DomContent render(RenderContext ctx) {
        DomContent body = div().withClasses(Bootstrap.container).with(
            p("Hello World"),
            p().with(
                a("Open AI showcase").withHref("/ai")
            ),
            p().with(
                a("Open AI streaming showcase").withHref("/ai/stream")
            ),
            p().with(
                a("Open AI session health showcase").withHref("/ai/health")
            ),
            p().with(
                a("Open Bootstrap showcase").withHref("/bootstrap")
            )
        );

        return new WebappPageLayout().layout("Home", body);
    }

}
