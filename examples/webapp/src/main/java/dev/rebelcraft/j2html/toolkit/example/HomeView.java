package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.toolkit.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import j2html.tags.DomContent;

import org.springframework.stereotype.Component;

import static j2html.TagCreator.div;
import static j2html.TagCreator.p;

@Component
public class HomeView implements HtmlComponent {

    @Override
    public DomContent render(RenderContext ctx) {

        return div().withClasses(Bootstrap.container).with(
                p("Hello World")
        );

    }

}
