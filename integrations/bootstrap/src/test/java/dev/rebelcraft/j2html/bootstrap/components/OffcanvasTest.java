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

class OffcanvasTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void offcanvasComponents() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                 .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_start, Bootstrap.show)
                 .withTabindex(-1)
                 .withId("offcanvas")
                 .attr(
                    AriaStatesAndProperties.ariaLabelledby("offcanvasLabel")
                  )
                 .with(
                    div()
                     .withClasses(Bootstrap.offcanvas_header)
                     .with(
                        h5()
                         .withClasses(Bootstrap.offcanvas_title)
                         .withId("offcanvasLabel")
                         .with(
                            text("Offcanvas")
                          ),
                        button()
                         .withType("button")
                         .withClasses(Bootstrap.btn_close)
                         .withData("bs-dismiss","offcanvas")
                         .attr(
                            AriaStatesAndProperties.ariaLabel("Close")
                          )
                      ),
                    div()
                     .withClasses(Bootstrap.offcanvas_body)
                     .with(
                        text("Content for the offcanvas goes here. You can place just about any Bootstrap component or custom elements here.")
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <div class="offcanvas offcanvas-start show" tabindex="-1" id="offcanvas" aria-labelledby="offcanvasLabel">
              <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasLabel">
                  Offcanvas
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
                </button>
              </div>
              <div class="offcanvas-body">
                Content for the offcanvas goes here. You can place just about any Bootstrap component or custom elements here.
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("offcanvas-components", renderedHtml);

        uiDocumentation.documentSource("offcanvas-components");

    }

    @Test
    void liveDemo() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        a()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withData("bs-toggle","offcanvas")
                                .withHref("#offcanvasExample")
                                .attr(AriaRoles.roleButton)
                                .attr(
                                        AriaStatesAndProperties.ariaControls("offcanvasExample")
                                )
                                .with(
                                        text("Link with href")
                                ),
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withData("bs-toggle","offcanvas")
                                .withData("bs-target","#offcanvasExample")
                                .attr(
                                        AriaStatesAndProperties.ariaControls("offcanvasExample")
                                )
                                .with(
                                        text("Button with data-bs-target")
                                ),
                        div()
                                .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_start)
                                .withTabindex(-1)
                                .withId("offcanvasExample")
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("offcanvasExampleLabel")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.offcanvas_header)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.offcanvas_title)
                                                                .withId("offcanvasExampleLabel")
                                                                .with(
                                                                        text("Offcanvas")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn_close)
                                                                .withData("bs-dismiss","offcanvas")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.offcanvas_body)
                                                .with(
                                                        div()
                                                                .with(
                                                                        text("Some text as placeholder. In real life you can have the elements you have chosen. Like, text, images, lists, etc.")
                                                                ),
                                                        div()
                                                                .withClasses(Bootstrap.dropdown, Bootstrap.mt_3)
                                                                .with(
                                                                        button()
                                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                                                .withType("button")
                                                                                .withData("bs-toggle","dropdown")
                                                                                .with(
                                                                                        text("Dropdown button")
                                                                                ),
                                                                        ul()
                                                                                .withClasses(Bootstrap.dropdown_menu)
                                                                                .with(
                                                                                        li()
                                                                                                .with(
                                                                                                        a()
                                                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                                                .withHref("#")
                                                                                                                .with(
                                                                                                                        text("Action")
                                                                                                                )
                                                                                                ),
                                                                                        li()
                                                                                                .with(
                                                                                                        a()
                                                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                                                .withHref("#")
                                                                                                                .with(
                                                                                                                        text("Another action")
                                                                                                                )
                                                                                                ),
                                                                                        li()
                                                                                                .with(
                                                                                                        a()
                                                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                                                .withHref("#")
                                                                                                                .with(
                                                                                                                        text("Something else here")
                                                                                                                )
                                                                                                )
                                                                                )
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <a class="btn btn-primary" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample">
          Link with href
        </a>
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
          Button with data-bs-target
        </button>
        <div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasExampleLabel">
              Offcanvas
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body">
            <div>
              Some text as placeholder. In real life you can have the elements you have chosen. Like, text, images, lists, etc.
            </div>
            <div class="dropdown mt-3">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown">
                Dropdown button
              </button>
              <ul class="dropdown-menu">
                <li>
                  <a class="dropdown-item" href="#">
                    Action
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Another action
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Something else here
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("live-demo", renderedHtml);

        uiDocumentation.documentSource("live-demo");

    }

    @Test
    void bodyScrolling() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withData("bs-toggle","offcanvas")
                                .withData("bs-target","#offcanvasScrolling")
                                .attr(
                                        AriaStatesAndProperties.ariaControls("offcanvasScrolling")
                                )
                                .with(
                                        text("Enable body scrolling")
                                ),
                        div()
                                .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_start)
                                .withData("bs-scroll","true")
                                .withData("bs-backdrop","false")
                                .withTabindex(-1)
                                .withId("offcanvasScrolling")
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("offcanvasScrollingLabel")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.offcanvas_header)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.offcanvas_title)
                                                                .withId("offcanvasScrollingLabel")
                                                                .with(
                                                                        text("Offcanvas with body scrolling")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn_close)
                                                                .withData("bs-dismiss","offcanvas")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.offcanvas_body)
                                                .with(
                                                        p()
                                                                .with(
                                                                        text("Try scrolling the rest of the page to see this option in action.")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling" aria-controls="offcanvasScrolling">
          Enable body scrolling
        </button>
        <div class="offcanvas offcanvas-start" data-bs-scroll="true" data-bs-backdrop="false" tabindex="-1" id="offcanvasScrolling" aria-labelledby="offcanvasScrollingLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasScrollingLabel">
              Offcanvas with body scrolling
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body">
            <p>
              Try scrolling the rest of the page to see this option in action.
            </p>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("body-scrolling", renderedHtml);

        uiDocumentation.documentSource("body-scrolling");

    }

    @Test
    void bodyScrollingAndBackdrop() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withData("bs-toggle","offcanvas")
                                .withData("bs-target","#offcanvasWithBothOptions")
                                .attr(
                                        AriaStatesAndProperties.ariaControls("offcanvasWithBothOptions")
                                )
                                .with(
                                        text("Enable both scrolling & backdrop")
                                ),
                        div()
                                .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_start)
                                .withData("bs-scroll","true")
                                .withTabindex(-1)
                                .withId("offcanvasWithBothOptions")
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("offcanvasWithBothOptionsLabel")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.offcanvas_header)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.offcanvas_title)
                                                                .withId("offcanvasWithBothOptionsLabel")
                                                                .with(
                                                                        text("Backdrop with scrolling")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn_close)
                                                                .withData("bs-dismiss","offcanvas")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.offcanvas_body)
                                                .with(
                                                        p()
                                                                .with(
                                                                        text("Try scrolling the rest of the page to see this option in action.")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBothOptions" aria-controls="offcanvasWithBothOptions">
          Enable both scrolling &amp; backdrop
        </button>
        <div class="offcanvas offcanvas-start" data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasWithBothOptionsLabel">
              Backdrop with scrolling
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body">
            <p>
              Try scrolling the rest of the page to see this option in action.
            </p>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("body-scrolling-and-backdrop", renderedHtml);

        uiDocumentation.documentSource("body-scrolling-and-backdrop");

    }

    @Test
    void staticBackdrop() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withData("bs-toggle","offcanvas")
                                .withData("bs-target","#staticBackdrop")
                                .attr(
                                        AriaStatesAndProperties.ariaControls("staticBackdrop")
                                )
                                .with(
                                        text("Toggle static offcanvas")
                                ),
                        div()
                                .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_start)
                                .withData("bs-backdrop","static")
                                .withTabindex(-1)
                                .withId("staticBackdrop")
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("staticBackdropLabel")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.offcanvas_header)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.offcanvas_title)
                                                                .withId("staticBackdropLabel")
                                                                .with(
                                                                        text("Offcanvas")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn_close)
                                                                .withData("bs-dismiss","offcanvas")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.offcanvas_body)
                                                .with(
                                                        div()
                                                                .with(
                                                                        text("I will not close if you click outside of me.")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#staticBackdrop" aria-controls="staticBackdrop">
          Toggle static offcanvas
        </button>
        <div class="offcanvas offcanvas-start" data-bs-backdrop="static" tabindex="-1" id="staticBackdrop" aria-labelledby="staticBackdropLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="staticBackdropLabel">
              Offcanvas
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body">
            <div>
              I will not close if you click outside of me.
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("static-backdrop", renderedHtml);

        uiDocumentation.documentSource("static-backdrop");

    }

    @Test
    void darkOffcanvas() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_start, Bootstrap.show, Bootstrap.text_bg_dark)
                        .withTabindex(-1)
                        .withId("offcanvasDark")
                        .attr(
                                AriaStatesAndProperties.ariaLabelledby("offcanvasDarkLabel")
                        )
                        .with(
                                div()
                                        .withClasses(Bootstrap.offcanvas_header)
                                        .with(
                                                h5()
                                                        .withClasses(Bootstrap.offcanvas_title)
                                                        .withId("offcanvasDarkLabel")
                                                        .with(
                                                                text("Offcanvas")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn_close, Bootstrap.btn_close_white)
                                                        .withData("bs-dismiss","offcanvasDark")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.offcanvas_body)
                                        .with(
                                                p()
                                                        .with(
                                                                text("Place offcanvas content here.")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="offcanvas offcanvas-start show text-bg-dark" tabindex="-1" id="offcanvasDark" aria-labelledby="offcanvasDarkLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasDarkLabel">
              Offcanvas
            </h5>
            <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvasDark" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body">
            <p>
              Place offcanvas content here.
            </p>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("dark-offcanvas", renderedHtml);

        uiDocumentation.documentSource("dark-offcanvas");

    }


    @Test
    void responsive() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.d_lg_none)
                                .withType("button")
                                .withData("bs-toggle","offcanvas")
                                .withData("bs-target","#offcanvasResponsive")
                                .attr(
                                        AriaStatesAndProperties.ariaControls("offcanvasResponsive")
                                )
                                .with(
                                        text("Toggle offcanvas")
                                ),
                        div()
                                .withClasses(Bootstrap.alert, Bootstrap.alert_info, Bootstrap.d_none, Bootstrap.d_lg_block)
                                .with(
                                        text("Resize your browser to show the responsive offcanvas toggle.")
                                ),
                        div()
                                .withClasses(Bootstrap.offcanvas_lg, Bootstrap.offcanvas_end)
                                .withTabindex(-1)
                                .withId("offcanvasResponsive")
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("offcanvasResponsiveLabel")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.offcanvas_header)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.offcanvas_title)
                                                                .withId("offcanvasResponsiveLabel")
                                                                .with(
                                                                        text("Responsive offcanvas")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn_close)
                                                                .withData("bs-dismiss","offcanvas")
                                                                .withData("bs-target","#offcanvasResponsive")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.offcanvas_body)
                                                .with(
                                                        p()
                                                                .withClasses(Bootstrap.mb_0)
                                                                .with(
                                                                        text("This is content within an"),
                                                                        code()
                                                                                .with(
                                                                                        text(".offcanvas-lg")
                                                                                ),
                                                                        text(".")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button class="btn btn-primary d-lg-none" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasResponsive" aria-controls="offcanvasResponsive">
          Toggle offcanvas
        </button>
        <div class="alert alert-info d-none d-lg-block">
          Resize your browser to show the responsive offcanvas toggle.
        </div>
        <div class="offcanvas-lg offcanvas-end" tabindex="-1" id="offcanvasResponsive" aria-labelledby="offcanvasResponsiveLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasResponsiveLabel">
              Responsive offcanvas
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" data-bs-target="#offcanvasResponsive" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body">
            <p class="mb-0">
              This is content within an
              <code>
                .offcanvas-lg
              </code>
              .
            </p>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("responsive", renderedHtml);

        uiDocumentation.documentSource("responsive");

    }

    @Test
    void placement() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withData("bs-toggle","offcanvas")
                                .withData("bs-target","#offcanvasTop")
                                .attr(
                                        AriaStatesAndProperties.ariaControls("offcanvasTop")
                                )
                                .with(
                                        text("Toggle top offcanvas")
                                ),
                        div()
                                .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_top)
                                .withTabindex(-1)
                                .withId("offcanvasTop")
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("offcanvasTopLabel")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.offcanvas_header)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.offcanvas_title)
                                                                .withId("offcanvasTopLabel")
                                                                .with(
                                                                        text("Offcanvas top")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn_close)
                                                                .withData("bs-dismiss","offcanvas")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.offcanvas_body)
                                                .with(
                                                        text("...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTop" aria-controls="offcanvasTop">
          Toggle top offcanvas
        </button>
        <div class="offcanvas offcanvas-top" tabindex="-1" id="offcanvasTop" aria-labelledby="offcanvasTopLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasTopLabel">
              Offcanvas top
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body">
            ...
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement", renderedHtml);

        uiDocumentation.documentSource("placement");

    }

    @Test
    void placement2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withData("bs-toggle","offcanvas")
                                .withData("bs-target","#offcanvasRight")
                                .attr(
                                        AriaStatesAndProperties.ariaControls("offcanvasRight")
                                )
                                .with(
                                        text("Toggle right offcanvas")
                                ),
                        div()
                                .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_end)
                                .withTabindex(-1)
                                .withId("offcanvasRight")
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("offcanvasRightLabel")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.offcanvas_header)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.offcanvas_title)
                                                                .withId("offcanvasRightLabel")
                                                                .with(
                                                                        text("Offcanvas right")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn_close)
                                                                .withData("bs-dismiss","offcanvas")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.offcanvas_body)
                                                .with(
                                                        text("...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
          Toggle right offcanvas
        </button>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasRightLabel">
              Offcanvas right
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body">
            ...
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement2", renderedHtml);

        uiDocumentation.documentSource("placement2");

    }

    @Test
    void placement3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withData("bs-toggle","offcanvas")
                                .withData("bs-target","#offcanvasBottom")
                                .attr(
                                        AriaStatesAndProperties.ariaControls("offcanvasBottom")
                                )
                                .with(
                                        text("Toggle bottom offcanvas")
                                ),
                        div()
                                .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_bottom)
                                .withTabindex(-1)
                                .withId("offcanvasBottom")
                                .attr(
                                        AriaStatesAndProperties.ariaLabelledby("offcanvasBottomLabel")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.offcanvas_header)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.offcanvas_title)
                                                                .withId("offcanvasBottomLabel")
                                                                .with(
                                                                        text("Offcanvas bottom")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn_close)
                                                                .withData("bs-dismiss","offcanvas")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.offcanvas_body,"small")
                                                .with(
                                                        text("...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">
          Toggle bottom offcanvas
        </button>
        <div class="offcanvas offcanvas-bottom" tabindex="-1" id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasBottomLabel">
              Offcanvas bottom
            </h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
            </button>
          </div>
          <div class="offcanvas-body small">
            ...
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement3", renderedHtml);

        uiDocumentation.documentSource("placement3");

    }


}
