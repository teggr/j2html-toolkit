package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SwappingTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void swapOptions() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .attr(hxPost("/like"))
                        .attr(hxSwap(outerHTML, ignoreTitle("true")))
                        .with(
                                text("Like")
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
