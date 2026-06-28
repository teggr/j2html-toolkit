package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IndicatorsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void requestIndicators() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .attr(hxGet("/click"))
                        .with(
                                text("Click Me!"),
                                img()
                                        .withClasses(htmx_indicator)
                                        .withSrc("/spinner.gif")
                        )
        );

        //language=HTML
        assertEquals("""
                <button hx-get="/click">
                  Click Me!
                  <img class="htmx-indicator" src="/spinner.gif">
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("request-indicators", renderedHtml);

        uiDocumentation.documentSource("request-indicators");

    }

    @Test
    void requestIndicators2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .with(
                                button()
                                        .attr(hxGet("/click"))
                                        .attr(hxIndicator("#indicator"))
                                        .with(
                                                text("Click Me!")
                                        ),
                                img()
                                        .withId("indicator")
                                        .withClasses(htmx_indicator)
                                        .withSrc("/spinner.gif")
                        )
        );

        //language=HTML
        assertEquals("""
                <div>
                  <button hx-get="/click" hx-indicator="#indicator">
                    Click Me!
                  </button>
                  <img id="indicator" class="htmx-indicator" src="/spinner.gif">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("request-indicators2", renderedHtml);

        uiDocumentation.documentSource("request-indicators2");

    }


}
