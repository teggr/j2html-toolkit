package dev.rebelcraft.j2html.toolkit.integration.bootstrap.components;

import dev.rebelcraft.j2html.attributes.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.toolkit.integration.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.toolkit.integration.bootstrap.DocRenderer.domContentToString;
import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CloseButtonTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = domContentToString(
                button()
                 .withType("button")
                 .withClasses(Bootstrap.btn_close)
                 .attr(
                    AriaStatesAndProperties.ariaLabel("Close")
                  )
        );

        //language=HTML
        assertEquals("""
            <button type="button" class="btn-close" aria-label="Close">
            </button>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void disabledState() throws Exception {

        String renderedHtml = domContentToString(
                button()
                        .withType("button")
                        .withClasses(Bootstrap.btn_close)
                        .withCondDisabled(true)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Close")
                        )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn-close" disabled aria-label="Close">
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled-state", renderedHtml);

        uiDocumentation.documentSource("disabled-state");

    }

    @Test
    void darkVariant() throws Exception {

        String renderedHtml = domContentToString(
                div()
                        .withData("bs-theme","dark")
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn_close)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Close")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn_close)
                                        .withCondDisabled(true)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Close")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div data-bs-theme="dark">
                  <button type="button" class="btn-close" aria-label="Close">
                  </button>
                  <button type="button" class="btn-close" disabled aria-label="Close">
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("dark-variant", renderedHtml);

        uiDocumentation.documentSource("dark-variant");

    }


}