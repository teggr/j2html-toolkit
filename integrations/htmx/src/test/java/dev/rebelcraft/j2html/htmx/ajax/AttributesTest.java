package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.button;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AttributesTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void hxGetTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .attr(hxGet("/example"))
                        .with(
                                text("Get Some HTML")
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
                button()
                        .attr(hxPost("/account/enable"))
                        .attr(hxTarget("body"))
                        .with(
                                text("Enable Your Account")
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
                button()
                        .attr(hxPut("/account"))
                        .attr(hxTarget("body"))
                        .with(
                                text("Put Money In Your Account")
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
                button()
                        .attr(hxPatch("/account"))
                        .attr("hx-target", "body")
                        .with(
                                text("Patch Your Account")
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
                button()
                        .attr(hxDelete("/account"))
                        .attr(hxTarget("body"))
                        .with(
                                text("Delete Your Account")
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