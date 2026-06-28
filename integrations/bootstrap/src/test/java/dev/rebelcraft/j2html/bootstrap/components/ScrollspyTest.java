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

class ScrollspyTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void navbar() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                  nav()
                   .withId("navbar-example2")
                   .withClasses(Bootstrap.navbar, Bootstrap.bg_body_tertiary, Bootstrap.px_3, Bootstrap.mb_3)
                   .with(
                      a()
                       .withClasses(Bootstrap.navbar_brand)
                       .withHref("#")
                       .with(
                          text("Navbar")
                        ),
                      ul()
                       .withClasses(Bootstrap.nav, Bootstrap.nav_pills)
                       .with(
                          li()
                           .withClasses(Bootstrap.nav_item)
                           .with(
                              a()
                               .withClasses(Bootstrap.nav_link)
                               .withHref("#scrollspyHeading1")
                               .with(
                                  text("First")
                                )
                            ),
                          li()
                           .withClasses(Bootstrap.nav_item)
                           .with(
                              a()
                               .withClasses(Bootstrap.nav_link)
                               .withHref("#scrollspyHeading2")
                               .with(
                                  text("Second")
                                )
                            ),
                          li()
                           .withClasses(Bootstrap.nav_item, Bootstrap.dropdown)
                           .with(
                              a()
                               .withClasses(Bootstrap.nav_link, Bootstrap.dropdown_toggle)
                               .withData("bs-toggle","dropdown")
                               .withHref("#")
                               .attr(AriaRoles.roleButton)
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
                                       .withHref("#scrollspyHeading3")
                                       .with(
                                          text("Third")
                                        )
                                    ),
                                  li()
                                   .with(
                                      a()
                                       .withClasses(Bootstrap.dropdown_item)
                                       .withHref("#scrollspyHeading4")
                                       .with(
                                          text("Fourth")
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
                                       .withHref("#scrollspyHeading5")
                                       .with(
                                          text("Fifth")
                                        )
                                    )
                                )
                            )
                        )
                    ),
                  div()
                   .withData("bs-spy","scroll")
                   .withData("bs-target","#navbar-example2")
                   .withData("bs-root-margin","0px 0px -40%")
                   .withData("bs-smooth-scroll","true")
                   .withClasses("scrollspy-example", Bootstrap.bg_body_tertiary, Bootstrap.p_3, Bootstrap.rounded_2)
                   .withTabindex(0)
                   .with(
                      h4()
                       .withId("scrollspyHeading1")
                       .with(
                          text("First heading")
                        ),
                      p()
                       .with(
                          text("...")
                        ),
                      h4()
                       .withId("scrollspyHeading2")
                       .with(
                          text("Second heading")
                        ),
                      p()
                       .with(
                          text("...")
                        ),
                      h4()
                       .withId("scrollspyHeading3")
                       .with(
                          text("Third heading")
                        ),
                      p()
                       .with(
                          text("...")
                        ),
                      h4()
                       .withId("scrollspyHeading4")
                       .with(
                          text("Fourth heading")
                        ),
                      p()
                       .with(
                          text("...")
                        ),
                      h4()
                       .withId("scrollspyHeading5")
                       .with(
                          text("Fifth heading")
                        ),
                      p()
                       .with(
                          text("...")
                        )
                    )
                )
        );

        //language=HTML
        assertEquals("""
            <nav id="navbar-example2" class="navbar bg-body-tertiary px-3 mb-3">
              <a class="navbar-brand" href="#">
                Navbar
              </a>
              <ul class="nav nav-pills">
                <li class="nav-item">
                  <a class="nav-link" href="#scrollspyHeading1">
                    First
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#scrollspyHeading2">
                    Second
                  </a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
                    Dropdown
                  </a>
                  <ul class="dropdown-menu">
                    <li>
                      <a class="dropdown-item" href="#scrollspyHeading3">
                        Third
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#scrollspyHeading4">
                        Fourth
                      </a>
                    </li>
                    <li>
                      <hr class="dropdown-divider">
                    </li>
                    <li>
                      <a class="dropdown-item" href="#scrollspyHeading5">
                        Fifth
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
            <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true" class="scrollspy-example bg-body-tertiary p-3 rounded-2" tabindex="0">
              <h4 id="scrollspyHeading1">
                First heading
              </h4>
              <p>
                ...
              </p>
              <h4 id="scrollspyHeading2">
                Second heading
              </h4>
              <p>
                ...
              </p>
              <h4 id="scrollspyHeading3">
                Third heading
              </h4>
              <p>
                ...
              </p>
              <h4 id="scrollspyHeading4">
                Fourth heading
              </h4>
              <p>
                ...
              </p>
              <h4 id="scrollspyHeading5">
                Fifth heading
              </h4>
              <p>
                ...
              </p>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("navbar", renderedHtml);

        uiDocumentation.documentSource("navbar");

    }

    @Test
    void nestedNav() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_4)
                                        .with(
                                                nav()
                                                        .withId("navbar-example3")
                                                        .withClasses(Bootstrap.h_100, Bootstrap.flex_column, Bootstrap.align_items_stretch, Bootstrap.pe_4, Bootstrap.border_end)
                                                        .with(
                                                                nav()
                                                                        .withClasses(Bootstrap.nav, Bootstrap.nav_pills, Bootstrap.flex_column)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                        .withHref("#item-1")
                                                                                        .with(
                                                                                                text("Item 1")
                                                                                        ),
                                                                                nav()
                                                                                        .withClasses(Bootstrap.nav, Bootstrap.nav_pills, Bootstrap.flex_column)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.ms_3, Bootstrap.my_1)
                                                                                                        .withHref("#item-1-1")
                                                                                                        .with(
                                                                                                                text("Item 1-1")
                                                                                                        ),
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.ms_3, Bootstrap.my_1)
                                                                                                        .withHref("#item-1-2")
                                                                                                        .with(
                                                                                                                text("Item 1-2")
                                                                                                        )
                                                                                        ),
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                        .withHref("#item-2")
                                                                                        .with(
                                                                                                text("Item 2")
                                                                                        ),
                                                                                a()
                                                                                        .withClasses(Bootstrap.nav_link)
                                                                                        .withHref("#item-3")
                                                                                        .with(
                                                                                                text("Item 3")
                                                                                        ),
                                                                                nav()
                                                                                        .withClasses(Bootstrap.nav, Bootstrap.nav_pills, Bootstrap.flex_column)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.ms_3, Bootstrap.my_1)
                                                                                                        .withHref("#item-3-1")
                                                                                                        .with(
                                                                                                                text("Item 3-1")
                                                                                                        ),
                                                                                                a()
                                                                                                        .withClasses(Bootstrap.nav_link, Bootstrap.ms_3, Bootstrap.my_1)
                                                                                                        .withHref("#item-3-2")
                                                                                                        .with(
                                                                                                                text("Item 3-2")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_8)
                                        .with(
                                                div()
                                                        .withData("bs-spy","scroll")
                                                        .withData("bs-target","#navbar-example3")
                                                        .withData("bs-smooth-scroll","true")
                                                        .withClasses("scrollspy-example-2")
                                                        .withTabindex(0)
                                                        .with(
                                                                div()
                                                                        .withId("item-1")
                                                                        .with(
                                                                                h4()
                                                                                        .with(
                                                                                                text("Item 1")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-1-1")
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Item 1-1")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-1-2")
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Item 1-2")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-2")
                                                                        .with(
                                                                                h4()
                                                                                        .with(
                                                                                                text("Item 2")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-3")
                                                                        .with(
                                                                                h4()
                                                                                        .with(
                                                                                                text("Item 3")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-3-1")
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Item 3-1")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-3-2")
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Item 3-2")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="row">
          <div class="col-4">
            <nav id="navbar-example3" class="h-100 flex-column align-items-stretch pe-4 border-end">
              <nav class="nav nav-pills flex-column">
                <a class="nav-link" href="#item-1">
                  Item 1
                </a>
                <nav class="nav nav-pills flex-column">
                  <a class="nav-link ms-3 my-1" href="#item-1-1">
                    Item 1-1
                  </a>
                  <a class="nav-link ms-3 my-1" href="#item-1-2">
                    Item 1-2
                  </a>
                </nav>
                <a class="nav-link" href="#item-2">
                  Item 2
                </a>
                <a class="nav-link" href="#item-3">
                  Item 3
                </a>
                <nav class="nav nav-pills flex-column">
                  <a class="nav-link ms-3 my-1" href="#item-3-1">
                    Item 3-1
                  </a>
                  <a class="nav-link ms-3 my-1" href="#item-3-2">
                    Item 3-2
                  </a>
                </nav>
              </nav>
            </nav>
          </div>
          <div class="col-8">
            <div data-bs-spy="scroll" data-bs-target="#navbar-example3" data-bs-smooth-scroll="true" class="scrollspy-example-2" tabindex="0">
              <div id="item-1">
                <h4>
                  Item 1
                </h4>
                <p>
                  ...
                </p>
              </div>
              <div id="item-1-1">
                <h5>
                  Item 1-1
                </h5>
                <p>
                  ...
                </p>
              </div>
              <div id="item-1-2">
                <h5>
                  Item 1-2
                </h5>
                <p>
                  ...
                </p>
              </div>
              <div id="item-2">
                <h4>
                  Item 2
                </h4>
                <p>
                  ...
                </p>
              </div>
              <div id="item-3">
                <h4>
                  Item 3
                </h4>
                <p>
                  ...
                </p>
              </div>
              <div id="item-3-1">
                <h5>
                  Item 3-1
                </h5>
                <p>
                  ...
                </p>
              </div>
              <div id="item-3-2">
                <h5>
                  Item 3-2
                </h5>
                <p>
                  ...
                </p>
              </div>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("nested-nav", renderedHtml);

        uiDocumentation.documentSource("nested-nav");

    }

    @Test
    void listGroup() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_4)
                                        .with(
                                                div()
                                                        .withId("list-example")
                                                        .withClasses(Bootstrap.list_group)
                                                        .with(
                                                                a()
                                                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                                                        .withHref("#list-item-1")
                                                                        .with(
                                                                                text("Item 1")
                                                                        ),
                                                                a()
                                                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                                                        .withHref("#list-item-2")
                                                                        .with(
                                                                                text("Item 2")
                                                                        ),
                                                                a()
                                                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                                                        .withHref("#list-item-3")
                                                                        .with(
                                                                                text("Item 3")
                                                                        ),
                                                                a()
                                                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                                                        .withHref("#list-item-4")
                                                                        .with(
                                                                                text("Item 4")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_8)
                                        .with(
                                                div()
                                                        .withData("bs-spy","scroll")
                                                        .withData("bs-target","#list-example")
                                                        .withData("bs-smooth-scroll","true")
                                                        .withClasses("scrollspy-example")
                                                        .withTabindex(0)
                                                        .with(
                                                                h4()
                                                                        .withId("list-item-1")
                                                                        .with(
                                                                                text("Item 1")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("list-item-2")
                                                                        .with(
                                                                                text("Item 2")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("list-item-3")
                                                                        .with(
                                                                                text("Item 3")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("list-item-4")
                                                                        .with(
                                                                                text("Item 4")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row">
                  <div class="col-4">
                    <div id="list-example" class="list-group">
                      <a class="list-group-item list-group-item-action" href="#list-item-1">
                        Item 1
                      </a>
                      <a class="list-group-item list-group-item-action" href="#list-item-2">
                        Item 2
                      </a>
                      <a class="list-group-item list-group-item-action" href="#list-item-3">
                        Item 3
                      </a>
                      <a class="list-group-item list-group-item-action" href="#list-item-4">
                        Item 4
                      </a>
                    </div>
                  </div>
                  <div class="col-8">
                    <div data-bs-spy="scroll" data-bs-target="#list-example" data-bs-smooth-scroll="true" class="scrollspy-example" tabindex="0">
                      <h4 id="list-item-1">
                        Item 1
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="list-item-2">
                        Item 2
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="list-item-3">
                        Item 3
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="list-item-4">
                        Item 4
                      </h4>
                      <p>
                        ...
                      </p>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("list-group", renderedHtml);

        uiDocumentation.documentSource("list-group");

    }

    @Test
    void simpleAnchors() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_4)
                                        .with(
                                                div()
                                                        .withId("simple-list-example")
                                                        .withClasses(Bootstrap.d_flex, Bootstrap.flex_column, Bootstrap.gap_2,"simple-list-example-scrollspy", Bootstrap.text_center)
                                                        .with(
                                                                a()
                                                                        .withClasses(Bootstrap.p_1, Bootstrap.rounded)
                                                                        .withHref("#simple-list-item-1")
                                                                        .with(
                                                                                text("Item 1")
                                                                        ),
                                                                a()
                                                                        .withClasses(Bootstrap.p_1, Bootstrap.rounded)
                                                                        .withHref("#simple-list-item-2")
                                                                        .with(
                                                                                text("Item 2")
                                                                        ),
                                                                a()
                                                                        .withClasses(Bootstrap.p_1, Bootstrap.rounded)
                                                                        .withHref("#simple-list-item-3")
                                                                        .with(
                                                                                text("Item 3")
                                                                        ),
                                                                a()
                                                                        .withClasses(Bootstrap.p_1, Bootstrap.rounded)
                                                                        .withHref("#simple-list-item-4")
                                                                        .with(
                                                                                text("Item 4")
                                                                        ),
                                                                a()
                                                                        .withClasses(Bootstrap.p_1, Bootstrap.rounded)
                                                                        .withHref("#simple-list-item-5")
                                                                        .with(
                                                                                text("Item 5")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_8)
                                        .with(
                                                div()
                                                        .withData("bs-spy","scroll")
                                                        .withData("bs-target","#simple-list-example")
                                                        .withData("bs-offset","0")
                                                        .withData("bs-smooth-scroll","true")
                                                        .withClasses("scrollspy-example")
                                                        .withTabindex(0)
                                                        .with(
                                                                h4()
                                                                        .withId("simple-list-item-1")
                                                                        .with(
                                                                                text("Item 1")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("simple-list-item-2")
                                                                        .with(
                                                                                text("Item 2")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("simple-list-item-3")
                                                                        .with(
                                                                                text("Item 3")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("simple-list-item-4")
                                                                        .with(
                                                                                text("Item 4")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("simple-list-item-5")
                                                                        .with(
                                                                                text("Item 5")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row">
                  <div class="col-4">
                    <div id="simple-list-example" class="d-flex flex-column gap-2 simple-list-example-scrollspy text-center">
                      <a class="p-1 rounded" href="#simple-list-item-1">
                        Item 1
                      </a>
                      <a class="p-1 rounded" href="#simple-list-item-2">
                        Item 2
                      </a>
                      <a class="p-1 rounded" href="#simple-list-item-3">
                        Item 3
                      </a>
                      <a class="p-1 rounded" href="#simple-list-item-4">
                        Item 4
                      </a>
                      <a class="p-1 rounded" href="#simple-list-item-5">
                        Item 5
                      </a>
                    </div>
                  </div>
                  <div class="col-8">
                    <div data-bs-spy="scroll" data-bs-target="#simple-list-example" data-bs-offset="0" data-bs-smooth-scroll="true" class="scrollspy-example" tabindex="0">
                      <h4 id="simple-list-item-1">
                        Item 1
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="simple-list-item-2">
                        Item 2
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="simple-list-item-3">
                        Item 3
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="simple-list-item-4">
                        Item 4
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="simple-list-item-5">
                        Item 5
                      </h4>
                      <p>
                        ...
                      </p>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("simple-anchors", renderedHtml);

        uiDocumentation.documentSource("simple-anchors");

    }


}
