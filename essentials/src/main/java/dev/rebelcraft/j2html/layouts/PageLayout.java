package dev.rebelcraft.j2html.layouts;

import static j2html.TagCreator.*;

import j2html.attributes.Attr;
import j2html.tags.DomContent;

public class PageLayout {

    public DomContent layout(String title, DomContent body) {
        return layout(title, body, null, null);
    }

    public DomContent layout(String title, DomContent body, DomContent header) {
        return layout(title, body, header, null);
    }

    public DomContent layout(String title, DomContent body, DomContent header, PageLayoutHeadConfigurer configurer) {
        return layout(title, body, header, configurer, null);
    }

    public DomContent layout(String title, DomContent body, DomContent header, PageLayoutHeadConfigurer headConfigurer,
                             PageLayoutBodyConfigurer bodyConfigurer) {
        PageLayoutHeadConfigurer resolvedHeadConfigurer = headConfigurer != null ? headConfigurer : new PageLayoutHeadConfigurer() {};
        PageLayoutBodyConfigurer resolvedBodyConfigurer = bodyConfigurer != null ? bodyConfigurer : new PageLayoutBodyConfigurer() {};
        String resolvedTitle = resolvedHeadConfigurer.title(title);
        var stylesheetContent = resolvedHeadConfigurer.stylesheets();
        DomContent[] headContent = new DomContent[1 + stylesheetContent.size()];
        headContent[0] = title(resolvedTitle);
        for (int i = 0; i < stylesheetContent.size(); i++) {
            headContent[i + 1] = link().withRel("stylesheet").withHref(stylesheetContent.get(i));
        }

        var bodyContent = resolvedBodyConfigurer.scripts();
        DomContent[] bodyChildren = new DomContent[2 + bodyContent.size()];
        bodyChildren[0] = header != null ? header : div();
        bodyChildren[1] = body;
        for (int i = 0; i < bodyContent.size(); i++) {
            bodyChildren[2 + i] = script().withSrc(bodyContent.get(i));
        }

        return each(
            document(),
            html()
                .attr(Attr.LANG, "en")
                .with(
                    head(headContent),
                    body(bodyChildren),
                    footer()
                )
        );
    }

}
