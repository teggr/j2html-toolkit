package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaceholdersTest {

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
                              text("Some quick example text to build on the card title and make up the bulk of the card's content.")
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
                   .withClasses(Bootstrap.card)
                   .attr(
                      AriaStatesAndProperties.ariaHidden("true")
                    )
                   .with(
                      img()
                       .withSrc("...")
                       .withClasses(Bootstrap.card_img_top)
                       .withAlt("..."),
                      div()
                       .withClasses(Bootstrap.card_body)
                       .with(
                          h5()
                           .withClasses(Bootstrap.card_title, Bootstrap.placeholder_glow)
                           .with(
                              span()
                               .withClasses(Bootstrap.placeholder, Bootstrap.col_6)
                            ),
                          p()
                           .withClasses(Bootstrap.card_text, Bootstrap.placeholder_glow)
                           .with(
                              span()
                               .withClasses(Bootstrap.placeholder, Bootstrap.col_7),
                              span()
                               .withClasses(Bootstrap.placeholder, Bootstrap.col_4),
                              span()
                               .withClasses(Bootstrap.placeholder, Bootstrap.col_4),
                              span()
                               .withClasses(Bootstrap.placeholder, Bootstrap.col_6),
                              span()
                               .withClasses(Bootstrap.placeholder, Bootstrap.col_8)
                            ),
                          a()
                           .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.disabled, Bootstrap.placeholder, Bootstrap.col_6)
                           .attr(
                              AriaStatesAndProperties.ariaDisabled("true")
                            )
                        )
                    )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="card">
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
            <div class="card" aria-hidden="true">
              <img src="..." class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title placeholder-glow">
                  <span class="placeholder col-6">
                  </span>
                </h5>
                <p class="card-text placeholder-glow">
                  <span class="placeholder col-7">
                  </span>
                  <span class="placeholder col-4">
                  </span>
                  <span class="placeholder col-4">
                  </span>
                  <span class="placeholder col-6">
                  </span>
                  <span class="placeholder col-8">
                  </span>
                </p>
                <a class="btn btn-primary disabled placeholder col-6" aria-disabled="true">
                </a>
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void howItWorks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .attr(
                                        AriaStatesAndProperties.ariaHidden("true")
                                )
                                .with(
                                        span()
                                                .withClasses(Bootstrap.placeholder, Bootstrap.col_6)
                                ),
                        a()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.disabled, Bootstrap.placeholder, Bootstrap.col_4)
                                .attr(
                                        AriaStatesAndProperties.ariaDisabled("true")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <p aria-hidden="true">
          <span class="placeholder col-6">
          </span>
        </p>
        <a class="btn btn-primary disabled placeholder col-4" aria-disabled="true">
        </a>
        """, renderedHtml);

        // document
        uiDocumentation.document("how-it-works", renderedHtml);

        uiDocumentation.documentSource("how-it-works");

    }

    @Test
    void width() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_6),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.w_75),
                        span()
                                .withClasses(Bootstrap.placeholder)
                                .withStyle("width: 25%;")
                )
        );

        //language=HTML
        assertEquals("""
        <span class="placeholder col-6">
        </span>
        <span class="placeholder w-75">
        </span>
        <span class="placeholder" style="width: 25%;">
        </span>
        """, renderedHtml);

        // document
        uiDocumentation.document("width", renderedHtml);

        uiDocumentation.documentSource("width");

    }

    @Test
    void color() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.bg_primary),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.bg_secondary),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.bg_success),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.bg_danger),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.bg_warning),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.bg_info),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.bg_light),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.bg_dark)
                )
        );

        //language=HTML
        assertEquals("""
        <span class="placeholder col-12">
        </span>
        <span class="placeholder col-12 bg-primary">
        </span>
        <span class="placeholder col-12 bg-secondary">
        </span>
        <span class="placeholder col-12 bg-success">
        </span>
        <span class="placeholder col-12 bg-danger">
        </span>
        <span class="placeholder col-12 bg-warning">
        </span>
        <span class="placeholder col-12 bg-info">
        </span>
        <span class="placeholder col-12 bg-light">
        </span>
        <span class="placeholder col-12 bg-dark">
        </span>
        """, renderedHtml);

        // document
        uiDocumentation.document("color", renderedHtml);

        uiDocumentation.documentSource("color");

    }

    @Test
    void sizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.placeholder_lg),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.placeholder_sm),
                        span()
                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12, Bootstrap.placeholder_xs)
                )
        );

        //language=HTML
        assertEquals("""
        <span class="placeholder col-12 placeholder-lg">
        </span>
        <span class="placeholder col-12">
        </span>
        <span class="placeholder col-12 placeholder-sm">
        </span>
        <span class="placeholder col-12 placeholder-xs">
        </span>
        """, renderedHtml);

        // document
        uiDocumentation.document("sizing", renderedHtml);

        uiDocumentation.documentSource("sizing");

    }

    @Test
    void animation() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Bootstrap.placeholder_glow)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12)
                                ),
                        p()
                                .withClasses(Bootstrap.placeholder_wave)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.placeholder, Bootstrap.col_12)
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <p class="placeholder-glow">
          <span class="placeholder col-12">
          </span>
        </p>
        <p class="placeholder-wave">
          <span class="placeholder col-12">
          </span>
        </p>
        """, renderedHtml);

        // document
        uiDocumentation.document("animation", renderedHtml);

        uiDocumentation.documentSource("animation");

    }


}
