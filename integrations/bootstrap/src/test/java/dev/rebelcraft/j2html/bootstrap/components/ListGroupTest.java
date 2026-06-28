package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListGroupTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void basicExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                 .withClasses(Bootstrap.list_group)
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
                      ),
                    li()
                     .withClasses(Bootstrap.list_group_item)
                     .with(
                        text("A fourth item")
                      ),
                    li()
                     .withClasses(Bootstrap.list_group_item)
                     .with(
                        text("And a fifth one")
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <ul class="list-group">
              <li class="list-group-item">
                An item
              </li>
              <li class="list-group-item">
                A second item
              </li>
              <li class="list-group-item">
                A third item
              </li>
              <li class="list-group-item">
                A fourth item
              </li>
              <li class="list-group-item">
                And a fifth one
              </li>
            </ul>
            """, renderedHtml);

        // document
        uiDocumentation.document("basic-example", renderedHtml);

        uiDocumentation.documentSource("basic-example");

    }

    @Test
    void activeItems() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("true")
                                        )
                                        .with(
                                                text("An active item")
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
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("A fourth item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("And a fifth one")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="list-group">
          <li class="list-group-item active" aria-current="true">
            An active item
          </li>
          <li class="list-group-item">
            A second item
          </li>
          <li class="list-group-item">
            A third item
          </li>
          <li class="list-group-item">
            A fourth item
          </li>
          <li class="list-group-item">
            And a fifth one
          </li>
        </ul>
        """, renderedHtml);

        // document
        uiDocumentation.document("active-items", renderedHtml);

        uiDocumentation.documentSource("active-items");

    }

    @Test
    void disabledItems() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.disabled)
                                        .attr(
                                                AriaStatesAndProperties.ariaDisabled("true")
                                        )
                                        .with(
                                                text("A disabled item")
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
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("A fourth item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("And a fifth one")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <ul class="list-group">
                  <li class="list-group-item disabled" aria-disabled="true">
                    A disabled item
                  </li>
                  <li class="list-group-item">
                    A second item
                  </li>
                  <li class="list-group-item">
                    A third item
                  </li>
                  <li class="list-group-item">
                    A fourth item
                  </li>
                  <li class="list-group-item">
                    And a fifth one
                  </li>
                </ul>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled-items", renderedHtml);

        uiDocumentation.documentSource("disabled-items");

    }

    @Test
    void linksAndButtons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("true")
                                        )
                                        .with(
                                                text("The current link item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                text("A second link item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                text("A third link item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                text("A fourth link item")
                                        ),
                                a()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.disabled)
                                        .attr(
                                                AriaStatesAndProperties.ariaDisabled("true")
                                        )
                                        .with(
                                                text("A disabled link item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="list-group">
                  <a href="#" class="list-group-item list-group-item-action active" aria-current="true">
                    The current link item
                  </a>
                  <a href="#" class="list-group-item list-group-item-action">
                    A second link item
                  </a>
                  <a href="#" class="list-group-item list-group-item-action">
                    A third link item
                  </a>
                  <a href="#" class="list-group-item list-group-item-action">
                    A fourth link item
                  </a>
                  <a class="list-group-item list-group-item-action disabled" aria-disabled="true">
                    A disabled link item
                  </a>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("links-and-buttons", renderedHtml);

        uiDocumentation.documentSource("links-and-buttons");

    }

    @Test
    void linksAndButtons2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("true")
                                        )
                                        .with(
                                                text("The current button")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                text("A second button item")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                text("A third button item")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                text("A fourth button item")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .withCondDisabled(true)
                                        .with(
                                                text("A disabled button item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="list-group">
          <button type="button" class="list-group-item list-group-item-action active" aria-current="true">
            The current button
          </button>
          <button type="button" class="list-group-item list-group-item-action">
            A second button item
          </button>
          <button type="button" class="list-group-item list-group-item-action">
            A third button item
          </button>
          <button type="button" class="list-group-item list-group-item-action">
            A fourth button item
          </button>
          <button type="button" class="list-group-item list-group-item-action" disabled>
            A disabled button item
          </button>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("links-and-buttons2", renderedHtml);

        uiDocumentation.documentSource("links-and-buttons2");

    }

    @Test
    void flush() throws Exception {

        String renderedHtml = uiDocumentation.render(
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
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("A fourth item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("And a fifth one")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
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
          <li class="list-group-item">
            A fourth item
          </li>
          <li class="list-group-item">
            And a fifth one
          </li>
        </ul>
        """, renderedHtml);

        // document
        uiDocumentation.document("flush", renderedHtml);

        uiDocumentation.documentSource("flush");

    }

    @Test
    void numbered() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ol()
                        .withClasses(Bootstrap.list_group, Bootstrap.list_group_numbered)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("A list item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("A list item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("A list item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ol class="list-group list-group-numbered">
          <li class="list-group-item">
            A list item
          </li>
          <li class="list-group-item">
            A list item
          </li>
          <li class="list-group-item">
            A list item
          </li>
        </ol>
        """, renderedHtml);

        // document
        uiDocumentation.document("numbered", renderedHtml);

        uiDocumentation.documentSource("numbered");

    }

    @Test
    void numbered2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ol()
                        .withClasses(Bootstrap.list_group, Bootstrap.list_group_numbered)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.d_flex, Bootstrap.justify_content_between, Bootstrap.align_items_start)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.ms_2, Bootstrap.me_auto)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.fw_bold)
                                                                        .with(
                                                                                text("Subheading")
                                                                        ),
                                                                text("Content for list item")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.badge, Bootstrap.text_bg_primary, Bootstrap.rounded_pill)
                                                        .with(
                                                                text("14")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.d_flex, Bootstrap.justify_content_between, Bootstrap.align_items_start)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.ms_2, Bootstrap.me_auto)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.fw_bold)
                                                                        .with(
                                                                                text("Subheading")
                                                                        ),
                                                                text("Content for list item")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.badge, Bootstrap.text_bg_primary, Bootstrap.rounded_pill)
                                                        .with(
                                                                text("14")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.d_flex, Bootstrap.justify_content_between, Bootstrap.align_items_start)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.ms_2, Bootstrap.me_auto)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.fw_bold)
                                                                        .with(
                                                                                text("Subheading")
                                                                        ),
                                                                text("Content for list item")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.badge, Bootstrap.text_bg_primary, Bootstrap.rounded_pill)
                                                        .with(
                                                                text("14")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ol class="list-group list-group-numbered">
          <li class="list-group-item d-flex justify-content-between align-items-start">
            <div class="ms-2 me-auto">
              <div class="fw-bold">
                Subheading
              </div>
              Content for list item
            </div>
            <span class="badge text-bg-primary rounded-pill">
              14
            </span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-start">
            <div class="ms-2 me-auto">
              <div class="fw-bold">
                Subheading
              </div>
              Content for list item
            </div>
            <span class="badge text-bg-primary rounded-pill">
              14
            </span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-start">
            <div class="ms-2 me-auto">
              <div class="fw-bold">
                Subheading
              </div>
              Content for list item
            </div>
            <span class="badge text-bg-primary rounded-pill">
              14
            </span>
          </li>
        </ol>
        """, renderedHtml);

        // document
        uiDocumentation.document("numbered2", renderedHtml);

        uiDocumentation.documentSource("numbered2");

    }

    @Test
    void horizontal() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        ul()
                                .withClasses(Bootstrap.list_group, Bootstrap.list_group_horizontal)
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
                        ul()
                                .withClasses(Bootstrap.list_group, Bootstrap.list_group_horizontal_sm)
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
                        ul()
                                .withClasses(Bootstrap.list_group, Bootstrap.list_group_horizontal_md)
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
                        ul()
                                .withClasses(Bootstrap.list_group, Bootstrap.list_group_horizontal_lg)
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
                        ul()
                                .withClasses(Bootstrap.list_group, Bootstrap.list_group_horizontal_xl)
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
                        ul()
                                .withClasses(Bootstrap.list_group, Bootstrap.list_group_horizontal_xxl)
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
        <ul class="list-group list-group-horizontal">
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
        <ul class="list-group list-group-horizontal-sm">
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
        <ul class="list-group list-group-horizontal-md">
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
        <ul class="list-group list-group-horizontal-lg">
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
        <ul class="list-group list-group-horizontal-xl">
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
        <ul class="list-group list-group-horizontal-xxl">
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
        """, renderedHtml);

        // document
        uiDocumentation.document("horizontal", renderedHtml);

        uiDocumentation.documentSource("horizontal");

    }

    @Test
    void variants() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                text("A simple default list group item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_primary)
                                        .with(
                                                text("A simple primary list group item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_secondary)
                                        .with(
                                                text("A simple secondary list group item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_success)
                                        .with(
                                                text("A simple success list group item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_danger)
                                        .with(
                                                text("A simple danger list group item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_warning)
                                        .with(
                                                text("A simple warning list group item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_info)
                                        .with(
                                                text("A simple info list group item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_light)
                                        .with(
                                                text("A simple light list group item")
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_dark)
                                        .with(
                                                text("A simple dark list group item")
                                        )
                        )
        );

        //language=HTML

        assertEquals("""
        <ul class="list-group">
          <li class="list-group-item">
            A simple default list group item
          </li>
          <li class="list-group-item list-group-item-primary">
            A simple primary list group item
          </li>
          <li class="list-group-item list-group-item-secondary">
            A simple secondary list group item
          </li>
          <li class="list-group-item list-group-item-success">
            A simple success list group item
          </li>
          <li class="list-group-item list-group-item-danger">
            A simple danger list group item
          </li>
          <li class="list-group-item list-group-item-warning">
            A simple warning list group item
          </li>
          <li class="list-group-item list-group-item-info">
            A simple info list group item
          </li>
          <li class="list-group-item list-group-item-light">
            A simple light list group item
          </li>
          <li class="list-group-item list-group-item-dark">
            A simple dark list group item
          </li>
        </ul>
        """, renderedHtml);
        // document
        uiDocumentation.document("variants", renderedHtml);

        uiDocumentation.documentSource("variants");

    }

    @Test
    void linksAndButtons3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                text("A simple default list group item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.list_group_item_primary)
                                        .with(
                                                text("A simple primary list group item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.list_group_item_secondary)
                                        .with(
                                                text("A simple secondary list group item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.list_group_item_success)
                                        .with(
                                                text("A simple success list group item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.list_group_item_danger)
                                        .with(
                                                text("A simple danger list group item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.list_group_item_warning)
                                        .with(
                                                text("A simple warning list group item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.list_group_item_info)
                                        .with(
                                                text("A simple info list group item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.list_group_item_light)
                                        .with(
                                                text("A simple light list group item")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.list_group_item_dark)
                                        .with(
                                                text("A simple dark list group item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="list-group">
          <a href="#" class="list-group-item list-group-item-action">
            A simple default list group item
          </a>
          <a href="#" class="list-group-item list-group-item-action list-group-item-primary">
            A simple primary list group item
          </a>
          <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">
            A simple secondary list group item
          </a>
          <a href="#" class="list-group-item list-group-item-action list-group-item-success">
            A simple success list group item
          </a>
          <a href="#" class="list-group-item list-group-item-action list-group-item-danger">
            A simple danger list group item
          </a>
          <a href="#" class="list-group-item list-group-item-action list-group-item-warning">
            A simple warning list group item
          </a>
          <a href="#" class="list-group-item list-group-item-action list-group-item-info">
            A simple info list group item
          </a>
          <a href="#" class="list-group-item list-group-item-action list-group-item-light">
            A simple light list group item
          </a>
          <a href="#" class="list-group-item list-group-item-action list-group-item-dark">
            A simple dark list group item
          </a>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("links-and-buttons", renderedHtml);

        uiDocumentation.documentSource("links-and-buttons");

    }

    @Test
    void withBadges() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.d_flex, Bootstrap.justify_content_between, Bootstrap.align_items_center)
                                        .with(
                                                text("A list item"),
                                                span()
                                                        .withClasses(Bootstrap.badge, Bootstrap.text_bg_primary, Bootstrap.rounded_pill)
                                                        .with(
                                                                text("14")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.d_flex, Bootstrap.justify_content_between, Bootstrap.align_items_center)
                                        .with(
                                                text("A second list item"),
                                                span()
                                                        .withClasses(Bootstrap.badge, Bootstrap.text_bg_primary, Bootstrap.rounded_pill)
                                                        .with(
                                                                text("2")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.d_flex, Bootstrap.justify_content_between, Bootstrap.align_items_center)
                                        .with(
                                                text("A third list item"),
                                                span()
                                                        .withClasses(Bootstrap.badge, Bootstrap.text_bg_primary, Bootstrap.rounded_pill)
                                                        .with(
                                                                text("1")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="list-group">
          <li class="list-group-item d-flex justify-content-between align-items-center">
            A list item
            <span class="badge text-bg-primary rounded-pill">
              14
            </span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-center">
            A second list item
            <span class="badge text-bg-primary rounded-pill">
              2
            </span>
          </li>
          <li class="list-group-item d-flex justify-content-between align-items-center">
            A third list item
            <span class="badge text-bg-primary rounded-pill">
              1
            </span>
          </li>
        </ul>
        """, renderedHtml);

        // document
        uiDocumentation.document("with-badges", renderedHtml);

        uiDocumentation.documentSource("with-badges");

    }

    @Test
    void customContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action, Bootstrap.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("true")
                                        )
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.d_flex, Bootstrap.w_100, Bootstrap.justify_content_between)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.mb_1)
                                                                        .with(
                                                                                text("List group item heading")
                                                                        ),
                                                                small()
                                                                        .with(
                                                                                text("3 days ago")
                                                                        )
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.mb_1)
                                                        .with(
                                                                text("Some placeholder content in a paragraph.")
                                                        ),
                                                small()
                                                        .with(
                                                                text("And some small print.")
                                                        )
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.d_flex, Bootstrap.w_100, Bootstrap.justify_content_between)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.mb_1)
                                                                        .with(
                                                                                text("List group item heading")
                                                                        ),
                                                                small()
                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                        .with(
                                                                                text("3 days ago")
                                                                        )
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.mb_1)
                                                        .with(
                                                                text("Some placeholder content in a paragraph.")
                                                        ),
                                                small()
                                                        .withClasses(Bootstrap.text_body_secondary)
                                                        .with(
                                                                text("And some muted small print.")
                                                        )
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.list_group_item, Bootstrap.list_group_item_action)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.d_flex, Bootstrap.w_100, Bootstrap.justify_content_between)
                                                        .with(
                                                                h5()
                                                                        .withClasses(Bootstrap.mb_1)
                                                                        .with(
                                                                                text("List group item heading")
                                                                        ),
                                                                small()
                                                                        .withClasses(Bootstrap.text_body_secondary)
                                                                        .with(
                                                                                text("3 days ago")
                                                                        )
                                                        ),
                                                p()
                                                        .withClasses(Bootstrap.mb_1)
                                                        .with(
                                                                text("Some placeholder content in a paragraph.")
                                                        ),
                                                small()
                                                        .withClasses(Bootstrap.text_body_secondary)
                                                        .with(
                                                                text("And some muted small print.")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="list-group">
          <a href="#" class="list-group-item list-group-item-action active" aria-current="true">
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">
                List group item heading
              </h5>
              <small>
                3 days ago
              </small>
            </div>
            <p class="mb-1">
              Some placeholder content in a paragraph.
            </p>
            <small>
              And some small print.
            </small>
          </a>
          <a href="#" class="list-group-item list-group-item-action">
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">
                List group item heading
              </h5>
              <small class="text-body-secondary">
                3 days ago
              </small>
            </div>
            <p class="mb-1">
              Some placeholder content in a paragraph.
            </p>
            <small class="text-body-secondary">
              And some muted small print.
            </small>
          </a>
          <a href="#" class="list-group-item list-group-item-action">
            <div class="d-flex w-100 justify-content-between">
              <h5 class="mb-1">
                List group item heading
              </h5>
              <small class="text-body-secondary">
                3 days ago
              </small>
            </div>
            <p class="mb-1">
              Some placeholder content in a paragraph.
            </p>
            <small class="text-body-secondary">
              And some muted small print.
            </small>
          </a>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("custom-content", renderedHtml);

        uiDocumentation.documentSource("custom-content");

    }

    @Test
    void checkboxesAndRadios() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("checkbox")
                                                        .withValue("")
                                                        .withId("firstCheckbox"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("firstCheckbox")
                                                        .with(
                                                                text("First checkbox")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("checkbox")
                                                        .withValue("")
                                                        .withId("secondCheckbox"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("secondCheckbox")
                                                        .with(
                                                                text("Second checkbox")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("checkbox")
                                                        .withValue("")
                                                        .withId("thirdCheckbox"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("thirdCheckbox")
                                                        .with(
                                                                text("Third checkbox")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="list-group">
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="" id="firstCheckbox">
            <label class="form-check-label" for="firstCheckbox">
              First checkbox
            </label>
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="" id="secondCheckbox">
            <label class="form-check-label" for="secondCheckbox">
              Second checkbox
            </label>
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="" id="thirdCheckbox">
            <label class="form-check-label" for="thirdCheckbox">
              Third checkbox
            </label>
          </li>
        </ul>
        """, renderedHtml);

        // document
        uiDocumentation.document("checkboxes-and-radios", renderedHtml);

        uiDocumentation.documentSource("checkboxes-and-radios");

    }

    @Test
    void checkboxesAndRadios2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("radio")
                                                        .withName("listGroupRadio")
                                                        .withValue("")
                                                        .withId("firstRadio")
                                                        .withCondChecked(true),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("firstRadio")
                                                        .with(
                                                                text("First radio")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("radio")
                                                        .withName("listGroupRadio")
                                                        .withValue("")
                                                        .withId("secondRadio"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("secondRadio")
                                                        .with(
                                                                text("Second radio")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("radio")
                                                        .withName("listGroupRadio")
                                                        .withValue("")
                                                        .withId("thirdRadio"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("thirdRadio")
                                                        .with(
                                                                text("Third radio")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="list-group">
          <li class="list-group-item">
            <input class="form-check-input me-1" type="radio" name="listGroupRadio" value="" id="firstRadio" checked>
            <label class="form-check-label" for="firstRadio">
              First radio
            </label>
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="radio" name="listGroupRadio" value="" id="secondRadio">
            <label class="form-check-label" for="secondRadio">
              Second radio
            </label>
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="radio" name="listGroupRadio" value="" id="thirdRadio">
            <label class="form-check-label" for="thirdRadio">
              Third radio
            </label>
          </li>
        </ul>
        """, renderedHtml);

        // document
        uiDocumentation.document("checkboxes-and-radios2", renderedHtml);

        uiDocumentation.documentSource("checkboxes-and-radios2");

    }

    @Test
    void checkboxesAndRadios3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(Bootstrap.list_group)
                        .with(
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("checkbox")
                                                        .withValue("")
                                                        .withId("firstCheckboxStretched"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label, Bootstrap.stretched_link)
                                                        .withFor("firstCheckboxStretched")
                                                        .with(
                                                                text("First checkbox")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("checkbox")
                                                        .withValue("")
                                                        .withId("secondCheckboxStretched"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label, Bootstrap.stretched_link)
                                                        .withFor("secondCheckboxStretched")
                                                        .with(
                                                                text("Second checkbox")
                                                        )
                                        ),
                                li()
                                        .withClasses(Bootstrap.list_group_item)
                                        .with(
                                                input()
                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.me_1)
                                                        .withType("checkbox")
                                                        .withValue("")
                                                        .withId("thirdCheckboxStretched"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label, Bootstrap.stretched_link)
                                                        .withFor("thirdCheckboxStretched")
                                                        .with(
                                                                text("Third checkbox")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="list-group">
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="" id="firstCheckboxStretched">
            <label class="form-check-label stretched-link" for="firstCheckboxStretched">
              First checkbox
            </label>
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="" id="secondCheckboxStretched">
            <label class="form-check-label stretched-link" for="secondCheckboxStretched">
              Second checkbox
            </label>
          </li>
          <li class="list-group-item">
            <input class="form-check-input me-1" type="checkbox" value="" id="thirdCheckboxStretched">
            <label class="form-check-label stretched-link" for="thirdCheckboxStretched">
              Third checkbox
            </label>
          </li>
        </ul>
        """, renderedHtml);

        // document
        uiDocumentation.document("checkboxes-and-radios3", renderedHtml);

        uiDocumentation.documentSource("checkboxes-and-radios3");

    }


}
