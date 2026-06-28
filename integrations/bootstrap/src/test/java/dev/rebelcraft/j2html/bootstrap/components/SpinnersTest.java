package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SpinnersTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void borderSpinner() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
             .withClasses(Bootstrap.spinner_border)
             .attr(AriaRoles.roleStatus)
             .with(
                span()
                 .withClasses(Bootstrap.visually_hidden)
                 .with(
                    text("Loading...")
                  )
              )
        );

        //language=HTML
        assertEquals("""
            <div class="spinner-border" role="status">
              <span class="visually-hidden">
                Loading...
              </span>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("border-spinner", renderedHtml);

        uiDocumentation.documentSource("border-spinner");

    }
    @Test
    void colors() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.text_primary)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.text_secondary)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.text_success)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.text_danger)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.text_warning)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.text_info)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.text_light)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.text_dark)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="spinner-border text-primary" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-border text-secondary" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-border text-success" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-border text-danger" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-border text-warning" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-border text-info" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-border text-light" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-border text-dark" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("colors", renderedHtml);

        uiDocumentation.documentSource("colors");

    }

    @Test
    void growingSpinner() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.spinner_grow)
                        .attr(AriaRoles.roleStatus)
                        .with(
                                span()
                                        .withClasses(Bootstrap.visually_hidden)
                                        .with(
                                                text("Loading...")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="spinner-grow" role="status">
              <span class="visually-hidden">
                Loading...
              </span>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("growing-spinner", renderedHtml);

        uiDocumentation.documentSource("growing-spinner");

    }

    @Test
    void growingSpinner2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.text_primary)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.text_secondary)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.text_success)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.text_danger)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.text_warning)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.text_info)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.text_light)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.text_dark)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="spinner-grow text-primary" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-grow text-secondary" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-grow text-success" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-grow text-danger" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-grow text-warning" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-grow text-info" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-grow text-light" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-grow text-dark" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("growing-spinner2", renderedHtml);

        uiDocumentation.documentSource("growing-spinner2");

    }

    @Test
    void margin() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.spinner_border, Bootstrap.m_5)
                        .attr(AriaRoles.roleStatus)
                        .with(
                                span()
                                        .withClasses(Bootstrap.visually_hidden)
                                        .with(
                                                text("Loading...")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="spinner-border m-5" role="status">
              <span class="visually-hidden">
                Loading...
              </span>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("margin", renderedHtml);

        uiDocumentation.documentSource("margin");

    }

    @Test
    void flex() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.justify_content_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.spinner_border)
                                        .attr(AriaRoles.roleStatus)
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Loading...")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex justify-content-center">
                  <div class="spinner-border" role="status">
                    <span class="visually-hidden">
                      Loading...
                    </span>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("flex", renderedHtml);

        uiDocumentation.documentSource("flex");

    }

    @Test
    void flex2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.align_items_center)
                        .with(
                                strong()
                                        .attr(AriaRoles.roleStatus)
                                        .with(
                                                text("Loading...")
                                        ),
                                div()
                                        .withClasses(Bootstrap.spinner_border, Bootstrap.ms_auto)
                                        .attr(
                                                AriaStatesAndProperties.ariaHidden("true")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-items-center">
                  <strong role="status">
                    Loading...
                  </strong>
                  <div class="spinner-border ms-auto" aria-hidden="true">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("flex2", renderedHtml);

        uiDocumentation.documentSource("flex2");

    }

    @Test
    void floats2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.clearfix)
                        .with(
                                div()
                                        .withClasses(Bootstrap.spinner_border, Bootstrap.float_end)
                                        .attr(AriaRoles.roleStatus)
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Loading...")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="clearfix">
                  <div class="spinner-border float-end" role="status">
                    <span class="visually-hidden">
                      Loading...
                    </span>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("floats2", renderedHtml);

        uiDocumentation.documentSource("floats2");

    }

    @Test
    void textAlign() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.text_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.spinner_border)
                                        .attr(AriaRoles.roleStatus)
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Loading...")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="text-center">
                  <div class="spinner-border" role="status">
                    <span class="visually-hidden">
                      Loading...
                    </span>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-align", renderedHtml);

        uiDocumentation.documentSource("text-align");

    }

    @Test
    void size() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.spinner_border, Bootstrap.spinner_border_sm)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow, Bootstrap.spinner_grow_sm)
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="spinner-border spinner-border-sm" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                <div class="spinner-grow spinner-grow-sm" role="status">
                  <span class="visually-hidden">
                    Loading...
                  </span>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("size", renderedHtml);

        uiDocumentation.documentSource("size");

    }

    @Test
    void size2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.spinner_border)
                                .withStyle("width: 3rem; height: 3rem;")
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.spinner_grow)
                                .withStyle("width: 3rem; height: 3rem;")
                                .attr(AriaRoles.roleStatus)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .with(
                                                        text("Loading...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="spinner-border" style="width: 3rem; height: 3rem;" role="status">
              <span class="visually-hidden">
                Loading...
              </span>
            </div>
            <div class="spinner-grow" style="width: 3rem; height: 3rem;" role="status">
              <span class="visually-hidden">
                Loading...
              </span>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("size2", renderedHtml);

        uiDocumentation.documentSource("size2");

    }

    @Test
    void buttons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withCondDisabled(true)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.spinner_border, Bootstrap.spinner_border_sm)
                                                .attr(
                                                        AriaStatesAndProperties.ariaHidden("true")
                                                ),
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .attr(AriaRoles.roleStatus)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withCondDisabled(true)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.spinner_border, Bootstrap.spinner_border_sm)
                                                .attr(
                                                        AriaStatesAndProperties.ariaHidden("true")
                                                ),
                                        span()
                                                .attr(AriaRoles.roleStatus)
                                                .with(
                                                        text("Loading...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <button class="btn btn-primary" type="button" disabled>
                  <span class="spinner-border spinner-border-sm" aria-hidden="true">
                  </span>
                  <span class="visually-hidden" role="status">
                    Loading...
                  </span>
                </button>
                <button class="btn btn-primary" type="button" disabled>
                  <span class="spinner-border spinner-border-sm" aria-hidden="true">
                  </span>
                  <span role="status">
                    Loading...
                  </span>
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("buttons", renderedHtml);

        uiDocumentation.documentSource("buttons");

    }

    @Test
    void buttons2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withCondDisabled(true)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.spinner_grow, Bootstrap.spinner_grow_sm)
                                                .attr(
                                                        AriaStatesAndProperties.ariaHidden("true")
                                                ),
                                        span()
                                                .withClasses(Bootstrap.visually_hidden)
                                                .attr(AriaRoles.roleStatus)
                                                .with(
                                                        text("Loading...")
                                                )
                                ),
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withCondDisabled(true)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.spinner_grow, Bootstrap.spinner_grow_sm)
                                                .attr(
                                                        AriaStatesAndProperties.ariaHidden("true")
                                                ),
                                        span()
                                                .attr(AriaRoles.roleStatus)
                                                .with(
                                                        text("Loading...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <button class="btn btn-primary" type="button" disabled>
              <span class="spinner-grow spinner-grow-sm" aria-hidden="true">
              </span>
              <span class="visually-hidden" role="status">
                Loading...
              </span>
            </button>
            <button class="btn btn-primary" type="button" disabled>
              <span class="spinner-grow spinner-grow-sm" aria-hidden="true">
              </span>
              <span role="status">
                Loading...
              </span>
            </button>
            """, renderedHtml);

        // document
        uiDocumentation.document("buttons2", renderedHtml);

        uiDocumentation.documentSource("buttons2");

    }


}
