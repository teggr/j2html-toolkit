package dev.rebelcraft.j2html.htmx;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.Htmx.hx;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntroductionHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void nutshell() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button()
                        .with(
                                text("Click Me!")
                        ),
                        (hx) -> hx.post("/clicked").trigger(click).target("#parent-div").swap(outerHTML)
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-post="/clicked" hx-trigger="click" hx-target="#parent-div" hx-swap="outerHTML">
                  Click Me!
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("nutshell", renderedHtml);

        uiDocumentation.documentSource("nutshell");

    }

    @Test
    void nutshell2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                        .withData(hx_post, "/click")
                        .with(
                                text("Click Me!")
                        )
        );

        //language=HTML
        assertEquals("""
                <a data-hx-post="/click">
                  Click Me!
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("nutshell2", renderedHtml);

        uiDocumentation.documentSource("nutshell2");

    }

    @Test
    void nutshellWrap2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button().with(text("Click Me!")), (hx) ->
                        hx.post("/clicked")
                            .trigger(click)
                            .target("#parent-div")
                            .swap(outerHTML)
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-post="/clicked" hx-trigger="click" hx-target="#parent-div" hx-swap="outerHTML">
                  Click Me!
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("nutshell", renderedHtml);

        uiDocumentation.documentSource("nutshell");

    }

    @Test
    void nutshellWrap4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button(), (hx) ->
                        hx.post("/clicked")
                                .trigger(click)
                                .target("#parent-div")
                                .swap(outerHTML)
                )
                        .with(text("Click Me!"))
        );

        //language=HTML
        assertEquals("""
                <button hx-post="/clicked" hx-trigger="click" hx-target="#parent-div" hx-swap="outerHTML">
                  Click Me!
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("nutshell", renderedHtml);

        uiDocumentation.documentSource("nutshell");

    }

}