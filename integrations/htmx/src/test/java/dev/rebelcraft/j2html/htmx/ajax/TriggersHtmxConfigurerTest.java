package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.Htmx.hx;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TriggersHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void triggeringRequests() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(div()
                                .with(
                                        text("[Here Mouse, Mouse!]")
                                ),
                        (hx) -> hx.post("/mouse_entered").trigger(mouseenter)
                )
        );

        //language=HTML
        assertEquals("""
                <div hx-post="/mouse_entered" hx-trigger="mouseenter">
                  [Here Mouse, Mouse!]
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("triggering-requests", renderedHtml);

        uiDocumentation.documentSource("triggering-requests");

    }

    @Test
    void triggerModifiers() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(div()
                        .with(
                                text("[Here Mouse, Mouse!]")
                        ),
                        (hx) -> hx.post("/mouse_entered").trigger(mouseenter, once)
                )
        );

        //language=HTML
        assertEquals("""
                <div hx-post="/mouse_entered" hx-trigger="mouseenter once">
                  [Here Mouse, Mouse!]
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("trigger-modifiers", renderedHtml);

        uiDocumentation.documentSource("trigger-modifiers");

    }

    @Test
    void triggerModifiers2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        hx(input()
                                .withType("text")
                                .withName("q")
                                .withPlaceholder("Search..."),
                                (hx -> hx.get("/trigger_delay").trigger(keyup, changed, delay("500ms")).target("#search-results"))
                        ),
                        div()
                                .withId("search-results")
                )
        );

        //language=HTML
        assertEquals("""
                <input type="text" name="q" placeholder="Search..." hx-get="/trigger_delay" hx-trigger="keyup changed delay:500ms" hx-target="#search-results">
                <div id="search-results">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("trigger-modifiers2", renderedHtml);

        uiDocumentation.documentSource("trigger-modifiers2");

    }

    @Test
    void triggerFilters() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(div()
                        .with(
                                text("Control Click Me")
                        ),
                        (hx) -> hx.get("/clicked").trigger(filteredEvent(click, "ctrlKey"))
                )
        );

        //language=HTML
        assertEquals("""
                <div hx-get="/clicked" hx-trigger="click[ctrlKey]">
                  Control Click Me
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("trigger-filters", renderedHtml);

        uiDocumentation.documentSource("trigger-filters");

    }

    @Test
    void pollingTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(div(),
                        (hx) -> hx.get("/news").trigger(every("2s"))
                )
        );

        //language=HTML
        assertEquals("""
                <div hx-get="/news" hx-trigger="every 2s">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("polling-test", renderedHtml);

        uiDocumentation.documentSource("polling-test");

    }

    @Test
    void loadPolling() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(div(),
                        (hx) -> hx.get("/messages").trigger(load(delay("1s"))).swap(outerHTML)
                )
        );

        //language=HTML
        assertEquals("""
                <div hx-get="/messages" hx-trigger="load delay:1s" hx-swap="outerHTML">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("load-polling", renderedHtml);

        uiDocumentation.documentSource("load-polling");

    }


}
