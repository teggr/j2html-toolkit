package dev.rebelcraft.j2html.htmx;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.Htmx.hx;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.hxGet;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.hxPushUrl;
import static j2html.TagCreator.a;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void historySupport() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(a()
                        .with(
                                text("Blog")
                        ),
                        (hx) -> hx.get("/blog").pushUrl("true")
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
