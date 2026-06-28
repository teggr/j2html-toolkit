package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TriggersTest {

    private dev.rebelcraft.uitest.UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void triggeringRequests() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                 .attr(hxPost("/mouse_entered"))
                 .attr(hxTrigger(mouseenter))
                 .with(
                    text("[Here Mouse, Mouse!]")
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
                div()
                        .attr(hxPost("/mouse_entered"))
                        .attr(hxTrigger(mouseenter, once))
                        .with(
                                text("[Here Mouse, Mouse!]")
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
                        input()
                                .withType("text")
                                .withName("q")
                                .attr(hxGet("/trigger_delay"))
                                .attr(hxTrigger(keyup, changed, delay("500ms")))
                                .attr(hxTarget("#search-results"))
                                .withPlaceholder("Search..."),
                        div()
                                .withId("search-results")
                )
        );

        //language=HTML
        assertEquals("""
                <input type="text" name="q" hx-get="/trigger_delay" hx-trigger="keyup changed delay:500ms" hx-target="#search-results" placeholder="Search...">
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
                div()
                        .attr(hxGet("/clicked"))
                        .attr(hxTrigger(filteredEvent(click, "ctrlKey")))
                        .with(
                                text("Control Click Me")
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
                div()
                        .attr(hxGet("/news"))
                        .attr(hxTrigger(every("2s")))
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
                div()
                        .attr(hxGet("/messages"))
                        .attr(hxTrigger(load(delay("1s"))))
                        .attr(hxSwap(outerHTML))
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
