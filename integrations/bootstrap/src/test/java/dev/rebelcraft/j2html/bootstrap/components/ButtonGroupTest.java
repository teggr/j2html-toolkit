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

class ButtonGroupTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void basicExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                 .withClasses(Bootstrap.btn_group)
                 .attr(AriaRoles.roleGroup)
                 .attr(
                    AriaStatesAndProperties.ariaLabel("Basic example")
                  )
                 .with(
                    button()
                     .withType("button")
                     .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                     .with(
                        text("Left")
                      ),
                    button()
                     .withType("button")
                     .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                     .with(
                        text("Middle")
                      ),
                    button()
                     .withType("button")
                     .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                     .with(
                        text("Right")
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <div class="btn-group" role="group" aria-label="Basic example">
              <button type="button" class="btn btn-primary">
                Left
              </button>
              <button type="button" class="btn btn-primary">
                Middle
              </button>
              <button type="button" class="btn btn-primary">
                Right
              </button>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("basic-example", renderedHtml);

        uiDocumentation.documentSource("basic-example");

    }

    @Test
    void basicExample2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .with(
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("page")
                                        )
                                        .with(
                                                text("Active link")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Link")
                                        ),
                                a()
                                        .withHref("#")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Link")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group">
                  <a href="#" class="btn btn-primary active" aria-current="page">
                    Active link
                  </a>
                  <a href="#" class="btn btn-primary">
                    Link
                  </a>
                  <a href="#" class="btn btn-primary">
                    Link
                  </a>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("basic-example2", renderedHtml);

        uiDocumentation.documentSource("basic-example2");

    }

    @Test
    void mixedStyles() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .attr(AriaRoles.roleGroup)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Basic mixed styles example")
                        )
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_danger)
                                        .with(
                                                text("Left")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_warning)
                                        .with(
                                                text("Middle")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_success)
                                        .with(
                                                text("Right")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                  <button type="button" class="btn btn-danger">
                    Left
                  </button>
                  <button type="button" class="btn btn-warning">
                    Middle
                  </button>
                  <button type="button" class="btn btn-success">
                    Right
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("mixed-styles", renderedHtml);

        uiDocumentation.documentSource("mixed-styles");

    }


    @Test
    void outlinedStyles() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .attr(AriaRoles.roleGroup)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Basic outlined example")
                        )
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .with(
                                                text("Left")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .with(
                                                text("Middle")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .with(
                                                text("Right")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="btn-group" role="group" aria-label="Basic outlined example">
              <button type="button" class="btn btn-outline-primary">
                Left
              </button>
              <button type="button" class="btn btn-outline-primary">
                Middle
              </button>
              <button type="button" class="btn btn-outline-primary">
                Right
              </button>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("outlined-styles", renderedHtml);

        uiDocumentation.documentSource("outlined-styles");

    }

    @Test
    void checkboxAndRadioButtonGroups() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .attr(AriaRoles.roleGroup)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Basic checkbox toggle button group")
                        )
                        .with(
                                input()
                                        .withType("checkbox")
                                        .withClasses(Bootstrap.btn_check)
                                        .withId("btncheck1")
                                        .attr("autocomplete","off"),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .withFor("btncheck1")
                                        .with(
                                                text("Checkbox 1")
                                        ),
                                input()
                                        .withType("checkbox")
                                        .withClasses(Bootstrap.btn_check)
                                        .withId("btncheck2")
                                        .attr("autocomplete","off"),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .withFor("btncheck2")
                                        .with(
                                                text("Checkbox 2")
                                        ),
                                input()
                                        .withType("checkbox")
                                        .withClasses(Bootstrap.btn_check)
                                        .withId("btncheck3")
                                        .attr("autocomplete","off"),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .withFor("btncheck3")
                                        .with(
                                                text("Checkbox 3")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
                  <input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off">
                  <label class="btn btn-outline-primary" for="btncheck1">
                    Checkbox 1
                  </label>
                  <input type="checkbox" class="btn-check" id="btncheck2" autocomplete="off">
                  <label class="btn btn-outline-primary" for="btncheck2">
                    Checkbox 2
                  </label>
                  <input type="checkbox" class="btn-check" id="btncheck3" autocomplete="off">
                  <label class="btn btn-outline-primary" for="btncheck3">
                    Checkbox 3
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("checkbox-and-radio-button-groups", renderedHtml);

        uiDocumentation.documentSource("checkbox-and-radio-button-groups");

    }

    @Test
    void checkboxAndRadioButtonGroups2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .attr(AriaRoles.roleGroup)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Basic radio toggle button group")
                        )
                        .with(
                                input()
                                        .withType("radio")
                                        .withClasses(Bootstrap.btn_check)
                                        .withName("btnradio")
                                        .withId("btnradio1")
                                        .attr("autocomplete","off")
                                        .withCondChecked(true),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .withFor("btnradio1")
                                        .with(
                                                text("Radio 1")
                                        ),
                                input()
                                        .withType("radio")
                                        .withClasses(Bootstrap.btn_check)
                                        .withName("btnradio")
                                        .withId("btnradio2")
                                        .attr("autocomplete","off"),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .withFor("btnradio2")
                                        .with(
                                                text("Radio 2")
                                        ),
                                input()
                                        .withType("radio")
                                        .withClasses(Bootstrap.btn_check)
                                        .withName("btnradio")
                                        .withId("btnradio3")
                                        .attr("autocomplete","off"),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                        .withFor("btnradio3")
                                        .with(
                                                text("Radio 3")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                  <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" checked>
                  <label class="btn btn-outline-primary" for="btnradio1">
                    Radio 1
                  </label>
                  <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
                  <label class="btn btn-outline-primary" for="btnradio2">
                    Radio 2
                  </label>
                  <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off">
                  <label class="btn btn-outline-primary" for="btnradio3">
                    Radio 3
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("checkbox-and-radio-button-groups2", renderedHtml);

        uiDocumentation.documentSource("checkbox-and-radio-button-groups2");

    }


    @Test
    void buttonToolbar() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_toolbar)
                        .attr(AriaRoles.roleToolbar)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Toolbar with button groups")
                        )
                        .with(
                                div()
                                        .withClasses(Bootstrap.btn_group, Bootstrap.me_2)
                                        .attr(AriaRoles.roleGroup)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("First group")
                                        )
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("1")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("2")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("3")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("4")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.btn_group, Bootstrap.me_2)
                                        .attr(AriaRoles.roleGroup)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Second group")
                                        )
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                        .with(
                                                                text("5")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                        .with(
                                                                text("6")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                                        .with(
                                                                text("7")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.btn_group)
                                        .attr(AriaRoles.roleGroup)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Third group")
                                        )
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_info)
                                                        .with(
                                                                text("8")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                  <div class="btn-group me-2" role="group" aria-label="First group">
                    <button type="button" class="btn btn-primary">
                      1
                    </button>
                    <button type="button" class="btn btn-primary">
                      2
                    </button>
                    <button type="button" class="btn btn-primary">
                      3
                    </button>
                    <button type="button" class="btn btn-primary">
                      4
                    </button>
                  </div>
                  <div class="btn-group me-2" role="group" aria-label="Second group">
                    <button type="button" class="btn btn-secondary">
                      5
                    </button>
                    <button type="button" class="btn btn-secondary">
                      6
                    </button>
                    <button type="button" class="btn btn-secondary">
                      7
                    </button>
                  </div>
                  <div class="btn-group" role="group" aria-label="Third group">
                    <button type="button" class="btn btn-info">
                      8
                    </button>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("button-toolbar", renderedHtml);

        uiDocumentation.documentSource("button-toolbar");

    }

    @Test
    void buttonToolbar2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.btn_toolbar, Bootstrap.mb_3)
                                .attr(AriaRoles.roleToolbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Toolbar with button groups")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.btn_group, Bootstrap.me_2)
                                                .attr(AriaRoles.roleGroup)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("First group")
                                                )
                                                .with(
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                                .with(
                                                                        text("1")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                                .with(
                                                                        text("2")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                                .with(
                                                                        text("3")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                                .with(
                                                                        text("4")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.input_group)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.input_group_text)
                                                                .withId("btnGroupAddon")
                                                                .with(
                                                                        text("@")
                                                                ),
                                                        input()
                                                                .withType("text")
                                                                .withClasses(Bootstrap.form_control)
                                                                .withPlaceholder("Input group example")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Input group example")
                                                                )
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaDescribedby("btnGroupAddon")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.btn_toolbar, Bootstrap.justify_content_between)
                                .attr(AriaRoles.roleToolbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Toolbar with button groups")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.btn_group)
                                                .attr(AriaRoles.roleGroup)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("First group")
                                                )
                                                .with(
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                                .with(
                                                                        text("1")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                                .with(
                                                                        text("2")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                                .with(
                                                                        text("3")
                                                                ),
                                                        button()
                                                                .withType("button")
                                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                                .with(
                                                                        text("4")
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.input_group)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.input_group_text)
                                                                .withId("btnGroupAddon2")
                                                                .with(
                                                                        text("@")
                                                                ),
                                                        input()
                                                                .withType("text")
                                                                .withClasses(Bootstrap.form_control)
                                                                .withPlaceholder("Input group example")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Input group example")
                                                                )
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaDescribedby("btnGroupAddon2")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
                  <div class="btn-group me-2" role="group" aria-label="First group">
                    <button type="button" class="btn btn-outline-secondary">
                      1
                    </button>
                    <button type="button" class="btn btn-outline-secondary">
                      2
                    </button>
                    <button type="button" class="btn btn-outline-secondary">
                      3
                    </button>
                    <button type="button" class="btn btn-outline-secondary">
                      4
                    </button>
                  </div>
                  <div class="input-group">
                    <div class="input-group-text" id="btnGroupAddon">
                      @
                    </div>
                    <input type="text" class="form-control" placeholder="Input group example" aria-label="Input group example" aria-describedby="btnGroupAddon">
                  </div>
                </div>
                <div class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups">
                  <div class="btn-group" role="group" aria-label="First group">
                    <button type="button" class="btn btn-outline-secondary">
                      1
                    </button>
                    <button type="button" class="btn btn-outline-secondary">
                      2
                    </button>
                    <button type="button" class="btn btn-outline-secondary">
                      3
                    </button>
                    <button type="button" class="btn btn-outline-secondary">
                      4
                    </button>
                  </div>
                  <div class="input-group">
                    <div class="input-group-text" id="btnGroupAddon2">
                      @
                    </div>
                    <input type="text" class="form-control" placeholder="Input group example" aria-label="Input group example" aria-describedby="btnGroupAddon2">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("button-toolbar2", renderedHtml);

        uiDocumentation.documentSource("button-toolbar2");

    }

    @Test
    void sizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.btn_group_lg)
                                .attr(AriaRoles.roleGroup)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Large button group")
                                )
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Left")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Middle")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Right")
                                                )
                                ),
                        br(),
                        div()
                                .withClasses(Bootstrap.btn_group)
                                .attr(AriaRoles.roleGroup)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Default button group")
                                )
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Left")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Middle")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Right")
                                                )
                                ),
                        br(),
                        div()
                                .withClasses(Bootstrap.btn_group, Bootstrap.btn_group_sm)
                                .attr(AriaRoles.roleGroup)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Small button group")
                                )
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Left")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Middle")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                                .with(
                                                        text("Right")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group btn-group-lg" role="group" aria-label="Large button group">
                  <button type="button" class="btn btn-outline-primary">
                    Left
                  </button>
                  <button type="button" class="btn btn-outline-primary">
                    Middle
                  </button>
                  <button type="button" class="btn btn-outline-primary">
                    Right
                  </button>
                </div>
                <br>
                <div class="btn-group" role="group" aria-label="Default button group">
                  <button type="button" class="btn btn-outline-primary">
                    Left
                  </button>
                  <button type="button" class="btn btn-outline-primary">
                    Middle
                  </button>
                  <button type="button" class="btn btn-outline-primary">
                    Right
                  </button>
                </div>
                <br>
                <div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
                  <button type="button" class="btn btn-outline-primary">
                    Left
                  </button>
                  <button type="button" class="btn btn-outline-primary">
                    Middle
                  </button>
                  <button type="button" class="btn btn-outline-primary">
                    Right
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizing", renderedHtml);

        uiDocumentation.documentSource("sizing");

    }

    @Test
    void nesting() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group)
                        .attr(AriaRoles.roleGroup)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Button group with nested dropdown")
                        )
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("1")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("2")
                                        ),
                                div()
                                        .withClasses(Bootstrap.btn_group)
                                        .attr(AriaRoles.roleGroup)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.dropdown_toggle)
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
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                  <button type="button" class="btn btn-primary">
                    1
                  </button>
                  <button type="button" class="btn btn-primary">
                    2
                  </button>
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                      Dropdown
                    </button>
                    <ul class="dropdown-menu">
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("nesting", renderedHtml);

        uiDocumentation.documentSource("nesting");

    }

    @Test
    void verticalVariation() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group_vertical)
                        .attr(AriaRoles.roleGroup)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Vertical button group")
                        )
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Button")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Button")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Button")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Button")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                  <button type="button" class="btn btn-primary">
                    Button
                  </button>
                  <button type="button" class="btn btn-primary">
                    Button
                  </button>
                  <button type="button" class="btn btn-primary">
                    Button
                  </button>
                  <button type="button" class="btn btn-primary">
                    Button
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-variation", renderedHtml);

        uiDocumentation.documentSource("vertical-variation");

    }

    @Test
    void verticalVariation2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group_vertical)
                        .attr(AriaRoles.roleGroup)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Vertical button group")
                        )
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Button")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Button")
                                        ),
                                div()
                                        .withClasses(Bootstrap.btn_group)
                                        .attr(AriaRoles.roleGroup)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.dropdown_toggle)
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
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses("btn-group","dropstart")
                                        .attr(AriaRoles.roleGroup)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.dropdown_toggle)
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
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.btn_group, Bootstrap.dropend)
                                        .attr(AriaRoles.roleGroup)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.dropdown_toggle)
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
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.btn_group, Bootstrap.dropup)
                                        .attr(AriaRoles.roleGroup)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.dropdown_toggle)
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
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Bootstrap.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Dropdown link")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group-vertical" role="group" aria-label="Vertical button group">
                  <button type="button" class="btn btn-primary">
                    Button
                  </button>
                  <button type="button" class="btn btn-primary">
                    Button
                  </button>
                  <div class="btn-group" role="group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                      Dropdown
                    </button>
                    <ul class="dropdown-menu">
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="btn-group dropstart" role="group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                      Dropdown
                    </button>
                    <ul class="dropdown-menu">
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="btn-group dropend" role="group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                      Dropdown
                    </button>
                    <ul class="dropdown-menu">
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="btn-group dropup" role="group">
                    <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                      Dropdown
                    </button>
                    <ul class="dropdown-menu">
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Dropdown link
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-variation2", renderedHtml);

        uiDocumentation.documentSource("vertical-variation2");

    }

    @Test
    void verticalVariation3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.btn_group_vertical)
                        .attr(AriaRoles.roleGroup)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Vertical radio toggle button group")
                        )
                        .with(
                                input()
                                        .withType("radio")
                                        .withClasses(Bootstrap.btn_check)
                                        .withName("vbtn-radio")
                                        .withId("vbtn-radio1")
                                        .attr("autocomplete","off")
                                        .withCondChecked(true),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_danger)
                                        .withFor("vbtn-radio1")
                                        .with(
                                                text("Radio 1")
                                        ),
                                input()
                                        .withType("radio")
                                        .withClasses(Bootstrap.btn_check)
                                        .withName("vbtn-radio")
                                        .withId("vbtn-radio2")
                                        .attr("autocomplete","off"),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_danger)
                                        .withFor("vbtn-radio2")
                                        .with(
                                                text("Radio 2")
                                        ),
                                input()
                                        .withType("radio")
                                        .withClasses(Bootstrap.btn_check)
                                        .withName("vbtn-radio")
                                        .withId("vbtn-radio3")
                                        .attr("autocomplete","off"),
                                label()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_outline_danger)
                                        .withFor("vbtn-radio3")
                                        .with(
                                                text("Radio 3")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="btn-group-vertical" role="group" aria-label="Vertical radio toggle button group">
                  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio1" autocomplete="off" checked>
                  <label class="btn btn-outline-danger" for="vbtn-radio1">
                    Radio 1
                  </label>
                  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio2" autocomplete="off">
                  <label class="btn btn-outline-danger" for="vbtn-radio2">
                    Radio 2
                  </label>
                  <input type="radio" class="btn-check" name="vbtn-radio" id="vbtn-radio3" autocomplete="off">
                  <label class="btn btn-outline-danger" for="vbtn-radio3">
                    Radio 3
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-variation3", renderedHtml);

        uiDocumentation.documentSource("vertical-variation3");

    }


}
