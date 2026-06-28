package dev.rebelcraft.j2html.bootstrap.content;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RebootTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void paragraphs() throws Exception {

        String renderedHtml = uiDocumentation.render(
                p("This is an example paragraph.")
        );

        //language=HTML
        assertEquals("""
                <p>
                  This is an example paragraph.
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("paragraphs", renderedHtml);

        uiDocumentation.documentSource("paragraphs");

    }

    @Test
    void links() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a("This is an example link")
                        .withHref("#")
        );

        //language=HTML
        assertEquals("""
                <a href="#">
                  This is an example link
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("links", renderedHtml);

        uiDocumentation.documentSource("links");

    }

    @Test
    void links2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a("This is an example link")
                        .withHref("#")
                        .attr("style", "--bs-link-opacity:.5")
        );

        //language=HTML
        assertEquals("""
                <a href="#" style="--bs-link-opacity:.5">
                  This is an example link
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("links2", renderedHtml);

        uiDocumentation.documentSource("links2");

    }

    @Test
    void links3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a("This is a placeholder link")
        );

        //language=HTML
        assertEquals("""
                <a>
                  This is a placeholder link
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("links3", renderedHtml);

        uiDocumentation.documentSource("links3");

    }

    @Test
    void horizontalRules() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div(
                        hr(),
                        div()
                                .withClass(Bootstrap.text_success)
                                .with(
                                        hr()
                                ),
                        hr()
                                .withClasses(Bootstrap.border, Bootstrap.border_danger, Bootstrap.border_2, Bootstrap.opacity_50),
                        hr()
                                .withClasses(Bootstrap.border, Bootstrap.border_primary, Bootstrap.border_3, Bootstrap.opacity_75)
                )
        );

        //language=HTML
        assertEquals("""
                <div>
                  <hr>
                  <div class="text-success">
                    <hr>
                  </div>
                  <hr class="border border-danger border-2 opacity-50">
                  <hr class="border border-primary border-3 opacity-75">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-rules", renderedHtml);

        uiDocumentation.documentSource("horizontal-rules");

    }

    @Test
    void inlineCode() throws Exception {

        String renderedHtml = uiDocumentation.render(
                p(join(
                        text("For example, "),
                        code("<section>"),
                        text(" should be wrapped as inline.")
                ))
        );

        //language=HTML
        assertEquals("""
                <p>
                  For example, <code>&lt;section&gt;</code> should be wrapped as inline.
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("inline-code", renderedHtml);

        uiDocumentation.documentSource("inline-code");

    }

    @Test
void codeBlocks() throws Exception {

    String renderedHtml = uiDocumentation.render(
            pre(
              code("<p>Sample text here...</p>\n<p>And another line of sample text here...</p>")
            )
    );

    //language=HTML
    assertEquals("""
        <pre><code>&lt;p&gt;Sample text here...&lt;/p&gt;
        &lt;p&gt;And another line of sample text here...&lt;/p&gt;</code></pre>
        """, renderedHtml);

    // document
    uiDocumentation.document("code-blocks", renderedHtml);

    uiDocumentation.documentSource("code-blocks");

}

    @Test
    void variables() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        var()
                                .with(
                                        text("y")
                                ),
                        text(" = "),
                        var()
                                .with(
                                        text("m")
                                ),
                        var()
                                .with(
                                        text("x")
                                ),
                        text(" + "),
                        var()
                                .with(
                                        text("b")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <var>
                  y
                </var>
                 =\s
                <var>
                  m
                </var>
                <var>
                  x
                </var>
                 +\s
                <var>
                  b
                </var>
                """, renderedHtml);

        // document
        uiDocumentation.document("variables", renderedHtml);

        uiDocumentation.documentSource("variables");

    }

    @Test
    void userInput() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        text("To switch directories, type "),
                        kbd()
                                .with(
                                        text("cd")
                                ),
                        text(" followed by the name of the directory."),
                        br(),
                        text(" To edit settings, press "),
                        kbd()
                                .with(
                                        kbd()
                                                .with(
                                                        text("Ctrl")
                                                ),
                                        text(" + "),
                                        kbd()
                                                .with(
                                                        text(",")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                To switch directories, type\s
                <kbd>
                  cd
                </kbd>
                 followed by the name of the directory.
                <br>
                 To edit settings, press\s
                <kbd>
                  <kbd>
                    Ctrl
                  </kbd>
                   +\s
                  <kbd>
                    ,
                  </kbd>
                </kbd>
                """, renderedHtml);

        // document
        uiDocumentation.document("user-input", renderedHtml);

        uiDocumentation.documentSource("user-input");

    }

    @Test
    void sample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                samp()
                        .with(
                                text("This text is meant to be treated as sample output from a computer program.")
                        )
        );

        //language=HTML
        assertEquals("""
                <samp>
                  This text is meant to be treated as sample output from a computer program.
                </samp>
                """, renderedHtml);

        // document
        uiDocumentation.document("sample", renderedHtml);

        uiDocumentation.documentSource("sample");

    }

    @Test
    void tables() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .with(
                                caption()
                                        .with(
                                                text(" This is an example table, and this is its caption to describe the contents.")
                                        ),
                                thead()
                                        .with(
                                                tr()
                                                        .with(
                                                                th()
                                                                        .with(
                                                                                text("Table heading")
                                                                        ),
                                                                th()
                                                                        .with(
                                                                                text("Table heading")
                                                                        ),
                                                                th()
                                                                        .with(
                                                                                text("Table heading")
                                                                        ),
                                                                th()
                                                                        .with(
                                                                                text("Table heading")
                                                                        )
                                                        )
                                        ),
                                tbody()
                                        .with(
                                                tr()
                                                        .with(
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        )
                                                        ),
                                                tr()
                                                        .with(
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        ),
                                                                td()
                                                                        .with(
                                                                                text("Table cell")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <table>
                  <caption>
                     This is an example table, and this is its caption to describe the contents.
                  </caption>
                  <thead>
                    <tr>
                      <th>
                        Table heading
                      </th>
                      <th>
                        Table heading
                      </th>
                      <th>
                        Table heading
                      </th>
                      <th>
                        Table heading
                      </th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                    </tr>
                    <tr>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                    </tr>
                    <tr>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                      <td>
                        Table cell
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("table", renderedHtml);

        uiDocumentation.documentSource("table");

    }

    @Test
    void pointersOnButtons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                span()
                        .attr(AriaRoles.roleButton)
                        .withTabindex(0)
                        .with(
                                text("Non-button element button")
                        )
        );

        //language=HTML
        assertEquals("""
                <span role="button" tabindex="0">
                  Non-button element button
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("pointers-on-buttons", renderedHtml);

        uiDocumentation.documentSource("pointers-on-buttons");

    }


}
