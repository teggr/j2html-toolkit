package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.div;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpacingTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void horizontalCentering() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.mx_auto, Bootstrap.p_2)
                        .withStyle("width: 200px;")
                        .with(
                                text("Centered element")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="mx-auto p-2" style="width: 200px;">
                  Centered element
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-centering", renderedHtml);

        uiDocumentation.documentSource("horizontal-centering");

    }

    @Test
    void gap() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(AriaRoles.grid, Bootstrap.gap_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 1")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 2")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 3")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 4")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="grid gap-3">
                  <div class="p-2 g-col-6">
                    Grid item 1
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 2
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 3
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 4
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("gap", renderedHtml);

        uiDocumentation.documentSource("gap");

    }

    @Test
    void rowGap() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(AriaRoles.grid, Bootstrap.gap_0, Bootstrap.row_gap_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 1")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 2")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 3")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 4")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="grid gap-0 row-gap-3">
                  <div class="p-2 g-col-6">
                    Grid item 1
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 2
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 3
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 4
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("row-gap", renderedHtml);

        uiDocumentation.documentSource("row-gap");

    }

    @Test
    void columnGap() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(AriaRoles.grid, Bootstrap.gap_0, Bootstrap.column_gap_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 1")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 2")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 3")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, "g-col-6")
                                        .with(
                                                text("Grid item 4")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="grid gap-0 column-gap-3">
                  <div class="p-2 g-col-6">
                    Grid item 1
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 2
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 3
                  </div>
                  <div class="p-2 g-col-6">
                    Grid item 4
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("column-gap", renderedHtml);

        uiDocumentation.documentSource("column-gap");

    }


}
