package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.Htmx.hx;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TargetsHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void targets() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        hx(input()
                                .withType("text")
                                .withName("q")
                                .withPlaceholder("Search..."),
                                (hx) -> hx.get("/trigger_delay").trigger(keyup,delay("500ms"),changed).target("#search-results")
                        ),
                        div()
                                .withId("search-results")
                )
        );

        //language=HTML
        assertEquals("""
                <input type="text" name="q" placeholder="Search..." hx-get="/trigger_delay" hx-trigger="keyup delay:500ms changed" hx-target="#search-results">
                <div id="search-results">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("targets", renderedHtml);

        uiDocumentation.documentSource("targets");

    }



}
