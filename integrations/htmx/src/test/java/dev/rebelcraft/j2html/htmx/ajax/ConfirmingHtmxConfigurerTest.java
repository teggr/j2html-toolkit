package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.Htmx.hx;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.hxConfirm;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.hxDelete;
import static j2html.TagCreator.button;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfirmingHtmxConfigurerTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void confirmingRequests() throws Exception {

        String renderedHtml = uiDocumentation.render(
                hx(button()
                        .with(
                                text("Delete My Account")
                        ),
                        (hx) -> hx.delete("/account").confirm("Are you sure you wish to delete your account?")
                )
        );

        //language=HTML
        assertEquals("""
                <button hx-delete="/account" hx-confirm="Are you sure you wish to delete your account?">
                  Delete My Account
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("confirming-requests", renderedHtml);

        uiDocumentation.documentSource("confirming-requests");

    }


}
