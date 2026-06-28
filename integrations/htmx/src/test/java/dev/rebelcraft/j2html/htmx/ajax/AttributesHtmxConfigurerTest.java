package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.Htmx.hx;
import static j2html.TagCreator.button;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AttributesHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void hxGetTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button()
                                .with(
                                        text("Get Some HTML")
                                ),
                        (hx) -> hx.get("/example")
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-get="/example">
                  Get Some HTML
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("hx-get-test", renderedHtml);

        uiDocumentation.documentSource("hx-get-test");

    }

    @Test
    void hxPostTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button()
                                .with(
                                        text("Enable Your Account")
                                ),
                        hx -> hx.post("/account/enable").target("body")
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-post="/account/enable" hx-target="body">
                  Enable Your Account
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("hx-post-test", renderedHtml);

        uiDocumentation.documentSource("hx-post-test");

    }

    @Test
    void hxPutTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button()
                                .with(
                                        text("Put Money In Your Account")
                                ),
                        (hx) -> hx.put("/account").target("body")
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-put="/account" hx-target="body">
                  Put Money In Your Account
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("hx-put-test", renderedHtml);

        uiDocumentation.documentSource("hx-put-test");

    }

    @Test
    void hxPatchTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button()
                                .with(
                                        text("Patch Your Account")
                                ),
                        (hx) -> hx.patch("/account").target("body")
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-patch="/account" hx-target="body">
                  Patch Your Account
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("hx-patch-test", renderedHtml);

        uiDocumentation.documentSource("hx-patch-test");

    }

    @Test
    void hxDeleteTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button()
                                .with(
                                        text("Delete Your Account")
                                ),
                        (hx) -> hx.delete("/account").target("body")
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-delete="/account" hx-target="body">
                  Delete Your Account
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("hx-delete-test", renderedHtml);

        uiDocumentation.documentSource("hx-delete-test");

    }

}