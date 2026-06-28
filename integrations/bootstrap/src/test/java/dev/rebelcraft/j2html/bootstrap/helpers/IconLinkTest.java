package dev.rebelcraft.j2html.bootstrap.helpers;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.svg;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.use;
import static j2html.TagCreator.a;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IconLinkTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                        .withClasses(Bootstrap.icon_link)
                        .withHref("#")
                        .with(
                                svg()
                                        .withClasses(Bootstrap.bi)
                                        .attr(
                                                AriaStatesAndProperties.ariaHidden("true")
                                        )
                                        .with(
                                                use()
                                                        .attr("xlink:href", "#box-seam")
                                        ),
                                text("Icon link")
                        )
        );

        //language=HTML
        assertEquals("""
                <a class="icon-link" href="#">
                  <svg class="bi" aria-hidden="true">
                    <use xlink:href="#box-seam">
                    </use>
                  </svg>
                  Icon link
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void example2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                        .withClasses(Bootstrap.icon_link)
                        .withHref("#")
                        .with(
                                text("Icon link"),
                                svg()
                                        .withClasses(Bootstrap.bi)
                                        .attr(
                                                AriaStatesAndProperties.ariaHidden("true")
                                        )
                                        .with(
                                                use()
                                                        .attr("xlink:href", "#arrow-right")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <a class="icon-link" href="#">
                  Icon link
                  <svg class="bi" aria-hidden="true">
                    <use xlink:href="#arrow-right">
                    </use>
                  </svg>
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("example2", renderedHtml);

        uiDocumentation.documentSource("example2");

    }

    @Test
    void styleOnHover() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                        .withClasses(Bootstrap.icon_link, Bootstrap.icon_link_hover)
                        .withHref("#")
                        .with(
                                text("Icon link"),
                                svg()
                                        .withClasses(Bootstrap.bi)
                                        .attr(
                                                AriaStatesAndProperties.ariaHidden("true")
                                        )
                                        .with(
                                                use()
                                                        .attr("xlink:href","#arrow-right")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <a class="icon-link icon-link-hover" href="#">
          Icon link
          <svg class="bi" aria-hidden="true">
            <use xlink:href="#arrow-right">
            </use>
          </svg>
        </a>
        """, renderedHtml);

        // document
        uiDocumentation.document("style-on-hover", renderedHtml);

        uiDocumentation.documentSource("style-on-hover");

    }


}
