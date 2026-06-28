package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.bootstrap.BootstrapIcons;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AlertsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_primary)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple primary alert—check it out!")
                        ),
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_secondary)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple secondary alert—check it out!")
                        ),
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_success)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple success alert—check it out!")
                        ),
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_danger)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple danger alert—check it out!")
                        ),
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_warning)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple warning alert—check it out!")
                        ),
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_info)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple info alert—check it out!")
                        ),
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_light)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple light alert—check it out!")
                        ),
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_dark)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple dark alert—check it out!")
                        )
                    )
                );

        //language=HTML
        assertEquals("""
            <div class="alert alert-primary" role="alert">
              A simple primary alert—check it out!
            </div>
            <div class="alert alert-secondary" role="alert">
              A simple secondary alert—check it out!
            </div>
            <div class="alert alert-success" role="alert">
              A simple success alert—check it out!
            </div>
            <div class="alert alert-danger" role="alert">
              A simple danger alert—check it out!
            </div>
            <div class="alert alert-warning" role="alert">
              A simple warning alert—check it out!
            </div>
            <div class="alert alert-info" role="alert">
              A simple info alert—check it out!
            </div>
            <div class="alert alert-light" role="alert">
              A simple light alert—check it out!
            </div>
            <div class="alert alert-dark" role="alert">
              A simple dark alert—check it out!
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

    @Test
    void liveExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withId("liveAlertPlaceholder"),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withId("liveAlertBtn")
                                .with(
                                        text("Show live alert")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div id="liveAlertPlaceholder">
            </div>
            <button type="button" class="btn btn-primary" id="liveAlertBtn">
              Show live alert
            </button>
            """, renderedHtml);

        // document
        uiDocumentation.document("live-example", renderedHtml);

        uiDocumentation.documentSource("live-example");

    }


    @Test
    void linkColor() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_primary)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        text("A simple primary alert with"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.alert_link)
                                                .with(
                                                        text("an example link")
                                                ),
                                        text(". Give it a click if you like.")
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_secondary)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        text("A simple secondary alert with"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.alert_link)
                                                .with(
                                                        text("an example link")
                                                ),
                                        text(". Give it a click if you like.")
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_success)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        text("A simple success alert with"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.alert_link)
                                                .with(
                                                        text("an example link")
                                                ),
                                        text(". Give it a click if you like.")
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_danger)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        text("A simple danger alert with"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.alert_link)
                                                .with(
                                                        text("an example link")
                                                ),
                                        text(". Give it a click if you like.")
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_warning)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        text("A simple warning alert with"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.alert_link)
                                                .with(
                                                        text("an example link")
                                                ),
                                        text(". Give it a click if you like.")
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_info)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        text("A simple info alert with"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.alert_link)
                                                .with(
                                                        text("an example link")
                                                ),
                                        text(". Give it a click if you like.")
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_light)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        text("A simple light alert with"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.alert_link)
                                                .with(
                                                        text("an example link")
                                                ),
                                        text(". Give it a click if you like.")
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_dark)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        text("A simple dark alert with"),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.alert_link)
                                                .with(
                                                        text("an example link")
                                                ),
                                        text(". Give it a click if you like.")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="alert alert-primary" role="alert">
                  A simple primary alert with
                  <a href="#" class="alert-link">
                    an example link
                  </a>
                  . Give it a click if you like.
                </div>
                <div class="alert alert-secondary" role="alert">
                  A simple secondary alert with
                  <a href="#" class="alert-link">
                    an example link
                  </a>
                  . Give it a click if you like.
                </div>
                <div class="alert alert-success" role="alert">
                  A simple success alert with
                  <a href="#" class="alert-link">
                    an example link
                  </a>
                  . Give it a click if you like.
                </div>
                <div class="alert alert-danger" role="alert">
                  A simple danger alert with
                  <a href="#" class="alert-link">
                    an example link
                  </a>
                  . Give it a click if you like.
                </div>
                <div class="alert alert-warning" role="alert">
                  A simple warning alert with
                  <a href="#" class="alert-link">
                    an example link
                  </a>
                  . Give it a click if you like.
                </div>
                <div class="alert alert-info" role="alert">
                  A simple info alert with
                  <a href="#" class="alert-link">
                    an example link
                  </a>
                  . Give it a click if you like.
                </div>
                <div class="alert alert-light" role="alert">
                  A simple light alert with
                  <a href="#" class="alert-link">
                    an example link
                  </a>
                  . Give it a click if you like.
                </div>
                <div class="alert alert-dark" role="alert">
                  A simple dark alert with
                  <a href="#" class="alert-link">
                    an example link
                  </a>
                  . Give it a click if you like.
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("link-color", renderedHtml);

        uiDocumentation.documentSource("link-color");

    }

    @Test
    void additionalContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.alert, Bootstrap.alert_success)
                        .attr(AriaRoles.roleAlert)
                        .with(
                                h4()
                                        .withClasses(Bootstrap.alert_heading)
                                        .with(
                                                text("Well done!")
                                        ),
                                p()
                                        .with(
                                                text("Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.")
                                        ),
                                hr(),
                                p()
                                        .withClasses(Bootstrap.mb_0)
                                        .with(
                                                text("Whenever you need to, be sure to use margin utilities to keep things nice and tidy.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="alert alert-success" role="alert">
                  <h4 class="alert-heading">
                    Well done!
                  </h4>
                  <p>
                    Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.
                  </p>
                  <hr>
                  <p class="mb-0">
                    Whenever you need to, be sure to use margin utilities to keep things nice and tidy.
                  </p>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("link-color", renderedHtml);

        uiDocumentation.documentSource("link-color");

    }

    @Test
    void icons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.alert, Bootstrap.alert_primary, Bootstrap.d_flex, Bootstrap.align_items_center)
                        .attr(AriaRoles.roleAlert)
                        .with(
                                svg()
                                        .attr("xmlns","http://www.w3.org/2000/svg")
                                        .withClasses(Bootstrap.bi,BootstrapIcons.bi_exclamation_triangle_fill, Bootstrap.flex_shrink_0, Bootstrap.me_2)
                                        .attr("viewBox","0 0 16 16")
                                        .attr(AriaRoles.roleImg)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Warning:")
                                        )
                                        .with(
                                                path()
                                                        .attr("d","M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0.954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z")
                                        ),
                                div()
                                        .with(
                                                text("An example alert with an icon")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="alert alert-primary d-flex align-items-center" role="alert">
                  <svg xmlns="http://www.w3.org/2000/svg" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
                    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0.954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z">
                    </path>
                  </svg>
                  <div>
                    An example alert with an icon
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("icons", renderedHtml);

        uiDocumentation.documentSource("icons");

    }

    @Test
    void icons2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        svg()
                                .attr("xmlns","http://www.w3.org/2000/svg")
                                .withClasses(Bootstrap.d_none)
                                .with(
                                        symbol()
                                                .withId("check-circle-fill")
                                                .attr("viewBox","0 0 16 16")
                                                .with(
                                                        path()
                                                                .attr("d","M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z")
                                                ),
                                        symbol()
                                                .withId("info-fill")
                                                .attr("viewBox","0 0 16 16")
                                                .with(
                                                        path()
                                                                .attr("d","M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0.487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z")
                                                ),
                                        symbol()
                                                .withId("exclamation-triangle-fill")
                                                .attr("viewBox","0 0 16 16")
                                                .with(
                                                        path()
                                                                .attr("d","M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0.954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_primary, Bootstrap.d_flex, Bootstrap.align_items_center)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        svg()
                                                .withClasses(Bootstrap.bi, Bootstrap.flex_shrink_0, Bootstrap.me_2)
                                                .attr(AriaRoles.roleImg)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Info:")
                                                )
                                                .with(
                                                        use()
                                                                .attr("xlink:href","#info-fill")
                                                ),
                                        div()
                                                .with(
                                                        text("An example alert with an icon")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_success, Bootstrap.d_flex, Bootstrap.align_items_center)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        svg()
                                                .withClasses(Bootstrap.bi, Bootstrap.flex_shrink_0, Bootstrap.me_2)
                                                .attr(AriaRoles.roleImg)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Success:")
                                                )
                                                .with(
                                                        use()
                                                                .attr("xlink:href","#check-circle-fill")
                                                ),
                                        div()
                                                .with(
                                                        text("An example success alert with an icon")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_warning, Bootstrap.d_flex, Bootstrap.align_items_center)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        svg()
                                                .withClasses(Bootstrap.bi, Bootstrap.flex_shrink_0, Bootstrap.me_2)
                                                .attr(AriaRoles.roleImg)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Warning:")
                                                )
                                                .with(
                                                        use()
                                                                .attr("xlink:href","#exclamation-triangle-fill")
                                                ),
                                        div()
                                                .with(
                                                        text("An example warning alert with an icon")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_danger, Bootstrap.d_flex, Bootstrap.align_items_center)
                                .attr(AriaRoles.roleAlert)
                                .with(
                                        svg()
                                                .withClasses(Bootstrap.bi, Bootstrap.flex_shrink_0, Bootstrap.me_2)
                                                .attr(AriaRoles.roleImg)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Danger:")
                                                )
                                                .with(
                                                        use()
                                                                .attr("xlink:href","#exclamation-triangle-fill")
                                                ),
                                        div()
                                                .with(
                                                        text("An example danger alert with an icon")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
                  <symbol id="check-circle-fill" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z">
                    </path>
                  </symbol>
                  <symbol id="info-fill" viewBox="0 0 16 16">
                    <path d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0.487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z">
                    </path>
                  </symbol>
                  <symbol id="exclamation-triangle-fill" viewBox="0 0 16 16">
                    <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0.954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z">
                    </path>
                  </symbol>
                </svg>
                <div class="alert alert-primary d-flex align-items-center" role="alert">
                  <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Info:">
                    <use xlink:href="#info-fill">
                    </use>
                  </svg>
                  <div>
                    An example alert with an icon
                  </div>
                </div>
                <div class="alert alert-success d-flex align-items-center" role="alert">
                  <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Success:">
                    <use xlink:href="#check-circle-fill">
                    </use>
                  </svg>
                  <div>
                    An example success alert with an icon
                  </div>
                </div>
                <div class="alert alert-warning d-flex align-items-center" role="alert">
                  <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Warning:">
                    <use xlink:href="#exclamation-triangle-fill">
                    </use>
                  </svg>
                  <div>
                    An example warning alert with an icon
                  </div>
                </div>
                <div class="alert alert-danger d-flex align-items-center" role="alert">
                  <svg class="bi flex-shrink-0 me-2" role="img" aria-label="Danger:">
                    <use xlink:href="#exclamation-triangle-fill">
                    </use>
                  </svg>
                  <div>
                    An example danger alert with an icon
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("icons2", renderedHtml);

        uiDocumentation.documentSource("icons2");

    }

    @Test
    void dismissing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.alert, Bootstrap.alert_warning, Bootstrap.alert_dismissible, Bootstrap.fade, Bootstrap.show)
                        .attr(AriaRoles.roleAlert)
                        .with(
                                strong()
                                        .with(
                                                text("Holy guacamole!")
                                        ),
                                text("You should check in on some of those fields below."),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn_close)
                                        .withData("bs-dismiss","alert")
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Close")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
              <strong>
                Holy guacamole!
              </strong>
              You should check in on some of those fields below.
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
              </button>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("dismissing", renderedHtml);

        uiDocumentation.documentSource("dismissing");

    }


}
