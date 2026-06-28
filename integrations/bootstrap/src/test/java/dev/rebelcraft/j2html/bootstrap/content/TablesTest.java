package dev.rebelcraft.j2html.bootstrap.content;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import j2html.tags.specialized.TbodyTag;
import j2html.tags.specialized.TheadTag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TablesTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void tablesTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
         .withClasses(Bootstrap.table)
         .with(
             testHead(),
             testBody()
          )
        );

        //language=HTML
        assertEquals("""
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">
                    #
                  </th>
                  <th scope="col">
                    First
                  </th>
                  <th scope="col">
                    Last
                  </th>
                  <th scope="col">
                    Handle
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">
                    1
                  </th>
                  <td>
                    Mark
                  </td>
                  <td>
                    Otto
                  </td>
                  <td>
                    @mdo
                  </td>
                </tr>
                <tr>
                  <th scope="row">
                    2
                  </th>
                  <td>
                    Jacob
                  </td>
                  <td>
                    Thornton
                  </td>
                  <td>
                    @fat
                  </td>
                </tr>
                <tr>
                  <th scope="row">
                    3
                  </th>
                  <td colspan="2">
                    Larry the Bird
                  </td>
                  <td>
                    @twitter
                  </td>
                </tr>
              </tbody>
            </table>
            """, renderedHtml);

        // document
        uiDocumentation.document("tables-test", renderedHtml);

        uiDocumentation.documentSource("tables-test");

    }

    @Test
    void stripedRows() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_striped)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("accented-tables", renderedHtml);

        uiDocumentation.documentSource("accented-tables");

    }

    @Test
    void stripedColumns() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_striped_columns)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("striped-columns", renderedHtml);

        uiDocumentation.documentSource("striped-columns");

    }

    @Test
    void stripedColumns2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_dark, Bootstrap.table_striped)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-dark table-striped">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("striped-columns2", renderedHtml);

        uiDocumentation.documentSource("striped-columns2");

    }

    @Test
    void stripedColumns3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_dark, Bootstrap.table_striped_columns)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-dark table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("striped-columns3", renderedHtml);

        uiDocumentation.documentSource("striped-columns3");

    }

    @Test
    void stripedColumns4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_success, Bootstrap.table_striped)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-success table-striped">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("striped-columns4", renderedHtml);

        uiDocumentation.documentSource("striped-columns4");

    }

    @Test
    void stripedColumns5() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_success, Bootstrap.table_striped_columns)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-success table-striped-columns">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("striped-columns5", renderedHtml);

        uiDocumentation.documentSource("striped-columns5");

    }

    @Test
    void hoverableRows() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_hover)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("hoverable-rows", renderedHtml);

        uiDocumentation.documentSource("hoverable-rows");

    }

    @Test
    void hoverableRows2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_dark, Bootstrap.table_hover)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-dark table-hover">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("hoverable-rows2", renderedHtml);

        uiDocumentation.documentSource("hoverable-rows2");

    }

    @Test
    void hoverableRows3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_striped, Bootstrap.table_hover)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-striped table-hover">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("hoverable-rows3", renderedHtml);

        uiDocumentation.documentSource("hoverable-rows3");

    }

    @Test
    void activeTables() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table)
                        .with(
                                testHead(),
                                tbody()
                                        .with(
                                                tr()
                                                        .withClasses(Bootstrap.table_active)
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("1")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Mark")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Otto")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@mdo")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("2")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Jacob")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Thornton")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@fat")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("3")
                                                                        ),
                                                                td()
                                                                        .withClasses(Bootstrap.table_active)
                                                                        .withColspan("2")
                                                                        .with(
                                                                                text("Larry the Bird")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@twitter")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr class="table-active">
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td class="table-active" colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("active-tables", renderedHtml);

        uiDocumentation.documentSource("active-tables");

    }

    @Test
    void activeTables2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_dark)
                        .with(
                                testHead(),
                                tbody()
                                        .with(
                                                tr()
                                                        .withClasses(Bootstrap.table_active)
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("1")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Mark")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Otto")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@mdo")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("2")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Jacob")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Thornton")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@fat")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("3")
                                                                        ),
                                                                td()
                                                                        .withClasses(Bootstrap.table_active)
                                                                        .withColspan("2")
                                                                        .with(
                                                                                text("Larry the Bird")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@twitter")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-dark">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr class="table-active">
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td class="table-active" colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("active-tables", renderedHtml);

        uiDocumentation.documentSource("active-tables");

    }

    @Test
    void borderedTables() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_bordered)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-bordered">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("bordered-tables", renderedHtml);

        uiDocumentation.documentSource("bordered-tables");

    }

    @Test
    void borderedTables2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_bordered, Bootstrap.border_primary)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-bordered border-primary">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("bordered-tables2", renderedHtml);

        uiDocumentation.documentSource("bordered-tables2");

    }

    @Test
    void tablesWithoutBorders() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_borderless)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-borderless">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("tables-without-borders", renderedHtml);

        uiDocumentation.documentSource("tables-without-borders");

    }

    @Test
    void tablesWithoutBorders2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_dark, Bootstrap.table_borderless)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-dark table-borderless">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("tables-without-borders2", renderedHtml);

        uiDocumentation.documentSource("tables-without-borders2");

    }

    @Test
    void smallTables() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_sm)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-sm">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("small-tables", renderedHtml);

        uiDocumentation.documentSource("small-tables");

    }

    @Test
    void smallTables2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_dark, Bootstrap.table_sm)
                        .with(
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-dark table-sm">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("small-tables2", renderedHtml);

        uiDocumentation.documentSource("small-tables2");

    }

    @Test
    void tableGroupDividers() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table)
                        .with(
                                testHead(),
                                tbody()
                                        .withClasses(Bootstrap.table_group_divider)
                                        .with(
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("1")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Mark")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Otto")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@mdo")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("2")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Jacob")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Thornton")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@fat")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("3")
                                                                        ),
                                                                td()
                                                                        .withColspan("2")
                                                                        .with(
                                                                                text("Larry the Bird")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@twitter")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody class="table-group-divider">
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("table-group-dividers", renderedHtml);

        uiDocumentation.documentSource("table-group-dividers");

    }

    @Test
    void verticalAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.align_middle)
                        .with(
                                thead()
                                        .with(
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .withClasses(Bootstrap.w_25)
                                                                        .with(
                                                                                text("Heading 1")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .withClasses(Bootstrap.w_25)
                                                                        .with(
                                                                                text("Heading 2")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .withClasses(Bootstrap.w_25)
                                                                        .with(
                                                                                text("Heading 3")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .withClasses(Bootstrap.w_25)
                                                                        .with(
                                                                                text("Heading 4")
                                                                        )
                                                        )
                                        ),
                                tbody()
                                        .with(
                                                tr()
                                                        .with(
                                                                td()
                                                                        .with(
                                                                                text("This cell inherits "),
                                                                                code()
                                                                                        .with(
                                                                                                text("vertical-align: middle;")
                                                                                        ),
                                                                                text(" from the table")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("This cell inherits "),
                                                                                code()
                                                                                        .with(
                                                                                                text("vertical-align: middle;")
                                                                                        ),
                                                                                text(" from the table")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("This cell inherits "),
                                                                                code()
                                                                                        .with(
                                                                                                text("vertical-align: middle;")
                                                                                        ),
                                                                                text(" from the table")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("This here is some placeholder text, intended to take up quite a bit of vertical space, to demonstrate how the vertical alignment works in the preceding cells.")
                                                                        )
                                                        ),
                                                tr()
                                                        .withClasses(Bootstrap.align_bottom)
                                                        .with(
                                                                td()
                                                                        .with(
                                                                                text("This cell inherits "),
                                                                                code()
                                                                                        .with(
                                                                                                text("vertical-align: bottom;")
                                                                                        ),
                                                                                text(" from the table row")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("This cell inherits "),
                                                                                code()
                                                                                        .with(
                                                                                                text("vertical-align: bottom;")
                                                                                        ),
                                                                                text(" from the table row")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("This cell inherits "),
                                                                                code()
                                                                                        .with(
                                                                                                text("vertical-align: bottom;")
                                                                                        ),
                                                                                text(" from the table row")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("This here is some placeholder text, intended to take up quite a bit of vertical space, to demonstrate how the vertical alignment works in the preceding cells.")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                td()
                                                                        .with(
                                                                                text("This cell inherits "),
                                                                                code()
                                                                                        .with(
                                                                                                text("vertical-align: middle;")
                                                                                        ),
                                                                                text(" from the table")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("This cell inherits "),
                                                                                code()
                                                                                        .with(
                                                                                                text("vertical-align: middle;")
                                                                                        ),
                                                                                text(" from the table")
                                                                        ),
                                                                td()
                                                                        .withClasses(Bootstrap.align_top)
                                                                        .with(
                                                                                text("This cell is aligned to the top.")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("This here is some placeholder text, intended to take up quite a bit of vertical space, to demonstrate how the vertical alignment works in the preceding cells.")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table align-middle">
                  <thead>
                    <tr>
                      <th scope="col" class="w-25">
                        Heading 1
                      </th>
                      <th scope="col" class="w-25">
                        Heading 2
                      </th>
                      <th scope="col" class="w-25">
                        Heading 3
                      </th>
                      <th scope="col" class="w-25">
                        Heading 4
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>
                        This cell inherits\s
                        <code>
                          vertical-align: middle;
                        </code>
                         from the table
                      </td>
                      <td>
                        This cell inherits\s
                        <code>
                          vertical-align: middle;
                        </code>
                         from the table
                      </td>
                      <td>
                        This cell inherits\s
                        <code>
                          vertical-align: middle;
                        </code>
                         from the table
                      </td>
                      <td>
                        This here is some placeholder text, intended to take up quite a bit of vertical space, to demonstrate how the vertical alignment works in the preceding cells.
                      </td>
                    </tr>
                    <tr class="align-bottom">
                      <td>
                        This cell inherits\s
                        <code>
                          vertical-align: bottom;
                        </code>
                         from the table row
                      </td>
                      <td>
                        This cell inherits\s
                        <code>
                          vertical-align: bottom;
                        </code>
                         from the table row
                      </td>
                      <td>
                        This cell inherits\s
                        <code>
                          vertical-align: bottom;
                        </code>
                         from the table row
                      </td>
                      <td>
                        This here is some placeholder text, intended to take up quite a bit of vertical space, to demonstrate how the vertical alignment works in the preceding cells.
                      </td>
                    </tr>
                    <tr>
                      <td>
                        This cell inherits\s
                        <code>
                          vertical-align: middle;
                        </code>
                         from the table
                      </td>
                      <td>
                        This cell inherits\s
                        <code>
                          vertical-align: middle;
                        </code>
                         from the table
                      </td>
                      <td class="align-top">
                        This cell is aligned to the top.
                      </td>
                      <td>
                        This here is some placeholder text, intended to take up quite a bit of vertical space, to demonstrate how the vertical alignment works in the preceding cells.
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-alignment", renderedHtml);

        uiDocumentation.documentSource("vertical-alignment");

    }

    @Test
    void nesting() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.table_striped, Bootstrap.table_bordered)
                        .with(
                                thead()
                                        .with(
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("#")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("First")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("Last")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("Handle")
                                                                        )
                                                        )
                                        ),
                                tbody()
                                        .with(
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("1")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Mark")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Otto")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@mdo")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                td()
                                                                        .withColspan("4")
                                                                        .with(
                                                                                table()
                                                                                        .withClasses(Bootstrap.table, Bootstrap.mb_0)
                                                                                        .with(
                                                                                                thead()
                                                                                                        .with(
                                                                                                                tr()
                                                                                                                        .with(
                                                                                                                                th()
                                                                                                                                        .withScope(Bootstrap.col)
                                                                                                                                        .with(
                                                                                                                                                text("Header")
                                                                                                                                        ),
                                                                                                                                th()
                                                                                                                                        .withScope(Bootstrap.col)
                                                                                                                                        .with(
                                                                                                                                                text("Header")
                                                                                                                                        ),
                                                                                                                                th()
                                                                                                                                        .withScope(Bootstrap.col)
                                                                                                                                        .with(
                                                                                                                                                text("Header")
                                                                                                                                        )
                                                                                                                        )
                                                                                                        ),
                                                                                                tbody()
                                                                                                        .with(
                                                                                                                tr()
                                                                                                                        .with(
                                                                                                                                th()
                                                                                                                                        .withScope(Bootstrap.row)
                                                                                                                                        .with(
                                                                                                                                                text("A")
                                                                                                                                        ),
                                                                                                                                td()
                                                                                                                                        .with(
                                                                                                                                                text("First")
                                                                                                                                        ),
                                                                                                                                td()
                                                                                                                                        .with(
                                                                                                                                                text("Last")
                                                                                                                                        )
                                                                                                                        ),
                                                                                                                tr()
                                                                                                                        .with(
                                                                                                                                th()
                                                                                                                                        .withScope(Bootstrap.row)
                                                                                                                                        .with(
                                                                                                                                                text("B")
                                                                                                                                        ),
                                                                                                                                td()
                                                                                                                                        .with(
                                                                                                                                                text("First")
                                                                                                                                        ),
                                                                                                                                td()
                                                                                                                                        .with(
                                                                                                                                                text("Last")
                                                                                                                                        )
                                                                                                                        ),
                                                                                                                tr()
                                                                                                                        .with(
                                                                                                                                th()
                                                                                                                                        .withScope(Bootstrap.row)
                                                                                                                                        .with(
                                                                                                                                                text("C")
                                                                                                                                        ),
                                                                                                                                td()
                                                                                                                                        .with(
                                                                                                                                                text("First")
                                                                                                                                        ),
                                                                                                                                td()
                                                                                                                                        .with(
                                                                                                                                                text("Last")
                                                                                                                                        )
                                                                                                                        )
                                                                                                        )
                                                                                        )
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.row)
                                                                        .with(
                                                                                text("3")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Larry")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("the Bird")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("@twitter")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table table-striped table-bordered">
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <td colspan="4">
                        <table class="table mb-0">
                          <thead>
                            <tr>
                              <th scope="col">
                                Header
                              </th>
                              <th scope="col">
                                Header
                              </th>
                              <th scope="col">
                                Header
                              </th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <th scope="row">
                                A
                              </th>
                              <td>
                                First
                              </td>
                              <td>
                                Last
                              </td>
                            </tr>
                            <tr>
                              <th scope="row">
                                B
                              </th>
                              <td>
                                First
                              </td>
                              <td>
                                Last
                              </td>
                            </tr>
                            <tr>
                              <th scope="row">
                                C
                              </th>
                              <td>
                                First
                              </td>
                              <td>
                                Last
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td>
                        Larry
                      </td>
                      <td>
                        the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("nesting", renderedHtml);

        uiDocumentation.documentSource("nesting");

    }

    @Test
    void tableHead() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table)
                        .with(
                                thead()
                                        .withClasses(Bootstrap.table_light)
                                        .with(
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("#")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("First")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("Last")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("Handle")
                                                                        )
                                                        )
                                        ),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
        <table class="table">
          <thead class="table-light">
            <tr>
              <th scope="col">
                #
              </th>
              <th scope="col">
                First
              </th>
              <th scope="col">
                Last
              </th>
              <th scope="col">
                Handle
              </th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">
                1
              </th>
              <td>
                Mark
              </td>
              <td>
                Otto
              </td>
              <td>
                @mdo
              </td>
            </tr>
            <tr>
              <th scope="row">
                2
              </th>
              <td>
                Jacob
              </td>
              <td>
                Thornton
              </td>
              <td>
                @fat
              </td>
            </tr>
            <tr>
              <th scope="row">
                3
              </th>
              <td colspan="2">
                Larry the Bird
              </td>
              <td>
                @twitter
              </td>
            </tr>
          </tbody>
        </table>
        """, renderedHtml);

        // document
        uiDocumentation.document("table-head", renderedHtml);

        uiDocumentation.documentSource("table-head");

    }

    @Test
    void tableHead2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table)
                        .with(
                                thead()
                                        .withClasses(Bootstrap.table_dark)
                                        .with(
                                                tr()
                                                        .with(
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("#")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("First")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("Last")
                                                                        ),
                                                                th()
                                                                        .withScope(Bootstrap.col)
                                                                        .with(
                                                                                text("Handle")
                                                                        )
                                                        )
                                        ),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
        <table class="table">
          <thead class="table-dark">
            <tr>
              <th scope="col">
                #
              </th>
              <th scope="col">
                First
              </th>
              <th scope="col">
                Last
              </th>
              <th scope="col">
                Handle
              </th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">
                1
              </th>
              <td>
                Mark
              </td>
              <td>
                Otto
              </td>
              <td>
                @mdo
              </td>
            </tr>
            <tr>
              <th scope="row">
                2
              </th>
              <td>
                Jacob
              </td>
              <td>
                Thornton
              </td>
              <td>
                @fat
              </td>
            </tr>
            <tr>
              <th scope="row">
                3
              </th>
              <td colspan="2">
                Larry the Bird
              </td>
              <td>
                @twitter
              </td>
            </tr>
          </tbody>
        </table>
        """, renderedHtml);

        // document
        uiDocumentation.document("table-head", renderedHtml);

        uiDocumentation.documentSource("table-head");

    }

    @Test
    void captions() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table)
                        .with(
                                caption()
                                        .with(
                                                text("List of users")
                                        ),
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table">
                  <caption>
                    List of users
                  </caption>
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("captions", renderedHtml);

        uiDocumentation.documentSource("captions");

    }

    @Test
    void captions2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withClasses(Bootstrap.table, Bootstrap.caption_top)
                        .with(
                                caption()
                                        .with(
                                                text("List of users")
                                        ),
                                testHead(),
                                testBody()
                        )
        );

        //language=HTML
        assertEquals("""
                <table class="table caption-top">
                  <caption>
                    List of users
                  </caption>
                  <thead>
                    <tr>
                      <th scope="col">
                        #
                      </th>
                      <th scope="col">
                        First
                      </th>
                      <th scope="col">
                        Last
                      </th>
                      <th scope="col">
                        Handle
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">
                        1
                      </th>
                      <td>
                        Mark
                      </td>
                      <td>
                        Otto
                      </td>
                      <td>
                        @mdo
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        2
                      </th>
                      <td>
                        Jacob
                      </td>
                      <td>
                        Thornton
                      </td>
                      <td>
                        @fat
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">
                        3
                      </th>
                      <td colspan="2">
                        Larry the Bird
                      </td>
                      <td>
                        @twitter
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("captions", renderedHtml);

        uiDocumentation.documentSource("captions");

    }

    @Test
    void alwaysResponsive() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.table_responsive)
                        .with(
                                table()
                                        .withClasses(Bootstrap.table)
                                        .with(
                                                thead()
                                                        .with(
                                                                tr()
                                                                        .with(
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("#")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        ),
                                                                                th()
                                                                                        .withScope(Bootstrap.col)
                                                                                        .with(
                                                                                                text("Heading")
                                                                                        )
                                                                        )
                                                        ),
                                                tbody()
                                                        .with(
                                                                tr()
                                                                        .with(
                                                                                th()
                                                                                        .withScope(Bootstrap.row)
                                                                                        .with(
                                                                                                text("1")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        )
                                                                        ),
                                                                tr()
                                                                        .with(
                                                                                th()
                                                                                        .withScope(Bootstrap.row)
                                                                                        .with(
                                                                                                text("2")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        )
                                                                        ),
                                                                tr()
                                                                        .with(
                                                                                th()
                                                                                        .withScope(Bootstrap.row)
                                                                                        .with(
                                                                                                text("3")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        ),
                                                                                td()
                                                                                        .with(
                                                                                                text("Cell")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                  <div class="table-responsive">
                    <table class="table">
                      <thead>
                        <tr>
                          <th scope="col">
                            #
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                          <th scope="col">
                            Heading
                          </th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <th scope="row">
                            1
                          </th>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                        </tr>
                        <tr>
                          <th scope="row">
                            2
                          </th>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                        </tr>
                        <tr>
                          <th scope="row">
                            3
                          </th>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                          <td>
                            Cell
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  """, renderedHtml);

        // document
        uiDocumentation.document("always-responsive", renderedHtml);

        uiDocumentation.documentSource("always-responsive");

    }


    private static TheadTag testHead() {
        return thead()
                .with(
                        tr()
                                .with(
                                        th()
                                                .withScope(Bootstrap.col)
                                                .with(
                                                        text("#")
                                                ),
                                        th()
                                                .withScope(Bootstrap.col)
                                                .with(
                                                        text("First")
                                                ),
                                        th()
                                                .withScope(Bootstrap.col)
                                                .with(
                                                        text("Last")
                                                ),
                                        th()
                                                .withScope(Bootstrap.col)
                                                .with(
                                                        text("Handle")
                                                )
                                )
                );
    }

    private static TbodyTag testBody() {
        return tbody()
                .with(
                        tr()
                                .with(
                                        th()
                                                .withScope(Bootstrap.row)
                                                .with(
                                                        text("1")
                                                ),
                                        td()
                                                .with(
                                                        text("Mark")
                                                ),
                                        td()
                                                .with(
                                                        text("Otto")
                                                ),
                                        td()
                                                .with(
                                                        text("@mdo")
                                                )
                                ),
                        tr()
                                .with(
                                        th()
                                                .withScope(Bootstrap.row)
                                                .with(
                                                        text("2")
                                                ),
                                        td()
                                                .with(
                                                        text("Jacob")
                                                ),
                                        td()
                                                .with(
                                                        text("Thornton")
                                                ),
                                        td()
                                                .with(
                                                        text("@fat")
                                                )
                                ),
                        tr()
                                .with(
                                        th()
                                                .withScope(Bootstrap.row)
                                                .with(
                                                        text("3")
                                                ),
                                        td()
                                                .withColspan("2")
                                                .with(
                                                        text("Larry the Bird")
                                                ),
                                        td()
                                                .with(
                                                        text("@twitter")
                                                )
                                )
                );
    }

}
