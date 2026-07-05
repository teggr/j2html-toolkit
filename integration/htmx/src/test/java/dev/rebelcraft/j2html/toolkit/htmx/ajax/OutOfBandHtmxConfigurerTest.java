package dev.rebelcraft.j2html.toolkit.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.toolkit.htmx.Htmx.hx;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OutOfBandHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void outOfBandSwaps() throws Exception {

        String renderedHtml = DocRenderer.domContentToString(
                each(
                        hx(div()
                                .withId("message")
                                .with(
                                        text("Swap me directly!")
                                ),
                                (hx) -> hx.swapOob("true")
                        ),
                        text("Additional Content")
                )
        );

        //language=HTML
        assertEquals("""
                <div id="message" hx-swap-oob="true">
                  Swap me directly!
                </div>
                Additional Content
                """, renderedHtml);

        // document
        uiDocumentation.document("out-of-band-swaps", renderedHtml);

        uiDocumentation.documentSource("out-of-band-swaps");

    }



}
