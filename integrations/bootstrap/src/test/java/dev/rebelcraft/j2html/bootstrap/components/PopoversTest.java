package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PopoversTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void liveDemo() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                 .withType("button")
                 .withClasses(Bootstrap.btn, Bootstrap.btn_lg, Bootstrap.btn_danger)
                 .withData("bs-toggle","popover")
                 .withData("bs-title","Popover title")
                 .withData("bs-content","And here's some amazing content. It's very engaging. Right?")
                 .with(
                    text("Click to toggle popover")
                  )
        );

        //language=HTML
        assertEquals("""
            <button type="button" class="btn btn-lg btn-danger" data-bs-toggle="popover" data-bs-title="Popover title" data-bs-content="And here&#x27;s some amazing content. It&#x27;s very engaging. Right?">
              Click to toggle popover
            </button>
            """, renderedHtml);

        // document
        uiDocumentation.document("live-demo", renderedHtml);

        uiDocumentation.documentSource("live-demo");

    }

    @Test
    void fourDirections() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withData("bs-container","body")
                                .withData("bs-toggle","popover")
                                .withData("bs-placement","top")
                                .withData("bs-content","Top popover")
                                .with(
                                        text("Popover on top")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withData("bs-container","body")
                                .withData("bs-toggle","popover")
                                .withData("bs-placement","right")
                                .withData("bs-content","Right popover")
                                .with(
                                        text("Popover on right")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withData("bs-container","body")
                                .withData("bs-toggle","popover")
                                .withData("bs-placement","bottom")
                                .withData("bs-content","Bottom popover")
                                .with(
                                        text("Popover on bottom")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withData("bs-container","body")
                                .withData("bs-toggle","popover")
                                .withData("bs-placement","left")
                                .withData("bs-content","Left popover")
                                .with(
                                        text("Popover on left")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button type="button" class="btn btn-secondary" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="top" data-bs-content="Top popover">
          Popover on top
        </button>
        <button type="button" class="btn btn-secondary" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="right" data-bs-content="Right popover">
          Popover on right
        </button>
        <button type="button" class="btn btn-secondary" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="bottom" data-bs-content="Bottom popover">
          Popover on bottom
        </button>
        <button type="button" class="btn btn-secondary" data-bs-container="body" data-bs-toggle="popover" data-bs-placement="left" data-bs-content="Left popover">
          Popover on left
        </button>
        """, renderedHtml);

        // document
        uiDocumentation.document("four-directions", renderedHtml);

        uiDocumentation.documentSource("four-directions");

    }

    @Test
    void disabledElements() throws Exception {

        String renderedHtml = uiDocumentation.render(
                span()
                        .withClasses(Bootstrap.d_inline_block)
                        .withTabindex(0)
                        .withData("bs-toggle","popover")
                        .withData("bs-trigger","hover focus")
                        .withData("bs-content","Disabled popover")
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .withType("button")
                                        .withCondDisabled(true)
                                        .with(
                                                text("Disabled button")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <span class="d-inline-block" tabindex="0" data-bs-toggle="popover" data-bs-trigger="hover focus" data-bs-content="Disabled popover">
              <button class="btn btn-primary" type="button" disabled>
                Disabled button
              </button>
            </span>
            """, renderedHtml);

        // document
        uiDocumentation.document("disabled-elements", renderedHtml);

        uiDocumentation.documentSource("disabled-elements");

    }


}
