package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.Htmx.hx;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.button;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SwappingHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void swapOptions() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button()
                        .with(
                                text("Like")
                        ),
                        (hx) -> hx.post("/like").swap(outerHTML, ignoreTitle("true"))
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-post="/like" hx-swap="outerHTML ignoreTitle:true">
                  Like
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("swap-options", renderedHtml);

        uiDocumentation.documentSource("swap-options");

    }


}
