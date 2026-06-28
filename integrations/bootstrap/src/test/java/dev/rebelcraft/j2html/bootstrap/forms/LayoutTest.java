package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LayoutTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void utilities() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                      div()
                       .withClasses(Bootstrap.mb_3)
                       .with(
                          label()
                           .withFor("formGroupExampleInput")
                           .withClasses(Bootstrap.form_label)
                           .with(
                              text("Example label")
                            ),
                          input()
                           .withType("text")
                           .withClasses(Bootstrap.form_control)
                           .withId("formGroupExampleInput")
                           .withPlaceholder("Example input placeholder")
                        ),
                      div()
                       .withClasses(Bootstrap.mb_3)
                       .with(
                          label()
                           .withFor("formGroupExampleInput2")
                           .withClasses(Bootstrap.form_label)
                           .with(
                              text("Another label")
                            ),
                          input()
                           .withType("text")
                           .withClasses(Bootstrap.form_control)
                           .withId("formGroupExampleInput2")
                           .withPlaceholder("Another input placeholder")
                        )
                    )
                );

        //language=HTML
        assertEquals("""
                <div class="mb-3">
                  <label for="formGroupExampleInput" class="form-label">
                    Example label
                  </label>
                  <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Example input placeholder">
                </div>
                <div class="mb-3">
                  <label for="formGroupExampleInput2" class="form-label">
                    Another label
                  </label>
                  <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Another input placeholder">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("utilities", renderedHtml);

        uiDocumentation.documentSource("utilities");

    }

    @Test
    void formGrid() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withPlaceholder("First name")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("First name")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withPlaceholder("Last name")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Last name")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row">
                  <div class="col">
                    <input type="text" class="form-control" placeholder="First name" aria-label="First name">
                  </div>
                  <div class="col">
                    <input type="text" class="form-control" placeholder="Last name" aria-label="Last name">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("form-grid", renderedHtml);

        uiDocumentation.documentSource("form-grid");

    }

    @Test
    void gutters() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.g_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withPlaceholder("First name")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("First name")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withPlaceholder("Last name")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Last name")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row g-3">
                  <div class="col">
                    <input type="text" class="form-control" placeholder="First name" aria-label="First name">
                  </div>
                  <div class="col">
                    <input type="text" class="form-control" placeholder="Last name" aria-label="Last name">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("gutters", renderedHtml);

        uiDocumentation.documentSource("gutters");

    }

    @Test
    void gutters2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.row, Bootstrap.g_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_md_6)
                                        .with(
                                                label()
                                                        .withFor("inputEmail4")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Email")
                                                        ),
                                                input()
                                                        .withType("email")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("inputEmail4")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_6)
                                        .with(
                                                label()
                                                        .withFor("inputPassword4")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Password")
                                                        ),
                                                input()
                                                        .withType("password")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("inputPassword4")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                label()
                                                        .withFor("inputAddress")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Address")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("inputAddress")
                                                        .withPlaceholder("1234 Main St")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                label()
                                                        .withFor("inputAddress2")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Address 2")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("inputAddress2")
                                                        .withPlaceholder("Apartment, studio, or floor")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_6)
                                        .with(
                                                label()
                                                        .withFor("inputCity")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("City")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("inputCity")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_4)
                                        .with(
                                                label()
                                                        .withFor("inputState")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("State")
                                                        ),
                                                select()
                                                        .withId("inputState")
                                                        .withClasses(Bootstrap.form_select)
                                                        .with(
                                                                option()
                                                                        .withCondSelected(true)
                                                                        .with(
                                                                                text("Choose...")
                                                                        ),
                                                                option()
                                                                        .with(
                                                                                text("...")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_2)
                                        .with(
                                                label()
                                                        .withFor("inputZip")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Zip")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("inputZip")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.form_check)
                                                        .with(
                                                                input()
                                                                        .withClasses(Bootstrap.form_check_input)
                                                                        .withType("checkbox")
                                                                        .withId("gridCheck"),
                                                                label()
                                                                        .withClasses(Bootstrap.form_check_label)
                                                                        .withFor("gridCheck")
                                                                        .with(
                                                                                text("Check me out")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
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
                <form class="row g-3">
                  <div class="col-md-6">
                    <label for="inputEmail4" class="form-label">
                      Email
                    </label>
                    <input type="email" class="form-control" id="inputEmail4">
                  </div>
                  <div class="col-md-6">
                    <label for="inputPassword4" class="form-label">
                      Password
                    </label>
                    <input type="password" class="form-control" id="inputPassword4">
                  </div>
                  <div class="col-12">
                    <label for="inputAddress" class="form-label">
                      Address
                    </label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                  </div>
                  <div class="col-12">
                    <label for="inputAddress2" class="form-label">
                      Address 2
                    </label>
                    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
                  </div>
                  <div class="col-md-6">
                    <label for="inputCity" class="form-label">
                      City
                    </label>
                    <input type="text" class="form-control" id="inputCity">
                  </div>
                  <div class="col-md-4">
                    <label for="inputState" class="form-label">
                      State
                    </label>
                    <select id="inputState" class="form-select">
                      <option selected>
                        Choose...
                      </option>
                      <option>
                        ...
                      </option>
                    </select>
                  </div>
                  <div class="col-md-2">
                    <label for="inputZip" class="form-label">
                      Zip
                    </label>
                    <input type="text" class="form-control" id="inputZip">
                  </div>
                  <div class="col-12">
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" id="gridCheck">
                      <label class="form-check-label" for="gridCheck">
                        Check me out
                      </label>
                    </div>
                  </div>
                  <div class="col-12">
                    <button type="submit" class="btn btn-primary">
                      Sign in
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("gutters2", renderedHtml);

        uiDocumentation.documentSource("gutters2");

    }

    @Test
    void horizontalForm() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .with(
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.mb_3)
                                        .with(
                                                label()
                                                        .withFor("inputEmail3")
                                                        .withClasses(Bootstrap.col_sm_2, Bootstrap.col_form_label)
                                                        .with(
                                                                text("Email")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.col_sm_10)
                                                        .with(
                                                                input()
                                                                        .withType("email")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("inputEmail3")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.mb_3)
                                        .with(
                                                label()
                                                        .withFor("inputPassword3")
                                                        .withClasses(Bootstrap.col_sm_2, Bootstrap.col_form_label)
                                                        .with(
                                                                text("Password")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.col_sm_10)
                                                        .with(
                                                                input()
                                                                        .withType("password")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("inputPassword3")
                                                        )
                                        ),
                                fieldset()
                                        .withClasses(Bootstrap.row, Bootstrap.mb_3)
                                        .with(
                                                legend()
                                                        .withClasses(Bootstrap.col_form_label, Bootstrap.col_sm_2, Bootstrap.pt_0)
                                                        .with(
                                                                text("Radios")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.col_sm_10)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.form_check)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(Bootstrap.form_check_input)
                                                                                        .withType("radio")
                                                                                        .withName("gridRadios")
                                                                                        .withId("gridRadios1")
                                                                                        .withValue("option1")
                                                                                        .withCondChecked(true),
                                                                                label()
                                                                                        .withClasses(Bootstrap.form_check_label)
                                                                                        .withFor("gridRadios1")
                                                                                        .with(
                                                                                                text("First radio")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Bootstrap.form_check)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(Bootstrap.form_check_input)
                                                                                        .withType("radio")
                                                                                        .withName("gridRadios")
                                                                                        .withId("gridRadios2")
                                                                                        .withValue("option2"),
                                                                                label()
                                                                                        .withClasses(Bootstrap.form_check_label)
                                                                                        .withFor("gridRadios2")
                                                                                        .with(
                                                                                                text("Second radio")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Bootstrap.form_check, Bootstrap.disabled)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(Bootstrap.form_check_input)
                                                                                        .withType("radio")
                                                                                        .withName("gridRadios")
                                                                                        .withId("gridRadios3")
                                                                                        .withValue("option3")
                                                                                        .withCondDisabled(true),
                                                                                label()
                                                                                        .withClasses(Bootstrap.form_check_label)
                                                                                        .withFor("gridRadios3")
                                                                                        .with(
                                                                                                text("Third disabled radio")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.row, Bootstrap.mb_3)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.col_sm_10, Bootstrap.offset_sm_2)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.form_check)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(Bootstrap.form_check_input)
                                                                                        .withType("checkbox")
                                                                                        .withId("gridCheck1"),
                                                                                label()
                                                                                        .withClasses(Bootstrap.form_check_label)
                                                                                        .withFor("gridCheck1")
                                                                                        .with(
                                                                                                text("Example checkbox")
                                                                                        )
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
        );

        //language=HTML
        assertEquals("""
                <form>
                  <div class="row mb-3">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">
                      Email
                    </label>
                    <div class="col-sm-10">
                      <input type="email" class="form-control" id="inputEmail3">
                    </div>
                  </div>
                  <div class="row mb-3">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">
                      Password
                    </label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="inputPassword3">
                    </div>
                  </div>
                  <fieldset class="row mb-3">
                    <legend class="col-form-label col-sm-2 pt-0">
                      Radios
                    </legend>
                    <div class="col-sm-10">
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
                        <label class="form-check-label" for="gridRadios1">
                          First radio
                        </label>
                      </div>
                      <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
                        <label class="form-check-label" for="gridRadios2">
                          Second radio
                        </label>
                      </div>
                      <div class="form-check disabled">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
                        <label class="form-check-label" for="gridRadios3">
                          Third disabled radio
                        </label>
                      </div>
                    </div>
                  </fieldset>
                  <div class="row mb-3">
                    <div class="col-sm-10 offset-sm-2">
                      <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="gridCheck1">
                        <label class="form-check-label" for="gridCheck1">
                          Example checkbox
                        </label>
                      </div>
                    </div>
                  </div>
                  <button type="submit" class="btn btn-primary">
                    Sign in
                  </button>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-form", renderedHtml);

        uiDocumentation.documentSource("horizontal-form");

    }

    @Test
    void horizontalFormLabelSizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.row, Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("colFormLabelSm")
                                                .withClasses(Bootstrap.col_sm_2, Bootstrap.col_form_label, Bootstrap.col_form_label_sm)
                                                .with(
                                                        text("Email")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.col_sm_10)
                                                .with(
                                                        input()
                                                                .withType("email")
                                                                .withClasses(Bootstrap.form_control, Bootstrap.form_control_sm)
                                                                .withId("colFormLabelSm")
                                                                .withPlaceholder("col-form-label-sm")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.row, Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("colFormLabel")
                                                .withClasses(Bootstrap.col_sm_2, Bootstrap.col_form_label)
                                                .with(
                                                        text("Email")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.col_sm_10)
                                                .with(
                                                        input()
                                                                .withType("email")
                                                                .withClasses(Bootstrap.form_control)
                                                                .withId("colFormLabel")
                                                                .withPlaceholder("col-form-label")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.row)
                                .with(
                                        label()
                                                .withFor("colFormLabelLg")
                                                .withClasses(Bootstrap.col_sm_2, Bootstrap.col_form_label, Bootstrap.col_form_label_lg)
                                                .with(
                                                        text("Email")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.col_sm_10)
                                                .with(
                                                        input()
                                                                .withType("email")
                                                                .withClasses(Bootstrap.form_control, Bootstrap.form_control_lg)
                                                                .withId("colFormLabelLg")
                                                                .withPlaceholder("col-form-label-lg")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="row mb-3">
                  <label for="colFormLabelSm" class="col-sm-2 col-form-label col-form-label-sm">
                    Email
                  </label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control form-control-sm" id="colFormLabelSm" placeholder="col-form-label-sm">
                  </div>
                </div>
                <div class="row mb-3">
                  <label for="colFormLabel" class="col-sm-2 col-form-label">
                    Email
                  </label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="colFormLabel" placeholder="col-form-label">
                  </div>
                </div>
                <div class="row">
                  <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">
                    Email
                  </label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control form-control-lg" id="colFormLabelLg" placeholder="col-form-label-lg">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-form-label-sizing", renderedHtml);

        uiDocumentation.documentSource("horizontal-form-label-sizing");

    }

    @Test
    void columnSizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.g_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_sm_7)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withPlaceholder("City")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("City")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_sm)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withPlaceholder("State")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("State")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_sm)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withPlaceholder("Zip")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Zip")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row g-3">
                  <div class="col-sm-7">
                    <input type="text" class="form-control" placeholder="City" aria-label="City">
                  </div>
                  <div class="col-sm">
                    <input type="text" class="form-control" placeholder="State" aria-label="State">
                  </div>
                  <div class="col-sm">
                    <input type="text" class="form-control" placeholder="Zip" aria-label="Zip">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("column-sizing", renderedHtml);

        uiDocumentation.documentSource("column-sizing");

    }

    @Test
    void autoSizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.row, Bootstrap.gy_2, Bootstrap.gx_3, Bootstrap.align_items_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                label()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .withFor("autoSizingInput")
                                                        .with(
                                                                text("Name")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("autoSizingInput")
                                                        .withPlaceholder("Jane Doe")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                label()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .withFor("autoSizingInputGroup")
                                                        .with(
                                                                text("Username")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.input_group)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.input_group_text)
                                                                        .with(
                                                                                text("@")
                                                                        ),
                                                                input()
                                                                        .withType("text")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("autoSizingInputGroup")
                                                                        .withPlaceholder("Username")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                label()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .withFor("autoSizingSelect")
                                                        .with(
                                                                text("Preference")
                                                        ),
                                                select()
                                                        .withClasses(Bootstrap.form_select)
                                                        .withId("autoSizingSelect")
                                                        .with(
                                                                option()
                                                                        .withCondSelected(true)
                                                                        .with(
                                                                                text("Choose...")
                                                                        ),
                                                                option()
                                                                        .withValue("1")
                                                                        .with(
                                                                                text("One")
                                                                        ),
                                                                option()
                                                                        .withValue("2")
                                                                        .with(
                                                                                text("Two")
                                                                        ),
                                                                option()
                                                                        .withValue("3")
                                                                        .with(
                                                                                text("Three")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.form_check)
                                                        .with(
                                                                input()
                                                                        .withClasses(Bootstrap.form_check_input)
                                                                        .withType("checkbox")
                                                                        .withId("autoSizingCheck"),
                                                                label()
                                                                        .withClasses(Bootstrap.form_check_label)
                                                                        .withFor("autoSizingCheck")
                                                                        .with(
                                                                                text("Remember me")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                button()
                                                        .withType("submit")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Submit")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="row gy-2 gx-3 align-items-center">
                  <div class="col-auto">
                    <label class="visually-hidden" for="autoSizingInput">
                      Name
                    </label>
                    <input type="text" class="form-control" id="autoSizingInput" placeholder="Jane Doe">
                  </div>
                  <div class="col-auto">
                    <label class="visually-hidden" for="autoSizingInputGroup">
                      Username
                    </label>
                    <div class="input-group">
                      <div class="input-group-text">
                        @
                      </div>
                      <input type="text" class="form-control" id="autoSizingInputGroup" placeholder="Username">
                    </div>
                  </div>
                  <div class="col-auto">
                    <label class="visually-hidden" for="autoSizingSelect">
                      Preference
                    </label>
                    <select class="form-select" id="autoSizingSelect">
                      <option selected>
                        Choose...
                      </option>
                      <option value="1">
                        One
                      </option>
                      <option value="2">
                        Two
                      </option>
                      <option value="3">
                        Three
                      </option>
                    </select>
                  </div>
                  <div class="col-auto">
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" id="autoSizingCheck">
                      <label class="form-check-label" for="autoSizingCheck">
                        Remember me
                      </label>
                    </div>
                  </div>
                  <div class="col-auto">
                    <button type="submit" class="btn btn-primary">
                      Submit
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("auto-sizing", renderedHtml);

        uiDocumentation.documentSource("auto-sizing");

    }

    @Test
    void autoSizing2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.row, Bootstrap.gx_3, Bootstrap.gy_2, Bootstrap.align_items_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_sm_3)
                                        .with(
                                                label()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .withFor("specificSizeInputName")
                                                        .with(
                                                                text("Name")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("specificSizeInputName")
                                                        .withPlaceholder("Jane Doe")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_sm_3)
                                        .with(
                                                label()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .withFor("specificSizeInputGroupUsername")
                                                        .with(
                                                                text("Username")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.input_group)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.input_group_text)
                                                                        .with(
                                                                                text("@")
                                                                        ),
                                                                input()
                                                                        .withType("text")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("specificSizeInputGroupUsername")
                                                                        .withPlaceholder("Username")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_sm_3)
                                        .with(
                                                label()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .withFor("specificSizeSelect")
                                                        .with(
                                                                text("Preference")
                                                        ),
                                                select()
                                                        .withClasses(Bootstrap.form_select)
                                                        .withId("specificSizeSelect")
                                                        .with(
                                                                option()
                                                                        .withCondSelected(true)
                                                                        .with(
                                                                                text("Choose...")
                                                                        ),
                                                                option()
                                                                        .withValue("1")
                                                                        .with(
                                                                                text("One")
                                                                        ),
                                                                option()
                                                                        .withValue("2")
                                                                        .with(
                                                                                text("Two")
                                                                        ),
                                                                option()
                                                                        .withValue("3")
                                                                        .with(
                                                                                text("Three")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.form_check)
                                                        .with(
                                                                input()
                                                                        .withClasses(Bootstrap.form_check_input)
                                                                        .withType("checkbox")
                                                                        .withId("autoSizingCheck2"),
                                                                label()
                                                                        .withClasses(Bootstrap.form_check_label)
                                                                        .withFor("autoSizingCheck2")
                                                                        .with(
                                                                                text("Remember me")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                button()
                                                        .withType("submit")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Submit")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="row gx-3 gy-2 align-items-center">
                  <div class="col-sm-3">
                    <label class="visually-hidden" for="specificSizeInputName">
                      Name
                    </label>
                    <input type="text" class="form-control" id="specificSizeInputName" placeholder="Jane Doe">
                  </div>
                  <div class="col-sm-3">
                    <label class="visually-hidden" for="specificSizeInputGroupUsername">
                      Username
                    </label>
                    <div class="input-group">
                      <div class="input-group-text">
                        @
                      </div>
                      <input type="text" class="form-control" id="specificSizeInputGroupUsername" placeholder="Username">
                    </div>
                  </div>
                  <div class="col-sm-3">
                    <label class="visually-hidden" for="specificSizeSelect">
                      Preference
                    </label>
                    <select class="form-select" id="specificSizeSelect">
                      <option selected>
                        Choose...
                      </option>
                      <option value="1">
                        One
                      </option>
                      <option value="2">
                        Two
                      </option>
                      <option value="3">
                        Three
                      </option>
                    </select>
                  </div>
                  <div class="col-auto">
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" id="autoSizingCheck2">
                      <label class="form-check-label" for="autoSizingCheck2">
                        Remember me
                      </label>
                    </div>
                  </div>
                  <div class="col-auto">
                    <button type="submit" class="btn btn-primary">
                      Submit
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("auto-sizing2", renderedHtml);

        uiDocumentation.documentSource("auto-sizing2");

    }

    @Test
    void inlineForms() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.row, Bootstrap.row_cols_lg_auto, Bootstrap.g_3, Bootstrap.align_items_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                label()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .withFor("inlineFormInputGroupUsername")
                                                        .with(
                                                                text("Username")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.input_group)
                                                        .with(
                                                                div()
                                                                        .withClasses(Bootstrap.input_group_text)
                                                                        .with(
                                                                                text("@")
                                                                        ),
                                                                input()
                                                                        .withType("text")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("inlineFormInputGroupUsername")
                                                                        .withPlaceholder("Username")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                label()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .withFor("inlineFormSelectPref")
                                                        .with(
                                                                text("Preference")
                                                        ),
                                                select()
                                                        .withClasses(Bootstrap.form_select)
                                                        .withId("inlineFormSelectPref")
                                                        .with(
                                                                option()
                                                                        .withCondSelected(true)
                                                                        .with(
                                                                                text("Choose...")
                                                                        ),
                                                                option()
                                                                        .withValue("1")
                                                                        .with(
                                                                                text("One")
                                                                        ),
                                                                option()
                                                                        .withValue("2")
                                                                        .with(
                                                                                text("Two")
                                                                        ),
                                                                option()
                                                                        .withValue("3")
                                                                        .with(
                                                                                text("Three")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.form_check)
                                                        .with(
                                                                input()
                                                                        .withClasses(Bootstrap.form_check_input)
                                                                        .withType("checkbox")
                                                                        .withId("inlineFormCheck"),
                                                                label()
                                                                        .withClasses(Bootstrap.form_check_label)
                                                                        .withFor("inlineFormCheck")
                                                                        .with(
                                                                                text("Remember me")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                button()
                                                        .withType("submit")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .with(
                                                                text("Submit")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <form class="row row-cols-lg-auto g-3 align-items-center">
          <div class="col-12">
            <label class="visually-hidden" for="inlineFormInputGroupUsername">
              Username
            </label>
            <div class="input-group">
              <div class="input-group-text">
                @
              </div>
              <input type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="Username">
            </div>
          </div>
          <div class="col-12">
            <label class="visually-hidden" for="inlineFormSelectPref">
              Preference
            </label>
            <select class="form-select" id="inlineFormSelectPref">
              <option selected>
                Choose...
              </option>
              <option value="1">
                One
              </option>
              <option value="2">
                Two
              </option>
              <option value="3">
                Three
              </option>
            </select>
          </div>
          <div class="col-12">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="inlineFormCheck">
              <label class="form-check-label" for="inlineFormCheck">
                Remember me
              </label>
            </div>
          </div>
          <div class="col-12">
            <button type="submit" class="btn btn-primary">
              Submit
            </button>
          </div>
        </form>
        """, renderedHtml);

        // document
        uiDocumentation.document("inline-forms", renderedHtml);

        uiDocumentation.documentSource("inline-forms");

    }


}
