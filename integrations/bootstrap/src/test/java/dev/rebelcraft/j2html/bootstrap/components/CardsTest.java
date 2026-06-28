package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                     .withClasses(Bootstrap.card)
                     .withStyle("width: 18rem;")
                     .with(
                        img()
                         .withSrc("...")
                         .withClasses(Bootstrap.card_img_top)
                         .withAlt("..."),
                        div()
                         .withClasses(Bootstrap.card_body)
                         .with(
                            h5()
                             .withClasses(Bootstrap.card_title)
                             .with(
                                text("Card title")
                              ),
                            p()
                             .withClasses(Bootstrap.card_text)
                             .with(
                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                              ),
                            a()
                             .withHref("#")
                             .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                             .with(
                                text("Go somewhere")
                              )
                          )
                      )
                );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <img src="..." class="card-img-top" alt="...">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void body() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                text("This is some text within a card body.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card">
                  <div class="card-body">
                    This is some text within a card body.
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("body", renderedHtml);

        uiDocumentation.documentSource("body");

    }

    @Test
    void titlesTextAndLinks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .withStyle("width: 18rem;")
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Card title")
                                                        ),
                                                h6()
                                                        .withClasses(Bootstrap.card_subtitle, Bootstrap.mb_2, Bootstrap.text_body_secondary)
                                                        .with(
                                                                text("Card subtitle")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.card_link)
                                                        .with(
                                                                text("Card link")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.card_link)
                                                        .with(
                                                                text("Another link")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <h6 class="card-subtitle mb-2 text-body-secondary">
                      Card subtitle
                    </h6>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                    <a href="#" class="card-link">
                      Card link
                    </a>
                    <a href="#" class="card-link">
                      Another link
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("titles-text-and-links", renderedHtml);

        uiDocumentation.documentSource("titles-text-and-links");

    }

    @Test
    void images() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .withStyle("width: 18rem;")
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Bootstrap.card_img_top)
                                        .withAlt("..."),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <img src="..." class="card-img-top" alt="...">
                  <div class="card-body">
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("images", renderedHtml);

        uiDocumentation.documentSource("images");

    }

    @Test
    void listGroup() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .withStyle("width: 18rem;")
                        .with(
                                ul()
                                        .withClasses(Bootstrap.list_group, Bootstrap.list_group_flush)
                                        .with(
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("An item")
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("A second item")
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("A third item")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      An item
                    </li>
                    <li class="list-group-item">
                      A second item
                    </li>
                    <li class="list-group-item">
                      A third item
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("list-group", renderedHtml);

        uiDocumentation.documentSource("list-group");

    }

    @Test
    void listGroup2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .withStyle("width: 18rem;")
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_header)
                                        .with(
                                                text("Featured")
                                        ),
                                ul()
                                        .withClasses(Bootstrap.list_group, Bootstrap.list_group_flush)
                                        .with(
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("An item")
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("A second item")
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("A third item")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <div class="card-header">
                    Featured
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      An item
                    </li>
                    <li class="list-group-item">
                      A second item
                    </li>
                    <li class="list-group-item">
                      A third item
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("list-group2", renderedHtml);

        uiDocumentation.documentSource("list-group2");

    }

    @Test
    void listGroup3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .withStyle("width: 18rem;")
                        .with(
                                ul()
                                        .withClasses(Bootstrap.list_group, Bootstrap.list_group_flush)
                                        .with(
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("An item")
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("A second item")
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("A third item")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_footer)
                                        .with(
                                                text("Card footer")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      An item
                    </li>
                    <li class="list-group-item">
                      A second item
                    </li>
                    <li class="list-group-item">
                      A third item
                    </li>
                  </ul>
                  <div class="card-footer">
                    Card footer
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("list-group3", renderedHtml);

        uiDocumentation.documentSource("list-group3");

    }

    @Test
    void kitchenSink() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .withStyle("width: 18rem;")
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Bootstrap.card_img_top)
                                        .withAlt("..."),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Card title")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        )
                                        ),
                                ul()
                                        .withClasses(Bootstrap.list_group, Bootstrap.list_group_flush)
                                        .with(
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("An item")
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("A second item")
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.list_group_item)
                                                        .with(
                                                                text("A third item")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.card_link)
                                                        .with(
                                                                text("Card link")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.card_link)
                                                        .with(
                                                                text("Another link")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <img src="..." class="card-img-top" alt="...">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      An item
                    </li>
                    <li class="list-group-item">
                      A second item
                    </li>
                    <li class="list-group-item">
                      A third item
                    </li>
                  </ul>
                  <div class="card-body">
                    <a href="#" class="card-link">
                      Card link
                    </a>
                    <a href="#" class="card-link">
                      Another link
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("kitchen-sink", renderedHtml);

        uiDocumentation.documentSource("kitchen-sink");

    }

    @Test
    void headerAndFooter() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_header)
                                        .with(
                                                text("Featured")
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card">
                  <div class="card-header">
                    Featured
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("header-and-footer", renderedHtml);

        uiDocumentation.documentSource("header-and-footer");

    }

    @Test
    void headerAndFooter2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .with(
                                h5()
                                        .withClasses(Bootstrap.card_header)
                                        .with(
                                                text("Featured")
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card">
                  <h5 class="card-header">
                    Featured
                  </h5>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("header-and-footer2", renderedHtml);

        uiDocumentation.documentSource("header-and-footer2");

    }

    @Test
    void headerAndFooter3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_header)
                                        .with(
                                                text("Quote")
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                blockquote()
                                                        .withClasses(Bootstrap.blockquote, Bootstrap.mb_0)
                                                        .with(
                                                                p()
                                                                        .with(
                                                                                text("A well-known quote, contained in a blockquote element.")
                                                                        ),
                                                                footer()
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
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card">
                  <div class="card-header">
                    Quote
                  </div>
                  <div class="card-body">
                    <blockquote class="blockquote mb-0">
                      <p>
                        A well-known quote, contained in a blockquote element.
                      </p>
                      <footer class="blockquote-footer">
                        Someone famous in
                        <cite title="Source Title">
                          Source Title
                        </cite>
                      </footer>
                    </blockquote>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("header-and-footer3", renderedHtml);

        uiDocumentation.documentSource("header-and-footer3");

    }

    @Test
    void headerAndFooter4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_header)
                                        .with(
                                                text("Featured")
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_footer, Bootstrap.text_body_secondary)
                                        .with(
                                                text("2 days ago")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-center">
                  <div class="card-header">
                    Featured
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                  <div class="card-footer text-body-secondary">
                    2 days ago
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("header-and-footer4", renderedHtml);

        uiDocumentation.documentSource("header-and-footer4");

    }

    @Test
    void usingGridMarkup() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_sm_6, Bootstrap.mb_3, Bootstrap.mb_sm_0)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Special title treatment")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                                                        ),
                                                                                a()
                                                                                        .withHref("#")
                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                                        .with(
                                                                                                text("Go somewhere")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_sm_6)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Special title treatment")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                                                        ),
                                                                                a()
                                                                                        .withHref("#")
                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                                        .with(
                                                                                                text("Go somewhere")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          Special title treatment
                        </h5>
                        <p class="card-text">
                          With supporting text below as a natural lead-in to additional content.
                        </p>
                        <a href="#" class="btn btn-primary">
                          Go somewhere
                        </a>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6">
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          Special title treatment
                        </h5>
                        <p class="card-text">
                          With supporting text below as a natural lead-in to additional content.
                        </p>
                        <a href="#" class="btn btn-primary">
                          Go somewhere
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("using-grid-markup", renderedHtml);

        uiDocumentation.documentSource("using-grid-markup");

    }

    @Test
    void usingUtilities() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.w_75, Bootstrap.mb_3)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("With supporting text below as a natural lead-in to additional content.")
                                                                ),
                                                        a()
                                                                .withHref("#")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                .with(
                                                                        text("Button")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.w_50)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("With supporting text below as a natural lead-in to additional content.")
                                                                ),
                                                        a()
                                                                .withHref("#")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                .with(
                                                                        text("Button")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="card w-75 mb-3">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Button
                    </a>
                  </div>
                </div>
                <div class="card w-50">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Button
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("using-utilities", renderedHtml);

        uiDocumentation.documentSource("using-utilities");

    }

    @Test
    void usingCustomCSS() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card)
                        .withStyle("width: 18rem;")
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("using-custom-css", renderedHtml);

        uiDocumentation.documentSource("using-custom-css");

    }

    @Test
    void textAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.mb_3)
                                .withStyle("width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Special title treatment")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("With supporting text below as a natural lead-in to additional content.")
                                                                ),
                                                        a()
                                                                .withHref("#")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                .with(
                                                                        text("Go somewhere")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_center, Bootstrap.mb_3)
                                .withStyle("width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Special title treatment")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("With supporting text below as a natural lead-in to additional content.")
                                                                ),
                                                        a()
                                                                .withHref("#")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                .with(
                                                                        text("Go somewhere")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_end)
                                .withStyle("width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Special title treatment")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("With supporting text below as a natural lead-in to additional content.")
                                                                ),
                                                        a()
                                                                .withHref("#")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                .with(
                                                                        text("Go somewhere")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="card mb-3" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                <div class="card text-center mb-3" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                <div class="card text-end" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-alignment", renderedHtml);

        uiDocumentation.documentSource("text-alignment");

    }


    @Test
    void navigation() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_header)
                                        .with(
                                                ul()
                                                        .withClasses(Bootstrap.nav, Bootstrap.nav_tabs, Bootstrap.card_header_tabs)
                                                        .with(
                                                                li()
                                                                        .withClasses(Bootstrap.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaCurrent("true")
                                                                                        )
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Active")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .withClasses(Bootstrap.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .withClasses(Bootstrap.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.disabled)
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                                                        )
                                                                                        .with(
                                                                                                text("Disabled")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-center">
                  <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs">
                      <li class="nav-item">
                        <a class="nav-link active" aria-current="true" href="#">
                          Active
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">
                          Link
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link disabled" aria-disabled="true">
                          Disabled
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("navigation", renderedHtml);

        uiDocumentation.documentSource("navigation");

    }

    @Test
    void navigation2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card, Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_header)
                                        .with(
                                                ul()
                                                        .withClasses(Bootstrap.nav, Bootstrap.nav_pills, Bootstrap.card_header_pills)
                                                        .with(
                                                                li()
                                                                        .withClasses(Bootstrap.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Active")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .withClasses(Bootstrap.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .withClasses(Bootstrap.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.disabled)
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                                                        )
                                                                                        .with(
                                                                                                text("Disabled")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-center">
                  <div class="card-header">
                    <ul class="nav nav-pills card-header-pills">
                      <li class="nav-item">
                        <a class="nav-link active" href="#">
                          Active
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">
                          Link
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link disabled" aria-disabled="true">
                          Disabled
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("navigation2", renderedHtml);

        uiDocumentation.documentSource("navigation2");

    }

    @Test
    void imageCaps() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.mb_3)
                                .with(
                                        img()
                                                .withSrc("...")
                                                .withClasses(Bootstrap.card_img_top)
                                                .withAlt("..."),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        small()
                                                                                .withClasses(Bootstrap.text_body_secondary)
                                                                                .with(
                                                                                        text("Last updated 3 mins ago")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        small()
                                                                                .withClasses("text-body-secondary")
                                                                                .with(
                                                                                        text("Last updated 3 mins ago")
                                                                                )
                                                                )
                                                ),
                                        img()
                                                .withSrc("...")
                                                .withClasses(Bootstrap.card_img_bottom)
                                                .withAlt("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="card mb-3">
                  <img src="..." class="card-img-top" alt="...">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    </p>
                    <p class="card-text">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </p>
                  </div>
                </div>
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    </p>
                    <p class="card-text">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </p>
                  </div>
                  <img src="..." class="card-img-bottom" alt="...">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("image-caps", renderedHtml);

        uiDocumentation.documentSource("image-caps");

    }

    @Test
    void imageOverlays() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card, Bootstrap.text_bg_dark)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Bootstrap.card_img)
                                        .withAlt("..."),
                                div()
                                        .withClasses(Bootstrap.card_img_overlay)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Card title")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                small()
                                                                        .with(
                                                                                text("Last updated 3 mins ago")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-bg-dark">
                  <img src="..." class="card-img" alt="...">
                  <div class="card-img-overlay">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    </p>
                    <p class="card-text">
                      <small>
                        Last updated 3 mins ago
                      </small>
                    </p>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("image-overlays", renderedHtml);

        uiDocumentation.documentSource("image-overlays");

    }

    @Test
    void horizontal() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card, Bootstrap.mb_3)
                        .withStyle("max-width: 540px;")
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.g_0)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.col_md_4)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.img_fluid, Bootstrap.rounded_start)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.col_md_8)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                small()
                                                                                                        .withClasses("text-body-secondary")
                                                                                                        .with(
                                                                                                                text("Last updated 3 mins ago")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card mb-3" style="max-width: 540px;">
                  <div class="row g-0">
                    <div class="col-md-4">
                      <img src="..." class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                        <p class="card-text">
                          <small class="text-body-secondary">
                            Last updated 3 mins ago
                          </small>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal", renderedHtml);

        uiDocumentation.documentSource("horizontal");

    }


    @Test
    void backgroundAndColor() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_bg_primary, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Primary card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_bg_secondary, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Secondary card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_bg_success, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Success card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_bg_danger, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Danger card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_bg_warning, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Warning card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_bg_info, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Info card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_bg_light, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Light card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.text_bg_dark, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Dark card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-bg-primary mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Primary card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-secondary mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Secondary card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-success mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Success card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-danger mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Danger card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-warning mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Warning card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-info mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Info card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-light mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Light card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-dark mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Dark card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("background-and-color", renderedHtml);

        uiDocumentation.documentSource("background-and-color");

    }

    @Test
    void border() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.border_primary, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body, Bootstrap.text_primary)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Primary card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.border_secondary, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body, Bootstrap.text_secondary)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Secondary card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.border_success, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body, Bootstrap.text_success)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Success card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.border_danger, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body, Bootstrap.text_danger)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Danger card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.border_warning, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Warning card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.border_info, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Info card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.border_light, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Light card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.card, Bootstrap.border_dark, Bootstrap.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.card_title)
                                                                .with(
                                                                        text("Dark card title")
                                                                ),
                                                        p()
                                                                .withClasses(Bootstrap.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="card border-primary mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body text-primary">
                    <h5 class="card-title">
                      Primary card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-secondary mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body text-secondary">
                    <h5 class="card-title">
                      Secondary card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-success mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body text-success">
                    <h5 class="card-title">
                      Success card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-danger mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body text-danger">
                    <h5 class="card-title">
                      Danger card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-warning mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Warning card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-info mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Info card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-light mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Light card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-dark mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Dark card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("border", renderedHtml);

        uiDocumentation.documentSource("border");

    }

    @Test
    void mixinUtilities() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card, Bootstrap.border_success, Bootstrap.mb_3)
                        .withStyle("max-width: 18rem;")
                        .with(
                                div()
                                        .withClasses(Bootstrap.card_header, Bootstrap.bg_transparent, Bootstrap.border_success)
                                        .with(
                                                text("Header")
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_body, Bootstrap.text_success)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.card_title)
                                                        .with(
                                                                text("Success card title")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card_footer, Bootstrap.bg_transparent, Bootstrap.border_success)
                                        .with(
                                                text("Footer")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card border-success mb-3" style="max-width: 18rem;">
                  <div class="card-header bg-transparent border-success">
                    Header
                  </div>
                  <div class="card-body text-success">
                    <h5 class="card-title">
                      Success card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                  <div class="card-footer bg-transparent border-success">
                    Footer
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("mixin-utilities", renderedHtml);

        uiDocumentation.documentSource("mixin-utilities");

    }

    @Test
    void cardLayout() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card_group)
                        .with(
                                div()
                                        .withClasses(Bootstrap.card)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Bootstrap.card_img_top)
                                                        .withAlt("..."),
                                                div()
                                                        .withClasses(Bootstrap.card_body)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.card_title)
                                                                        .with(
                                                                                text("Card title")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Bootstrap.card_img_top)
                                                        .withAlt("..."),
                                                div()
                                                        .withClasses(Bootstrap.card_body)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.card_title)
                                                                        .with(
                                                                                text("Card title")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                text("This card has supporting text below as a natural lead-in to additional content.")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Bootstrap.card_img_top)
                                                        .withAlt("..."),
                                                div()
                                                        .withClasses(Bootstrap.card_body)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.card_title)
                                                                        .with(
                                                                                text("Card title")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card-group">
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                      </p>
                      <p class="card-text">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </p>
                    </div>
                  </div>
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This card has supporting text below as a natural lead-in to additional content.
                      </p>
                      <p class="card-text">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </p>
                    </div>
                  </div>
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.
                      </p>
                      <p class="card-text">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </p>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("card-layout", renderedHtml);

        uiDocumentation.documentSource("card-layout");

    }

    @Test
    void cardLayout2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.card_group)
                        .with(
                                div()
                                        .withClasses(Bootstrap.card)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Bootstrap.card_img_top)
                                                        .withAlt("..."),
                                                div()
                                                        .withClasses(Bootstrap.card_body)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.card_title)
                                                                        .with(
                                                                                text("Card title")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.card_footer)
                                                        .with(
                                                                small()
                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                        .with(
                                                                                text("Last updated 3 mins ago")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Bootstrap.card_img_top)
                                                        .withAlt("..."),
                                                div()
                                                        .withClasses(Bootstrap.card_body)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.card_title)
                                                                        .with(
                                                                                text("Card title")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                text("This card has supporting text below as a natural lead-in to additional content.")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.card_footer)
                                                        .with(
                                                                small()
                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                        .with(
                                                                                text("Last updated 3 mins ago")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.card)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Bootstrap.card_img_top)
                                                        .withAlt("..."),
                                                div()
                                                        .withClasses(Bootstrap.card_body)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.card_title)
                                                                        .with(
                                                                                text("Card title")
                                                                        ),
                                                                p()
                                                                        .withClasses(Bootstrap.card_text)
                                                                        .with(
                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.card_footer)
                                                        .with(
                                                                small()
                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                        .with(
                                                                                text("Last updated 3 mins ago")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card-group">
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                      </p>
                    </div>
                    <div class="card-footer">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </div>
                  </div>
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This card has supporting text below as a natural lead-in to additional content.
                      </p>
                    </div>
                    <div class="card-footer">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </div>
                  </div>
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.
                      </p>
                    </div>
                    <div class="card-footer">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("card-layout2", renderedHtml);

        uiDocumentation.documentSource("card-layout2");

    }

    @Test
    void gridCards() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.row_cols_1, Bootstrap.row_cols_md_2, Bootstrap.g_4)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row row-cols-1 row-cols-md-2 g-4">
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-cards", renderedHtml);

        uiDocumentation.documentSource("grid-cards");

    }

    @Test
    void gridCards2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.row_cols_1, Bootstrap.row_cols_md_3, Bootstrap.g_4)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row row-cols-1 row-cols-md-3 g-4">
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-cards2", renderedHtml);

        uiDocumentation.documentSource("grid-cards2");

    }

    @Test
    void gridCards3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.row_cols_1, Bootstrap.row_cols_md_3, Bootstrap.g_4)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card, Bootstrap.h_100)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card, Bootstrap.h_100)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a short BootstrapClasses.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card, Bootstrap.h_100)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card, Bootstrap.h_100)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row row-cols-1 row-cols-md-3 g-4">
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a short BootstrapClasses.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-cards3", renderedHtml);

        uiDocumentation.documentSource("grid-cards3");

    }

    @Test
    void gridCards4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.row_cols_1, Bootstrap.row_cols_md_3, Bootstrap.g_4)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card, Bootstrap.h_100)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Bootstrap.card_footer)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card, Bootstrap.h_100)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This card has supporting text below as a natural lead-in to additional content.")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Bootstrap.card_footer)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.card, Bootstrap.h_100)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.card_img_top)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.card_title)
                                                                                        .with(
                                                                                                text("Card title")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Bootstrap.card_text)
                                                                                        .with(
                                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Bootstrap.card_footer)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row row-cols-1 row-cols-md-3 g-4">
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This card has supporting text below as a natural lead-in to additional content.
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-cards4", renderedHtml);

        uiDocumentation.documentSource("grid-cards4");

    }


}
