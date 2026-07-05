package dev.rebelcraft.j2html.example;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import j2html.tags.DomContent;
import sh.rebelstack.j2html.engine.HtmlComponent;
import sh.rebelstack.j2html.engine.RenderContext;
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
