package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SynchronisationTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void synchronization() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .attr(hxPost("/store"))
                        .with(
                                input()
                                        .withId("title")
                                        .withName("title")
                                        .withType("text")
                                        .attr(hxPost("/validate"))
                                        .attr(hxTrigger(change))
                                        .attr(hxSync(closest("form"), abort)),
                                button()
                                        .withType("submit")
                                        .with(
                                                text("Submit")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form hx-post="/store">
                  <input id="title" name="title" type="text" hx-post="/validate" hx-trigger="change" hx-sync="closest form:abort">
                  <button type="submit">
                    Submit
                  </button>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("synchronization", renderedHtml);

        uiDocumentation.documentSource("synchronization");

    }


}
