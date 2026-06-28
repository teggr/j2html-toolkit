package dev.rebelcraft.j2html.bootstrap.layout;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.comment;
import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void gridExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-example", renderedHtml);

        uiDocumentation.documentSource("grid-example");

    }

    @Test
    void equalWidthExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("1 of 2")
                                                        .withClass(Bootstrap.col),
                                                div("2 of 2")
                                                        .withClass(Bootstrap.col)
                                        ),
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("1 of 3")
                                                        .withClass(Bootstrap.col),
                                                div("2 of 3")
                                                        .withClass(Bootstrap.col),
                                                div("3 of 3")
                                                        .withClass(Bootstrap.col)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col">
                      1 of 2
                    </div>
                    <div class="col">
                      2 of 2
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      1 of 3
                    </div>
                    <div class="col">
                      2 of 3
                    </div>
                    <div class="col">
                      3 of 3
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("equal-width-example", renderedHtml);

        uiDocumentation.documentSource("equal-width-example");

    }

    @Test
    void oneColumnWidthExample() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("1 of 3")
                                                        .withClass(Bootstrap.col),
                                                div("2 of 3 (wider)")
                                                        .withClass(Bootstrap.col_6),
                                                div("3 of 3")
                                                        .withClass(Bootstrap.col)
                                        ),
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("1 of 3")
                                                        .withClass(Bootstrap.col),
                                                div("2 of 3 (wider)")
                                                        .withClass(Bootstrap.col_5),
                                                div("3 of 3")
                                                        .withClass(Bootstrap.col)
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col">
                      1 of 3
                    </div>
                    <div class="col-6">
                      2 of 3 (wider)
                    </div>
                    <div class="col">
                      3 of 3
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      1 of 3
                    </div>
                    <div class="col-5">
                      2 of 3 (wider)
                    </div>
                    <div class="col">
                      3 of 3
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("one-column-width-example", renderedHtml);

        uiDocumentation.documentSource("one-column-width-example");

    }

    @Test
    void variableWidthExample() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.justify_content_md_center)
                                        .with(
                                                div("1 of 3")
                                                        .withClasses(Bootstrap.col, Bootstrap.col_lg_2),
                                                div("Variable width content")
                                                        .withClass(Bootstrap.col_md_auto),
                                                div("3 of 3")
                                                        .withClasses(Bootstrap.col, Bootstrap.col_lg_2)
                                        ),
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("1 of 3")
                                                        .withClass(Bootstrap.col),
                                                div("Variable width content")
                                                        .withClass(Bootstrap.col_md_auto),
                                                div("3 of 3")
                                                        .withClasses(Bootstrap.col, Bootstrap.col_lg_2)
                                        )
                        )


        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row justify-content-md-center">
                    <div class="col col-lg-2">
                      1 of 3
                    </div>
                    <div class="col-md-auto">
                      Variable width content
                    </div>
                    <div class="col col-lg-2">
                      3 of 3
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      1 of 3
                    </div>
                    <div class="col-md-auto">
                      Variable width content
                    </div>
                    <div class="col col-lg-2">
                      3 of 3
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("variable-width-example", renderedHtml);

        uiDocumentation.documentSource("variable-width-example");

    }

    @Test
    void responsiveClassesAllBreakpointsExample() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("col")
                                                        .withClass(Bootstrap.col),
                                                div("col")
                                                        .withClass(Bootstrap.col),
                                                div("col")
                                                        .withClass(Bootstrap.col),
                                                div("col")
                                                        .withClass(Bootstrap.col)
                                        ),
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("col-8")
                                                        .withClass(Bootstrap.col_8),
                                                div("col-4")
                                                        .withClass(Bootstrap.col_4)
                                        )
                        )


        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col">
                      col
                    </div>
                    <div class="col">
                      col
                    </div>
                    <div class="col">
                      col
                    </div>
                    <div class="col">
                      col
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-8">
                      col-8
                    </div>
                    <div class="col-4">
                      col-4
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("responsive-classes-all-breakpoints-example", renderedHtml);

        uiDocumentation.documentSource("responsive-classes-all-breakpoints-example");

    }

    @Test
    void stackedToHorizontalExample() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("col")
                                                        .withClass(Bootstrap.col),
                                                div("col")
                                                        .withClass(Bootstrap.col),
                                                div("col")
                                                        .withClass(Bootstrap.col),
                                                div("col")
                                                        .withClass(Bootstrap.col)
                                        ),
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("col-8")
                                                        .withClass(Bootstrap.col_8),
                                                div("col-4")
                                                        .withClass(Bootstrap.col_4)
                                        )
                        )


        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col">
                      col
                    </div>
                    <div class="col">
                      col
                    </div>
                    <div class="col">
                      col
                    </div>
                    <div class="col">
                      col
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-8">
                      col-8
                    </div>
                    <div class="col-4">
                      col-4
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("stacked-to-horizontal-example", renderedHtml);

        uiDocumentation.documentSource("stacked-to-horizontal-example");

    }

    @Test
    void mixAndMatchExample() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                comment("Stack the columns on mobile by making one full-width and the other half-width"),
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div(".col-md-8")
                                                        .withClass(Bootstrap.col_md_8),
                                                div(".col-6.col-md-4")
                                                        .withClasses(Bootstrap.col_6, Bootstrap.col_md_4)
                                        ),
                                comment("Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop"),
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div(".col-6.col-md-4")
                                                        .withClasses(Bootstrap.col_6, Bootstrap.col_md_4),
                                                div(".col-6.col-md-4")
                                                        .withClasses(Bootstrap.col_6, Bootstrap.col_md_4),
                                                div(".col-6.col-md-4")
                                                        .withClasses(Bootstrap.col_6, Bootstrap.col_md_4)
                                        ),
                                comment("Columns are always 50% wide, on mobile and desktop"),
                                div()
                                        .withClass("row")
                                        .with(
                                                div(".col-6")
                                                        .withClass(Bootstrap.col_6),
                                                div(".col-6")
                                                        .withClass(Bootstrap.col_6)
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <!-- Stack the columns on mobile by making one full-width and the other half-width -->
                  <div class="row">
                    <div class="col-md-8">
                      .col-md-8
                    </div>
                    <div class="col-6 col-md-4">
                      .col-6.col-md-4
                    </div>
                  </div>
                  <!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
                  <div class="row">
                    <div class="col-6 col-md-4">
                      .col-6.col-md-4
                    </div>
                    <div class="col-6 col-md-4">
                      .col-6.col-md-4
                    </div>
                    <div class="col-6 col-md-4">
                      .col-6.col-md-4
                    </div>
                  </div>
                  <!-- Columns are always 50% wide, on mobile and desktop -->
                  <div class="row">
                    <div class="col-6">
                      .col-6
                    </div>
                    <div class="col-6">
                      .col-6
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("mix-and-match-example", renderedHtml);

        uiDocumentation.documentSource("mix-and-match-example");

    }

    @Test
    void rowColumnsExample1() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.row_cols_2)
                                        .with(
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col)
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row row-cols-2">
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("row-columns-example-1", renderedHtml);

        uiDocumentation.documentSource("row-columns-example-1");

    }

    @Test
    void rowColumnsExample2() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.row_cols_3)
                                        .with(
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col)
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row row-cols-3">
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("row-columns-example-2", renderedHtml);

        uiDocumentation.documentSource("row-columns-example-2");

    }

    @Test
    void rowColumnsExample3() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.row_cols_auto)
                                        .with(
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col)
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row row-cols-auto">
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("row-columns-example-3", renderedHtml);

        uiDocumentation.documentSource("row-columns-example-3");

    }

    @Test
    void rowColumnsExample4() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.row_cols_4)
                                        .with(
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col)
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row row-cols-4">
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("row-columns-example-4", renderedHtml);

        uiDocumentation.documentSource("row-columns-example-4");

    }

    @Test
    void rowColumnsExample5() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.row_cols_4)
                                        .with(
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col_6),
                                                div("Column")
                                                        .withClass(Bootstrap.col)
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row row-cols-4">
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col-6">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("row-columns-example-5", renderedHtml);

        uiDocumentation.documentSource("row-columns-example-5");

    }

    @Test
    void rowColumnsExample6() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.row_cols_1, Bootstrap.row_cols_sm_2, Bootstrap.row_cols_md_4)
                                        .with(
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col),
                                                div("Column")
                                                        .withClass(Bootstrap.col)
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row row-cols-1 row-cols-sm-2 row-cols-md-4">
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                    <div class="col">
                      Column
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("row-columns-example-6", renderedHtml);

        uiDocumentation.documentSource("row-columns-example-6");

    }

    @Test
    void nestingExample() throws Exception {

        String renderedHtml = uiDocumentation.render(

                div()
                        .withClasses(Bootstrap.container, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClass(Bootstrap.row)
                                        .with(
                                                div("Level 1: .col-sm-3")
                                                        .withClass(Bootstrap.col_sm_3),
                                                div()
                                                        .withClass(Bootstrap.col_sm_9)
                                                        .with(
                                                                div()
                                                                        .withClass(Bootstrap.row)
                                                                        .with(
                                                                                div("Level 2: .col-8 .col-sm-6")
                                                                                        .withClasses(Bootstrap.col_8, Bootstrap.col_sm_6),
                                                                                div("Level 2: .col-4 .col-sm-6")
                                                                                        .withClasses(Bootstrap.col_4, Bootstrap.col_sm_6)
                                                                        )
                                                        )
                                        )
                        )

        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col-sm-3">
                      Level 1: .col-sm-3
                    </div>
                    <div class="col-sm-9">
                      <div class="row">
                        <div class="col-8 col-sm-6">
                          Level 2: .col-8 .col-sm-6
                        </div>
                        <div class="col-4 col-sm-6">
                          Level 2: .col-4 .col-sm-6
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("nesting-example", renderedHtml);

        uiDocumentation.documentSource("nesting-example");

    }

}