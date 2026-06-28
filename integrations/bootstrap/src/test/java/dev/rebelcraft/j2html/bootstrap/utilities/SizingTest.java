package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SizingTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void relativeToParent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.w_25, Bootstrap.p_3)
                                .with(
                                        text("Width 25%")
                                ),
                        div()
                                .withClasses(Bootstrap.w_50, Bootstrap.p_3)
                                .with(
                                        text("Width 50%")
                                ),
                        div()
                                .withClasses(Bootstrap.w_75, Bootstrap.p_3)
                                .with(
                                        text("Width 75%")
                                ),
                        div()
                                .withClasses(Bootstrap.w_100, Bootstrap.p_3)
                                .with(
                                        text("Width 100%")
                                ),
                        div()
                                .withClasses(Bootstrap.w_auto, Bootstrap.p_3)
                                .with(
                                        text("Width auto")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="w-25 p-3">
                  Width 25%
                </div>
                <div class="w-50 p-3">
                  Width 50%
                </div>
                <div class="w-75 p-3">
                  Width 75%
                </div>
                <div class="w-100 p-3">
                  Width 100%
                </div>
                <div class="w-auto p-3">
                  Width auto
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("relative-to-parent", renderedHtml);

        uiDocumentation.documentSource("relative-to-parent");

    }

    @Test
    void relativeToParent2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withStyle("height: 100px;")
                        .with(
                                div()
                                        .withClasses(Bootstrap.h_25, Bootstrap.d_inline_block)
                                        .withStyle("width: 120px;")
                                        .with(
                                                text("Height 25%")
                                        ),
                                div()
                                        .withClasses(Bootstrap.h_50, Bootstrap.d_inline_block)
                                        .withStyle("width: 120px;")
                                        .with(
                                                text("Height 50%")
                                        ),
                                div()
                                        .withClasses(Bootstrap.h_75, Bootstrap.d_inline_block)
                                        .withStyle("width: 120px;")
                                        .with(
                                                text("Height 75%")
                                        ),
                                div()
                                        .withClasses(Bootstrap.h_100, Bootstrap.d_inline_block)
                                        .withStyle("width: 120px;")
                                        .with(
                                                text("Height 100%")
                                        ),
                                div()
                                        .withClasses(Bootstrap.h_auto, Bootstrap.d_inline_block)
                                        .withStyle("width: 120px;")
                                        .with(
                                                text("Height auto")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div style="height: 100px;">
                  <div class="h-25 d-inline-block" style="width: 120px;">
                    Height 25%
                  </div>
                  <div class="h-50 d-inline-block" style="width: 120px;">
                    Height 50%
                  </div>
                  <div class="h-75 d-inline-block" style="width: 120px;">
                    Height 75%
                  </div>
                  <div class="h-100 d-inline-block" style="width: 120px;">
                    Height 100%
                  </div>
                  <div class="h-auto d-inline-block" style="width: 120px;">
                    Height auto
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("relative-to-parent2", renderedHtml);

        uiDocumentation.documentSource("relative-to-parent2");

    }

    @Test
    void relativeToParent3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withStyle("width: 50%; height: 100px;")
                        .with(
                                div()
                                        .withClasses(Bootstrap.mw_100)
                                        .withStyle("width: 200%;")
                                        .with(
                                                text("Max-width 100%")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div style="width: 50%; height: 100px;">
                  <div class="mw-100" style="width: 200%;">
                    Max-width 100%
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("relative-to-parent3", renderedHtml);

        uiDocumentation.documentSource("relative-to-parent3");

    }

    @Test
    void relativeToParent4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withStyle("height: 100px;")
                        .with(
                                div()
                                        .withClasses(Bootstrap.mh_100)
                                        .withStyle("width: 100px; height: 200px;")
                                        .with(
                                                text("Max-height 100%")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div style="height: 100px;">
                  <div class="mh-100" style="width: 100px; height: 200px;">
                    Max-height 100%
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("relative-to-parent4", renderedHtml);

        uiDocumentation.documentSource("relative-to-parent4");

    }

    @Test
    void relativeToTheViewport() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.min_vw_100)
                                .with(
                                        text("Min-width 100vw")
                                ),
                        div()
                                .withClasses(Bootstrap.min_vh_100)
                                .with(
                                        text("Min-height 100vh")
                                ),
                        div()
                                .withClasses(Bootstrap.vw_100)
                                .with(
                                        text("Width 100vw")
                                ),
                        div()
                                .withClasses(Bootstrap.vh_100)
                                .with(
                                        text("Height 100vh")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="min-vw-100">
                  Min-width 100vw
                </div>
                <div class="min-vh-100">
                  Min-height 100vh
                </div>
                <div class="vw-100">
                  Width 100vw
                </div>
                <div class="vh-100">
                  Height 100vh
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("relative-to-the-viewport", renderedHtml);

        uiDocumentation.documentSource("relative-to-the-viewport");

    }

}
