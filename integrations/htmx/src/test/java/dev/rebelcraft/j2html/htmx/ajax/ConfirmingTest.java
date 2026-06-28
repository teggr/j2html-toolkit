package dev.rebelcraft.j2html.htmx.ajax;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfirmingTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void confirmingRequests() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .attr(hxDelete("/account"))
                        .attr(hxConfirm("Are you sure you wish to delete your account?"))
                        .with(
                                text("Delete My Account")
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
