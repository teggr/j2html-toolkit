package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.comment;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ModalTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void modalComponents() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                 .withClasses(Bootstrap.modal)
                 .withTabindex(-1)
                 .with(
                    div()
                     .withClasses(Bootstrap.modal_dialog)
                     .with(
                        div()
                         .withClasses(Bootstrap.modal_content)
                         .with(
                            div()
                             .withClasses(Bootstrap.modal_header)
                             .with(
                                h5()
                                 .withClasses(Bootstrap.modal_title)
                                 .with(
                                    text("Modal title")
                                  ),
                                button()
                                 .withType("button")
                                 .withClasses(Bootstrap.btn_close)
                                 .withData("bs-dismiss","modal")
                                 .attr(
                                    AriaStatesAndProperties.ariaLabel("Close")
                                  )
                              ),
                            div()
                             .withClasses(Bootstrap.modal_body)
                             .with(
                                p()
                                 .with(
                                    text("Modal body text goes here.")
                                  )
                              ),
                            div()
                             .withClasses(Bootstrap.modal_footer)
                             .with(
                                button()
                                 .withType("button")
                                 .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                 .withData("bs-dismiss","modal")
                                 .with(
                                    text("Close")
                                  ),
                                button()
                                 .withType("button")
                                 .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                 .with(
                                    text("Save changes")
                                  )
                              )
                          )
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <div class="modal" tabindex="-1">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title">
                      Modal title
                    </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">  
                    </button>
                  </div>
                  <div class="modal-body">
                    <p>
                      Modal body text goes here.
                    </p>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                      Close
                    </button>
                    <button type="button" class="btn btn-primary">
                      Save changes
                    </button>
                  </div>
                </div>
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("modal-components", renderedHtml);

        uiDocumentation.documentSource("modal-components");

    }

    @Test
    void liveDemo() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withData("bs-toggle","modal")
                                .withData("bs-target","#exampleModal")
                                .with(
                                        text("Launch demo modal")
                                ),
                        comment("Modal"),
                        div()
                                .withClasses(Bootstrap.modal, Bootstrap.fade)
                                .withId("exampleModal")
                                .withTabindex(-1)
                                .attr(AriaStatesAndProperties.ariaLabelledby("exampleModalLabel"))
                                .attr(
                                        AriaStatesAndProperties.ariaHidden("true")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.modal_dialog)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.modal_content)
                                                                .with(
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_header)
                                                                                .with(
                                                                                        h1()
                                                                                                .withClasses(Bootstrap.modal_title, Bootstrap.fs_5)
                                                                                                .withId("exampleModalLabel")
                                                                                                .with(
                                                                                                        text("Modal title")
                                                                                                ),
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn_close)
                                                                                                .withData("bs-dismiss","modal")
                                                                                                .attr(
                                                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                                                )
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_body)
                                                                                .with(
                                                                                        text("...")
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_footer)
                                                                                .with(
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                                                                .withData("bs-dismiss","modal")
                                                                                                .with(
                                                                                                        text("Close")
                                                                                                ),
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                                                .with(
                                                                                                        text("Save changes")
                                                                                                )
                                                                                )
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
          Launch demo modal
        </button>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">
                  Modal title
                </h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                </button>
              </div>
              <div class="modal-body">
                ...
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                  Close
                </button>
                <button type="button" class="btn btn-primary">
                  Save changes
                </button>
              </div>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("live-demo", renderedHtml);

        uiDocumentation.documentSource("live-demo");

    }

    @Test
    void staticBackdrop() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withData("bs-toggle","modal")
                                .withData("bs-target","#staticBackdrop")
                                .with(
                                        text("Launch static backdrop modal")
                                ),
                        comment("Modal"),
                        div()
                                .withClasses(Bootstrap.modal, Bootstrap.fade)
                                .withId("staticBackdrop")
                                .withData("bs-backdrop","static")
                                .withData("bs-keyboard","false")
                                .withTabindex(-1)
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("staticBackdropLabel")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaHidden("true")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.modal_dialog)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.modal_content)
                                                                .with(
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_header)
                                                                                .with(
                                                                                        h1()
                                                                                                .withClasses(Bootstrap.modal_title, Bootstrap.fs_5)
                                                                                                .withId("staticBackdropLabel")
                                                                                                .with(
                                                                                                        text("Modal title")
                                                                                                ),
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn_close)
                                                                                                .withData("bs-dismiss","modal")
                                                                                                .attr(
                                                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                                                )
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_body)
                                                                                .with(
                                                                                        text("...")
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_footer)
                                                                                .with(
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                                                                .withData("bs-dismiss","modal")
                                                                                                .with(
                                                                                                        text("Close")
                                                                                                ),
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                                                .with(
                                                                                                        text("Understood")
                                                                                                )
                                                                                )
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
          Launch static backdrop modal
        </button>
        <!-- Modal -->
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">
                  Modal title
                </h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                </button>
              </div>
              <div class="modal-body">
                ...
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                  Close
                </button>
                <button type="button" class="btn btn-primary">
                  Understood
                </button>
              </div>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("static-backdrop", renderedHtml);

        uiDocumentation.documentSource("static-backdrop");

    }

    @Test
    void scrollingLongContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_dialog_scrollable)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="modal-dialog modal-dialog-scrollable">
          ...
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("scrolling-long-content", renderedHtml);

        uiDocumentation.documentSource("scrolling-long-content");

    }

    @Test
    void verticallyCentered() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_dialog_centered)
                                .with(
                                        text("...")
                                ),
                        comment("Vertically centered scrollable modal"),
                        div()
                                .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_dialog_centered, Bootstrap.modal_dialog_scrollable)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="modal-dialog modal-dialog-centered">
          ...
        </div>
        <!-- Vertically centered scrollable modal -->
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
          ...
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("vertically-centered", renderedHtml);

        uiDocumentation.documentSource("vertically-centered");

    }

    @Test
    void tooltipsAndPopovers() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.modal_body)
                        .with(
                                h2()
                                        .withClasses(Bootstrap.fs_5)
                                        .with(
                                                text("Popover in a modal")
                                        ),
                                p()
                                        .with(
                                                text("This"),
                                                button()
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                        .withData("bs-toggle","popover")
                                                        .withTitle("Popover title")
                                                        .withData("bs-content","Popover body content is set in this attribute.")
                                                        .with(
                                                                text("button")
                                                        ),
                                                text("triggers a popover on click.")
                                        ),
                                hr(),
                                h2()
                                        .withClasses(Bootstrap.fs_5)
                                        .with(
                                                text("Tooltips in a modal")
                                        ),
                                p()
                                        .with(
                                                a()
                                                        .withHref("#")
                                                        .withData("bs-toggle","tooltip")
                                                        .withTitle("Tooltip")
                                                        .with(
                                                                text("This link")
                                                        ),
                                                text("and"),
                                                a()
                                                        .withHref("#")
                                                        .withData("bs-toggle","tooltip")
                                                        .withTitle("Tooltip")
                                                        .with(
                                                                text("that link")
                                                        ),
                                                text("have tooltips on hover.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="modal-body">
          <h2 class="fs-5">
            Popover in a modal
          </h2>
          <p>
            This
            <button class="btn btn-secondary" data-bs-toggle="popover" title="Popover title" data-bs-content="Popover body content is set in this attribute.">
              button
            </button>
            triggers a popover on click.
          </p>
          <hr>
          <h2 class="fs-5">
            Tooltips in a modal
          </h2>
          <p>
            <a href="#" data-bs-toggle="tooltip" title="Tooltip">
              This link
            </a>
            and
            <a href="#" data-bs-toggle="tooltip" title="Tooltip">
              that link
            </a>
            have tooltips on hover.
          </p>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("tooltips-and-popovers", renderedHtml);

        uiDocumentation.documentSource("tooltips-and-popovers");

    }

    @Test
    void usingTheGrid() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.modal_body)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.row)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.col_md_4)
                                                                        .with(
                                                                                text(".col-md-4")
                                                                        ),
                                                                div()
                                                                        .withClasses(Bootstrap.col_md_4, Bootstrap.ms_auto)
                                                                        .with(
                                                                                text(".col-md-4.ms-auto")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.row)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.col_md_3, Bootstrap.ms_auto)
                                                                        .with(
                                                                                text(".col-md-3.ms-auto")
                                                                        ),
                                                                div()
                                                                        .withClasses(Bootstrap.col_md_2, Bootstrap.ms_auto)
                                                                        .with(
                                                                                text(".col-md-2.ms-auto")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.row)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.col_md_6, Bootstrap.ms_auto)
                                                                        .with(
                                                                                text(".col-md-6.ms-auto")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.row)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.col_sm_9)
                                                                        .with(
                                                                                text("Level 1:.col-sm-9"),
                                                                                div()
                                                                                        .withClasses(Bootstrap.row)
                                                                                        .with(
                                                                                                div()
                                                                                                        .withClasses(Bootstrap.col_8, Bootstrap.col_sm_6)
                                                                                                        .with(
                                                                                                                text("Level 2:.col-8.col-sm-6")
                                                                                                        ),
                                                                                                div()
                                                                                                        .withClasses(Bootstrap.col_4, Bootstrap.col_sm_6)
                                                                                                        .with(
                                                                                                                text("Level 2:.col-4.col-sm-6")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="modal-body">
          <div class="container-fluid">
            <div class="row">
              <div class="col-md-4">
                .col-md-4
              </div>
              <div class="col-md-4 ms-auto">
                .col-md-4.ms-auto
              </div>
            </div>
            <div class="row">
              <div class="col-md-3 ms-auto">
                .col-md-3.ms-auto
              </div>
              <div class="col-md-2 ms-auto">
                .col-md-2.ms-auto
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 ms-auto">
                .col-md-6.ms-auto
              </div>
            </div>
            <div class="row">
              <div class="col-sm-9">
                Level 1:.col-sm-9
                <div class="row">
                  <div class="col-8 col-sm-6">
                    Level 2:.col-8.col-sm-6
                  </div>
                  <div class="col-4 col-sm-6">
                    Level 2:.col-4.col-sm-6
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("using-the-grid", renderedHtml);

        uiDocumentation.documentSource("using-the-grid");

    }

    @Test
    void varyingModalContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withData("bs-toggle","modal")
                                .withData("bs-target","#exampleModal")
                                .withData("bs-whatever","@mdo")
                                .with(
                                        text("Open modal for @mdo")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withData("bs-toggle","modal")
                                .withData("bs-target","#exampleModal")
                                .withData("bs-whatever","@fat")
                                .with(
                                        text("Open modal for @fat")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withData("bs-toggle","modal")
                                .withData("bs-target","#exampleModal")
                                .withData("bs-whatever","@getbootstrap")
                                .with(
                                        text("Open modal for @getbootstrap")
                                ),
                        div()
                                .withClasses(Bootstrap.modal, Bootstrap.fade)
                                .withId("exampleModal")
                                .withTabindex(-1)
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("exampleModalLabel")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaHidden("true")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.modal_dialog)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.modal_content)
                                                                .with(
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_header)
                                                                                .with(
                                                                                        h1()
                                                                                                .withClasses(Bootstrap.modal_title, Bootstrap.fs_5)
                                                                                                .withId("exampleModalLabel")
                                                                                                .with(
                                                                                                        text("New message")
                                                                                                ),
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn_close)
                                                                                                .withData("bs-dismiss","modal")
                                                                                                .attr(
                                                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                                                )
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_body)
                                                                                .with(
                                                                                        form()
                                                                                                .with(
                                                                                                        div()
                                                                                                                .withClasses(Bootstrap.mb_3)
                                                                                                                .with(
                                                                                                                        label()
                                                                                                                                .withFor("recipient-name")
                                                                                                                                .withClasses(Bootstrap.col_form_label)
                                                                                                                                .with(
                                                                                                                                        text("Recipient:")
                                                                                                                                ),
                                                                                                                        input()
                                                                                                                                .withType("text")
                                                                                                                                .withClasses(Bootstrap.form_control)
                                                                                                                                .withId("recipient-name")
                                                                                                                ),
                                                                                                        div()
                                                                                                                .withClasses(Bootstrap.mb_3)
                                                                                                                .with(
                                                                                                                        label()
                                                                                                                                .withFor("message-text")
                                                                                                                                .withClasses(Bootstrap.col_form_label)
                                                                                                                                .with(
                                                                                                                                        text("Message:")
                                                                                                                                ),
                                                                                                                        textarea()
                                                                                                                                .withClasses(Bootstrap.form_control)
                                                                                                                                .withId("message-text")
                                                                                                                )
                                                                                                )
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_footer)
                                                                                .with(
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                                                                .withData("bs-dismiss","modal")
                                                                                                .with(
                                                                                                        text("Close")
                                                                                                ),
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                                                .with(
                                                                                                        text("Send message")
                                                                                                )
                                                                                )
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">
          Open modal for @mdo
        </button>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@fat">
          Open modal for @fat
        </button>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">
          Open modal for @getbootstrap
        </button>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">
                  New message
                </h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                </button>
              </div>
              <div class="modal-body">
                <form>
                  <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">
                      Recipient:
                    </label>
                    <input type="text" class="form-control" id="recipient-name">
                  </div>
                  <div class="mb-3">
                    <label for="message-text" class="col-form-label">
                      Message:
                    </label>
                    <textarea class="form-control" id="message-text"></textarea>
                  </div>
                </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                  Close
                </button>
                <button type="button" class="btn btn-primary">
                  Send message
                </button>
              </div>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("varying-modal-content", renderedHtml);

        uiDocumentation.documentSource("varying-modal-content");

    }

    @Test
    void toggleBetweenModals() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.modal, Bootstrap.fade)
                                .withId("exampleModalToggle")
                                .attr(
                                        AriaStatesAndProperties.ariaHidden("true")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("exampleModalToggleLabel")
                                )
                                .withTabindex(-1)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_dialog_centered)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.modal_content)
                                                                .with(
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_header)
                                                                                .with(
                                                                                        h1()
                                                                                                .withClasses(Bootstrap.modal_title, Bootstrap.fs_5)
                                                                                                .withId("exampleModalToggleLabel")
                                                                                                .with(
                                                                                                        text("Modal 1")
                                                                                                ),
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn_close)
                                                                                                .withData("bs-dismiss","modal")
                                                                                                .attr(
                                                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                                                )
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_body)
                                                                                .with(
                                                                                        text("Show a second modal and hide this one with the button below.")
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_footer)
                                                                                .with(
                                                                                        button()
                                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                                                .withData("bs-target","#exampleModalToggle2")
                                                                                                .withData("bs-toggle","modal")
                                                                                                .with(
                                                                                                        text("Open second modal")
                                                                                                )
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.modal, Bootstrap.fade)
                                .withId("exampleModalToggle2")
                                .attr(
                                        AriaStatesAndProperties.ariaHidden("true")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("exampleModalToggleLabel2")
                                )
                                .withTabindex(-1)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_dialog_centered)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.modal_content)
                                                                .with(
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_header)
                                                                                .with(
                                                                                        h1()
                                                                                                .withClasses(Bootstrap.modal_title, Bootstrap.fs_5)
                                                                                                .withId("exampleModalToggleLabel2")
                                                                                                .with(
                                                                                                        text("Modal 2")
                                                                                                ),
                                                                                        button()
                                                                                                .withType("button")
                                                                                                .withClasses(Bootstrap.btn_close)
                                                                                                .withData("bs-dismiss","modal")
                                                                                                .attr(
                                                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                                                )
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_body)
                                                                                .with(
                                                                                        text("Hide this modal and show the first with the button below.")
                                                                                ),
                                                                        div()
                                                                                .withClasses(Bootstrap.modal_footer)
                                                                                .with(
                                                                                        button()
                                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                                                                .withData("bs-target","#exampleModalToggle")
                                                                                                .withData("bs-toggle","modal")
                                                                                                .with(
                                                                                                        text("Back to first")
                                                                                                )
                                                                                )
                                                                )
                                                )
                                ),
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withData("bs-target","#exampleModalToggle")
                                .withData("bs-toggle","modal")
                                .with(
                                        text("Open first modal")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalToggleLabel">
                  Modal 1
                </h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                </button>
              </div>
              <div class="modal-body">
                Show a second modal and hide this one with the button below.
              </div>
              <div class="modal-footer">
                <button class="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal">
                  Open second modal
                </button>
              </div>
            </div>
          </div>
        </div>
        <div class="modal fade" id="exampleModalToggle2" aria-hidden="true" aria-labelledby="exampleModalToggleLabel2" tabindex="-1">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalToggleLabel2">
                  Modal 2
                </h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                </button>
              </div>
              <div class="modal-body">
                Hide this modal and show the first with the button below.
              </div>
              <div class="modal-footer">
                <button class="btn btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">
                  Back to first
                </button>
              </div>
            </div>
          </div>
        </div>
        <button class="btn btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal">
          Open first modal
        </button>
        """, renderedHtml);

        // document
        uiDocumentation.document("toggle-between-modals", renderedHtml);

        uiDocumentation.documentSource("toggle-between-modals");

    }

    @Test
    void optionalSizes() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_xl)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_lg)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_sm)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="modal-dialog modal-xl">
          ...
        </div>
        <div class="modal-dialog modal-lg">
          ...
        </div>
        <div class="modal-dialog modal-sm">
          ...
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("optional-sizes", renderedHtml);

        uiDocumentation.documentSource("optional-sizes");

    }

    @Test
    void fullScreenModal() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.modal_dialog, Bootstrap.modal_fullscreen_sm_down)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="modal-dialog modal-fullscreen-sm-down">
          ...
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("full-screen-modal", renderedHtml);

        uiDocumentation.documentSource("full-screen-modal");

    }


}
