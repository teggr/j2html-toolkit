package dev.rebelcraft.j2html.htmx;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void historySupport() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                        .attr(hxGet("/blog"))
                        .attr(hxPushUrl("true"))
                        .with(
                                text("Blog")
                        )
        );

        //language=HTML
        assertEquals("""
                <a hx-get="/blog" hx-push-url="true">
                  Blog
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("history-support", renderedHtml);

        uiDocumentation.documentSource("history-support");

    }


}
