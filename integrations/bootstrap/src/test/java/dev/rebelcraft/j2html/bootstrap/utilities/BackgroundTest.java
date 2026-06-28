package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackgroundTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void backgroundColor() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_primary, Bootstrap.text_white)
                                .with(
                                        text(".bg-primary")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_primary_subtle, Bootstrap.text_primary_emphasis)
                                .with(
                                        text(".bg-primary-subtle")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_secondary, Bootstrap.text_white)
                                .with(
                                        text(".bg-secondary")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_secondary_subtle, Bootstrap.text_secondary_emphasis)
                                .with(
                                        text(".bg-secondary-subtle")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_success, Bootstrap.text_white)
                                .with(
                                        text(".bg-success")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_success_subtle, Bootstrap.text_success_emphasis)
                                .with(
                                        text(".bg-success-subtle")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_danger, Bootstrap.text_white)
                                .with(
                                        text(".bg-danger")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_danger_subtle, Bootstrap.text_danger_emphasis)
                                .with(
                                        text(".bg-danger-subtle")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_warning, Bootstrap.text_dark)
                                .with(
                                        text(".bg-warning")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_warning_subtle, Bootstrap.text_warning_emphasis)
                                .with(
                                        text(".bg-warning-subtle")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_info, Bootstrap.text_dark)
                                .with(
                                        text(".bg-info")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_info_subtle, Bootstrap.text_info_emphasis)
                                .with(
                                        text(".bg-info-subtle")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_light, Bootstrap.text_dark)
                                .with(
                                        text(".bg-light")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_light_subtle, Bootstrap.text_light_emphasis)
                                .with(
                                        text(".bg-light-subtle")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_dark, Bootstrap.text_white)
                                .with(
                                        text(".bg-dark")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_dark_subtle, Bootstrap.text_dark_emphasis)
                                .with(
                                        text(".bg-dark-subtle")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_body_secondary)
                                .with(
                                        text(".bg-body-secondary")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_body_tertiary)
                                .with(
                                        text(".bg-body-tertiary")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_body, Bootstrap.text_body)
                                .with(
                                        text(".bg-body")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_black, Bootstrap.text_white)
                                .with(
                                        text(".bg-black")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_white, Bootstrap.text_dark)
                                .with(
                                        text(".bg-white")
                                ),
                        div()
                                .withClasses(Bootstrap.p_3, Bootstrap.mb_2, Bootstrap.bg_transparent, Bootstrap.text_body)
                                .with(
                                        text(".bg-transparent")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="p-3 mb-2 bg-primary text-white">
                  .bg-primary
                </div>
                <div class="p-3 mb-2 bg-primary-subtle text-primary-emphasis">
                  .bg-primary-subtle
                </div>
                <div class="p-3 mb-2 bg-secondary text-white">
                  .bg-secondary
                </div>
                <div class="p-3 mb-2 bg-secondary-subtle text-secondary-emphasis">
                  .bg-secondary-subtle
                </div>
                <div class="p-3 mb-2 bg-success text-white">
                  .bg-success
                </div>
                <div class="p-3 mb-2 bg-success-subtle text-success-emphasis">
                  .bg-success-subtle
                </div>
                <div class="p-3 mb-2 bg-danger text-white">
                  .bg-danger
                </div>
                <div class="p-3 mb-2 bg-danger-subtle text-danger-emphasis">
                  .bg-danger-subtle
                </div>
                <div class="p-3 mb-2 bg-warning text-dark">
                  .bg-warning
                </div>
                <div class="p-3 mb-2 bg-warning-subtle text-warning-emphasis">
                  .bg-warning-subtle
                </div>
                <div class="p-3 mb-2 bg-info text-dark">
                  .bg-info
                </div>
                <div class="p-3 mb-2 bg-info-subtle text-info-emphasis">
                  .bg-info-subtle
                </div>
                <div class="p-3 mb-2 bg-light text-dark">
                  .bg-light
                </div>
                <div class="p-3 mb-2 bg-light-subtle text-light-emphasis">
                  .bg-light-subtle
                </div>
                <div class="p-3 mb-2 bg-dark text-white">
                  .bg-dark
                </div>
                <div class="p-3 mb-2 bg-dark-subtle text-dark-emphasis">
                  .bg-dark-subtle
                </div>
                <div class="p-3 mb-2 bg-body-secondary">
                  .bg-body-secondary
                </div>
                <div class="p-3 mb-2 bg-body-tertiary">
                  .bg-body-tertiary
                </div>
                <div class="p-3 mb-2 bg-body text-body">
                  .bg-body
                </div>
                <div class="p-3 mb-2 bg-black text-white">
                  .bg-black
                </div>
                <div class="p-3 mb-2 bg-white text-dark">
                  .bg-white
                </div>
                <div class="p-3 mb-2 bg-transparent text-body">
                  .bg-transparent
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("background-color", renderedHtml);

        uiDocumentation.documentSource("background-color");

    }

}
