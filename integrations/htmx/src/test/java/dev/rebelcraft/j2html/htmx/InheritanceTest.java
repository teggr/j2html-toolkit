package dev.rebelcraft.j2html.htmx;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InheritanceTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void attributeInheritance() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .attr(hxConfirm("Are you sure?"))
                        .with(
                                button()
                                        .attr(hxDelete("/account"))
                                        .with(
                                                text("Delete My Account")
                                        ),
                                button()
                                        .attr(hxPut("/account"))
                                        .with(
                                                text("Update My Account")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div hx-confirm="Are you sure?">
                  <button hx-delete="/account">
                    Delete My Account
                  </button>
                  <button hx-put="/account">
                    Update My Account
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("attribute-inheritance", renderedHtml);

        uiDocumentation.documentSource("attribute-inheritance");

    }

    @Test
    void attributeInheritance2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .attr(hxConfirm("Are you sure?"))
                        .with(
                                button()
                                        .attr(hxDelete("/account"))
                                        .with(
                                                text("Delete My Account")
                                        ),
                                button()
                                        .attr(hxPut("/account"))
                                        .with(
                                                text("Update My Account")
                                        ),
                                button()
                                        .attr(hxConfirm(unset))
                                        .attr(hxGet("/"))
                                        .with(
                                                text("Cancel")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div hx-confirm="Are you sure?">
                  <button hx-delete="/account">
                    Delete My Account
                  </button>
                  <button hx-put="/account">
                    Update My Account
                  </button>
                  <button hx-confirm="unset" hx-get="/">
                    Cancel
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("attribute-inheritance2", renderedHtml);

        uiDocumentation.documentSource("attribute-inheritance2");

    }


}
