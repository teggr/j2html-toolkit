package dev.rebelcraft.j2html.htmx;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoostingTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void boostingTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .attr(hxBoost("true"))
                        .with(
                                a()
                                        .withHref("/blog")
                                        .with(
                                                text("Blog")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div hx-boost="true">
                  <a href="/blog">
                    Blog
                  </a>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("boosting-test", renderedHtml);

        uiDocumentation.documentSource("boosting-test");

    }

    @Test
    void progressiveEnhancement() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withAction("/search")
                        .withMethod("POST")
                        .with(
                                input()
                                        .withClasses("form-control")
                                        .withType("search")
                                        .withName("search")
                                        .withPlaceholder("Begin typing to search users...")
                                        .attr(hxPost("/search"))
                                        .attr(hxTrigger(keyup, changed, delay("500ms,"), "search"))
                                        .attr(hxTarget("#search-results"))
                                        .attr(hxIndicator(".htmx-indicator"))
                        )
        );

        //language=HTML
        assertEquals("""
                <form action="/search" method="POST">
                  <input class="form-control" type="search" name="search" placeholder="Begin typing to search users..." hx-post="/search" hx-trigger="keyup changed delay:500ms, search" hx-target="#search-results" hx-indicator=".htmx-indicator">
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("progressive-enhancement", renderedHtml);

        uiDocumentation.documentSource("progressive-enhancement");

    }


}
