package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormsOverviewTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void overview() throws Exception {

        String renderedHtml = uiDocumentation.render(
                form()
                        .with(
                                div()
                                        .withClasses(Bootstrap.mb_3)
                                        .with(
                                                label()
                                                        .withFor("exampleInputEmail1")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Email address")
                                                        ),
                                                input()
                                                        .withType("email")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("exampleInputEmail1")
                                                        .attr(AriaStatesAndProperties.ariaDescribedby("emailHelp")),
                                                div()
                                                        .withId("emailHelp")
                                                        .withClasses(Bootstrap.form_text)
                                                        .with(
                                                                text("We'll never share your email with anyone else.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.mb_3)
                                        .with(
                                                label()
                                                        .withFor("exampleInputPassword1")
                                                        .withClasses(Bootstrap.form_label)
                                                        .with(
                                                                text("Password")
                                                        ),
                                                input()
                                                        .withType("password")
                                                        .withClasses(Bootstrap.form_control)
                                                        .withId("exampleInputPassword1")
                                        ),
                                div()
                                        .withClasses(Bootstrap.mb_3, Bootstrap.form_check)
                                        .with(
                                                input()
                                                        .withType("checkbox")
                                                        .withClasses(Bootstrap.form_check_input)
                                                        .withId("exampleCheck1"),
                                                label()
                                                        .withClasses(Bootstrap.form_check_label)
                                                        .withFor("exampleCheck1")
                                                        .with(
                                                                text("Check me out")
                                                        )
                                        ),
                                button()
                                        .withType("submit")
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .with(
                                                text("Submit")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <form>
                  <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">
                      Email address
                    </label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">
                      We&#x27;ll never share your email with anyone else.
                    </div>
                  </div>
                  <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">
                      Password
                    </label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                  </div>
                  <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">
                      Check me out
                    </label>
                  </div>
                  <button type="submit" class="btn btn-primary">
                    Submit
                  </button>
                </form>
                """, renderedHtml);

        // document
        uiDocumentation.document("overview", renderedHtml);

        uiDocumentation.documentSource("overview");

    }


}
