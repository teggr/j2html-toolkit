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

class DropdownsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void singleButton() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                 .withClasses(Bootstrap.dropdown)
                 .with(
                    button()
                     .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                     .withType("button")
                     .withData("bs-toggle","dropdown")
                     .attr(
                        AriaStatesAndProperties.ariaExpanded("false")
                      )
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
        );

        //language=HTML
        assertEquals("""
            <div class="dropdown">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
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
            """, renderedHtml);

        // document
        uiDocumentation.document("single-button", renderedHtml);

        uiDocumentation.documentSource("single-button");

    }


    @Test
    void singleButton2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropdown)
                        .with(
                                a()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
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
        );

        //language=HTML
        assertEquals("""
            <div class="dropdown">
              <a class="btn btn-secondary dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("single-button2", renderedHtml);

        uiDocumentation.documentSource("single-button2");

    }

    @Test
    void singleButton3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_danger, Bootstrap.dropdown_toggle)
                                        .withData("bs-toggle","dropdown")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                text("Action")
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
                                                                                text("Separated link")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group">
                  <button type="button" class="btn btn-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    Action
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
                    <li>
                      <hr class="dropdown-divider">
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        Separated link
                      </a>
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("single-button3", renderedHtml);

        uiDocumentation.documentSource("single-button3");

    }


    @Test
    void splitButton() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_danger)
                                        .with(
                                                text("Action")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_danger, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
                                        .withData("bs-toggle","dropdown")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Toggle Dropdown")
                                                        )
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
                                                                                text("Separated link")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="btn-group">
              <button type="button" class="btn btn-danger">
                Action
              </button>
              <button type="button" class="btn btn-danger dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
                <span class="visually-hidden">
                  Toggle Dropdown
                </span>
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
                <li>
                  <hr class="dropdown-divider">
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Separated link
                  </a>
                </li>
              </ul>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("split-button", renderedHtml);

        uiDocumentation.documentSource("split-button");

    }

    @Test
    void sizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.btn_lg, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Large button")
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu)
                                                .with(
                                                        text("...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.btn_lg)
                                                .withType("button")
                                                .with(
                                                        text("Large split button")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_lg, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        span()
                                                                .withClasses(Bootstrap.visually_hidden)
                                                                .with(
                                                                        text("Toggle Dropdown")
                                                                )
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu)
                                                .with(
                                                        text("...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="btn-group">
          <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            Large button
          </button>
          <ul class="dropdown-menu">
            ...
          </ul>
        </div>
        <div class="btn-group">
          <button class="btn btn-secondary btn-lg" type="button">
            Large split button
          </button>
          <button type="button" class="btn btn-lg btn-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
            <span class="visually-hidden">
              Toggle Dropdown
            </span>
          </button>
          <ul class="dropdown-menu">
            ...
          </ul>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("sizing", renderedHtml);

        uiDocumentation.documentSource("sizing");

    }

    @Test
    void sizing2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.btn_sm, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Small button")
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu)
                                                .with(
                                                        text("...")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.btn_sm)
                                                .withType("button")
                                                .with(
                                                        text("Small split button")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_sm, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        span()
                                                                .withClasses(Bootstrap.visually_hidden)
                                                                .with(
                                                                        text("Toggle Dropdown")
                                                                )
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu)
                                                .with(
                                                        text("...")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group">
                  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Small button
                  </button>
                  <ul class="dropdown-menu">
                    ...
                  </ul>
                </div>
                <div class="btn-group">
                  <button class="btn btn-secondary btn-sm" type="button">
                    Small split button
                  </button>
                  <button type="button" class="btn btn-sm btn-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
                    <span class="visually-hidden">
                      Toggle Dropdown
                    </span>
                  </button>
                  <ul class="dropdown-menu">
                    ...
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizing2", renderedHtml);

        uiDocumentation.documentSource("sizing2");

    }

    @Test
    void darkDropdowns() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropdown)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                        .withType("button")
                                        .withData("bs-toggle","dropdown")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                text("Dropdown button")
                                        ),
                                ul()
                                        .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_dark)
                                        .with(
                                                li()
                                                        .with(
                                                                a()
                                                                        .withClasses(Bootstrap.dropdown_item, Bootstrap.active)
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
                                                                                text("Separated link")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="dropdown">
                  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown button
                  </button>
                  <ul class="dropdown-menu dropdown-menu-dark">
                    <li>
                      <a class="dropdown-item active" href="#">
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
                    <li>
                      <hr class="dropdown-divider">
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        Separated link
                      </a>
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("dark-dropdowns", renderedHtml);

        uiDocumentation.documentSource("dark-dropdowns");

    }

    @Test
    void darkDropdowns2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Bootstrap.navbar, Bootstrap.navbar_expand_lg, Bootstrap.navbar_dark, Bootstrap.bg_dark)
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
                                                        .withData("bs-target","#navbarNavDarkDropdown")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarNavDarkDropdown")
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
                                                        .withId("navbarNavDarkDropdown")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Bootstrap.navbar_nav)
                                                                        .with(
                                                                                li()
                                                                                        .withClasses(Bootstrap.nav_item, Bootstrap.dropdown)
                                                                                        .with(
                                                                                                button()
                                                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_dark, Bootstrap.dropdown_toggle)
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
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                  <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                      Navbar
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon">
                      </span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
                      <ul class="navbar-nav">
                        <li class="nav-item dropdown">
                          <button class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown
                          </button>
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
        uiDocumentation.document("dark-dropdowns2", renderedHtml);

        uiDocumentation.documentSource("dark-dropdowns2");

    }

    @Test
    void centered() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropdown_center)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                        .withType("button")
                                        .withData("bs-toggle","dropdown")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                text("Centered dropdown")
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
                                                                                text("Action two")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                a()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Action three")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="dropdown-center">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Centered dropdown
              </button>
              <ul class="dropdown-menu">
                <li>
                  <a class="dropdown-item" href="#">
                    Action
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Action two
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Action three
                  </a>
                </li>
              </ul>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("centered", renderedHtml);

        uiDocumentation.documentSource("centered");

    }

    @Test
    void dropUp() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.dropup)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Dropup")
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu)
                                                .with(
                                                        comment("Dropdown menu links")
                                                )
                                ),
                        comment("Split dropup button"),
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.dropup)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                .with(
                                                        text("Split dropup")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        span()
                                                                .withClasses(Bootstrap.visually_hidden)
                                                                .with(
                                                                        text("Toggle Dropdown")
                                                                )
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu)
                                                .with(
                                                        comment("Dropdown menu links")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group dropup">
                  <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropup
                  </button>
                  <ul class="dropdown-menu">
                    <!-- Dropdown menu links -->
                  </ul>
                </div>
                <!-- Split dropup button -->
                <div class="btn-group dropup">
                  <button type="button" class="btn btn-secondary">
                    Split dropup
                  </button>
                  <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
                    <span class="visually-hidden">
                      Toggle Dropdown
                    </span>
                  </button>
                  <ul class="dropdown-menu">
                    <!-- Dropdown menu links -->
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("drop-up", renderedHtml);

        uiDocumentation.documentSource("drop-up");

    }

    @Test
    void dropUpCentered() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropup_center, Bootstrap.dropup)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                        .withType("button")
                                        .withData("bs-toggle","dropdown")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                text("Centered dropup")
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
                                                                                text("Action two")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                a()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Action three")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="dropup-center dropup">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                Centered dropup
              </button>
              <ul class="dropdown-menu">
                <li>
                  <a class="dropdown-item" href="#">
                    Action
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Action two
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Action three
                  </a>
                </li>
              </ul>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("drop-up-centered", renderedHtml);

        uiDocumentation.documentSource("drop-up-centered");

    }

    @Test
    void dropEnd() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropup_center, Bootstrap.dropup)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                        .withType("button")
                                        .withData("bs-toggle","dropdown")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                text("Centered dropup")
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
                                                comment("Default dropend button"),
                                                div()
                                                        .withClasses(Bootstrap.btn_group, Bootstrap.dropend)
                                                        .with(
                                                                button()
                                                                        .withType("button")
                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                                        .withData("bs-toggle","dropdown")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .with(
                                                                                text("Dropend")
                                                                        ),
                                                                ul()
                                                                        .withClasses(Bootstrap.dropdown_menu)
                                                                        .with(
                                                                                comment("Dropdown menu links")
                                                                        )
                                                        ),
                                                comment("Split dropend button"),
                                                div()
                                                        .withClasses(Bootstrap.btn_group, Bootstrap.dropend)
                                                        .with(
                                                                button()
                                                                        .withType("button")
                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                                        .with(
                                                                                text("Split dropend")
                                                                        ),
                                                                button()
                                                                        .withType("button")
                                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
                                                                        .withData("bs-toggle","dropdown")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .with(
                                                                                span()
                                                                                        .withClasses(Bootstrap.visually_hidden)
                                                                                        .with(
                                                                                                text("Toggle Dropend")
                                                                                        )
                                                                        ),
                                                                ul()
                                                                        .withClasses(Bootstrap.dropdown_menu)
                                                                        .with(
                                                                                comment("Dropdown menu links")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                a()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Action two")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                a()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Action three")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="dropup-center dropup">
                  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Centered dropup
                  </button>
                  <ul class="dropdown-menu">
                    <li>
                      <a class="dropdown-item" href="#">
                        Action
                      </a>
                    </li>
                    <!-- Default dropend button -->
                    <div class="btn-group dropend">
                      <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropend
                      </button>
                      <ul class="dropdown-menu">
                        <!-- Dropdown menu links -->
                      </ul>
                    </div>
                    <!-- Split dropend button -->
                    <div class="btn-group dropend">
                      <button type="button" class="btn btn-secondary">
                        Split dropend
                      </button>
                      <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
                        <span class="visually-hidden">
                          Toggle Dropend
                        </span>
                      </button>
                      <ul class="dropdown-menu">
                        <!-- Dropdown menu links -->
                      </ul>
                    </div>
                    <li>
                      <a class="dropdown-item" href="#">
                        Action two
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        Action three
                      </a>
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("drop-end", renderedHtml);

        uiDocumentation.documentSource("drop-end");

    }

    @Test
    void dropStart() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.dropstart)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Dropstart")
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu)
                                                .with(
                                                        comment("Dropdown menu links")
                                                )
                                ),
                        comment("Split dropstart button"),
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.dropstart)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        span()
                                                                .withClasses(Bootstrap.visually_hidden)
                                                                .with(
                                                                        text("Toggle Dropstart")
                                                                )
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu)
                                                .with(
                                                        comment("Dropdown menu links")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                .with(
                                                        text("Split dropstart")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group dropstart">
                  <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropstart
                  </button>
                  <ul class="dropdown-menu">
                    <!-- Dropdown menu links -->
                  </ul>
                </div>
                <!-- Split dropstart button -->
                <div class="btn-group dropstart">
                  <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
                    <span class="visually-hidden">
                      Toggle Dropstart
                    </span>
                  </button>
                  <ul class="dropdown-menu">
                    <!-- Dropdown menu links -->
                  </ul>
                  <button type="button" class="btn btn-secondary">
                    Split dropstart
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("drop-start", renderedHtml);

        uiDocumentation.documentSource("drop-start");

    }

    @Test
    void menuItems() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropdown)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                        .withType("button")
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
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Action")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Another action")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Something else here")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="dropdown">
                  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown
                  </button>
                  <ul class="dropdown-menu">
                    <li>
                      <button class="dropdown-item" type="button">
                        Action
                      </button>
                    </li>
                    <li>
                      <button class="dropdown-item" type="button">
                        Another action
                      </button>
                    </li>
                    <li>
                      <button class="dropdown-item" type="button">
                        Something else here
                      </button>
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("menu-items", renderedHtml);

        uiDocumentation.documentSource("menu-items");

    }

    @Test
    void menuItems2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.dropdown_menu)
                        .with(
                                li()
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.dropdown_item_text)
                                                        .with(
                                                                text("Dropdown item text")
                                                        )
                                        ),
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
        );

        //language=HTML
        assertEquals("""
                <ul class="dropdown-menu">
                  <li>
                    <span class="dropdown-item-text">
                      Dropdown item text
                    </span>
                  </li>
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
                """, renderedHtml);

        // document
        uiDocumentation.document("menu-items2", renderedHtml);

        uiDocumentation.documentSource("menu-items2");

    }

    @Test
    void active() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.dropdown_menu)
                        .with(
                                li()
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.dropdown_item)
                                                        .withHref("#")
                                                        .with(
                                                                text("Regular link")
                                                        )
                                        ),
                                li()
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.dropdown_item, Bootstrap.active)
                                                        .withHref("#")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("true")
                                                        )
                                                        .with(
                                                                text("Active link")
                                                        )
                                        ),
                                li()
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.dropdown_item)
                                                        .withHref("#")
                                                        .with(
                                                                text("Another link")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" href="#">
                  Regular link
                </a>
              </li>
              <li>
                <a class="dropdown-item active" href="#" aria-current="true">
                  Active link
                </a>
              </li>
              <li>
                <a class="dropdown-item" href="#">
                  Another link
                </a>
              </li>
            </ul>
            """, renderedHtml);

        // document
        uiDocumentation.document("active", renderedHtml);

        uiDocumentation.documentSource("active");

    }

    @Test
    void disabled() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.dropdown_menu)
                        .with(
                                li()
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.dropdown_item)
                                                        .withHref("#")
                                                        .with(
                                                                text("Regular link")
                                                        )
                                        ),
                                li()
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.dropdown_item, Bootstrap.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled link")
                                                        )
                                        ),
                                li()
                                        .with(
                                                a()
                                                        .withClasses(Bootstrap.dropdown_item)
                                                        .withHref("#")
                                                        .with(
                                                                text("Another link")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item" href="#">
                      Regular link
                    </a>
                  </li>
                  <li>
                    <a class="dropdown-item disabled" aria-disabled="true">
                      Disabled link
                    </a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">
                      Another link
                    </a>
                  </li>
                </ul>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled", renderedHtml);

        uiDocumentation.documentSource("disabled");

    }

    @Test
    void menuAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                        .withData("bs-toggle","dropdown")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                text("Right-aligned menu example")
                                        ),
                                ul()
                                        .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_end)
                                        .with(
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Action")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Another action")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Something else here")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group">
                  <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                    Right-aligned menu example
                  </button>
                  <ul class="dropdown-menu dropdown-menu-end">
                    <li>
                      <button class="dropdown-item" type="button">
                        Action
                      </button>
                    </li>
                    <li>
                      <button class="dropdown-item" type="button">
                        Another action
                      </button>
                    </li>
                    <li>
                      <button class="dropdown-item" type="button">
                        Something else here
                      </button>
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("menu-alignment", renderedHtml);

        uiDocumentation.documentSource("menu-alignment");

    }

    @Test
    void responsiveAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                        .withData("bs-toggle","dropdown")
                                        .withData("bs-display","static")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                text("Left-aligned but right aligned when large screen")
                                        ),
                                ul()
                                        .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_lg_end)
                                        .with(
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Action")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Another action")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Something else here")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group">
                  <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false">
                    Left-aligned but right aligned when large screen
                  </button>
                  <ul class="dropdown-menu dropdown-menu-lg-end">
                    <li>
                      <button class="dropdown-item" type="button">
                        Action
                      </button>
                    </li>
                    <li>
                      <button class="dropdown-item" type="button">
                        Another action
                      </button>
                    </li>
                    <li>
                      <button class="dropdown-item" type="button">
                        Something else here
                      </button>
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("responsive-alignment", renderedHtml);

        uiDocumentation.documentSource("responsive-alignment");

    }

    @Test
    void responsiveAlignment2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                        .withData("bs-toggle","dropdown")
                                        .withData("bs-display","static")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .with(
                                                text("Right-aligned but left aligned when large screen")
                                        ),
                                ul()
                                        .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_end, Bootstrap.dropdown_menu_lg_start)
                                        .with(
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Action")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Another action")
                                                                        )
                                                        ),
                                                li()
                                                        .with(
                                                                button()
                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                        .withType("button")
                                                                        .with(
                                                                                text("Something else here")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="btn-group">
              <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false">
                Right-aligned but left aligned when large screen
              </button>
              <ul class="dropdown-menu dropdown-menu-end dropdown-menu-lg-start">
                <li>
                  <button class="dropdown-item" type="button">
                    Action
                  </button>
                </li>
                <li>
                  <button class="dropdown-item" type="button">
                    Another action
                  </button>
                </li>
                <li>
                  <button class="dropdown-item" type="button">
                    Something else here
                  </button>
                </li>
              </ul>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("responsive-alignment2", renderedHtml);

        uiDocumentation.documentSource("responsive-alignment2");

    }

    @Test
    void alignmentOptions() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
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
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Right-aligned menu")
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_end)
                                                .with(
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withData("bs-toggle","dropdown")
                                                .withData("bs-display","static")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Left-aligned, right-aligned lg")
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_lg_end)
                                                .with(
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withData("bs-toggle","dropdown")
                                                .withData("bs-display","static")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Right-aligned, left-aligned lg")
                                                ),
                                        ul()
                                                .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_end, Bootstrap.dropdown_menu_lg_start)
                                                .with(
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.dropstart)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Dropstart")
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
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.dropend)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Dropend")
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
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.dropup)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withData("bs-toggle","dropdown")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Dropup")
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
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="btn-group">
          <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </button>
          <ul class="dropdown-menu">
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
          </ul>
        </div>
        <div class="btn-group">
          <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Right-aligned menu
          </button>
          <ul class="dropdown-menu dropdown-menu-end">
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
          </ul>
        </div>
        <div class="btn-group">
          <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false">
            Left-aligned, right-aligned lg
          </button>
          <ul class="dropdown-menu dropdown-menu-lg-end">
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
          </ul>
        </div>
        <div class="btn-group">
          <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" data-bs-display="static" aria-expanded="false">
            Right-aligned, left-aligned lg
          </button>
          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-lg-start">
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
          </ul>
        </div>
        <div class="btn-group dropstart">
          <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Dropstart
          </button>
          <ul class="dropdown-menu">
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
          </ul>
        </div>
        <div class="btn-group dropend">
          <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Dropend
          </button>
          <ul class="dropdown-menu">
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
          </ul>
        </div>
        <div class="btn-group dropup">
          <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Dropup
          </button>
          <ul class="dropdown-menu">
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">
                Menu item
              </a>
            </li>
          </ul>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("alignment-options", renderedHtml);

        uiDocumentation.documentSource("alignment-options");

    }

    @Test
    void headers() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.dropdown_menu)
                        .with(
                                li()
                                        .with(
                                                h6()
                                                        .withClasses(Bootstrap.dropdown_header)
                                                        .with(
                                                                text("Dropdown header")
                                                        )
                                        ),
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
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <ul class="dropdown-menu">
              <li>
                <h6 class="dropdown-header">
                  Dropdown header
                </h6>
              </li>
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
            </ul>
            """, renderedHtml);

        // document
        uiDocumentation.document("headers", renderedHtml);

        uiDocumentation.documentSource("headers");

    }

    @Test
    void dividers() throws Exception {

        String renderedHtml = uiDocumentation.render(
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
                                                                text("Separated link")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
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
                  <li>
                    <hr class="dropdown-divider">
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">
                      Separated link
                    </a>
                  </li>
                </ul>
                """, renderedHtml);

        // document
        uiDocumentation.document("dividers", renderedHtml);

        uiDocumentation.documentSource("dividers");

    }

    @Test
    void textTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropdown_menu, Bootstrap.p_4, Bootstrap.text_body_secondary)
                        .withStyle("max-width: 200px;")
                        .with(
                                p()
                                        .with(
                                                text("Some example text that's free-flowing within the dropdown menu.")
                                        ),
                                p()
                                        .withClasses(Bootstrap.mb_0)
                                        .with(
                                                text("And this is more example BootstrapClasses.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="dropdown-menu p-4 text-body-secondary" style="max-width: 200px;">
              <p>
                Some example text that&#x27;s free-flowing within the dropdown menu.
              </p>
              <p class="mb-0">
                And this is more example BootstrapClasses.
              </p>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("text", renderedHtml);

        uiDocumentation.documentSource("text");

    }

    @Test
    void forms() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropdown_menu)
                        .with(
                                form()
                                        .withClasses(Bootstrap.px_4, Bootstrap.py_3)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.mb_3)
                                                        .with(
                                                                label()
                                                                        .withFor("exampleDropdownFormEmail1")
                                                                        .withClasses(Bootstrap.form_label)
                                                                        .with(
                                                                                text("Email address")
                                                                        ),
                                                                input()
                                                                        .withType("email")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("exampleDropdownFormEmail1")
                                                                        .withPlaceholder("email@example.com")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.mb_3)
                                                        .with(
                                                                label()
                                                                        .withFor("exampleDropdownFormPassword1")
                                                                        .withClasses(Bootstrap.form_label)
                                                                        .with(
                                                                                text("Password")
                                                                        ),
                                                                input()
                                                                        .withType("password")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("exampleDropdownFormPassword1")
                                                                        .withPlaceholder("Password")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.mb_3)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.form_check)
                                                                        .with(
                                                                                input()
                                                                                        .withType("checkbox")
                                                                                        .withClasses(Bootstrap.form_check_input)
                                                                                        .withId("dropdownCheck"),
                                                                                label()
                                                                                        .withClasses(Bootstrap.form_check_label)
                                                                                        .withFor("dropdownCheck")
                                                                                        .with(
                                                                                                text("Remember me")
                                                                                        )
                                                                        )
                                                        ),
                                                button()
                                                        .withType("submit")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Sign in")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.dropdown_divider),
                                a()
                                        .withClasses(Bootstrap.dropdown_item)
                                        .withHref("#")
                                        .with(
                                                text("New around here? Sign up")
                                        ),
                                a()
                                        .withClasses(Bootstrap.dropdown_item)
                                        .withHref("#")
                                        .with(
                                                text("Forgot password?")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="dropdown-menu">
                  <form class="px-4 py-3">
                    <div class="mb-3">
                      <label for="exampleDropdownFormEmail1" class="form-label">
                        Email address
                      </label>
                      <input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com">
                    </div>
                    <div class="mb-3">
                      <label for="exampleDropdownFormPassword1" class="form-label">
                        Password
                      </label>
                      <input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Password">
                    </div>
                    <div class="mb-3">
                      <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="dropdownCheck">
                        <label class="form-check-label" for="dropdownCheck">
                          Remember me
                        </label>
                      </div>
                    </div>
                    <button type="submit" class="btn btn-primary">
                      Sign in
                    </button>
                  </form>
                  <div class="dropdown-divider">
                  </div>
                  <a class="dropdown-item" href="#">
                    New around here? Sign up
                  </a>
                  <a class="dropdown-item" href="#">
                    Forgot password?
                  </a>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("forms", renderedHtml);

        uiDocumentation.documentSource("forms");

    }

    @Test
    void forms2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.dropdown)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.dropdown_toggle)
                                        .withData("bs-toggle","dropdown")
                                        .attr(
                                                AriaStatesAndProperties.ariaExpanded("false")
                                        )
                                        .withData("bs-auto-close","outside")
                                        .with(
                                                text("Dropdown form")
                                        ),
                                form()
                                        .withClasses(Bootstrap.dropdown_menu, Bootstrap.p_4)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.mb_3)
                                                        .with(
                                                                label()
                                                                        .withFor("exampleDropdownFormEmail2")
                                                                        .withClasses(Bootstrap.form_label)
                                                                        .with(
                                                                                text("Email address")
                                                                        ),
                                                                input()
                                                                        .withType("email")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("exampleDropdownFormEmail2")
                                                                        .withPlaceholder("email@example.com")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.mb_3)
                                                        .with(
                                                                label()
                                                                        .withFor("exampleDropdownFormPassword2")
                                                                        .withClasses(Bootstrap.form_label)
                                                                        .with(
                                                                                text("Password")
                                                                        ),
                                                                input()
                                                                        .withType("password")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("exampleDropdownFormPassword2")
                                                                        .withPlaceholder("Password")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.mb_3)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.form_check)
                                                                        .with(
                                                                                input()
                                                                                        .withType("checkbox")
                                                                                        .withClasses(Bootstrap.form_check_input)
                                                                                        .withId("dropdownCheck2"),
                                                                                label()
                                                                                        .withClasses(Bootstrap.form_check_label)
                                                                                        .withFor("dropdownCheck2")
                                                                                        .with(
                                                                                                text("Remember me")
                                                                                        )
                                                                        )
                                                        ),
                                                button()
                                                        .withType("submit")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Sign in")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="dropdown">
                  <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-bs-auto-close="outside">
                    Dropdown form
                  </button>
                  <form class="dropdown-menu p-4">
                    <div class="mb-3">
                      <label for="exampleDropdownFormEmail2" class="form-label">
                        Email address
                      </label>
                      <input type="email" class="form-control" id="exampleDropdownFormEmail2" placeholder="email@example.com">
                    </div>
                    <div class="mb-3">
                      <label for="exampleDropdownFormPassword2" class="form-label">
                        Password
                      </label>
                      <input type="password" class="form-control" id="exampleDropdownFormPassword2" placeholder="Password">
                    </div>
                    <div class="mb-3">
                      <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="dropdownCheck2">
                        <label class="form-check-label" for="dropdownCheck2">
                          Remember me
                        </label>
                      </div>
                    </div>
                    <button type="submit" class="btn btn-primary">
                      Sign in
                    </button>
                  </form>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("forms2", renderedHtml);

        uiDocumentation.documentSource("forms2");

    }

    @Test
    void dropdownOptions() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex)
                        .with(
                                div()
                                        .withClasses(Bootstrap.dropdown, Bootstrap.me_1)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                        .withData("bs-toggle","dropdown")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .withData("bs-offset","10,20")
                                                        .with(
                                                                text("Offset")
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
                                        ),
                                div()
                                        .withClasses(Bootstrap.btn_group)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                        .with(
                                                                text("Reference")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
                                                        .withData("bs-toggle","dropdown")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .withData("bs-reference","parent")
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.visually_hidden)
                                                                        .with(
                                                                                text("Toggle Dropdown")
                                                                        )
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
                                                                                                text("Separated link")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="d-flex">
              <div class="dropdown me-1">
                <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="10,20">
                  Offset
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
              <div class="btn-group">
                <button type="button" class="btn btn-secondary">
                  Reference
                </button>
                <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false" data-bs-reference="parent">
                  <span class="visually-hidden">
                    Toggle Dropdown
                  </span>
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
                  <li>
                    <hr class="dropdown-divider">
                  </li>
                  <li>
                    <a class="dropdown-item" href="#">
                      Separated link
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("dropdown-options", renderedHtml);

        uiDocumentation.documentSource("dropdown-options");

    }

    @Test
    void autoCloseBehaviour() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .withData("bs-auto-close","true")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Default dropdown")
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
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .withData("bs-auto-close","inside")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Clickable inside")
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
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .withData("bs-auto-close","outside")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Clickable outside")
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
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .withData("bs-auto-close","false")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .with(
                                                        text("Manual close")
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
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Menu item")
                                                                                )
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="btn-group">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" data-bs-auto-close="true" aria-expanded="false">
                Default dropdown
              </button>
              <ul class="dropdown-menu">
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
              </ul>
            </div>
            <div class="btn-group">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" data-bs-auto-close="inside" aria-expanded="false">
                Clickable inside
              </button>
              <ul class="dropdown-menu">
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
              </ul>
            </div>
            <div class="btn-group">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" data-bs-auto-close="outside" aria-expanded="false">
                Clickable outside
              </button>
              <ul class="dropdown-menu">
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
              </ul>
            </div>
            <div class="btn-group">
              <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false">
                Manual close
              </button>
              <ul class="dropdown-menu">
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">
                    Menu item
                  </a>
                </li>
              </ul>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("auto-close-behaviour", renderedHtml);

        uiDocumentation.documentSource("auto-close-behaviour");

    }


}
