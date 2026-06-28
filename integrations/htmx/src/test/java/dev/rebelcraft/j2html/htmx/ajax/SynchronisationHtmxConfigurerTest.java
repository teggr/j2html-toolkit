package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.Htmx.hx;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SynchronisationHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void synchronization() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(form()
                                .with(
                                        hx(input()
                                                        .withId("title")
                                                        .withName("title")
                                                        .withType("text"),
                                                (hx) -> hx
                                                        .post("/validate")
                                                        .trigger(change)
                                                        .sync(closest("form"), abort)
                                        ),
                                        button()
                                                .withType("submit")
                                                .with(
                                                        text("Submit")
                                                )
                                ),
                        (hx) -> hx.post("/store")
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
