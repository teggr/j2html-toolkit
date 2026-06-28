package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidationTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void customStyles() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                     .withClasses(Bootstrap.row, Bootstrap.g_3,Validation.needs_validation)
                     .withCondNovalidate(true)
                     .with(
                        div()
                         .withClasses(Bootstrap.col_md_4)
                         .with(
                            label()
                             .withFor("validationCustom01")
                             .withClasses(Bootstrap.form_label)
                             .with(
                                text("First name")
                              ),
                            input()
                             .withType("text")
                             .withClasses(Bootstrap.form_control)
                             .withId("validationCustom01")
                             .withValue("Mark")
                             .withCondRequired(true),
                            div()
                             .withClasses(Bootstrap.valid_feedback)
                             .with(
                                text("Looks good!")
                              )
                          ),
                        div()
                         .withClasses(Bootstrap.col_md_4)
                         .with(
                            label()
                             .withFor("validationCustom02")
                             .withClasses(Bootstrap.form_label)
                             .with(
                                text("Last name")
                              ),
                            input()
                             .withType("text")
                             .withClasses(Bootstrap.form_control)
                             .withId("validationCustom02")
                             .withValue("Otto")
                             .withCondRequired(true),
                            div()
                             .withClasses(Bootstrap.valid_feedback)
                             .with(
                                text("Looks good!")
                              )
                          ),
                        div()
                         .withClasses(Bootstrap.col_md_4)
                         .with(
                            label()
                             .withFor("validationCustomUsername")
                             .withClasses(Bootstrap.form_label)
                             .with(
                                text("Username")
                              ),
                            div()
                             .withClasses(Bootstrap.input_group, Bootstrap.has_validation)
                             .with(
                                span()
                                 .withClasses(Bootstrap.input_group_text)
                                 .withId("inputGroupPrepend")
                                 .with(
                                    text("@")
                                  ),
                                input()
                                 .withType("text")
                                 .withClasses(Bootstrap.form_control)
                                 .withId("validationCustomUsername")
                                 .attr(
                                    AriaStatesAndProperties.ariaDescribedby("inputGroupPrepend")
                                  )
                                 .withCondRequired(true),
                                div()
                                 .withClasses(Bootstrap.invalid_feedback)
                                 .with(
                                    text("Please choose a username.")
                                  )
                              )
                          ),
                        div()
                         .withClasses(Bootstrap.col_md_6)
                         .with(
                            label()
                             .withFor("validationCustom03")
                             .withClasses(Bootstrap.form_label)
                             .with(
                                text("City")
                              ),
                            input()
                             .withType("text")
                             .withClasses(Bootstrap.form_control)
                             .withId("validationCustom03")
                             .withCondRequired(true),
                            div()
                             .withClasses(Bootstrap.invalid_feedback)
                             .with(
                                text("Please provide a valid city.")
                              )
                          ),
                        div()
                         .withClasses(Bootstrap.col_md_3)
                         .with(
                            label()
                             .withFor("validationCustom04")
                             .withClasses(Bootstrap.form_label)
                             .with(
                                text("State")
                              ),
                            select()
                             .withClasses(Bootstrap.form_select)
                             .withId("validationCustom04")
                             .withCondRequired(true)
                             .with(
                                option()
                                 .withCondSelected(true)
                                 .withCondDisabled(true)
                                 .withValue("")
                                 .with(
                                    text("Choose...")
                                  ),
                                option()
                                 .with(
                                    text("...")
                                  )
                              ),
                            div()
                             .withClasses(Bootstrap.invalid_feedback)
                             .with(
                                text("Please select a valid state.")
                              )
                          ),
                        div()
                         .withClasses(Bootstrap.col_md_3)
                         .with(
                            label()
                             .withFor("validationCustom05")
                             .withClasses(Bootstrap.form_label)
                             .with(
                                text("Zip")
                              ),
                            input()
                             .withType("text")
                             .withClasses(Bootstrap.form_control)
                             .withId("validationCustom05")
                             .withCondRequired(true),
                            div()
                             .withClasses(Bootstrap.invalid_feedback)
                             .with(
                                text("Please provide a valid zip.")
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
                                 .withValue("")
                                 .withId("invalidCheck")
                                 .withCondRequired(true),
                                label()
                                 .withClasses(Bootstrap.form_check_label)
                                 .withFor("invalidCheck")
                                 .with(
                                    text("Agree to terms and conditions")
                                  ),
                                div()
                                 .withClasses(Bootstrap.invalid_feedback)
                                 .with(
                                    text("You must agree before submitting.")
                                  )
                              )
                          ),
                        div()
                         .withClasses(Bootstrap.col_12)
                         .with(
                            button()
                             .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                             .withType("submit")
                             .with(
                                text("Submit form")
                              )
                          )
                      )
                    );

        //language=HTML
        assertEquals("""
                <form class="row g-3 needs-validation" novalidate>
                  <div class="col-md-4">
                    <label for="validationCustom01" class="form-label">
                      First name
                    </label>
                    <input type="text" class="form-control" id="validationCustom01" value="Mark" required>
                    <div class="valid-feedback">
                      Looks good!
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationCustom02" class="form-label">
                      Last name
                    </label>
                    <input type="text" class="form-control" id="validationCustom02" value="Otto" required>
                    <div class="valid-feedback">
                      Looks good!
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationCustomUsername" class="form-label">
                      Username
                    </label>
                    <div class="input-group has-validation">
                      <span class="input-group-text" id="inputGroupPrepend">
                        @
                      </span>
                      <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
                      <div class="invalid-feedback">
                        Please choose a username.
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationCustom03" class="form-label">
                      City
                    </label>
                    <input type="text" class="form-control" id="validationCustom03" required>
                    <div class="invalid-feedback">
                      Please provide a valid city.
                    </div>
                  </div>
                  <div class="col-md-3">
                    <label for="validationCustom04" class="form-label">
                      State
                    </label>
                    <select class="form-select" id="validationCustom04" required>
                      <option selected disabled value="">
                        Choose...
                      </option>
                      <option>
                        ...
                      </option>
                    </select>
                    <div class="invalid-feedback">
                      Please select a valid state.
                    </div>
                  </div>
                  <div class="col-md-3">
                    <label for="validationCustom05" class="form-label">
                      Zip
                    </label>
                    <input type="text" class="form-control" id="validationCustom05" required>
                    <div class="invalid-feedback">
                      Please provide a valid zip.
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                      <label class="form-check-label" for="invalidCheck">
                        Agree to terms and conditions
                      </label>
                      <div class="invalid-feedback">
                        You must agree before submitting.
                      </div>
                    </div>
                  </div>
                  <div class="col-12">
                    <button class="btn btn-primary" type="submit">
                      Submit form
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("custom-styles", renderedHtml);

        uiDocumentation.documentSource("custom-styles");

    }

    @Test
    void browserDefaults() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.row, Bootstrap.g_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_md_4)
                                        .with(
                                                label()
                                                        .withFor("validationDefault01")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("First name")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationDefault01")
                                                        .withValue("Mark")
                                                        .withCondRequired(true)
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_4)
                                        .with(
                                                label()
                                                        .withFor("validationDefault02")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Last name")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationDefault02")
                                                        .withValue("Otto")
                                                        .withCondRequired(true)
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_4)
                                        .with(
                                                label()
                                                        .withFor("validationDefaultUsername")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Username")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.input_group)
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.input_group_text)
                                                                        .withId("inputGroupPrepend2")
                                                                        .with(
                                                                                text("@")
                                                                        ),
                                                                input()
                                                                        .withType("text")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("validationDefaultUsername")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaDescribedby("inputGroupPrepend2")
                                                                        )
                                                                        .withCondRequired(true)
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_6)
                                        .with(
                                                label()
                                                        .withFor("validationDefault03")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("City")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationDefault03")
                                                        .withCondRequired(true)
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_3)
                                        .with(
                                                label()
                                                        .withFor("validationDefault04")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("State")
                                                        ),
                                                select()
                                                        .withClasses(Bootstrap.form_select)
                                                        .withId("validationDefault04")
                                                        .withCondRequired(true)
                                                        .with(
                                                                option()
                                                                        .withCondSelected(true)
                                                                        .withCondDisabled(true)
                                                                        .withValue("")
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
                                        .withClasses(Bootstrap.col_md_3)
                                        .with(
                                                label()
                                                        .withFor("validationDefault05")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Zip")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationDefault05")
                                                        .withCondRequired(true)
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
                                                                        .withValue("")
                                                                        .withId("invalidCheck2")
                                                                        .withCondRequired(true),
                                                                label()
                                                                        .withClasses(Bootstrap.form_check_label)
                                                                        .withFor("invalidCheck2")
                                                                        .with(
                                                                                text("Agree to terms and conditions")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                button()
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .withType("submit")
                                                        .with(
                                                                text("Submit form")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="row g-3">
                  <div class="col-md-4">
                    <label for="validationDefault01" class="form-label">
                      First name
                    </label>
                    <input type="text" class="form-control" id="validationDefault01" value="Mark" required>
                  </div>
                  <div class="col-md-4">
                    <label for="validationDefault02" class="form-label">
                      Last name
                    </label>
                    <input type="text" class="form-control" id="validationDefault02" value="Otto" required>
                  </div>
                  <div class="col-md-4">
                    <label for="validationDefaultUsername" class="form-label">
                      Username
                    </label>
                    <div class="input-group">
                      <span class="input-group-text" id="inputGroupPrepend2">
                        @
                      </span>
                      <input type="text" class="form-control" id="validationDefaultUsername" aria-describedby="inputGroupPrepend2" required>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationDefault03" class="form-label">
                      City
                    </label>
                    <input type="text" class="form-control" id="validationDefault03" required>
                  </div>
                  <div class="col-md-3">
                    <label for="validationDefault04" class="form-label">
                      State
                    </label>
                    <select class="form-select" id="validationDefault04" required>
                      <option selected disabled value="">
                        Choose...
                      </option>
                      <option>
                        ...
                      </option>
                    </select>
                  </div>
                  <div class="col-md-3">
                    <label for="validationDefault05" class="form-label">
                      Zip
                    </label>
                    <input type="text" class="form-control" id="validationDefault05" required>
                  </div>
                  <div class="col-12">
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                      <label class="form-check-label" for="invalidCheck2">
                        Agree to terms and conditions
                      </label>
                    </div>
                  </div>
                  <div class="col-12">
                    <button class="btn btn-primary" type="submit">
                      Submit form
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("browser-defaults", renderedHtml);

        uiDocumentation.documentSource("browser-defaults");

    }

    @Test
    void serverside() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.row, Bootstrap.g_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_md_4)
                                        .with(
                                                label()
                                                        .withFor("validationServer01")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("First name")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control, Bootstrap.is_valid)
                                                        .withId("validationServer01")
                                                        .withValue("Mark")
                                                        .withCondRequired(true),
                                                div()
                                                        .withClasses(Bootstrap.valid_feedback)
                                                        .with(
                                                                text("Looks good!")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_4)
                                        .with(
                                                label()
                                                        .withFor("validationServer02")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Last name")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control, Bootstrap.is_valid)
                                                        .withId("validationServer02")
                                                        .withValue("Otto")
                                                        .withCondRequired(true),
                                                div()
                                                        .withClasses(Bootstrap.valid_feedback)
                                                        .with(
                                                                text("Looks good!")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_4)
                                        .with(
                                                label()
                                                        .withFor("validationServerUsername")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Username")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.input_group, Bootstrap.has_validation)
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.input_group_text)
                                                                        .withId("inputGroupPrepend3")
                                                                        .with(
                                                                                text("@")
                                                                        ),
                                                                input()
                                                                        .withType("text")
                                                                        .withClasses(Bootstrap.form_control, Bootstrap.is_invalid)
                                                                        .withId("validationServerUsername")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaDescribedby("inputGroupPrepend3 validationServerUsernameFeedback")
                                                                        )
                                                                        .withCondRequired(true),
                                                                div()
                                                                        .withId("validationServerUsernameFeedback")
                                                                        .withClasses(Bootstrap.invalid_feedback)
                                                                        .with(
                                                                                text("Please choose a username.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_6)
                                        .with(
                                                label()
                                                        .withFor("validationServer03")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("City")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control, Bootstrap.is_invalid)
                                                        .withId("validationServer03")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDescribedby("validationServer03Feedback")
                                                        )
                                                        .withCondRequired(true),
                                                div()
                                                        .withId("validationServer03Feedback")
                                                        .withClasses(Bootstrap.invalid_feedback)
                                                        .with(
                                                                text("Please provide a valid city.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_3)
                                        .with(
                                                label()
                                                        .withFor("validationServer04")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("State")
                                                        ),
                                                select()
                                                        .withClasses(Bootstrap.form_select, Bootstrap.is_invalid)
                                                        .withId("validationServer04")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDescribedby("validationServer04Feedback")
                                                        )
                                                        .withCondRequired(true)
                                                        .with(
                                                                option()
                                                                        .withCondSelected(true)
                                                                        .withCondDisabled(true)
                                                                        .withValue("")
                                                                        .with(
                                                                                text("Choose...")
                                                                        ),
                                                                option()
                                                                        .with(
                                                                                text("...")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("validationServer04Feedback")
                                                        .withClasses(Bootstrap.invalid_feedback)
                                                        .with(
                                                                text("Please select a valid state.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_3)
                                        .with(
                                                label()
                                                        .withFor("validationServer05")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Zip")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control, Bootstrap.is_invalid)
                                                        .withId("validationServer05")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDescribedby("validationServer05Feedback")
                                                        )
                                                        .withCondRequired(true),
                                                div()
                                                        .withId("validationServer05Feedback")
                                                        .withClasses(Bootstrap.invalid_feedback)
                                                        .with(
                                                                text("Please provide a valid zip.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.form_check)
                                                        .with(
                                                                input()
                                                                        .withClasses(Bootstrap.form_check_input, Bootstrap.is_invalid)
                                                                        .withType("checkbox")
                                                                        .withValue("")
                                                                        .withId("invalidCheck3")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaDescribedby("invalidCheck3Feedback")
                                                                        )
                                                                        .withCondRequired(true),
                                                                label()
                                                                        .withClasses(Bootstrap.form_check_label)
                                                                        .withFor("invalidCheck3")
                                                                        .with(
                                                                                text("Agree to terms and conditions")
                                                                        ),
                                                                div()
                                                                        .withId("invalidCheck3Feedback")
                                                                        .withClasses(Bootstrap.invalid_feedback)
                                                                        .with(
                                                                                text("You must agree before submitting.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                button()
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .withType("submit")
                                                        .with(
                                                                text("Submit form")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="row g-3">
                  <div class="col-md-4">
                    <label for="validationServer01" class="form-label">
                      First name
                    </label>
                    <input type="text" class="form-control is-valid" id="validationServer01" value="Mark" required>
                    <div class="valid-feedback">
                      Looks good!
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationServer02" class="form-label">
                      Last name
                    </label>
                    <input type="text" class="form-control is-valid" id="validationServer02" value="Otto" required>
                    <div class="valid-feedback">
                      Looks good!
                    </div>
                  </div>
                  <div class="col-md-4">
                    <label for="validationServerUsername" class="form-label">
                      Username
                    </label>
                    <div class="input-group has-validation">
                      <span class="input-group-text" id="inputGroupPrepend3">
                        @
                      </span>
                      <input type="text" class="form-control is-invalid" id="validationServerUsername" aria-describedby="inputGroupPrepend3 validationServerUsernameFeedback" required>
                      <div id="validationServerUsernameFeedback" class="invalid-feedback">
                        Please choose a username.
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6">
                    <label for="validationServer03" class="form-label">
                      City
                    </label>
                    <input type="text" class="form-control is-invalid" id="validationServer03" aria-describedby="validationServer03Feedback" required>
                    <div id="validationServer03Feedback" class="invalid-feedback">
                      Please provide a valid city.
                    </div>
                  </div>
                  <div class="col-md-3">
                    <label for="validationServer04" class="form-label">
                      State
                    </label>
                    <select class="form-select is-invalid" id="validationServer04" aria-describedby="validationServer04Feedback" required>
                      <option selected disabled value="">
                        Choose...
                      </option>
                      <option>
                        ...
                      </option>
                    </select>
                    <div id="validationServer04Feedback" class="invalid-feedback">
                      Please select a valid state.
                    </div>
                  </div>
                  <div class="col-md-3">
                    <label for="validationServer05" class="form-label">
                      Zip
                    </label>
                    <input type="text" class="form-control is-invalid" id="validationServer05" aria-describedby="validationServer05Feedback" required>
                    <div id="validationServer05Feedback" class="invalid-feedback">
                      Please provide a valid zip.
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="form-check">
                      <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>
                      <label class="form-check-label" for="invalidCheck3">
                        Agree to terms and conditions
                      </label>
                      <div id="invalidCheck3Feedback" class="invalid-feedback">
                        You must agree before submitting.
                      </div>
                    </div>
                  </div>
                  <div class="col-12">
                    <button class="btn btn-primary" type="submit">
                      Submit form
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("serverside", renderedHtml);

        uiDocumentation.documentSource("serverside");

    }

    @Test
    void supportedElements() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.was_validated)
                        .with(
                                div()
                                        .withClasses(Bootstrap.mb_3)
                                        .with(
                                                label()
                                                        .withFor("validationTextarea")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Textarea")
                                                        ),
                                                textarea()
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationTextarea")
                                                        .withPlaceholder("Required example textarea")
                                                        .withCondRequired(true),
                                                div()
                                                        .withClasses(Bootstrap.invalid_feedback)
                                                        .with(
                                                                text("Please enter a message in the textarea.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.form_check, Bootstrap.mb_3)
                                        .with(
                                                input()
                                                        .withType("checkbox")
                                                        .withClasses(Bootstrap.form_check_input)
                                                        .withId("validationFormCheck1")
                                                        .withCondRequired(true),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("validationFormCheck1")
                                                        .with(
                                                                text("Check this checkbox")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.invalid_feedback)
                                                        .with(
                                                                text("Example invalid feedback text")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.form_check)
                                        .with(
                                                input()
                                                        .withType("radio")
                                                        .withClasses(Bootstrap.form_check_input)
                                                        .withId("validationFormCheck2")
                                                        .withName("radio-stacked")
                                                        .withCondRequired(true),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("validationFormCheck2")
                                                        .with(
                                                                text("Toggle this radio")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.form_check, Bootstrap.mb_3)
                                        .with(
                                                input()
                                                        .withType("radio")
                                                        .withClasses(Bootstrap.form_check_input)
                                                        .withId("validationFormCheck3")
                                                        .withName("radio-stacked")
                                                        .withCondRequired(true),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("validationFormCheck3")
                                                        .with(
                                                                text("Or toggle this other radio")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.invalid_feedback)
                                                        .with(
                                                                text("More example invalid feedback text")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.mb_3)
                                        .with(
                                                select()
                                                        .withClasses(Bootstrap.form_select)
                                                        .withCondRequired(true)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("select example")
                                                        )
                                                        .with(
                                                                option()
                                                                        .withValue("")
                                                                        .with(
                                                                                text("Open this select menu")
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
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.invalid_feedback)
                                                        .with(
                                                                text("Example invalid select feedback")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.mb_3)
                                        .with(
                                                input()
                                                        .withType("file")
                                                        .withClasses(Bootstrap.form_control)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("file example")
                                                        )
                                                        .withCondRequired(true),
                                                div()
                                                        .withClasses(Bootstrap.invalid_feedback)
                                                        .with(
                                                                text("Example invalid form file feedback")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.mb_3)
                                        .with(
                                                button()
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .withType("submit")
                                                        .withCondDisabled(true)
                                                        .with(
                                                                text("Submit form")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="was-validated">
                  <div class="mb-3">
                    <label for="validationTextarea" class="form-label">
                      Textarea
                    </label>
                    <textarea class="form-control" id="validationTextarea" placeholder="Required example textarea" required></textarea>
                    <div class="invalid-feedback">
                      Please enter a message in the textarea.
                    </div>
                  </div>
                  <div class="form-check mb-3">
                    <input type="checkbox" class="form-check-input" id="validationFormCheck1" required>
                    <label class="form-check-label" for="validationFormCheck1">
                      Check this checkbox
                    </label>
                    <div class="invalid-feedback">
                      Example invalid feedback text
                    </div>
                  </div>
                  <div class="form-check">
                    <input type="radio" class="form-check-input" id="validationFormCheck2" name="radio-stacked" required>
                    <label class="form-check-label" for="validationFormCheck2">
                      Toggle this radio
                    </label>
                  </div>
                  <div class="form-check mb-3">
                    <input type="radio" class="form-check-input" id="validationFormCheck3" name="radio-stacked" required>
                    <label class="form-check-label" for="validationFormCheck3">
                      Or toggle this other radio
                    </label>
                    <div class="invalid-feedback">
                      More example invalid feedback text
                    </div>
                  </div>
                  <div class="mb-3">
                    <select class="form-select" required aria-label="select example">
                      <option value="">
                        Open this select menu
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
                    <div class="invalid-feedback">
                      Example invalid select feedback
                    </div>
                  </div>
                  <div class="mb-3">
                    <input type="file" class="form-control" aria-label="file example" required>
                    <div class="invalid-feedback">
                      Example invalid form file feedback
                    </div>
                  </div>
                  <div class="mb-3">
                    <button class="btn btn-primary" type="submit" disabled>
                      Submit form
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("supported-elements", renderedHtml);

        uiDocumentation.documentSource("supported-elements");

    }

    @Test
    void tooltips() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.row, Bootstrap.g_3,Validation.needs_validation)
                        .withCondNovalidate(true)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_md_4, Bootstrap.position_relative)
                                        .with(
                                                label()
                                                        .withFor("validationTooltip01")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("First name")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationTooltip01")
                                                        .withValue("Mark")
                                                        .withCondRequired(true),
                                                div()
                                                        .withClasses(Bootstrap.valid_tooltip)
                                                        .with(
                                                                text("Looks good!")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_4, Bootstrap.position_relative)
                                        .with(
                                                label()
                                                        .withFor("validationTooltip02")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Last name")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationTooltip02")
                                                        .withValue("Otto")
                                                        .withCondRequired(true),
                                                div()
                                                        .withClasses(Bootstrap.valid_tooltip)
                                                        .with(
                                                                text("Looks good!")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_4, Bootstrap.position_relative)
                                        .with(
                                                label()
                                                        .withFor("validationTooltipUsername")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Username")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.input_group, Bootstrap.has_validation)
                                                        .with(
                                                                span()
                                                                        .withClasses(Bootstrap.input_group_text)
                                                                        .withId("validationTooltipUsernamePrepend")
                                                                        .with(
                                                                                text("@")
                                                                        ),
                                                                input()
                                                                        .withType("text")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("validationTooltipUsername")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaDescribedby("validationTooltipUsernamePrepend")
                                                                        )
                                                                        .withCondRequired(true),
                                                                div()
                                                                        .withClasses(Bootstrap.invalid_tooltip)
                                                                        .with(
                                                                                text("Please choose a unique and valid username.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_6, Bootstrap.position_relative)
                                        .with(
                                                label()
                                                        .withFor("validationTooltip03")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("City")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationTooltip03")
                                                        .withCondRequired(true),
                                                div()
                                                        .withClasses(Bootstrap.invalid_tooltip)
                                                        .with(
                                                                text("Please provide a valid city.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_3, Bootstrap.position_relative)
                                        .with(
                                                label()
                                                        .withFor("validationTooltip04")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("State")
                                                        ),
                                                select()
                                                        .withClasses(Bootstrap.form_select)
                                                        .withId("validationTooltip04")
                                                        .withCondRequired(true)
                                                        .with(
                                                                option()
                                                                        .withCondSelected(true)
                                                                        .withCondDisabled(true)
                                                                        .withValue("")
                                                                        .with(
                                                                                text("Choose...")
                                                                        ),
                                                                option()
                                                                        .with(
                                                                                text("...")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.invalid_tooltip)
                                                        .with(
                                                                text("Please select a valid state.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md_3, Bootstrap.position_relative)
                                        .with(
                                                label()
                                                        .withFor("validationTooltip05")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Zip")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("validationTooltip05")
                                                        .withCondRequired(true),
                                                div()
                                                        .withClasses(Bootstrap.invalid_tooltip)
                                                        .with(
                                                                text("Please provide a valid zip.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_12)
                                        .with(
                                                button()
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                        .withType("submit")
                                                        .with(
                                                                text("Submit form")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="row g-3 needs-validation" novalidate>
                  <div class="col-md-4 position-relative">
                    <label for="validationTooltip01" class="form-label">
                      First name
                    </label>
                    <input type="text" class="form-control" id="validationTooltip01" value="Mark" required>
                    <div class="valid-tooltip">
                      Looks good!
                    </div>
                  </div>
                  <div class="col-md-4 position-relative">
                    <label for="validationTooltip02" class="form-label">
                      Last name
                    </label>
                    <input type="text" class="form-control" id="validationTooltip02" value="Otto" required>
                    <div class="valid-tooltip">
                      Looks good!
                    </div>
                  </div>
                  <div class="col-md-4 position-relative">
                    <label for="validationTooltipUsername" class="form-label">
                      Username
                    </label>
                    <div class="input-group has-validation">
                      <span class="input-group-text" id="validationTooltipUsernamePrepend">
                        @
                      </span>
                      <input type="text" class="form-control" id="validationTooltipUsername" aria-describedby="validationTooltipUsernamePrepend" required>
                      <div class="invalid-tooltip">
                        Please choose a unique and valid username.
                      </div>
                    </div>
                  </div>
                  <div class="col-md-6 position-relative">
                    <label for="validationTooltip03" class="form-label">
                      City
                    </label>
                    <input type="text" class="form-control" id="validationTooltip03" required>
                    <div class="invalid-tooltip">
                      Please provide a valid city.
                    </div>
                  </div>
                  <div class="col-md-3 position-relative">
                    <label for="validationTooltip04" class="form-label">
                      State
                    </label>
                    <select class="form-select" id="validationTooltip04" required>
                      <option selected disabled value="">
                        Choose...
                      </option>
                      <option>
                        ...
                      </option>
                    </select>
                    <div class="invalid-tooltip">
                      Please select a valid state.
                    </div>
                  </div>
                  <div class="col-md-3 position-relative">
                    <label for="validationTooltip05" class="form-label">
                      Zip
                    </label>
                    <input type="text" class="form-control" id="validationTooltip05" required>
                    <div class="invalid-tooltip">
                      Please provide a valid zip.
                    </div>
                  </div>
                  <div class="col-12">
                    <button class="btn btn-primary" type="submit">
                      Submit form
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("tooltips", renderedHtml);

        uiDocumentation.documentSource("tooltips");

    }


}
