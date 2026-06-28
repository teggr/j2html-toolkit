package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.comment;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NavbarTest {

    public static final String border_body = "border-body";
    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void supportedContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                 .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                 .with(
                    div()
                     .withClasses(Bootstrap.container_fluid)
                     .with(
                        a()
                         .withClasses(Bootstrap.navbar_brand)
                         .withHref("#")
                         .with(
                            text("Navbar")
                          ),
                        button()
                         .withClasses(Bootstrap.navbar_toggler)
                         .withType("button")
                         .withData("bs-toggle","collapse")
                         .withData("bs-target","#navbarSupportedContent")
                         .attr(
                            AriaStatesAndProperties.ariaControls("navbarSupportedContent")
                          )
                         .attr(
                            AriaStatesAndProperties.ariaExpanded("false")
                          )
                         .attr(
                            AriaStatesAndProperties.ariaLabel("Toggle navigation")
                          )
                         .with(
                            span()
                             .withClasses(Bootstrap.navbar_toggler_icon)
                          ),
                        div()
                         .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                         .withId("navbarSupportedContent")
                         .with(
                            ul()
                             .withClasses(Bootstrap.navbar_nav, Bootstrap.me_auto, Bootstrap.mb_2, Bootstrap.mb_lg_0)
                             .with(
                                li()
                                 .withClasses(Bootstrap.nav_item)
                                 .with(
                                    a()
                                     .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                     .attr(
                                        AriaStatesAndProperties.ariaCurrent("page")
                                      )
                                     .withHref("#")
                                     .with(
                                        text("Home")
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
                                 .withClasses(Bootstrap.nav_item, Bootstrap.dropdown)
                                 .with(
                                    a()
                                     .withClasses(Bootstrap.nav_link, Bootstrap.dropdown_toggle)
                                     .withHref("#")
                                     .attr(AriaRoles.roleButton)
                                     .withData("bs-toggle","dropdown")
                                     .attr(
                                        AriaStatesAndProperties.ariaExpanded("false")
                                      )
                                     .with(
                                        text("Dropdown")
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
                                            hr()
                                             .withClasses(Bootstrap.dropdown_divider)
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
                              ),
                            form()
                             .withClasses(Bootstrap.d_flex)
                             .attr(AriaRoles.roleSearch)
                             .with(
                                input()
                                 .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                 .withType("search")
                                 .withPlaceholder("Search")
                                 .attr(
                                    AriaStatesAndProperties.ariaLabel("Search")
                                  ),
                                button()
                                 .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                 .withType("submit")
                                 .with(
                                    text("Search")
                                  )
                              )
                          )
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
              <div class="container-fluid">
                <a class="navbar-brand" href="#">
                  Navbar
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon">
                  </span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                      <a class="nav-link active" aria-current="page" href="#">
                        Home
                      </a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">
                        Link
                      </a>
                    </li>
                    <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                      </a>
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
                          <hr class="dropdown-divider">
                        </li>
                        <li>
                          <a class="dropdown-item" href="#">
                            Something else here
                          </a>
                        </li>
                      </ul>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link disabled" aria-disabled="true">
                        Disabled
                      </a>
                    </li>
                  </ul>
                  <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">
                      Search
                    </button>
                  </form>
                </div>
              </div>
            </nav>
            """, renderedHtml);

        // document
        uiDocumentation.document("supported-content", renderedHtml);

        uiDocumentation.documentSource("supported-content");

    }

    @Test
    void textTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        nav()
                                .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.container_fluid)
                                                .with(
                                                        a()
                                                                .withClasses(Bootstrap.navbar_brand)
                                                                .withHref("#")
                                                                .with(
                                                                        text("Navbar")
                                                                )
                                                )
                                ),
                        comment("As a heading"),
                        nav()
                                .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.container_fluid)
                                                .with(
                                                        span()
                                                                .withClasses(Bootstrap.navbar_brand, Bootstrap.mb_0, Bootstrap.h1)
                                                                .with(
                                                                        text("Navbar")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <nav class="navbar bg-body-tertiary">
                  <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                      Navbar
                    </a>
                  </div>
                </nav>
                <!-- As a heading -->
                <nav class="navbar bg-body-tertiary">
                  <div class="container-fluid">
                    <span class="navbar-brand mb-0 h1">
                      Navbar
                    </span>
                  </div>
                </nav>
                """, renderedHtml);

        // document
        uiDocumentation.document("text", renderedHtml);

        uiDocumentation.documentSource("text");

    }

    @Test
    void imageTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                img()
                                                                        .withSrc("/docs/5.3/assets/brand/bootstrap-logo.svg")
                                                                        .withAlt("Bootstrap")
                                                                        .attr("width","30")
                                                                        .attr("height","24")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container">
            <a class="navbar-brand" href="#">
              <img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Bootstrap" width="30" height="24">
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("image-test", renderedHtml);

        uiDocumentation.documentSource("image-test");

    }

    @Test
    void imageAndText() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                img()
                                                                        .withSrc("/docs/5.3/assets/brand/bootstrap-logo.svg")
                                                                        .withAlt("Logo")
                                                                        .attr("width","30")
                                                                        .attr("height","24")
                                                                        .withClasses(Bootstrap.d_inline_block, Bootstrap.align_text_top),
                                                                text("Bootstrap")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              <img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
              Bootstrap
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("image-and-text", renderedHtml);

        uiDocumentation.documentSource("image-and-text");

    }

    @Test
    void navTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarNav")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarNav")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                                                        .withId("navbarNav")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Bootstrap.navbar_nav)
                                                                        .with(
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                        )
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Home")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Features")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Pricing")
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
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Features
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Pricing
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link disabled" aria-disabled="true">
                    Disabled
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("nav-test", renderedHtml);

        uiDocumentation.documentSource("nav-test");

    }

    @Test
    void navTest2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarNavAltMarkup")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarNavAltMarkup")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                                                        .withId("navbarNavAltMarkup")
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.navbar_nav)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                        )
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Home")
                                                                                        ),
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Features")
                                                                                        ),
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Pricing")
                                                                                        ),
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
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="#">
                  Home
                </a>
                <a class="nav-link" href="#">
                  Features
                </a>
                <a class="nav-link" href="#">
                  Pricing
                </a>
                <a class="nav-link disabled" aria-disabled="true">
                  Disabled
                </a>
              </div>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("nav-test2", renderedHtml);

        uiDocumentation.documentSource("nav-test2");

    }

    @Test
    void navTest3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarNavDropdown")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarNavDropdown")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                                                        .withId("navbarNavDropdown")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Bootstrap.navbar_nav)
                                                                        .with(
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                        )
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Home")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Features")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Pricing")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item, Bootstrap.dropdown)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.dropdown_toggle)
                                                                                                        .withHref("#")
                                                                                                        .attr(AriaRoles.roleButton)
                                                                                                        .withData("bs-toggle","dropdown")
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                                                        )
                                                                                                        .with(
                                                                                                                text("Dropdown link")
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
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Features
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Pricing
                  </a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown link
                  </a>
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
                </li>
              </ul>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("nav-test2", renderedHtml);

        uiDocumentation.documentSource("nav-test2");

    }

    @Test
    void forms() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                form()
                                                        .withClasses(Bootstrap.d_flex)
                                                        .attr(AriaRoles.roleSearch)
                                                        .with(
                                                                input()
                                                                        .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                                                        .withType("search")
                                                                        .withPlaceholder("Search")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                        ),
                                                                button()
                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                                                        .withType("submit")
                                                                        .with(
                                                                                text("Search")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("forms", renderedHtml);

        uiDocumentation.documentSource("forms");

    }

    @Test
    void forms2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                form()
                                                        .withClasses(Bootstrap.d_flex)
                                                        .attr(AriaRoles.roleSearch)
                                                        .with(
                                                                input()
                                                                        .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                                                        .withType("search")
                                                                        .withPlaceholder("Search")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                        ),
                                                                button()
                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                                                        .withType("submit")
                                                                        .with(
                                                                                text("Search")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand">
              Navbar
            </a>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("forms2", renderedHtml);

        uiDocumentation.documentSource("forms2");

    }

    @Test
    void forms3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                        .with(
                                form()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.input_group)
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.input_group_text)
                                                                        .withId("basic-addon1")
                                                                        .with(
                                                                                text("@")
                                                                        ),
                                                                input()
                                                                        .withType("text")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withPlaceholder("Username")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Username")
                                                                        )
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaDescribedby("basic-addon1")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <nav class="navbar bg-body-tertiary">
              <form class="container-fluid">
                <div class="input-group">
                  <span class="input-group-text" id="basic-addon1">
                    @
                  </span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
              </form>
            </nav>
            """, renderedHtml);

        // document
        uiDocumentation.document("forms3", renderedHtml);

        uiDocumentation.documentSource("forms3");

    }

    @Test
    void forms4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                        .with(
                                form()
                                        .withClasses(Bootstrap.container_fluid, Bootstrap.justify_content_start)
                                        .with(
                                                button()
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success, Bootstrap.me_2)
                                                        .withType("button")
                                                        .with(
                                                                text("Main button")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_sm, Bootstrap.btn_outline_secondary)
                                                        .withType("button")
                                                        .with(
                                                                text("Smaller button")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <form class="container-fluid justify-content-start">
            <button class="btn btn-outline-success me-2" type="button">
              Main button
            </button>
            <button class="btn btn-sm btn-outline-secondary" type="button">
              Smaller button
            </button>
          </form>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("forms4", renderedHtml);

        uiDocumentation.documentSource("forms4");

    }

    @Test
    void text2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.navbar_text)
                                                        .with(
                                                                text("Navbar text with an inline element")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <span class="navbar-text">
              Navbar text with an inline element
            </span>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("text2", renderedHtml);

        uiDocumentation.documentSource("text2");

    }

    @Test
    void text3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar w/ text")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarText")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarText")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                                                        .withId("navbarText")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Bootstrap.navbar_nav, Bootstrap.me_auto, Bootstrap.mb_2, Bootstrap.mb_lg_0)
                                                                        .with(
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                        )
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Home")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Features")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Pricing")
                                                                                                        )
                                                                                        )
                                                                        ),
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_text)
                                                                        .with(
                                                                                text("Navbar text with an inline element")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar w/ text
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Features
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Pricing
                  </a>
                </li>
              </ul>
              <span class="navbar-text">
                Navbar text with an inline element
              </span>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("text3", renderedHtml);

        uiDocumentation.documentSource("text3");

    }

    @Test
    void colorSchemes() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        nav()
                                .withClasses(Bootstrap.navbar, Bootstrap.bg_dark, Bootstrap.border_bottom, border_body)
                                .withData("bs-theme","dark")
                                .with(
                                        comment("Navbar content")
                                ),
                        nav()
                                .withClasses(Bootstrap.navbar, Bootstrap.bg_primary)
                                .withData("bs-theme","dark")
                                .with(
                                        comment("Navbar content")
                                ),
                        nav()
                                .withClasses(Bootstrap.navbar)
                                .withStyle("background-color: #e3f2fd;")
                                .with(
                                        comment("Navbar content")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
              <!-- Navbar content -->
            </nav>
            <nav class="navbar bg-primary" data-bs-theme="dark">
              <!-- Navbar content -->
            </nav>
            <nav class="navbar" style="background-color: #e3f2fd;">
              <!-- Navbar content -->
            </nav>
            """, renderedHtml);

        // document
        uiDocumentation.document("color-schemes", renderedHtml);

        uiDocumentation.documentSource("color-schemes");

    }

    @Test
    void containersTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        nav()
                                .withClasses(Bootstrap.navbar, Bootstrap.bg_dark, Bootstrap.border_bottom,"border-body")
                                .withData("bs-theme","dark")
                                .with(
                                        comment("Navbar content")
                                ),
                        nav()
                                .withClasses(Bootstrap.navbar, Bootstrap.bg_primary)
                                .withData("bs-theme","dark")
                                .with(
                                        comment("Navbar content")
                                ),
                        nav()
                                .withClasses(Bootstrap.navbar)
                                .withStyle("background-color: #e3f2fd;")
                                .with(
                                        comment("Navbar content")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
          <!-- Navbar content -->
        </nav>
        <nav class="navbar bg-primary" data-bs-theme="dark">
          <!-- Navbar content -->
        </nav>
        <nav class="navbar" style="background-color: #e3f2fd;">
          <!-- Navbar content -->
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("containers-test", renderedHtml);

        uiDocumentation.documentSource("containers-test");

    }

    @Test
    void containersTest2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_md)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-md">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("containers-test2", renderedHtml);

        uiDocumentation.documentSource("containers-test2");

    }

    @Test
    void placement1() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Default")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Default
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement1", renderedHtml);

        uiDocumentation.documentSource("placement1");

    }

    @Test
    void placement2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.fixed_top, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Fixed top")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar fixed-top bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Fixed top
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement2", renderedHtml);

        uiDocumentation.documentSource("placement2");

    }

    @Test
    void placement3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.fixed_bottom, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Fixed bottom")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar fixed-bottom bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Fixed bottom
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement3", renderedHtml);

        uiDocumentation.documentSource("placement3");

    }

    @Test
    void placement4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.sticky_top, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Sticky top")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar sticky-top bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Sticky top
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement4", renderedHtml);

        uiDocumentation.documentSource("placement4");

    }

    @Test
    void placement5() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.sticky_bottom, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Sticky bottom")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar sticky-bottom bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Sticky bottom
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement5", renderedHtml);

        uiDocumentation.documentSource("placement5");

    }

    @Test
    void scrolling() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar scroll")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarScroll")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarScroll")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                                                        .withId("navbarScroll")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Bootstrap.navbar_nav, Bootstrap.me_auto, Bootstrap.my_2, Bootstrap.my_lg_0, Bootstrap.navbar_nav_scroll)
                                                                        .withStyle("--bs-scroll-height: 100px;")
                                                                        .with(
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                        )
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Home")
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
                                                                                        .withClasses(Bootstrap.nav_item, Bootstrap.dropdown)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.dropdown_toggle)
                                                                                                        .withHref("#")
                                                                                                        .attr(AriaRoles.roleButton)
                                                                                                        .withData("bs-toggle","dropdown")
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                                                        )
                                                                                                        .with(
                                                                                                                text("Link")
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
                                                                                                                                hr()
                                                                                                                                        .withClasses(Bootstrap.dropdown_divider)
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
                                                                                                                text("Link")
                                                                                                        )
                                                                                        )
                                                                        ),
                                                                form()
                                                                        .withClasses(Bootstrap.d_flex)
                                                                        .attr(AriaRoles.roleSearch)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                                                                        .withType("search")
                                                                                        .withPlaceholder("Search")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                        ),
                                                                                button()
                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                                                                        .withType("submit")
                                                                                        .with(
                                                                                                text("Search")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar scroll
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
              <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Link
                  </a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Link
                  </a>
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
                      <hr class="dropdown-divider">
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        Something else here
                      </a>
                    </li>
                  </ul>
                </li>
                <li class="nav-item">
                  <a class="nav-link disabled" aria-disabled="true">
                    Link
                  </a>
                </li>
              </ul>
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("scrolling", renderedHtml);

        uiDocumentation.documentSource("scrolling");

    }

    @Test
    void toggler() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarTogglerDemo01")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarTogglerDemo01")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                                                        .withId("navbarTogglerDemo01")
                                                        .with(
                                                                a()
                                                                        .withClasses(Bootstrap.navbar_brand)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Hidden brand")
                                                                        ),
                                                                ul()
                                                                        .withClasses(Bootstrap.navbar_nav, Bootstrap.me_auto, Bootstrap.mb_2,"mb-lg-0")
                                                                        .with(
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                        )
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Home")
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
                                                                        ),
                                                                form()
                                                                        .withClasses(Bootstrap.d_flex)
                                                                        .attr(AriaRoles.roleSearch)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                                                                        .withType("search")
                                                                                        .withPlaceholder("Search")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                        ),
                                                                                button()
                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                                                                        .withType("submit")
                                                                                        .with(
                                                                                                text("Search")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
              <a class="navbar-brand" href="#">
                Hidden brand
              </a>
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
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
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("toggler", renderedHtml);

        uiDocumentation.documentSource("toggler");

    }


    @Test
    void toggler2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarTogglerDemo02")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarTogglerDemo02")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                                                        .withId("navbarTogglerDemo02")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Bootstrap.navbar_nav, Bootstrap.me_auto, Bootstrap.mb_2, Bootstrap.mb_lg_0)
                                                                        .with(
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                        )
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Home")
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
                                                                        ),
                                                                form()
                                                                        .withClasses(Bootstrap.d_flex)
                                                                        .attr(AriaRoles.roleSearch)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                                                                        .withType("search")
                                                                                        .withPlaceholder("Search")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                        ),
                                                                                button()
                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                                                                        .withType("submit")
                                                                                        .with(
                                                                                                text("Search")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
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
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("toggler2", renderedHtml);

        uiDocumentation.documentSource("toggler2");

    }

    @Test
    void toggler3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarTogglerDemo03")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarTogglerDemo03")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.collapse, Bootstrap.navbar_collapse)
                                                        .withId("navbarTogglerDemo03")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Bootstrap.navbar_nav, Bootstrap.me_auto, Bootstrap.mb_2,"mb-lg-0")
                                                                        .with(
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                        )
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Home")
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
                                                                        ),
                                                                form()
                                                                        .withClasses(Bootstrap.d_flex)
                                                                        .attr(AriaRoles.roleSearch)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                                                                        .withType("search")
                                                                                        .withPlaceholder("Search")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                        ),
                                                                                button()
                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                                                                        .withType("submit")
                                                                                        .with(
                                                                                                text("Search")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
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
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("toggler3", renderedHtml);

        uiDocumentation.documentSource("toggler3");

    }

    @Test
    void externalContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.collapse)
                                .withId("navbarToggleExternalContent")
                                .withData("bs-theme","dark")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.bg_dark, Bootstrap.p_4)
                                                .with(
                                                        h5()
                                                                .withClasses(Bootstrap.text_body_emphasis, Bootstrap.h4)
                                                                .with(
                                                                        text("Collapsed content")
                                                                ),
                                                        span()
                                                                .withClasses(Bootstrap.text_body_secondary)
                                                                .with(
                                                                        text("Toggleable via the navbar brand.")
                                                                )
                                                )
                                ),
                        nav()
                                .withClasses(Bootstrap.navbar, Bootstrap.navbar_dark, Bootstrap.bg_dark)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.container_fluid)
                                                .with(
                                                        button()
                                                                .withClasses(Bootstrap.navbar_toggler)
                                                                .withType("button")
                                                                .withData("bs-toggle","collapse")
                                                                .withData("bs-target","#navbarToggleExternalContent")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaControls("navbarToggleExternalContent")
                                                                )
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                                )
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                                )
                                                                .with(
                                                                        span()
                                                                                .withClasses(Bootstrap.navbar_toggler_icon)
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="collapse" id="navbarToggleExternalContent" data-bs-theme="dark">
          <div class="bg-dark p-4">
            <h5 class="text-body-emphasis h4">
              Collapsed content
            </h5>
            <span class="text-body-secondary">
              Toggleable via the navbar brand.
            </span>
          </div>
        </div>
        <nav class="navbar navbar-dark bg-dark">
          <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("external-content", renderedHtml);

        uiDocumentation.documentSource("external-content");

    }

    @Test
    void offcanvasNavbar() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary, Bootstrap.fixed_top)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Offcanvas navbar")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","offcanvas")
                                                        .withData("bs-target","#offcanvasNavbar")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("offcanvasNavbar")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_end)
                                                        .withTabindex(-1)
                                                        .withId("offcanvasNavbar")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabelledby("offcanvasNavbarLabel")
                                                        )
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.offcanvas_header)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.offcanvas_title)
                                                                                        .withId("offcanvasNavbarLabel")
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
                                                                                ul()
                                                                                        .withClasses(Bootstrap.navbar_nav, Bootstrap.justify_content_end, Bootstrap.flex_grow_1, Bootstrap.pe_3)
                                                                                        .with(
                                                                                                li()
                                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                                        .with(
                                                                                                                a()
                                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                                        .attr(
                                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                                        )
                                                                                                                        .withHref("#")
                                                                                                                        .with(
                                                                                                                                text("Home")
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
                                                                                                        .withClasses(Bootstrap.nav_item, Bootstrap.dropdown)
                                                                                                        .with(
                                                                                                                a()
                                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.dropdown_toggle)
                                                                                                                        .withHref("#")
                                                                                                                        .attr(AriaRoles.roleButton)
                                                                                                                        .withData("bs-toggle","dropdown")
                                                                                                                        .attr(
                                                                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                                                                        )
                                                                                                                        .with(
                                                                                                                                text("Dropdown")
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
                                                                                                                                                hr()
                                                                                                                                                        .withClasses(Bootstrap.dropdown_divider)
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
                                                                                        ),
                                                                                form()
                                                                                        .withClasses(Bootstrap.d_flex, Bootstrap.mt_3)
                                                                                        .attr(AriaRoles.roleSearch)
                                                                                        .with(
                                                                                                input()
                                                                                                        .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                                                                                        .withType("search")
                                                                                                        .withPlaceholder("Search")
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                                        ),
                                                                                                button()
                                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                                                                                        .withType("submit")
                                                                                                        .with(
                                                                                                                text("Search")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary fixed-top">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Offcanvas navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
              <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">
                  Offcanvas
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
                </button>
              </div>
              <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">
                      Home
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">
                      Link
                    </a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Dropdown
                    </a>
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
                        <hr class="dropdown-divider">
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Something else here
                        </a>
                      </li>
                    </ul>
                  </li>
                </ul>
                <form class="d-flex mt-3" role="search">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">
                    Search
                  </button>
                </form>
              </div>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("offcanvas-navbar", renderedHtml);

        uiDocumentation.documentSource("offcanvas-navbar");

    }

    @Test
    void offcanvasNavbar2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.bg_body_tertiary, Bootstrap.fixed_top)
                        .with(
                                a()
                                        .withClasses(Bootstrap.navbar_brand)
                                        .withHref("#")
                                        .with(
                                                text("Offcanvas navbar")
                                        ),
                                button()
                                        .withClasses(Bootstrap.navbar_toggler)
                                        .withType("button")
                                        .withData("bs-toggle","offcanvas")
                                        .withData("bs-target","#navbarOffcanvasLg")
                                        .attr(
                                                AriaStatesAndProperties.ariaControls("navbarOffcanvasLg")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                        )
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                        ),
                                div()
                                        .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_end)
                                        .withTabindex(-1)
                                        .withId("navbarOffcanvasLg")
                                        .attr(
                                                AriaStatesAndProperties.ariaLabelledby("navbarOffcanvasLgLabel")
                                        )
                                        .with(
                                                text("...")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary fixed-top">
          <a class="navbar-brand" href="#">
            Offcanvas navbar
          </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#navbarOffcanvasLg" aria-controls="navbarOffcanvasLg" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon">
            </span>
          </button>
          <div class="offcanvas offcanvas-end" tabindex="-1" id="navbarOffcanvasLg" aria-labelledby="navbarOffcanvasLgLabel">
            ...
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("offcanvas-navbar2", renderedHtml);

        uiDocumentation.documentSource("offcanvas-navbar2");

    }

    @Test
    void offcanvasNavbar3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar,"navbar-dark", Bootstrap.bg_dark, Bootstrap.fixed_top)
                        .with(
                                div()
                                        .withClasses(Bootstrap.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Offcanvas dark navbar")
                                                        ),
                                                button()
                                                        .withClasses(Bootstrap.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","offcanvas")
                                                        .withData("bs-target","#offcanvasDarkNavbar")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("offcanvasDarkNavbar")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.offcanvas, Bootstrap.offcanvas_end, Bootstrap.text_bg_dark)
                                                        .withTabindex(-1)
                                                        .withId("offcanvasDarkNavbar")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabelledby("offcanvasDarkNavbarLabel")
                                                        )
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.offcanvas_header)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Bootstrap.offcanvas_title)
                                                                                        .withId("offcanvasDarkNavbarLabel")
                                                                                        .with(
                                                                                                text("Dark offcanvas")
                                                                                        ),
                                                                                button()
                                                                                        .withType("button")
                                                                                        .withClasses(Bootstrap.btn_close, Bootstrap.btn_close_white)
                                                                                        .withData("bs-dismiss","offcanvas")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Bootstrap.offcanvas_body)
                                                                        .with(
                                                                                ul()
                                                                                        .withClasses(Bootstrap.navbar_nav, Bootstrap.justify_content_end, Bootstrap.flex_grow_1, Bootstrap.pe_3)
                                                                                        .with(
                                                                                                li()
                                                                                                        .withClasses(Bootstrap.nav_item)
                                                                                                        .with(
                                                                                                                a()
                                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.active)
                                                                                                                        .attr(
                                                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                                                        )
                                                                                                                        .withHref("#")
                                                                                                                        .with(
                                                                                                                                text("Home")
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
                                                                                                        .withClasses(Bootstrap.nav_item, Bootstrap.dropdown)
                                                                                                        .with(
                                                                                                                a()
                                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.dropdown_toggle)
                                                                                                                        .withHref("#")
                                                                                                                        .attr(AriaRoles.roleButton)
                                                                                                                        .withData("bs-toggle","dropdown")
                                                                                                                        .attr(
                                                                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                                                                        )
                                                                                                                        .with(
                                                                                                                                text("Dropdown")
                                                                                                                        ),
                                                                                                                ul()
                                                                                                                        .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_dark)
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
                                                                                                                                                hr()
                                                                                                                                                        .withClasses(Bootstrap.dropdown_divider)
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
                                                                                        ),
                                                                                form()
                                                                                        .withClasses(Bootstrap.d_flex, Bootstrap.mt_3)
                                                                                        .attr(AriaRoles.roleSearch)
                                                                                        .with(
                                                                                                input()
                                                                                                        .withClasses(Bootstrap.form_control, Bootstrap.me_2)
                                                                                                        .withType("search")
                                                                                                        .withPlaceholder("Search")
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                                        ),
                                                                                                button()
                                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_success)
                                                                                                        .withType("submit")
                                                                                                        .with(
                                                                                                                text("Search")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-dark bg-dark fixed-top">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Offcanvas dark navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
              <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">
                  Dark offcanvas
                </h5>
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close">
                </button>
              </div>
              <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">
                      Home
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">
                      Link
                    </a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Dropdown
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark">
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
                        <hr class="dropdown-divider">
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Something else here
                        </a>
                      </li>
                    </ul>
                  </li>
                </ul>
                <form class="d-flex mt-3" role="search">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-success" type="submit">
                    Search
                  </button>
                </form>
              </div>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("offcanvas-navbar2", renderedHtml);

        uiDocumentation.documentSource("offcanvas-navbar2");

    }


}
