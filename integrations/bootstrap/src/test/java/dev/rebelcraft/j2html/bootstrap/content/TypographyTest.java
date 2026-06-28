package dev.rebelcraft.j2html.bootstrap.content;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TypographyTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void headings() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        h1()
                                .with(
                                        text("h1. Bootstrap heading")
                                ),
                        h2()
                                .with(
                                        text("h2. Bootstrap heading")
                                ),
                        h3()
                                .with(
                                        text("h3. Bootstrap heading")
                                ),
                        h4()
                                .with(
                                        text("h4. Bootstrap heading")
                                ),
                        h5()
                                .with(
                                        text("h5. Bootstrap heading")
                                ),
                        h6()
                                .with(
                                        text("h6. Bootstrap heading")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <h1>
                  h1. Bootstrap heading
                </h1>
                <h2>
                  h2. Bootstrap heading
                </h2>
                <h3>
                  h3. Bootstrap heading
                </h3>
                <h4>
                  h4. Bootstrap heading
                </h4>
                <h5>
                  h5. Bootstrap heading
                </h5>
                <h6>
                  h6. Bootstrap heading
                </h6>
                """, renderedHtml);

        // document
        uiDocumentation.document("typography", renderedHtml);

        uiDocumentation.documentSource("typography");

    }


    @Test
    void headings2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Bootstrap.h1)
                                .with(
                                        text("h1. Bootstrap heading")
                                ),
                        p()
                                .withClasses(Bootstrap.h2)
                                .with(
                                        text("h2. Bootstrap heading")
                                ),
                        p()
                                .withClasses(Bootstrap.h3)
                                .with(
                                        text("h3. Bootstrap heading")
                                ),
                        p()
                                .withClasses(Bootstrap.h4)
                                .with(
                                        text("h4. Bootstrap heading")
                                ),
                        p()
                                .withClasses(Bootstrap.h5)
                                .with(
                                        text("h5. Bootstrap heading")
                                ),
                        p()
                                .withClasses(Bootstrap.h6)
                                .with(
                                        text("h6. Bootstrap heading")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="h1">
                  h1. Bootstrap heading
                </p>
                <p class="h2">
                  h2. Bootstrap heading
                </p>
                <p class="h3">
                  h3. Bootstrap heading
                </p>
                <p class="h4">
                  h4. Bootstrap heading
                </p>
                <p class="h5">
                  h5. Bootstrap heading
                </p>
                <p class="h6">
                  h6. Bootstrap heading
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("headings2", renderedHtml);

        uiDocumentation.documentSource("headings2");

    }

    @Test
    void customisedHeadings() throws Exception {

        String renderedHtml = uiDocumentation.render(
                h3()
                        .with(
                                text("Fancy display heading"),
                                small()
                                        .withClasses(Bootstrap.text_body_secondary)
                                        .with(
                                                text("With faded secondary text")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <h3>
                  Fancy display heading
                  <small class="text-body-secondary">
                    With faded secondary text
                  </small>
                </h3>
                """, renderedHtml);

        // document
        uiDocumentation.document("customised-headings", renderedHtml);

        uiDocumentation.documentSource("customised-headings");

    }

    @Test
    void displayHeadings() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        h1()
                                .withClasses(Bootstrap.display_1)
                                .with(
                                        text("Display 1")
                                ),
                        h1()
                                .withClasses(Bootstrap.display_2)
                                .with(
                                        text("Display 2")
                                ),
                        h1()
                                .withClasses(Bootstrap.display_3)
                                .with(
                                        text("Display 3")
                                ),
                        h1()
                                .withClasses(Bootstrap.display_4)
                                .with(
                                        text("Display 4")
                                ),
                        h1()
                                .withClasses(Bootstrap.display_5)
                                .with(
                                        text("Display 5")
                                ),
                        h1()
                                .withClasses(Bootstrap.display_6)
                                .with(
                                        text("Display 6")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <h1 class="display-1">
                  Display 1
                </h1>
                <h1 class="display-2">
                  Display 2
                </h1>
                <h1 class="display-3">
                  Display 3
                </h1>
                <h1 class="display-4">
                  Display 4
                </h1>
                <h1 class="display-5">
                  Display 5
                </h1>
                <h1 class="display-6">
                  Display 6
                </h1>
                """, renderedHtml);

        // document
        uiDocumentation.document("display-headings", renderedHtml);

        uiDocumentation.documentSource("display-headings");

    }

    @Test
    void lead() throws Exception {

        String renderedHtml = uiDocumentation.render(
                p()
                        .withClasses(Bootstrap.lead)
                        .with(
                                text("This is a lead paragraph. It stands out from regular paragraphs.")
                        )
        );

        //language=HTML
        assertEquals("""
                <p class="lead">
                  This is a lead paragraph. It stands out from regular paragraphs.
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("lead", renderedHtml);

        uiDocumentation.documentSource("lead");

    }

    @Test
    void inlineTextElements() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        text("You can use the mark tag to"),
                                        mark()
                                                .with(
                                                        text("highlight")
                                                ),
                                        text("BootstrapClasses.")
                                ),
                        p()
                                .with(
                                        del()
                                                .with(
                                                        text("This line of text is meant to be treated as deleted BootstrapClasses.")
                                                )
                                ),
                        p()
                                .with(
                                        s()
                                                .with(
                                                        text("This line of text is meant to be treated as no longer accurate.")
                                                )
                                ),
                        p()
                                .with(
                                        ins()
                                                .with(
                                                        text("This line of text is meant to be treated as an addition to the document.")
                                                )
                                ),
                        p()
                                .with(
                                        u()
                                                .with(
                                                        text("This line of text will render as underlined.")
                                                )
                                ),
                        p()
                                .with(
                                        small()
                                                .with(
                                                        text("This line of text is meant to be treated as fine print.")
                                                )
                                ),
                        p()
                                .with(
                                        strong()
                                                .with(
                                                        text("This line rendered as bold BootstrapClasses.")
                                                )
                                ),
                        p()
                                .with(
                                        em()
                                                .with(
                                                        text("This line rendered as italicized BootstrapClasses.")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  You can use the mark tag to
                  <mark>
                    highlight
                  </mark>
                  BootstrapClasses.
                </p>
                <p>
                  <del>
                    This line of text is meant to be treated as deleted BootstrapClasses.
                  </del>
                </p>
                <p>
                  <s>
                    This line of text is meant to be treated as no longer accurate.
                  </s>
                </p>
                <p>
                  <ins>
                    This line of text is meant to be treated as an addition to the document.
                  </ins>
                </p>
                <p>
                  <u>
                    This line of text will render as underlined.
                  </u>
                </p>
                <p>
                  <small>
                    This line of text is meant to be treated as fine print.
                  </small>
                </p>
                <p>
                  <strong>
                    This line rendered as bold BootstrapClasses.
                  </strong>
                </p>
                <p>
                  <em>
                    This line rendered as italicized BootstrapClasses.
                  </em>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("inline-text-elements", renderedHtml);

        uiDocumentation.documentSource("inline-text-elements");

    }

    @Test
    void abbreviations() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        abbr()
                                                .withTitle( "attribute")
                                                .with(
                                                        text("attr")
                                                )
                                ),
                        p()
                                .with(
                                        abbr()
                                                .withTitle("HyperText Markup Language")
                                                .withClasses(Bootstrap.initialism)
                                                .with(
                                                        text("HTML")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <abbr title="attribute">
                    attr
                  </abbr>
                </p>
                <p>
                  <abbr title="HyperText Markup Language" class="initialism">
                    HTML
                  </abbr>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("abbreviations", renderedHtml);

        uiDocumentation.documentSource("abbreviations");

    }


    @Test
    void blockQuotes() throws Exception {

        String renderedHtml = uiDocumentation.render(
                blockquote()
                        .withClasses(Bootstrap.blockquote)
                        .with(
                                p()
                                        .with(
                                                text("A well-known quote, contained in a blockquote element.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <blockquote class="blockquote">
              <p>
                A well-known quote, contained in a blockquote element.
              </p>
            </blockquote>
            """, renderedHtml);

        // document
        uiDocumentation.document("block-quotes", renderedHtml);

        uiDocumentation.documentSource("block-quotes");

    }

    @Test
    void namingASource() throws Exception {

        String renderedHtml = uiDocumentation.render(
                figure()
                        .with(
                                blockquote()
                                        .withClasses(Bootstrap.blockquote)
                                        .with(
                                                p()
                                                        .with(
                                                                text("A well-known quote, contained in a blockquote element.")
                                                        )
                                        ),
                                figcaption()
                                        .withClasses(Bootstrap.blockquote_footer)
                                        .with(
                                                text("Someone famous in"),
                                                cite()
                                                        .withTitle("Source Title")
                                                        .with(
                                                                text("Source Title")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <figure>
                  <blockquote class="blockquote">
                    <p>
                      A well-known quote, contained in a blockquote element.
                    </p>
                  </blockquote>
                  <figcaption class="blockquote-footer">
                    Someone famous in
                    <cite title="Source Title">
                      Source Title
                    </cite>
                  </figcaption>
                </figure>
                """, renderedHtml);

        // document
        uiDocumentation.document("naming-asource", renderedHtml);

        uiDocumentation.documentSource("naming-asource");

    }

    @Test
    void alignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                figure()
                        .withClasses(Bootstrap.text_center)
                        .with(
                                blockquote()
                                        .withClasses(Bootstrap.blockquote)
                                        .with(
                                                p()
                                                        .with(
                                                                text("A well-known quote, contained in a blockquote element.")
                                                        )
                                        ),
                                figcaption()
                                        .withClasses(Bootstrap.blockquote_footer)
                                        .with(
                                                text("Someone famous in"),
                                                cite()
                                                        .withTitle("Source Title")
                                                        .with(
                                                                text("Source Title")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <figure class="text-center">
                  <blockquote class="blockquote">
                    <p>
                      A well-known quote, contained in a blockquote element.
                    </p>
                  </blockquote>
                  <figcaption class="blockquote-footer">
                    Someone famous in
                    <cite title="Source Title">
                      Source Title
                    </cite>
                  </figcaption>
                </figure>
                """, renderedHtml);

        // document
        uiDocumentation.document("alignment", renderedHtml);

        uiDocumentation.documentSource("alignment");

    }

    @Test
    void alignment2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                figure()
                        .withClasses(Bootstrap.text_end)
                        .with(
                                blockquote()
                                        .withClasses(Bootstrap.blockquote)
                                        .with(
                                                p()
                                                        .with(
                                                                text("A well-known quote, contained in a blockquote element.")
                                                        )
                                        ),
                                figcaption()
                                        .withClasses(Bootstrap.blockquote_footer)
                                        .with(
                                                text("Someone famous in"),
                                                cite()
                                                        .withTitle("Source Title")
                                                        .with(
                                                                text("Source Title")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <figure class="text-end">
                  <blockquote class="blockquote">
                    <p>
                      A well-known quote, contained in a blockquote element.
                    </p>
                  </blockquote>
                  <figcaption class="blockquote-footer">
                    Someone famous in
                    <cite title="Source Title">
                      Source Title
                    </cite>
                  </figcaption>
                </figure>
                """, renderedHtml);

        // document
        uiDocumentation.document("alignment2", renderedHtml);

        uiDocumentation.documentSource("alignment2");

    }

    @Test
    void listsUnstyled() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_unstyled)
                        .with(
                                li()
                                        .with(
                                                text("This is a list.")
                                        ),
                                li()
                                        .with(
                                                text("It appears completely unstyled.")
                                        ),
                                li()
                                        .with(
                                                text("Structurally, it's still a list.")
                                        ),
                                li()
                                        .with(
                                                text("However, this style only applies to immediate child elements.")
                                        ),
                                li()
                                        .with(
                                                text("Nested lists:"),
                                                ul()
                                                        .with(
                                                                li()
                                                                        .with(
                                                                                text("are unaffected by this style")
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                text("will still show a bullet")
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                text("and have appropriate left margin")
                                                                        )
                                                        )
                                        ),
                                li()
                                        .with(
                                                text("This may still come in handy in some situations.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <ul class="list-unstyled">
                  <li>
                    This is a list.
                  </li>
                  <li>
                    It appears completely unstyled.
                  </li>
                  <li>
                    Structurally, it&#x27;s still a list.
                  </li>
                  <li>
                    However, this style only applies to immediate child elements.
                  </li>
                  <li>
                    Nested lists:
                    <ul>
                      <li>
                        are unaffected by this style
                      </li>
                      <li>
                        will still show a bullet
                      </li>
                      <li>
                        and have appropriate left margin
                      </li>
                    </ul>
                  </li>
                  <li>
                    This may still come in handy in some situations.
                  </li>
                </ul>
                """, renderedHtml);

        // document
        uiDocumentation.document("lists-unstyled", renderedHtml);

        uiDocumentation.documentSource("lists-unstyled");

    }

    @Test
    void listsInline() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_inline)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_inline_item)
                                        .with(
                                                text("This is a list item.")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_inline_item)
                                        .with(
                                                text("And another one.")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_inline_item)
                                        .with(
                                                text("But they're displayed inline.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <ul class="list-inline">
                  <li class="list-inline-item">
                    This is a list item.
                  </li>
                  <li class="list-inline-item">
                    And another one.
                  </li>
                  <li class="list-inline-item">
                    But they&#x27;re displayed inline.
                  </li>
                </ul>
                """, renderedHtml);

        // document
        uiDocumentation.document("lists-inline", renderedHtml);

        uiDocumentation.documentSource("lists-inline");

    }

    @Test
    void descriptionListAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                dl()
                        .withClasses(Bootstrap.row)
                        .with(
                                dt()
                                        .withClasses(Bootstrap.col_sm_3)
                                        .with(
                                                text("Description lists")
                                        ),
                                dd()
                                        .withClasses(Bootstrap.col_sm_9)
                                        .with(
                                                text("A description list is perfect for defining terms.")
                                        ),
                                dt()
                                        .withClasses(Bootstrap.col_sm_3)
                                        .with(
                                                text("Term")
                                        ),
                                dd()
                                        .withClasses(Bootstrap.col_sm_9)
                                        .with(
                                                p()
                                                        .with(
                                                                text("Definition for the term.")
                                                        ),
                                                p()
                                                        .with(
                                                                text("And some more placeholder definition BootstrapClasses.")
                                                        )
                                        ),
                                dt()
                                        .withClasses(Bootstrap.col_sm_3)
                                        .with(
                                                text("Another term")
                                        ),
                                dd()
                                        .withClasses(Bootstrap.col_sm_9)
                                        .with(
                                                text("This definition is short, so no extra paragraphs or anything.")
                                        ),
                                dt()
                                        .withClasses(Bootstrap.col_sm_3, Bootstrap.text_truncate)
                                        .with(
                                                text("Truncated term is truncated")
                                        ),
                                dd()
                                        .withClasses(Bootstrap.col_sm_9)
                                        .with(
                                                text("This can be useful when space is tight. Adds an ellipsis at the end.")
                                        ),
                                dt()
                                        .withClasses(Bootstrap.col_sm_3)
                                        .with(
                                                text("Nesting")
                                        ),
                                dd()
                                        .withClasses(Bootstrap.col_sm_9)
                                        .with(
                                                dl()
                                                        .withClasses(Bootstrap.row)
                                                        .with(
                                                                dt()
                                                                        .withClasses(Bootstrap.col_sm_4)
                                                                        .with(
                                                                                text("Nested definition list")
                                                                        ),
                                                                dd()
                                                                        .withClasses(Bootstrap.col_sm_8)
                                                                        .with(
                                                                                text("I heard you like definition lists. Let me put a definition list inside your definition list.")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <dl class="row">
                  <dt class="col-sm-3">
                    Description lists
                  </dt>
                  <dd class="col-sm-9">
                    A description list is perfect for defining terms.
                  </dd>
                  <dt class="col-sm-3">
                    Term
                  </dt>
                  <dd class="col-sm-9">
                    <p>
                      Definition for the term.
                    </p>
                    <p>
                      And some more placeholder definition BootstrapClasses.
                    </p>
                  </dd>
                  <dt class="col-sm-3">
                    Another term
                  </dt>
                  <dd class="col-sm-9">
                    This definition is short, so no extra paragraphs or anything.
                  </dd>
                  <dt class="col-sm-3 text-truncate">
                    Truncated term is truncated
                  </dt>
                  <dd class="col-sm-9">
                    This can be useful when space is tight. Adds an ellipsis at the end.
                  </dd>
                  <dt class="col-sm-3">
                    Nesting
                  </dt>
                  <dd class="col-sm-9">
                    <dl class="row">
                      <dt class="col-sm-4">
                        Nested definition list
                      </dt>
                      <dd class="col-sm-8">
                        I heard you like definition lists. Let me put a definition list inside your definition list.
                      </dd>
                    </dl>
                  </dd>
                </dl>
                """, renderedHtml);

        // document
        uiDocumentation.document("description-list-alignment", renderedHtml);

        uiDocumentation.documentSource("description-list-alignment");

    }



}
