package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InteractionsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void textSelection() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Bootstrap.user_select_all)
                                .with(
                                        text("This paragraph will be entirely selected when clicked by the user.")
                                ),
                        p()
                                .withClasses(Bootstrap.user_select_auto)
                                .with(
                                        text("This paragraph has default select behavior.")
                                ),
                        p()
                                .withClasses(Bootstrap.user_select_none)
                                .with(
                                        text("This paragraph will not be selectable when clicked by the user.")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="user-select-all">
                  This paragraph will be entirely selected when clicked by the user.
                </p>
                <p class="user-select-auto">
                  This paragraph has default select behavior.
                </p>
                <p class="user-select-none">
                  This paragraph will not be selectable when clicked by the user.
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-selection", renderedHtml);

        uiDocumentation.documentSource("text-selection");

    }

    @Test
    void pointerEvents() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.pe_none)
                                                .withTabindex(-1)
                                                .attr(
                                                        AriaStatesAndProperties.ariaDisabled("true")
                                                )
                                                .with(
                                                        text("This link")
                                                ),
                                        text("can not be clicked.")
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.pe_auto)
                                                .with(
                                                        text("This link")
                                                ),
                                        text("can be clicked (this is default behavior).")
                                ),
                        p()
                                .withClasses(Bootstrap.pe_none)
                                .with(
                                        a()
                                                .withHref("#")
                                                .withTabindex(-1)
                                                .attr(
                                                        AriaStatesAndProperties.ariaDisabled("true")
                                                )
                                                .with(
                                                        text("This link")
                                                ),
                                        text("can not be clicked because the"),
                                        code()
                                                .with(
                                                        text("pointer-events")
                                                ),
                                        text("property is inherited from its parent. However,"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.pe_auto)
                                                .with(
                                                        text("this link")
                                                ),
                                        text("has a"),
                                        code()
                                                .with(
                                                        text("pe-auto")
                                                ),
                                        text("class and can be clicked.")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <a href="#" class="pe-none" tabindex="-1" aria-disabled="true">
                    This link
                  </a> 
                  can not be clicked.
                </p>
                <p>
                  <a href="#" class="pe-auto">
                    This link
                  </a>
                  can be clicked (this is default behavior).
                </p>
                <p class="pe-none">
                  <a href="#" tabindex="-1" aria-disabled="true">
                    This link
                  </a>
                  can not be clicked because the 
                  <code>
                    pointer-events
                  </code>
                  property is inherited from its parent. However, 
                  <a href="#" class="pe-auto">
                    this link
                  </a>
                  has a
                  <code>
                    pe-auto
                  </code>
                  class and can be clicked.
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("pointer-events", renderedHtml);

        uiDocumentation.documentSource("pointer-events");

    }


}
