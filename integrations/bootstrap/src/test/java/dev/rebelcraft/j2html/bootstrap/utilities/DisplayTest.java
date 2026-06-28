package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DisplayTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.d_inline, Bootstrap.p_2, Bootstrap.text_bg_primary)
                                .with(
                                        text("d-inline")
                                ),
                        div()
                                .withClasses(Bootstrap.d_inline, Bootstrap.p_2, Bootstrap.text_bg_dark)
                                .with(
                                        text("d-inline")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="d-inline p-2 text-bg-primary">
                  d-inline
                </div>
                <div class="d-inline p-2 text-bg-dark">
                  d-inline
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void example2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Bootstrap.d_block, Bootstrap.p_2, Bootstrap.text_bg_primary)
                                .with(
                                        text("d-block")
                                ),
                        span()
                                .withClasses(Bootstrap.d_block, Bootstrap.p_2, Bootstrap.text_bg_dark)
                                .with(
                                        text("d-block")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <span class="d-block p-2 text-bg-primary">
                  d-block
                </span>
                <span class="d-block p-2 text-bg-dark">
                  d-block
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("example2", renderedHtml);

        uiDocumentation.documentSource("example2");

    }

    @Test
    void hiding() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.d_lg_none)
                                .with(
                                        text("hide on lg and wider screens")
                                ),
                        div()
                                .withClasses(Bootstrap.d_none, Bootstrap.d_lg_block)
                                .with(
                                        text("hide on screens smaller than lg")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="d-lg-none">
                  hide on lg and wider screens
                </div>
                <div class="d-none d-lg-block">
                  hide on screens smaller than lg
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("hiding", renderedHtml);

        uiDocumentation.documentSource("hiding");

    }

    @Test
    void displayInPrint() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.d_print_none)
                                .with(
                                        text("Screen Only (Hide on print only)")
                                ),
                        div()
                                .withClasses(Bootstrap.d_none, Bootstrap.d_print_block)
                                .with(
                                        text("Print Only (Hide on screen only)")
                                ),
                        div()
                                .withClasses(Bootstrap.d_none, Bootstrap.d_lg_block, Bootstrap.d_print_block)
                                .with(
                                        text("Hide up to large on screen, but always show on print")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="d-print-none">
                  Screen Only (Hide on print only)
                </div>
                <div class="d-none d-print-block">
                  Print Only (Hide on screen only)
                </div>
                <div class="d-none d-lg-block d-print-block">
                  Hide up to large on screen, but always show on print
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("display-in-print", renderedHtml);

        uiDocumentation.documentSource("display-in-print");

    }


}
