package dev.rebelcraft.j2html.bootstrap.helpers;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StretchedlinkTest {

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
                        text("Card with stretched link")
                      ),
                    p()
                     .withClasses(Bootstrap.card_text)
                     .with(
                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                      ),
                    a()
                     .withHref("#")
                     .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.stretched_link)
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
                  Card with stretched link
                </h5>
                <p class="card-text">
                  Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                </p>
                <a href="#" class="btn btn-primary stretched-link">
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
    void example2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.position_relative)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Bootstrap.flex_shrink_0, Bootstrap.me_3)
                                        .withAlt("..."),
                                div()
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.mt_0)
                                                        .with(
                                                                text("Custom component with stretched link")
                                                        ),
                                                p()
                                                        .with(
                                                                text("This is some placeholder content for the custom component. It is intended to mimic what some real-world content would look like, and we're using it here to give the component a bit of body and size.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.stretched_link)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="d-flex position-relative">
          <img src="..." class="flex-shrink-0 me-3" alt="...">
          <div>
            <h5 class="mt-0">
              Custom component with stretched link
            </h5>
            <p>
              This is some placeholder content for the custom component. It is intended to mimic what some real-world content would look like, and we&#x27;re using it here to give the component a bit of body and size.
            </p>
            <a href="#" class="stretched-link">
              Go somewhere
            </a>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("example2", renderedHtml);

        uiDocumentation.documentSource("example2");

    }

    @Test
    void example3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.g_0, Bootstrap.bg_body_secondary, Bootstrap.position_relative)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_md_6, Bootstrap.mb_md_0, Bootstrap.p_md_4)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Bootstrap.w_100)
                                                        .withAlt("...")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_6, Bootstrap.p_4, Bootstrap.ps_md_0)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.mt_0)
                                                        .with(
                                                                text("Columns with stretched link")
                                                        ),
                                                p()
                                                        .with(
                                                                text("Another instance of placeholder content for this other custom component. It is intended to mimic what some real-world content would look like, and we're using it here to give the component a bit of body and size.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Bootstrap.stretched_link)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="row g-0 bg-body-secondary position-relative">
          <div class="col-md-6 mb-md-0 p-md-4">
            <img src="..." class="w-100" alt="...">
          </div>
          <div class="col-md-6 p-4 ps-md-0">
            <h5 class="mt-0">
              Columns with stretched link
            </h5>
            <p>
              Another instance of placeholder content for this other custom component. It is intended to mimic what some real-world content would look like, and we&#x27;re using it here to give the component a bit of body and size.
            </p>
            <a href="#" class="stretched-link">
              Go somewhere
            </a>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("example3", renderedHtml);

        uiDocumentation.documentSource("example3");

    }

    @Test
    void identifyingTheContainingBlock() throws Exception {

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
                                                                text("Card with stretched links")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text)
                                                        .with(
                                                                a()
                                                                        .withHref("#")
                                                                        .withClasses(Bootstrap.stretched_link, Bootstrap.text_danger)
                                                                        .withStyle("position: relative;")
                                                                        .with(
                                                                                text("Stretched link will not work here, because"),
                                                                                code()
                                                                                        .with(
                                                                                                text("position: relative")
                                                                                        ),
                                                                                text("is added to the link")
                                                                        )
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.card_text, Bootstrap.bg_body_tertiary)
                                                        .withStyle("transform: rotate(0);")
                                                        .with(
                                                                text("This"),
                                                                a()
                                                                        .withHref("#")
                                                                        .withClasses(Bootstrap.text_warning, Bootstrap.stretched_link)
                                                                        .with(
                                                                                text("stretched link")
                                                                        ),
                                                                text("will only be spread over the"),
                                                                code()
                                                                        .with(
                                                                                text("p")
                                                                        ),
                                                                text("-tag, because a transform is applied to it.")
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
              Card with stretched links
            </h5>
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
            </p>
            <p class="card-text">
              <a href="#" class="stretched-link text-danger" style="position: relative;">
                Stretched link will not work here, because
                <code>
                  position: relative
                </code>
                is added to the link
              </a>
            </p>
            <p class="card-text bg-body-tertiary" style="transform: rotate(0);">
              This
              <a href="#" class="text-warning stretched-link">
                stretched link
              </a>
              will only be spread over the
              <code>
                p
              </code>
              -tag, because a transform is applied to it.
            </p>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("identifying-the-containing-block", renderedHtml);

        uiDocumentation.documentSource("identifying-the-containing-block");

    }


}
