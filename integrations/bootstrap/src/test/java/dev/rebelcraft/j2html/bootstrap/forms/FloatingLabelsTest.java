package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FloatingLabelsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                  div()
                   .withClasses(Bootstrap.form_floating, Bootstrap.mb_3)
                   .with(
                      input()
                       .withType("email")
                       .withClasses(Bootstrap.form_control)
                       .withId("floatingInput")
                       .withPlaceholder("name@example.com"),
                      label()
                       .withFor("floatingInput")
                       .with(
                          text("Email address")
                        )
                    ),
                  div()
                   .withClasses(Bootstrap.form_floating)
                   .with(
                      input()
                       .withType("password")
                       .withClasses(Bootstrap.form_control)
                       .withId("floatingPassword")
                       .withPlaceholder("Password"),
                      label()
                       .withFor("floatingPassword")
                       .with(
                          text("Password")
                        )
                    )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-floating mb-3">
                  <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                  <label for="floatingInput">
                    Email address
                  </label>
                </div>
                <div class="form-floating">
                  <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                  <label for="floatingPassword">
                    Password
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void example2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.form_floating)
                        .with(
                                input()
                                        .withType("email")
                                        .withClasses(Bootstrap.form_control)
                                        .withId("floatingInputValue")
                                        .withPlaceholder("name@example.com")
                                        .withValue("test@example.com"),
                                label()
                                        .withFor("floatingInputValue")
                                        .with(
                                                text("Input with value")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="form-floating">
                  <input type="email" class="form-control" id="floatingInputValue" placeholder="name@example.com" value="test@example.com">
                  <label for="floatingInputValue">
                    Input with value
                  </label>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("example2", renderedHtml);

        uiDocumentation.documentSource("example2");

    }

    @Test
    void example3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.form_floating)
                        .with(
                                input()
                                        .withType("email")
                                        .withClasses(Bootstrap.form_control, Bootstrap.is_invalid)
                                        .withId("floatingInputInvalid")
                                        .withPlaceholder("name@example.com")
                                        .withValue("test@example.com"),
                                label()
                                        .withFor("floatingInputInvalid")
                                        .with(
                                                text("Invalid input")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="form-floating">
                  <input type="email" class="form-control is-invalid" id="floatingInputInvalid" placeholder="name@example.com" value="test@example.com">
                  <label for="floatingInputInvalid">
                    Invalid input
                  </label>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("example3", renderedHtml);

        uiDocumentation.documentSource("example3");

    }

    @Test
    void textAreas() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.form_floating)
                        .with(
                                textarea()
                                        .withClasses(Bootstrap.form_control)
                                        .withPlaceholder("Leave a comment here")
                                        .withId("floatingTextarea"),
                                label()
                                        .withFor("floatingTextarea")
                                        .with(
                                                text("Comments")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="form-floating">
                  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
                  <label for="floatingTextarea">
                    Comments
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-areas", renderedHtml);

        uiDocumentation.documentSource("text-areas");

    }

    @Test
    void textAreas2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.form_floating)
                        .with(
                                textarea()
                                        .withClasses(Bootstrap.form_control)
                                        .withPlaceholder("Leave a comment here")
                                        .withId("floatingTextarea2")
                                        .withStyle("height: 100px"),
                                label()
                                        .withFor("floatingTextarea2")
                                        .with(
                                                text("Comments")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="form-floating">
                  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
                  <label for="floatingTextarea2">
                    Comments
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-areas2", renderedHtml);

        uiDocumentation.documentSource("text-areas2");

    }

    @Test
    void selects() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.form_floating)
                        .with(
                                select()
                                        .withClasses(Bootstrap.form_select)
                                        .withId("floatingSelect")
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Floating label select example")
                                        )
                                        .with(
                                                option()
                                                        .withCondSelected(true)
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
                                label()
                                        .withFor("floatingSelect")
                                        .with(
                                                text("Works with selects")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="form-floating">
                  <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                    <option selected>
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
                  <label for="floatingSelect">
                    Works with selects
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("selects", renderedHtml);

        uiDocumentation.documentSource("selects");

    }

    @Test
    void disabled() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_floating, Bootstrap.mb_3)
                                .with(
                                        input()
                                                .withType("email")
                                                .withClasses(Bootstrap.form_control)
                                                .withId("floatingInputDisabled")
                                                .withPlaceholder("name@example.com")
                                                .withCondDisabled(true),
                                        label()
                                                .withFor("floatingInputDisabled")
                                                .with(
                                                        text("Email address")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_floating, Bootstrap.mb_3)
                                .with(
                                        textarea()
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("Leave a comment here")
                                                .withId("floatingTextareaDisabled")
                                                .withCondDisabled(true),
                                        label()
                                                .withFor("floatingTextareaDisabled")
                                                .with(
                                                        text("Comments")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_floating, Bootstrap.mb_3)
                                .with(
                                        textarea()
                                                .withClasses(Bootstrap.form_control)
                                                .withPlaceholder("Leave a comment here")
                                                .withId("floatingTextarea2Disabled")
                                                .withStyle("height: 100px")
                                                .withCondDisabled(true)
                                                .with(
                                                        text("Disabled textarea with some text inside")
                                                ),
                                        label()
                                                .withFor("floatingTextarea2Disabled")
                                                .with(
                                                        text("Comments")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_floating)
                                .with(
                                        select()
                                                .withClasses(Bootstrap.form_select)
                                                .withId("floatingSelectDisabled")
                                                .attr(
                                                        AriaStatesAndProperties.ariaLabel("Floating label disabled select example")
                                                )
                                                .withCondDisabled(true)
                                                .with(
                                                        option()
                                                                .withCondSelected(true)
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
                                        label()
                                                .withFor("floatingSelectDisabled")
                                                .with(
                                                        text("Works with selects")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-floating mb-3">
                  <input type="email" class="form-control" id="floatingInputDisabled" placeholder="name@example.com" disabled>
                  <label for="floatingInputDisabled">
                    Email address
                  </label>
                </div>
                <div class="form-floating mb-3">
                  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextareaDisabled" disabled></textarea>
                  <label for="floatingTextareaDisabled">
                    Comments
                  </label>
                </div>
                <div class="form-floating mb-3">
                  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2Disabled" style="height: 100px" disabled>Disabled textarea with some text inside</textarea>
                  <label for="floatingTextarea2Disabled">
                    Comments
                  </label>
                </div>
                <div class="form-floating">
                  <select class="form-select" id="floatingSelectDisabled" aria-label="Floating label disabled select example" disabled>
                    <option selected>
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
                  <label for="floatingSelectDisabled">
                    Works with selects
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled", renderedHtml);

        uiDocumentation.documentSource("disabled");

    }

    @Test
    void readOnlyPlainText() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_floating, Bootstrap.mb_3)
                                .with(
                                        input()
                                                .withType("email")
                                                .withCondReadonly(true)
                                                .withClasses(Bootstrap.form_control_plaintext)
                                                .withId("floatingEmptyPlaintextInput")
                                                .withPlaceholder("name@example.com"),
                                        label()
                                                .withFor("floatingEmptyPlaintextInput")
                                                .with(
                                                        text("Empty input")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_floating, Bootstrap.mb_3)
                                .with(
                                        input()
                                                .withType("email")
                                                .withCondReadonly(true)
                                                .withClasses(Bootstrap.form_control_plaintext)
                                                .withId("floatingPlaintextInput")
                                                .withPlaceholder("name@example.com")
                                                .withValue("name@example.com"),
                                        label()
                                                .withFor("floatingPlaintextInput")
                                                .with(
                                                        text("Input with value")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-floating mb-3">
                  <input type="email" readonly class="form-control-plaintext" id="floatingEmptyPlaintextInput" placeholder="name@example.com">
                  <label for="floatingEmptyPlaintextInput">
                    Empty input
                  </label>
                </div>
                <div class="form-floating mb-3">
                  <input type="email" readonly class="form-control-plaintext" id="floatingPlaintextInput" placeholder="name@example.com" value="name@example.com">
                  <label for="floatingPlaintextInput">
                    Input with value
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("read-only-plain-text", renderedHtml);

        uiDocumentation.documentSource("read-only-plain-text");

    }

    @Test
    void inputGroups() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.input_group, Bootstrap.mb_3)
                        .with(
                                span()
                                        .withClasses(Bootstrap.input_group_text)
                                        .with(
                                                text("@")
                                        ),
                                div()
                                        .withClasses(Bootstrap.form_floating)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("floatingInputGroup1")
                                                        .withPlaceholder("Username"),
                                                label()
                                                        .withFor("floatingInputGroup1")
                                                        .with(
                                                                text("Username")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="input-group mb-3">
                  <span class="input-group-text">
                    @
                  </span>
                  <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInputGroup1" placeholder="Username">
                    <label for="floatingInputGroup1">
                      Username
                    </label>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("input-groups", renderedHtml);

        uiDocumentation.documentSource("input-groups");

    }

    @Test
    void inputGroups2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.input_group, Bootstrap.has_validation)
                        .with(
                                span()
                                        .withClasses(Bootstrap.input_group_text)
                                        .with(
                                                text("@")
                                        ),
                                div()
                                        .withClasses(Bootstrap.form_floating, Bootstrap.is_invalid)
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withClasses(Bootstrap.form_control, Bootstrap.is_invalid)
                                                        .withId("floatingInputGroup2")
                                                        .withPlaceholder("Username")
                                                        .withCondRequired(true),
                                                label()
                                                        .withFor("floatingInputGroup2")
                                                        .with(
                                                                text("Username")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.invalid_feedback)
                                        .with(
                                                text("Please choose a username.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="input-group has-validation">
                  <span class="input-group-text">
                    @
                  </span>
                  <div class="form-floating is-invalid">
                    <input type="text" class="form-control is-invalid" id="floatingInputGroup2" placeholder="Username" required>
                    <label for="floatingInputGroup2">
                      Username
                    </label>
                  </div>
                  <div class="invalid-feedback">
                    Please choose a username.
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("input-groups2", renderedHtml);

        uiDocumentation.documentSource("input-groups2");

    }

    @Test
    void layout() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.g_2)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_md)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.form_floating)
                                                        .with(
                                                                input()
                                                                        .withType("email")
                                                                        .withClasses(Bootstrap.form_control)
                                                                        .withId("floatingInputGrid")
                                                                        .withPlaceholder("name@example.com")
                                                                        .withValue("mdo@example.com"),
                                                                label()
                                                                        .withFor("floatingInputGrid")
                                                                        .with(
                                                                                text("Email address")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_md)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.form_floating)
                                                        .with(
                                                                select()
                                                                        .withClasses(Bootstrap.form_select)
                                                                        .withId("floatingSelectGrid")
                                                                        .with(
                                                                                option()
                                                                                        .withCondSelected(true)
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
                                                                label()
                                                                        .withFor("floatingSelectGrid")
                                                                        .with(
                                                                                text("Works with selects")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row g-2">
                  <div class="col-md">
                    <div class="form-floating">
                      <input type="email" class="form-control" id="floatingInputGrid" placeholder="name@example.com" value="mdo@example.com">
                      <label for="floatingInputGrid">
                        Email address
                      </label>
                    </div>
                  </div>
                  <div class="col-md">
                    <div class="form-floating">
                      <select class="form-select" id="floatingSelectGrid">
                        <option selected>
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
                      <label for="floatingSelectGrid">
                        Works with selects
                      </label>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("layout", renderedHtml);

        uiDocumentation.documentSource("layout");

    }


}
