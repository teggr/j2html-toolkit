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

class ButtonsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void baseClass() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                     .withType("button")
                     .withClasses(Bootstrap.btn)
                     .with(
                        text("Base class")
                      )
                );

        //language=HTML
        assertEquals("""
            <button type="button" class="btn">
              Base class
            </button>
            """, renderedHtml);

        // document
        uiDocumentation.document("base-class", renderedHtml);

        uiDocumentation.documentSource("base-class");

    }

    @Test
    void variants() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .with(
                                        text("Primary")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .with(
                                        text("Secondary")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_success)
                                .with(
                                        text("Success")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_danger)
                                .with(
                                        text("Danger")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_warning)
                                .with(
                                        text("Warning")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_info)
                                .with(
                                        text("Info")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_light)
                                .with(
                                        text("Light")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_dark)
                                .with(
                                        text("Dark")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_link)
                                .with(
                                        text("Link")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary">
                  Primary
                </button>
                <button type="button" class="btn btn-secondary">
                  Secondary
                </button>
                <button type="button" class="btn btn-success">
                  Success
                </button>
                <button type="button" class="btn btn-danger">
                  Danger
                </button>
                <button type="button" class="btn btn-warning">
                  Warning
                </button>
                <button type="button" class="btn btn-info">
                  Info
                </button>
                <button type="button" class="btn btn-light">
                  Light
                </button>
                <button type="button" class="btn btn-dark">
                  Dark
                </button>
                <button type="button" class="btn btn-link">
                  Link
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("variants", renderedHtml);

        uiDocumentation.documentSource("variants");

    }

    @Test
    void buttonTags() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        a()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withHref("#")
                                .attr(AriaRoles.roleButton)
                                .with(
                                        text("Link")
                                ),
                        button()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("submit")
                                .with(
                                        text("Button")
                                ),
                        input()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("button")
                                .withValue("Input"),
                        input()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("submit")
                                .withValue("Submit"),
                        input()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withType("reset")
                                .withValue("Reset")
                )
        );

        //language=HTML
        assertEquals("""
                <a class="btn btn-primary" href="#" role="button">
                  Link
                </a>
                <button class="btn btn-primary" type="submit">
                  Button
                </button>
                <input class="btn btn-primary" type="button" value="Input">
                <input class="btn btn-primary" type="submit" value="Submit">
                <input class="btn btn-primary" type="reset" value="Reset">
                """, renderedHtml);

        // document
        uiDocumentation.document("button-tags", renderedHtml);

        uiDocumentation.documentSource("button-tags");

    }

    @Test
    void outlineButtons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                .with(
                                        text("Primary")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                .with(
                                        text("Secondary")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                .with(
                                        text("Success")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_danger)
                                .with(
                                        text("Danger")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_warning)
                                .with(
                                        text("Warning")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_info)
                                .with(
                                        text("Info")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_light)
                                .with(
                                        text("Light")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_dark)
                                .with(
                                        text("Dark")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-outline-primary">
                  Primary
                </button>
                <button type="button" class="btn btn-outline-secondary">
                  Secondary
                </button>
                <button type="button" class="btn btn-outline-success">
                  Success
                </button>
                <button type="button" class="btn btn-outline-danger">
                  Danger
                </button>
                <button type="button" class="btn btn-outline-warning">
                  Warning
                </button>
                <button type="button" class="btn btn-outline-info">
                  Info
                </button>
                <button type="button" class="btn btn-outline-light">
                  Light
                </button>
                <button type="button" class="btn btn-outline-dark">
                  Dark
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("outline-buttons", renderedHtml);

        uiDocumentation.documentSource("outline-buttons");

    }

    @Test
    void sizes() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.btn_lg)
                                .with(
                                        text("Large button")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.btn_lg)
                                .with(
                                        text("Large button")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary btn-lg">
                  Large button
                </button>
                <button type="button" class="btn btn-secondary btn-lg">
                  Large button
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizes", renderedHtml);

        uiDocumentation.documentSource("sizes");

    }

    @Test
    void sizes2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.btn_sm)
                                .with(
                                        text("Small button")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.btn_sm)
                                .with(
                                        text("Small button")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary btn-sm">
                  Small button
                </button>
                <button type="button" class="btn btn-secondary btn-sm">
                  Small button
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizes2", renderedHtml);

        uiDocumentation.documentSource("sizes2");

    }

    @Test
    void sizes3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .withType("button")
                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                        .withStyle("--bs-btn-padding-y:.25rem; --bs-btn-padding-x:.5rem; --bs-btn-font-size:.75rem;")
                        .with(
                                text("Custom button")
                        )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary" style="--bs-btn-padding-y:.25rem; --bs-btn-padding-x:.5rem; --bs-btn-font-size:.75rem;">
                  Custom button
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizes3", renderedHtml);

        uiDocumentation.documentSource("sizes3");

    }

    @Test
    void disabledState() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withCondDisabled(true)
                                .with(
                                        text("Primary button")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withCondDisabled(true)
                                .with(
                                        text("Button")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                .withCondDisabled(true)
                                .with(
                                        text("Primary button")
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                .withCondDisabled(true)
                                .with(
                                        text("Button")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary" disabled>
                  Primary button
                </button>
                <button type="button" class="btn btn-secondary" disabled>
                  Button
                </button>
                <button type="button" class="btn btn-outline-primary" disabled>
                  Primary button
                </button>
                <button type="button" class="btn btn-outline-secondary" disabled>
                  Button
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled-state", renderedHtml);

        uiDocumentation.documentSource("disabled-state");

    }

    @Test
    void disabledState2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        a()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.disabled)
                                .attr(AriaRoles.roleButton)
                                .attr(AriaStatesAndProperties.ariaDisabled("true"))
                                .with(
                                        text("Primary link")
                                ),
                        a()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.disabled)
                                .attr(AriaRoles.roleButton)
                                .attr(AriaStatesAndProperties.ariaDisabled("true"))
                                .with(
                                        text("Link")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <a class="btn btn-primary disabled" role="button" aria-disabled="true">
                  Primary link
                </a>
                <a class="btn btn-secondary disabled" role="button" aria-disabled="true">
                  Link
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled-state2", renderedHtml);

        uiDocumentation.documentSource("disabled-state2");

    }

    @Test
    void linkCaveat() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        a()
                                .withHref("#")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.disabled)
                                .withTabindex(-1)
                                .attr(AriaRoles.roleButton)
                                .attr(
                                        AriaStatesAndProperties.ariaDisabled("true")
                                )
                                .with(
                                        text("Primary link")
                                ),
                        a()
                                .withHref("#")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary, Bootstrap.disabled)
                                .withTabindex(-1)
                                .attr(AriaRoles.roleButton)
                                .attr(
                                        AriaStatesAndProperties.ariaDisabled("true")
                                )
                                .with(
                                        text("Link")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <a href="#" class="btn btn-primary disabled" tabindex="-1" role="button" aria-disabled="true">
              Primary link
            </a>
            <a href="#" class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true">
              Link
            </a>
            """, renderedHtml);

        // document
        uiDocumentation.document("link-caveat", renderedHtml);

        uiDocumentation.documentSource("link-caveat");

    }

    @Test
    void blockButtons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_grid, Bootstrap.gap_2)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .withType("button")
                                        .with(
                                                text("Button")
                                        ),
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .withType("button")
                                        .with(
                                                text("Button")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="d-grid gap-2">
              <button class="btn btn-primary" type="button">
                Button
              </button>
              <button class="btn btn-primary" type="button">
                Button
              </button>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("block-buttons", renderedHtml);

        uiDocumentation.documentSource("block-buttons");

    }

    @Test
    void blockButtons2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_grid, Bootstrap.gap_2, Bootstrap.d_md_block)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .withType("button")
                                        .with(
                                                text("Button")
                                        ),
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .withType("button")
                                        .with(
                                                text("Button")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-grid gap-2 d-md-block">
                  <button class="btn btn-primary" type="button">
                    Button
                  </button>
                  <button class="btn btn-primary" type="button">
                    Button
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("block-buttons2", renderedHtml);

        uiDocumentation.documentSource("block-buttons2");

    }

    @Test
    void blockButtons3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_grid, Bootstrap.gap_2, Bootstrap.col_6, Bootstrap.mx_auto)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .withType("button")
                                        .with(
                                                text("Button")
                                        ),
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .withType("button")
                                        .with(
                                                text("Button")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-grid gap-2 col-6 mx-auto">
                  <button class="btn btn-primary" type="button">
                    Button
                  </button>
                  <button class="btn btn-primary" type="button">
                    Button
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("block-buttons3", renderedHtml);

        uiDocumentation.documentSource("block-buttons3");

    }

    @Test
    void blockButtons4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_grid, Bootstrap.gap_2, Bootstrap.d_md_flex, Bootstrap.justify_content_md_end)
                        .with(
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.me_md_2)
                                        .withType("button")
                                        .with(
                                                text("Button")
                                        ),
                                button()
                                        .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                        .withType("button")
                                        .with(
                                                text("Button")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                  <button class="btn btn-primary me-md-2" type="button">
                    Button
                  </button>
                  <button class="btn btn-primary" type="button">
                    Button
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("block-buttons4", renderedHtml);

        uiDocumentation.documentSource("block-buttons4");

    }

    @Test
    void toggleStates() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Bootstrap.d_inline_flex, Bootstrap.gap_1)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn)
                                                .withData("bs-toggle","button")
                                                .with(
                                                        text("Toggle button")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.active)
                                                .withData("bs-toggle","button")
                                                .attr(AriaStatesAndProperties.ariaPressed("true"))
                                                .with(
                                                        text("Active toggle button")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn)
                                                .withCondDisabled(true)
                                                .withData("bs-toggle","button")
                                                .with(
                                                        text("Disabled toggle button")
                                                )
                                ),
                        p()
                                .withClasses(Bootstrap.d_inline_flex, Bootstrap.gap_1)
                                .with(
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                .withData("bs-toggle","button")
                                                .with(
                                                        text("Toggle button")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.active)
                                                .withData("bs-toggle","button")
                                                .attr(AriaStatesAndProperties.ariaPressed("true"))
                                                .with(
                                                        text("Active toggle button")
                                                ),
                                        button()
                                                .withType("button")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                .withCondDisabled(true)
                                                .withData("bs-toggle","button")
                                                .with(
                                                        text("Disabled toggle button")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="d-inline-flex gap-1">
                  <button type="button" class="btn" data-bs-toggle="button">
                    Toggle button
                  </button>
                  <button type="button" class="btn active" data-bs-toggle="button" aria-pressed="true">
                    Active toggle button
                  </button>
                  <button type="button" class="btn" disabled data-bs-toggle="button">
                    Disabled toggle button
                  </button>
                </p>
                <p class="d-inline-flex gap-1">
                  <button type="button" class="btn btn-primary" data-bs-toggle="button">
                    Toggle button
                  </button>
                  <button type="button" class="btn btn-primary active" data-bs-toggle="button" aria-pressed="true">
                    Active toggle button
                  </button>
                  <button type="button" class="btn btn-primary" disabled data-bs-toggle="button">
                    Disabled toggle button
                  </button>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("toggle-states", renderedHtml);

        uiDocumentation.documentSource("toggle-states");

    }

    @Test
    void toggleStates2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Bootstrap.d_inline_flex, Bootstrap.gap_1)
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.btn)
                                                .attr(AriaRoles.roleButton)
                                                .withData("bs-toggle","button")
                                                .with(
                                                        text("Toggle link")
                                                ),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.btn, Bootstrap.active)
                                                .attr(AriaRoles.roleButton)
                                                .withData("bs-toggle","button")
                                                .attr(
                                                        AriaStatesAndProperties.ariaPressed("true")
                                                )
                                                .with(
                                                        text("Active toggle link")
                                                ),
                                        a()
                                                .withClasses(Bootstrap.btn, Bootstrap.disabled)
                                                .attr(
                                                        AriaStatesAndProperties.ariaDisabled("true")
                                                )
                                                .attr(AriaRoles.roleButton)
                                                .withData("bs-toggle","button")
                                                .with(
                                                        text("Disabled toggle link")
                                                )
                                ),
                        p()
                                .withClasses(Bootstrap.d_inline_flex, Bootstrap.gap_1)
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                .attr(AriaRoles.roleButton)
                                                .withData("bs-toggle","button")
                                                .with(
                                                        text("Toggle link")
                                                ),
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.active)
                                                .attr(AriaRoles.roleButton)
                                                .withData("bs-toggle","button")
                                                .attr(
                                                        AriaStatesAndProperties.ariaPressed("true")
                                                )
                                                .with(
                                                        text("Active toggle link")
                                                ),
                                        a()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.disabled)
                                                .attr(
                                                        AriaStatesAndProperties.ariaDisabled("true")
                                                )
                                                .attr(AriaRoles.roleButton)
                                                .withData("bs-toggle","button")
                                                .with(
                                                        text("Disabled toggle link")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <p class="d-inline-flex gap-1">
              <a href="#" class="btn" role="button" data-bs-toggle="button">
                Toggle link
              </a>
              <a href="#" class="btn active" role="button" data-bs-toggle="button" aria-pressed="true">
                Active toggle link
              </a>
              <a class="btn disabled" aria-disabled="true" role="button" data-bs-toggle="button">
                Disabled toggle link
              </a>
            </p>
            <p class="d-inline-flex gap-1">
              <a href="#" class="btn btn-primary" role="button" data-bs-toggle="button">
                Toggle link
              </a>
              <a href="#" class="btn btn-primary active" role="button" data-bs-toggle="button" aria-pressed="true">
                Active toggle link
              </a>
              <a class="btn btn-primary disabled" aria-disabled="true" role="button" data-bs-toggle="button">
                Disabled toggle link
              </a>
            </p>
            """, renderedHtml);

        // document
        uiDocumentation.document("toggle-states2", renderedHtml);

        uiDocumentation.documentSource("toggle-states2");

    }


}
