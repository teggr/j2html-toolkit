package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormControlsTest {

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
                                .withClasses(Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("exampleFormControlInput1")
                                                .withClasses(Bootstrap.form_label)
                                                .with(
                                                        text("Email address")
                                                ),
                                        input()
                                                .withType("email")
                                                .withClasses(Bootstrap.form_control)
                                                .withId("exampleFormControlInput1")
                                                .withPlaceholder("name@example.com")
                                ),
                        div()
                                .withClasses(Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("exampleFormControlTextarea1")
                                                .withClasses(Bootstrap.form_label)
                                                .with(
                                                        text("Example textarea")
                                                ),
                                        textarea()
                                                .withClasses(Bootstrap.form_control)
                                                .withId("exampleFormControlTextarea1")
                                                .withRows("3")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="mb-3">
                  <label for="exampleFormControlInput1" class="form-label">
                    Email address
                  </label>
                  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
                </div>
                <div class="mb-3">
                  <label for="exampleFormControlTextarea1" class="form-label">
                    Example textarea
                  </label>
                  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void sizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        input()
                                .withClasses(Bootstrap.form_control, Bootstrap.form_control_lg)
                                .withType("text")
                                .withPlaceholder(".form-control-lg")
                                .attr(AriaStatesAndProperties.ariaLabel(".form-control-lg example")),
                        input()
                                .withClasses(Bootstrap.form_control)
                                .withType("text")
                                .withPlaceholder("Default input")
                                .attr(AriaStatesAndProperties.ariaLabel("default input example")),
                        input()
                                .withClasses(Bootstrap.form_control, Bootstrap.form_control_sm)
                                .withType("text")
                                .withPlaceholder(".form-control-sm")
                                .attr(AriaStatesAndProperties.ariaLabel(".form-control-sm example"))
                )
        );

        //language=HTML
        assertEquals("""
                <input class="form-control form-control-lg" type="text" placeholder=".form-control-lg" aria-label=".form-control-lg example">
                <input class="form-control" type="text" placeholder="Default input" aria-label="default input example">
                <input class="form-control form-control-sm" type="text" placeholder=".form-control-sm" aria-label=".form-control-sm example">
                """, renderedHtml);

        // document
        uiDocumentation.document("sizing", renderedHtml);

        uiDocumentation.documentSource("sizing");

    }

    @Test
    void formText() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        label()
                                .withFor("inputPassword5")
                                .withClasses(Bootstrap.form_label)
                                .with(
                                        text("Password")
                                ),
                        input()
                                .withType("password")
                                .withId("inputPassword5")
                                .withClasses(Bootstrap.form_control)
                                .attr(AriaStatesAndProperties.ariaDescribedby("passwordHelpBlock")),
                        div()
                                .withId("passwordHelpBlock")
                                .withClasses(Bootstrap.form_text)
                                .with(
                                        text("Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <label for="inputPassword5" class="form-label">
                  Password
                </label>
                <input type="password" id="inputPassword5" class="form-control" aria-describedby="passwordHelpBlock">
                <div id="passwordHelpBlock" class="form-text">
                  Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("form-text", renderedHtml);

        uiDocumentation.documentSource("form-text");

    }

    @Test
    void formText2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.row, Bootstrap.g_3, Bootstrap.align_items_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                label()
                                                        .withFor("inputPassword6")
                                                        .withClasses(Bootstrap.col_form_label)
                                                        .with(
                                                                text("Password")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                input()
                                                        .withType("password")
                                                        .withId("inputPassword6")
                                                        .withClasses(Bootstrap.form_control)
                                                        .attr(AriaStatesAndProperties.ariaDescribedby("passwordHelpInline"))
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                span()
                                                        .withId("passwordHelpInline")
                                                        .withClasses(Bootstrap.form_text)
                                                        .with(
                                                                text("Must be 8-20 characters long.")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row g-3 align-items-center">
                  <div class="col-auto">
                    <label for="inputPassword6" class="col-form-label">
                      Password
                    </label>
                  </div>
                  <div class="col-auto">
                    <input type="password" id="inputPassword6" class="form-control" aria-describedby="passwordHelpInline">
                  </div>
                  <div class="col-auto">
                    <span id="passwordHelpInline" class="form-text">
                      Must be 8-20 characters long.
                    </span>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("form-text2", renderedHtml);

        uiDocumentation.documentSource("form-text2");

    }

    @Test
    void disabled() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        input()
                                .withClasses(Bootstrap.form_control)
                                .withType("text")
                                .withPlaceholder("Disabled input")
                                .attr(AriaStatesAndProperties.ariaLabel("Disabled input example"))
                                .withCondDisabled(true ),
                        input()
                                .withClasses(Bootstrap.form_control)
                                .withType("text")
                                .withValue("Disabled readonly input")
                                .attr(AriaStatesAndProperties.ariaLabel("Disabled input example"))
                                .withCondDisabled(true)
                                .withCondReadonly(true)
                )
        );

        //language=HTML
        assertEquals("""
                <input class="form-control" type="text" placeholder="Disabled input" aria-label="Disabled input example" disabled>
                <input class="form-control" type="text" value="Disabled readonly input" aria-label="Disabled input example" disabled readonly>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled", renderedHtml);

        uiDocumentation.documentSource("disabled");

    }

    @Test
    void readOnly() throws Exception {

        String renderedHtml = uiDocumentation.render(
                input()
                        .withClasses(Bootstrap.form_control)
                        .withType("text")
                        .withValue("Readonly input here...")
                        .attr(AriaStatesAndProperties.ariaLabel("readonly input example"))
                        .withCondReadonly(true)
        );

        //language=HTML
        assertEquals("""
                <input class="form-control" type="text" value="Readonly input here..." aria-label="readonly input example" readonly>
                """, renderedHtml);

        // document
        uiDocumentation.document("read-only", renderedHtml);

        uiDocumentation.documentSource("read-only");

    }

    @Test
    void readOnlyPlainText() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.mb_3, Bootstrap.row)
                                .with(
                                        label()
                                                .withFor("staticEmail")
                                                .withClasses(Bootstrap.col_sm_2, Bootstrap.col_form_label)
                                                .with(
                                                        text("Email")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.col_sm_10)
                                                .with(
                                                        input()
                                                                .withType("text")
                                                                .withCondReadonly(true)
                                                                .withClasses(Bootstrap.form_control_plaintext)
                                                                .withId("staticEmail")
                                                                .withValue("email@example.com")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.mb_3, Bootstrap.row)
                                .with(
                                        label()
                                                .withFor("inputPassword")
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
                                                                .withId("inputPassword")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="mb-3 row">
                  <label for="staticEmail" class="col-sm-2 col-form-label">
                    Email
                  </label>
                  <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="email@example.com">
                  </div>
                </div>
                <div class="mb-3 row">
                  <label for="inputPassword" class="col-sm-2 col-form-label">
                    Password
                  </label>
                  <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("read-only-plain-text", renderedHtml);

        uiDocumentation.documentSource("read-only-plain-text");

    }

    @Test
    void readOnlyPlainText2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .withClasses(Bootstrap.row, Bootstrap.g_3)
                        .with(
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                label()
                                                        .withFor("staticEmail2")
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Email")
                                                        ),
                                                input()
                                                        .withType("text")
                                                        .withCondReadonly(true)
                                                        .withClasses(Bootstrap.form_control_plaintext)
                                                        .withId("staticEmail2")
                                                        .withValue("email@example.com")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                label()
                                                        .withFor("inputPassword2")
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Password")
                                                        ),
                                                input()
                                                        .withType("password")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("inputPassword2")
                                                        .withPlaceholder("Password")
                                        ),
                                div()
                                        .withClasses(Bootstrap.col_auto)
                                        .with(
                                                button()
                                                        .withType("submit")
                                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.mb_3)
                                                        .with(
                                                                text("Confirm identity")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form class="row g-3">
                  <div class="col-auto">
                    <label for="staticEmail2" class="visually-hidden">
                      Email
                    </label>
                    <input type="text" readonly class="form-control-plaintext" id="staticEmail2" value="email@example.com">
                  </div>
                  <div class="col-auto">
                    <label for="inputPassword2" class="visually-hidden">
                      Password
                    </label>
                    <input type="password" class="form-control" id="inputPassword2" placeholder="Password">
                  </div>
                  <div class="col-auto">
                    <button type="submit" class="btn btn-primary mb-3">
                      Confirm identity
                    </button>
                  </div>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("read-only-plain-text2", renderedHtml);

        uiDocumentation.documentSource("read-only-plain-text2");

    }

    @Test
    void fileInput() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("formFile")
                                                .withClasses(Bootstrap.form_label)
                                                .with(
                                                        text("Default file input example")
                                                ),
                                        input()
                                                .withClasses(Bootstrap.form_control)
                                                .withType("file")
                                                .withId("formFile")
                                ),
                        div()
                                .withClasses(Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("formFileMultiple")
                                                .withClasses(Bootstrap.form_label)
                                                .with(
                                                        text("Multiple files input example")
                                                ),
                                        input()
                                                .withClasses(Bootstrap.form_control)
                                                .withType("file")
                                                .withId("formFileMultiple")
                                                .withCondMultiple(true)
                                ),
                        div()
                                .withClasses(Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("formFileDisabled")
                                                .withClasses(Bootstrap.form_label)
                                                .with(
                                                        text("Disabled file input example")
                                                ),
                                        input()
                                                .withClasses(Bootstrap.form_control)
                                                .withType("file")
                                                .withId("formFileDisabled")
                                                .withCondDisabled(true)
                                ),
                        div()
                                .withClasses(Bootstrap.mb_3)
                                .with(
                                        label()
                                                .withFor("formFileSm")
                                                .withClasses(Bootstrap.form_label)
                                                .with(
                                                        text("Small file input example")
                                                ),
                                        input()
                                                .withClasses(Bootstrap.form_control, Bootstrap.form_control_sm)
                                                .withId("formFileSm")
                                                .withType("file")
                                ),
                        div()
                                .with(
                                        label()
                                                .withFor("formFileLg")
                                                .withClasses(Bootstrap.form_label)
                                                .with(
                                                        text("Large file input example")
                                                ),
                                        input()
                                                .withClasses(Bootstrap.form_control, Bootstrap.form_control_lg)
                                                .withId("formFileLg")
                                                .withType("file")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="mb-3">
                  <label for="formFile" class="form-label">
                    Default file input example
                  </label>
                  <input class="form-control" type="file" id="formFile">
                </div>
                <div class="mb-3">
                  <label for="formFileMultiple" class="form-label">
                    Multiple files input example
                  </label>
                  <input class="form-control" type="file" id="formFileMultiple" multiple>
                </div>
                <div class="mb-3">
                  <label for="formFileDisabled" class="form-label">
                    Disabled file input example
                  </label>
                  <input class="form-control" type="file" id="formFileDisabled" disabled>
                </div>
                <div class="mb-3">
                  <label for="formFileSm" class="form-label">
                    Small file input example
                  </label>
                  <input class="form-control form-control-sm" id="formFileSm" type="file">
                </div>
                <div>
                  <label for="formFileLg" class="form-label">
                    Large file input example
                  </label>
                  <input class="form-control form-control-lg" id="formFileLg" type="file">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("file-input", renderedHtml);

        uiDocumentation.documentSource("file-input");

    }

    @Test
    void color() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        label()
                                .withFor("exampleColorInput")
                                .withClasses(Bootstrap.form_label)
                                .with(
                                        text("Color picker")
                                ),
                        input()
                                .withType("color")
                                .withClasses(Bootstrap.form_control, Bootstrap.form_control_color)
                                .withId("exampleColorInput")
                                .withValue("#563d7c")
                                .withTitle("Choose your color")
                )
        );

        //language=HTML
        assertEquals("""
                <label for="exampleColorInput" class="form-label">
                  Color picker
                </label>
                <input type="color" class="form-control form-control-color" id="exampleColorInput" value="#563d7c" title="Choose your color">
                """, renderedHtml);

        // document
        uiDocumentation.document("color", renderedHtml);

        uiDocumentation.documentSource("color");

    }

    @Test
    void datalists() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        label()
                                .withFor("exampleDataList")
                                .withClasses(Bootstrap.form_label)
                                .with(
                                        text("Datalist example")
                                ),
                        input()
                                .withClasses(Bootstrap.form_control)
                                .withList("datalistOptions")
                                .withId("exampleDataList")
                                .withPlaceholder("Type to search..."),
                        datalist()
                                .withId("datalistOptions")
                                .with(
                                        option()
                                                .withValue("San Francisco"),
                                        option()
                                                .withValue("New York"),
                                        option()
                                                .withValue("Seattle"),
                                        option()
                                                .withValue("Los Angeles"),
                                        option()
                                                .withValue("Chicago")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <label for="exampleDataList" class="form-label">
                  Datalist example
                </label>
                <input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Type to search...">
                <datalist id="datalistOptions">
                  <option value="San Francisco">
                  </option>
                  <option value="New York">
                  </option>
                  <option value="Seattle">
                  </option>
                  <option value="Los Angeles">
                  </option>
                  <option value="Chicago">
                  </option>
                </datalist>
                """, renderedHtml);

        // document
        uiDocumentation.document("datalists", renderedHtml);

        uiDocumentation.documentSource("datalists");

    }


}
