package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TooltipsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void tooltipsOnLinks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                p()
                 .withClasses("muted")
                 .with(
                    text("Placeholder text to demonstrate some"),
                    a()
                     .withHref("#")
                     .withData("bs-toggle","tooltip")
                     .withData("bs-title","Default tooltip")
                     .with(
                        text("inline links")
                      ),
                    text("with tooltips. This is now just filler, no killer. Content placed here just to mimic the presence of"),
                    a()
                     .withHref("#")
                     .withData("bs-toggle","tooltip")
                     .withData("bs-title","Another tooltip")
                     .with(
                        text("real text")
                      ),
                    text(". And all that just to give you an idea of how tooltips would look when used in real-world situations. So hopefully you've now seen how"),
                    a()
                     .withHref("#")
                     .withData("bs-toggle","tooltip")
                     .withData("bs-title","Another one here too")
                     .with(
                        text("these tooltips on links")
                      ),
                    text("can work in practice, once you use them on"),
                    a()
                     .withHref("#")
                     .withData("bs-toggle","tooltip")
                     .withData("bs-title","The last tip!")
                     .with(
                        text("your own")
                      ),
                    text("site or project.")
                  )
        );

        //language=HTML
        assertEquals("""
            <p class="muted">
              Placeholder text to demonstrate some 
              <a href="#" data-bs-toggle="tooltip" data-bs-title="Default tooltip">
                inline links
              </a>
              with tooltips. This is now just filler, no killer. Content placed here just to mimic the presence of
              <a href="#" data-bs-toggle="tooltip" data-bs-title="Another tooltip">
                real text
              </a>
              . And all that just to give you an idea of how tooltips would look when used in real-world situations. So hopefully you&#x27;ve now seen how
              <a href="#" data-bs-toggle="tooltip" data-bs-title="Another one here too">
                these tooltips on links
              </a>
              can work in practice, once you use them on
              <a href="#" data-bs-toggle="tooltip" data-bs-title="The last tip!">
                your own
              </a>
              site or project.
            </p>
            """, renderedHtml);

        // document
        uiDocumentation.document("tooltips-on-links", renderedHtml);

        uiDocumentation.documentSource("tooltips-on-links");

    }

    @Test
    void customTooltip() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .withType("button")
                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                        .withData("bs-toggle","tooltip")
                        .withData("bs-placement","top")
                        .withData("bs-custom-class","custom-tooltip")
                        .withData("bs-title","This top tooltip is themed via CSS variables.")
                        .with(
                                text("Custom tooltip")
                        )
        );

        //language=HTML
        assertEquals("""
        <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-custom-class="custom-tooltip" data-bs-title="This top tooltip is themed via CSS variables.">
          Custom tooltip
        </button>
        """, renderedHtml);

        // document
        uiDocumentation.document("custom-tooltip", renderedHtml);

        uiDocumentation.documentSource("custom-tooltip");

    }

    @Test
    void directions() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withData("bs-toggle","tooltip")
                                .withData("bs-placement","top")
                                .withData("bs-title","Tooltip on top")
                                .with(
                                        text("Tooltip on top")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withData("bs-toggle","tooltip")
                                .withData("bs-placement","right")
                                .withData("bs-title","Tooltip on right")
                                .with(
                                        text("Tooltip on right")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withData("bs-toggle","tooltip")
                                .withData("bs-placement","bottom")
                                .withData("bs-title","Tooltip on bottom")
                                .with(
                                        text("Tooltip on bottom")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withData("bs-toggle","tooltip")
                                .withData("bs-placement","left")
                                .withData("bs-title","Tooltip on left")
                                .with(
                                        text("Tooltip on left")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Tooltip on top">
          Tooltip on top
        </button>
        <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="right" data-bs-title="Tooltip on right">
          Tooltip on right
        </button>
        <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="bottom" data-bs-title="Tooltip on bottom">
          Tooltip on bottom
        </button>
        <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="left" data-bs-title="Tooltip on left">
          Tooltip on left
        </button>
        """, renderedHtml);

        // document
        uiDocumentation.document("directions", renderedHtml);

        uiDocumentation.documentSource("directions");

    }



}
