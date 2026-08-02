package dev.rebelcraft.j2html.layouts;

import static j2html.TagCreator.*;

import j2html.attributes.Attr;
import j2html.tags.DomContent;

public class PageLayout {

    public DomContent layout( String title, DomContent body ) {

        return each(
            document(),
            html()
                .attr(Attr.LANG, "en")
                .with(
                    head(
                        title(title)
                    ),
                    body(
                        body
                    ),
                    footer()
                )
        );

    }

}
