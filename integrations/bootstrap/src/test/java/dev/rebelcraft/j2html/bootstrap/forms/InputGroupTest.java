package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputGroupTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void basicExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                  div()
                   .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
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
                       .attr(AriaStatesAndProperties.ariaLabel("Username"))
                       .attr(AriaStatesAndProperties.ariaDescribedby("basic-addon1"))
                    ),
                  div()
                   .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                   .with(
                      input()
                       .withType("text")
                       .withClasses(Bootstrap.form_control)
                       .withPlaceholder("Recipient's username")
                       .attr(AriaStatesAndProperties.ariaLabel("Recipient's username"))
                       .attr(AriaStatesAndProperties.ariaDescribedby("basic-addon2")),
                      span()
                       .withClasses(Bootstrap.input_group_text)
                       .withId("basic-addon2")
                       .with(
                          text("@example.com")
                        )
                    ),
                  div()
                   .withClasses(Bootstrap.mb_3)
                   .with(
                      label()
                       .withFor("basic-url")
                       .withClasses(Bootstrap.form_label)
                       .with(
                          text("Your vanity URL")
                        ),
                      div()
                       .withClasses(Bootstrap.input_group)
                       .with(
                          span()
                           .withClasses(Bootstrap.input_group_text)
                           .withId("basic-addon3")
                           .with(
                              text("https://example.com/users/")
                            ),
                          input()
                           .withType("text")
                           .withClasses(Bootstrap.form_control)
                           .withId("basic-url")
                           .attr(AriaStatesAndProperties.ariaDescribedby("basic-addon3 basic-addon4"))
                        ),
                      div()
                       .withClasses(Bootstrap.form_text)
                       .withId("basic-addon4")
                       .with(
                          text("Example help text goes outside the input group.")
                        )
                    ),
                  div()
                   .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                   .with(
                      span()
                       .withClasses(Bootstrap.input_group_text)
                       .with(
                          text("$")
                        ),
                      input()
                       .withType("text")
                       .withClasses(Bootstrap.form_control)
                       .attr(AriaStatesAndProperties.ariaLabel("Amount (to the nearest dollar)")),
                      span()
                       .withClasses(Bootstrap.input_group_text)
                       .with(
                          text(".00")
                        )
                    ),
                  div()
                   .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                   .with(
                      input()
                       .withType("text")
                       .withClasses(Bootstrap.form_control)
                       .withPlaceholder("Username")
                       .attr(AriaStatesAndProperties.ariaLabel("Username")),
                      span()
                       .withClasses(Bootstrap.input_group_text)
                       .with(
                          text("@")
                        ),
                      input()
                       .withType("text")
                       .withClasses(Bootstrap.form_control)
                       .withPlaceholder("Server")
                       .attr(AriaStatesAndProperties.ariaLabel("Server"))
                    ),
                  div()
                   .withClasses(Bootstrap.input_group)
                   .with(
                      span()
                       .withClasses(Bootstrap.input_group_text)
                       .with(
                          text("With textarea")
                        ),
                      textarea()
                       .withClasses(Bootstrap.form_control)
                       .attr(AriaStatesAndProperties.ariaLabel("With textarea"))
                    )
            )
        );

        //language=HTML
        assertEquals("""
            <div class="input-group mb-3">
              <span class="input-group-text" id="basic-addon1">
                @
              </span>
              <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
              <input type="text" class="form-control" placeholder="Recipient&#x27;s username" aria-label="Recipient&#x27;s username" aria-describedby="basic-addon2">
              <span class="input-group-text" id="basic-addon2">
                @example.com
              </span>
            </div>
            <div class="mb-3">
              <label for="basic-url" class="form-label">
                Your vanity URL
              </label>
              <div class="input-group">
                <span class="input-group-text" id="basic-addon3">
                  https://example.com/users/
                </span>
                <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3 basic-addon4">
              </div>
              <div class="form-text" id="basic-addon4">
                Example help text goes outside the input group.
              </div>
            </div>
            <div class="input-group mb-3">
              <span class="input-group-text">
                $
              </span>
              <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
              <span class="input-group-text">
                .00
              </span>
            </div>
            <div class="input-group mb-3">
              <input type="text" class="form-control" placeholder="Username" aria-label="Username">
              <span class="input-group-text">
                @
              </span>
              <input type="text" class="form-control" placeholder="Server" aria-label="Server">
            </div>
            <div class="input-group">
              <span class="input-group-text">
                With textarea
              </span>
              <textarea class="form-control" aria-label="With textarea"></textarea>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("basic-example", renderedHtml);

        uiDocumentation.documentSource("basic-example");

    }

    @Test
    void wrapping() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
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
                                                .attr(AriaStatesAndProperties.ariaLabel("Username"))
                                                .attr(AriaStatesAndProperties.ariaDescribedby("basic-addon1"))
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("Recipient's username")
                                                .attr(AriaStatesAndProperties.ariaLabel("Recipient's username"))
                                                .attr(AriaStatesAndProperties.ariaDescribedby("basic-addon2")),
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .withId("basic-addon2")
                                                .with(
                                                        text("@example.com")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("basic-url")
                                                .withClasses(Bootstrap.form_label)
                                                .with(
                                                        text("Your vanity URL")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.input_group)
                                                .with(
                                                        span()
                                                                .withClasses(Bootstrap.input_group_text)
                                                                .withId("basic-addon3")
                                                                .with(
                                                                        text("https://example.com/users/")
                                                                ),
                                                        input()
                                                                .withType("text")
                                                                .withClasses(Bootstrap.form_control)
                                                                .withId("basic-url")
                                                                .attr(AriaStatesAndProperties.ariaDescribedby("basic-addon3 basic-addon4"))
                                                ),
                                        div()
                                                .withClasses(Bootstrap.form_text)
                                                .withId("basic-addon4")
                                                .with(
                                                        text("Example help text goes outside the input group.")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        text("$")
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(AriaStatesAndProperties.ariaLabel("Amount (to the nearest dollar)")),
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        text(".00")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("Username")
                                                .attr(AriaStatesAndProperties.ariaLabel("Username")),
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        text("@")
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("Server")
                                                .attr(AriaStatesAndProperties.ariaLabel("Server"))
                                ),
                        div()
                                .withClasses(Bootstrap.input_group)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        text("With textarea")
                                                ),
                                        textarea()
                                                .withClasses(Bootstrap.form_control)
                                                .attr(AriaStatesAndProperties.ariaLabel("With textarea"))
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="input-group mb-3">
                  <span class="input-group-text" id="basic-addon1">
                    @
                  </span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                  <input type="text" class="form-control" placeholder="Recipient&#x27;s username" aria-label="Recipient&#x27;s username" aria-describedby="basic-addon2">
                  <span class="input-group-text" id="basic-addon2">
                    @example.com
                  </span>
                </div>
                <div class="mb-3">
                  <label for="basic-url" class="form-label">
                    Your vanity URL
                  </label>
                  <div class="input-group">
                    <span class="input-group-text" id="basic-addon3">
                      https://example.com/users/
                    </span>
                    <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3 basic-addon4">
                  </div>
                  <div class="form-text" id="basic-addon4">
                    Example help text goes outside the input group.
                  </div>
                </div>
                <div class="input-group mb-3">
                  <span class="input-group-text">
                    $
                  </span>
                  <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
                  <span class="input-group-text">
                    .00
                  </span>
                </div>
                <div class="input-group mb-3">
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username">
                  <span class="input-group-text">
                    @
                  </span>
                  <input type="text" class="form-control" placeholder="Server" aria-label="Server">
                </div>
                <div class="input-group">
                  <span class="input-group-text">
                    With textarea
                  </span>
                  <textarea class="form-control" aria-label="With textarea"></textarea>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("wrapping", renderedHtml);

        uiDocumentation.documentSource("wrapping");

    }

    @Test
    void sizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.input_group_sm, Bootstrap.mb_3)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .withId("inputGroup-sizing-sm")
                                                .with(
                                                        text("Small")
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(AriaStatesAndProperties.ariaLabel("Sizing example input"))
                                                .attr(AriaStatesAndProperties.ariaDescribedby("inputGroup-sizing-sm"))
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .withId("inputGroup-sizing-default")
                                                .with(
                                                        text("Default")
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(AriaStatesAndProperties.ariaLabel("Sizing example input"))
                                                .attr(AriaStatesAndProperties.ariaDescribedby("inputGroup-sizing-default"))
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.input_group_lg)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .withId("inputGroup-sizing-lg")
                                                .with(
                                                        text("Large")
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(AriaStatesAndProperties.ariaLabel("Sizing example input"))
                                                .attr(AriaStatesAndProperties.ariaDescribedby("inputGroup-sizing-lg"))
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="input-group input-group-sm mb-3">
              <span class="input-group-text" id="inputGroup-sizing-sm">
                Small
              </span>
              <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
            </div>
            <div class="input-group mb-3">
              <span class="input-group-text" id="inputGroup-sizing-default">
                Default
              </span>
              <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">
                Large
              </span>
              <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg">
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("sizing", renderedHtml);

        uiDocumentation.documentSource("sizing");

    }

    @Test
    void checkboxesAndRadios() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        input()
                                                                .withClasses(Bootstrap.form_check_input, Bootstrap.mt_0)
                                                                .withType("checkbox")
                                                                .withValue("")
                                                                .attr(AriaStatesAndProperties.ariaLabel("Checkbox for following text input"))
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(AriaStatesAndProperties.ariaLabel("Text input with checkbox"))
                                ),
                        div()
                                .withClasses(Bootstrap.input_group)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        input()
                                                                .withClasses(Bootstrap.form_check_input, Bootstrap.mt_0)
                                                                .withType("radio")
                                                                .withValue("")
                                                                .attr(AriaStatesAndProperties.ariaLabel("Radio button for following text input"))
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(AriaStatesAndProperties.ariaLabel("Text input with radio button"))
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="input-group mb-3">
                  <div class="input-group-text">
                    <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
                  </div>
                  <input type="text" class="form-control" aria-label="Text input with checkbox">
                </div>
                <div class="input-group">
                  <div class="input-group-text">
                    <input class="form-check-input mt-0" type="radio" value="" aria-label="Radio button for following text input">
                  </div>
                  <input type="text" class="form-control" aria-label="Text input with radio button">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("checkboxes-and-radios", renderedHtml);

        uiDocumentation.documentSource("checkboxes-and-radios");

    }

    @Test
    void multipleInputs() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.input_group)
                        .with(
                                span()
                                        .withClasses(Bootstrap.input_group_text)
                                        .with(
                                                text("First and last name")
                                        ),
                                input()
                                        .withType("text")
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("First name")
                                        )
                                        .withClasses(Bootstrap.form_control),
                                input()
                                        .withType("text")
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Last name")
                                        )
                                        .withClasses(Bootstrap.form_control)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="input-group">
                  <span class="input-group-text">
                    First and last name
                  </span>
                  <input type="text" aria-label="First name" class="form-control">
                  <input type="text" aria-label="Last name" class="form-control">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("multiple-inputs", renderedHtml);

        uiDocumentation.documentSource("multiple-inputs");

    }

    @Test
    void multipleAddOns() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        text("$")
                                                ),
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        text("0.00")
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Dollar amount (with dot and two decimal places)")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group)
                                .with(
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Dollar amount (with dot and two decimal places)")
                                                ),
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        text("$")
                                                ),
                                        span()
                                                .withClasses(Bootstrap.input_group_text)
                                                .with(
                                                        text("0.00")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="input-group mb-3">
          <span class="input-group-text">
            $
          </span>
          <span class="input-group-text">
            0.00
          </span>
          <input type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
        </div>
        <div class="input-group">
          <input type="text" class="form-control" aria-label="Dollar amount (with dot and two decimal places)">
          <span class="input-group-text">
            $
          </span>
          <span class="input-group-text">
            0.00
          </span>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("multiple-add-ons", renderedHtml);

        uiDocumentation.documentSource("multiple-add-ons");

    }

    @Test
    void buttonAddOns() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .withId("button-addon1")
                                                .with(
                                                        text("Button")
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("")
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Example text with button addon")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaDescribedby("button-addon1")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("Recipient's username")
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Recipient's username")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaDescribedby("button-addon2")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .withId("button-addon2")
                                                .with(
                                                        text("Button")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .with(
                                                        text("Button")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .with(
                                                        text("Button")
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("")
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Example text with two button addons")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group)
                                .with(
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("Recipient's username")
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Recipient's username with two button addons")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .with(
                                                        text("Button")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .with(
                                                        text("Button")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="input-group mb-3">
                  <button class="btn btn-outline-secondary" type="button" id="button-addon1">
                    Button
                  </button>
                  <input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
                </div>
                <div class="input-group mb-3">
                  <input type="text" class="form-control" placeholder="Recipient&#x27;s username" aria-label="Recipient&#x27;s username" aria-describedby="button-addon2">
                  <button class="btn btn-outline-secondary" type="button" id="button-addon2">
                    Button
                  </button>
                </div>
                <div class="input-group mb-3">
                  <button class="btn btn-outline-secondary" type="button">
                    Button
                  </button>
                  <button class="btn btn-outline-secondary" type="button">
                    Button
                  </button>
                  <input type="text" class="form-control" placeholder="" aria-label="Example text with two button addons">
                </div>
                <div class="input-group">
                  <input type="text" class="form-control" placeholder="Recipient&#x27;s username" aria-label="Recipient&#x27;s username with two button addons">
                  <button class="btn btn-outline-secondary" type="button">
                    Button
                  </button>
                  <button class="btn btn-outline-secondary" type="button">
                    Button
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("button-add-ons", renderedHtml);

        uiDocumentation.documentSource("button-add-ons");

    }

    @Test
    void buttonWithDropdowns() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .attr(AriaStatesAndProperties.ariaExpanded("false"))
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
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Text input with dropdown button")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Text input with dropdown button")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .attr(AriaStatesAndProperties.ariaExpanded("false"))
                                                .with(
                                                        text("Dropdown")
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
                                ),
                        div()
                                .withClasses(Bootstrap.input_group)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .attr(AriaStatesAndProperties.ariaExpanded("false"))
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
                                                                                        text("Action before")
                                                                                )
                                                                ),
                                                        li()
                                                                .with(
                                                                        a()
                                                                                .withClasses(Bootstrap.dropdown_item)
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Another action before")
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
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Text input with 2 dropdown buttons")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary, Bootstrap.dropdown_toggle)
                                                .withType("button")
                                                .withData("bs-toggle","dropdown")
                                                .attr(AriaStatesAndProperties.ariaExpanded("false"))
                                                .with(
                                                        text("Dropdown")
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
                <div class="input-group mb-3">
                  <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown
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
                  <input type="text" class="form-control" aria-label="Text input with dropdown button">
                </div>
                <div class="input-group mb-3">
                  <input type="text" class="form-control" aria-label="Text input with dropdown button">
                  <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown
                  </button>
                  <ul class="dropdown-menu dropdown-menu-end">
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
                <div class="input-group">
                  <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown
                  </button>
                  <ul class="dropdown-menu">
                    <li>
                      <a class="dropdown-item" href="#">
                        Action before
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        Another action before
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
                  <input type="text" class="form-control" aria-label="Text input with 2 dropdown buttons">
                  <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown
                  </button>
                  <ul class="dropdown-menu dropdown-menu-end">
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
        uiDocumentation.document("button-with-dropdowns", renderedHtml);

        uiDocumentation.documentSource("button-with-dropdowns");

    }

    @Test
    void segmentedButtons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .with(
                                                        text("Action")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
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
                                                ),
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Text input with segmented dropdown button")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group)
                                .with(
                                        input()
                                                .withType("text")
                                                .withClasses(Bootstrap.form_control)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Text input with segmented dropdown button")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .with(
                                                        text("Action")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary, Bootstrap.dropdown_toggle, Bootstrap.dropdown_toggle_split)
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
                                                .withClasses(Bootstrap.dropdown_menu, Bootstrap.dropdown_menu_end)
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
                <div class="input-group mb-3">
                  <button type="button" class="btn btn-outline-secondary">
                    Action
                  </button>
                  <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
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
                  <input type="text" class="form-control" aria-label="Text input with segmented dropdown button">
                </div>
                <div class="input-group">
                  <input type="text" class="form-control" aria-label="Text input with segmented dropdown button">
                  <button type="button" class="btn btn-outline-secondary">
                    Action
                  </button>
                  <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">
                    <span class="visually-hidden">
                      Toggle Dropdown
                    </span>
                  </button>
                  <ul class="dropdown-menu dropdown-menu-end">
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
        uiDocumentation.document("segmented-buttons", renderedHtml);

        uiDocumentation.documentSource("segmented-buttons");

    }

    @Test
    void customSelect() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withClasses(Bootstrap.input_group_text)
                                                .withFor("inputGroupSelect01")
                                                .with(
                                                        text("Options")
                                                ),
                                        select()
                                                .withClasses(Bootstrap.form_select)
                                                .withId("inputGroupSelect01")
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
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        select()
                                                .withClasses(Bootstrap.form_select)
                                                .withId("inputGroupSelect02")
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
                                                ),
                                        label()
                                                .withClasses(Bootstrap.input_group_text)
                                                .withFor("inputGroupSelect02")
                                                .with(
                                                        text("Options")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .with(
                                                        text("Button")
                                                ),
                                        select()
                                                .withClasses(Bootstrap.form_select)
                                                .withId("inputGroupSelect03")
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Example select with button addon")
                                                )
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
                                .withClasses(Bootstrap.input_group)
                                .with(
                                        select()
                                                .withClasses(Bootstrap.form_select)
                                                .withId("inputGroupSelect04")
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Example select with button addon")
                                                )
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
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .with(
                                                        text("Button")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="input-group mb-3">
                  <label class="input-group-text" for="inputGroupSelect01">
                    Options
                  </label>
                  <select class="form-select" id="inputGroupSelect01">
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
                <div class="input-group mb-3">
                  <select class="form-select" id="inputGroupSelect02">
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
                  <label class="input-group-text" for="inputGroupSelect02">
                    Options
                  </label>
                </div>
                <div class="input-group mb-3">
                  <button class="btn btn-outline-secondary" type="button">
                    Button
                  </button>
                  <select class="form-select" id="inputGroupSelect03" aria-label="Example select with button addon">
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
                <div class="input-group">
                  <select class="form-select" id="inputGroupSelect04" aria-label="Example select with button addon">
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
                  <button class="btn btn-outline-secondary" type="button">
                    Button
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("custom-select", renderedHtml);

        uiDocumentation.documentSource("custom-select");

    }

    @Test
    void customFileInput() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withClasses(Bootstrap.input_group_text)
                                                .withFor("inputGroupFile01")
                                                .with(
                                                        text("Upload")
                                                ),
                                        input()
                                                .withType("file")
                                                .withClasses(Bootstrap.form_control)
                                                .withId("inputGroupFile01")
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        input()
                                                .withType("file")
                                                .withClasses(Bootstrap.form_control)
                                                .withId("inputGroupFile02"),
                                        label()
                                                .withClasses(Bootstrap.input_group_text)
                                                .withFor("inputGroupFile02")
                                                .with(
                                                        text("Upload")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .withId("inputGroupFileAddon03")
                                                .with(
                                                        text("Button")
                                                ),
                                        input()
                                                .withType("file")
                                                .withClasses(Bootstrap.form_control)
                                                .withId("inputGroupFile03")
                                                .attr(
                                                        AriaStatesAndProperties.ariaDescribedby("inputGroupFileAddon03")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Upload")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.input_group)
                                .with(
                                        input()
                                                .withType("file")
                                                .withClasses(Bootstrap.form_control)
                                                .withId("inputGroupFile04")
                                                .attr(
                                                        AriaStatesAndProperties.ariaDescribedby("inputGroupFileAddon04")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Upload")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                                .withType("button")
                                                .withId("inputGroupFileAddon04")
                                                .with(
                                                        text("Button")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="input-group mb-3">
                  <label class="input-group-text" for="inputGroupFile01">
                    Upload
                  </label>
                  <input type="file" class="form-control" id="inputGroupFile01">
                </div>
                <div class="input-group mb-3">
                  <input type="file" class="form-control" id="inputGroupFile02">
                  <label class="input-group-text" for="inputGroupFile02">
                    Upload
                  </label>
                </div>
                <div class="input-group mb-3">
                  <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon03">
                    Button
                  </button>
                  <input type="file" class="form-control" id="inputGroupFile03" aria-describedby="inputGroupFileAddon03" aria-label="Upload">
                </div>
                <div class="input-group">
                  <input type="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                  <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">
                    Button
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("custom-file-input", renderedHtml);

        uiDocumentation.documentSource("custom-file-input");

    }



}
