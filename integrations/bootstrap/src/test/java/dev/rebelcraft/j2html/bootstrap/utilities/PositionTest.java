package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.path;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.svg;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void positionValues() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.position_static)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.position_relative)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.position_absolute)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.position_fixed)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.position_sticky)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="position-static">
                  ...
                </div>
                <div class="position-relative">
                  ...
                </div>
                <div class="position-absolute">
                  ...
                </div>
                <div class="position-fixed">
                  ...
                </div>
                <div class="position-sticky">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("position-values", renderedHtml);

        uiDocumentation.documentSource("position-values");

    }

    @Test
    void arrangeElements() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.position_relative)
                        .with(
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_0),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.end_0),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_50, Bootstrap.start_50),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.bottom_50, Bootstrap.end_50),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.bottom_0, Bootstrap.start_0),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.bottom_0, Bootstrap.end_0)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="position-relative">
                  <div class="position-absolute top-0 start-0">
                  </div>
                  <div class="position-absolute top-0 end-0">
                  </div>
                  <div class="position-absolute top-50 start-50">
                  </div>
                  <div class="position-absolute bottom-50 end-50">
                  </div>
                  <div class="position-absolute bottom-0 start-0">
                  </div>
                  <div class="position-absolute bottom-0 end-0">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("arrange-elements", renderedHtml);

        uiDocumentation.documentSource("arrange-elements");

    }

    @Test
    void centerElements() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.position_relative)
                        .with(
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_0, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_50, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_100, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_50, Bootstrap.start_0, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_50, Bootstrap.start_50, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_50, Bootstrap.start_100, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_100, Bootstrap.start_0, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_100, Bootstrap.start_50, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_100, Bootstrap.start_100, Bootstrap.translate_middle)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="position-relative">
                  <div class="position-absolute top-0 start-0 translate-middle">
                  </div>
                  <div class="position-absolute top-0 start-50 translate-middle">
                  </div>
                  <div class="position-absolute top-0 start-100 translate-middle">
                  </div>
                  <div class="position-absolute top-50 start-0 translate-middle">
                  </div>
                  <div class="position-absolute top-50 start-50 translate-middle">
                  </div>
                  <div class="position-absolute top-50 start-100 translate-middle">
                  </div>
                  <div class="position-absolute top-100 start-0 translate-middle">
                  </div>
                  <div class="position-absolute top-100 start-50 translate-middle">
                  </div>
                  <div class="position-absolute top-100 start-100 translate-middle">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("center-elements", renderedHtml);

        uiDocumentation.documentSource("center-elements");

    }

    @Test
    void centerElements2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.position_relative)
                        .with(
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_0),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_50, Bootstrap.translate_middle_x),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.end_0),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_50, Bootstrap.start_0, Bootstrap.translate_middle_y),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_50, Bootstrap.start_50, Bootstrap.translate_middle),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_50, Bootstrap.end_0, Bootstrap.translate_middle_y),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.bottom_0, Bootstrap.start_0),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.bottom_0, Bootstrap.start_50, Bootstrap.translate_middle_x),
                                div()
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.bottom_0, Bootstrap.end_0)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="position-relative">
                  <div class="position-absolute top-0 start-0">
                  </div>
                  <div class="position-absolute top-0 start-50 translate-middle-x">
                  </div>
                  <div class="position-absolute top-0 end-0">
                  </div>
                  <div class="position-absolute top-50 start-0 translate-middle-y">
                  </div>
                  <div class="position-absolute top-50 start-50 translate-middle">
                  </div>
                  <div class="position-absolute top-50 end-0 translate-middle-y">
                  </div>
                  <div class="position-absolute bottom-0 start-0">
                  </div>
                  <div class="position-absolute bottom-0 start-50 translate-middle-x">
                  </div>
                  <div class="position-absolute bottom-0 end-0">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("center-elements2", renderedHtml);

        uiDocumentation.documentSource("center-elements2");

    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.position_relative)
                                .with(
                                        text("Mails"),
                                        span()
                                                .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_100, Bootstrap.translate_middle, Bootstrap.badge, Bootstrap.rounded_pill, Bootstrap.text_bg_secondary)
                                                .with(
                                                        text("+99"),
                                                        span()
                                                                .withClasses(Bootstrap.visually_hidden)
                                                                .with(
                                                                        text("unread messages")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.position_relative, Bootstrap.py_2, Bootstrap.px_4, Bootstrap.text_bg_secondary, Bootstrap.border, Bootstrap.border_secondary, Bootstrap.rounded_pill)
                                .with(
                                        text("Marker"),
                                        svg()
                                                .attr("width", "1em")
                                                .attr("height", "1em")
                                                .attr("viewBox", "0 0 16 16")
                                                .withClasses(Bootstrap.position_absolute, Bootstrap.top_100, Bootstrap.start_50, Bootstrap.translate_middle, Bootstrap.mt_1)
                                                .attr("fill", "var(--bs-secondary)")
                                                .attr("xmlns", "http://www.w3.org/2000/svg")
                                                .with(
                                                        path()
                                                                .attr("d", "M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1.753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z")
                                                )
                                ),
                        button()
                                .withType("button")
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary, Bootstrap.position_relative)
                                .with(
                                        text("Alerts"),
                                        span()
                                                .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_100, Bootstrap.translate_middle, Bootstrap.badge, Bootstrap.border, Bootstrap.border_light, Bootstrap.rounded_circle, Bootstrap.bg_danger, Bootstrap.p_2)
                                                .with(
                                                        span()
                                                                .withClasses(Bootstrap.visually_hidden)
                                                                .with(
                                                                        text("unread messages")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary position-relative">
                  Mails 
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill text-bg-secondary">
                    +99 
                    <span class="visually-hidden">
                      unread messages
                    </span>
                  </span>
                </button>
                <div class="position-relative py-2 px-4 text-bg-secondary border border-secondary rounded-pill">
                  Marker 
                  <svg width="1em" height="1em" viewBox="0 0 16 16" class="position-absolute top-100 start-50 translate-middle mt-1" fill="var(--bs-secondary)" xmlns="http://www.w3.org/2000/svg">
                    <path d="M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1.753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z">
                    </path>
                  </svg>
                </div>
                <button type="button" class="btn btn-primary position-relative">
                  Alerts 
                  <span class="position-absolute top-0 start-100 translate-middle badge border border-light rounded-circle bg-danger p-2">
                    <span class="visually-hidden">
                      unread messages
                    </span>
                  </span>
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

    @Test
    void examples2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.position_relative, Bootstrap.m_4)
                        .with(
                                div()
                                        .withClasses(Bootstrap.progress)
                                        .attr(AriaRoles.roleProgressbar)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Progress")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuenow("50")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemin("0")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemax("100")
                                        )
                                        .withStyle("height: 1px;")
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.progress_bar)
                                                        .withStyle("width: 50%")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_0, Bootstrap.translate_middle, Bootstrap.btn, Bootstrap.btn_sm, Bootstrap.btn_primary, Bootstrap.rounded_pill)
                                        .withStyle("width: 2rem; height:2rem;")
                                        .with(
                                                text("1")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_50, Bootstrap.translate_middle, Bootstrap.btn, Bootstrap.btn_sm, Bootstrap.btn_primary, Bootstrap.rounded_pill)
                                        .withStyle("width: 2rem; height:2rem;")
                                        .with(
                                                text("2")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Bootstrap.position_absolute, Bootstrap.top_0, Bootstrap.start_100, Bootstrap.translate_middle, Bootstrap.btn, Bootstrap.btn_sm, Bootstrap.btn_secondary, Bootstrap.rounded_pill)
                                        .withStyle("width: 2rem; height:2rem;")
                                        .with(
                                                text("3")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="position-relative m-4">
                  <div class="progress" role="progressbar" aria-label="Progress" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="height: 1px;">
                    <div class="progress-bar" style="width: 50%">
                    </div>
                  </div>
                  <button type="button" class="position-absolute top-0 start-0 translate-middle btn btn-sm btn-primary rounded-pill" style="width: 2rem; height:2rem;">
                    1
                  </button>
                  <button type="button" class="position-absolute top-0 start-50 translate-middle btn btn-sm btn-primary rounded-pill" style="width: 2rem; height:2rem;">
                    2
                  </button>
                  <button type="button" class="position-absolute top-0 start-100 translate-middle btn btn-sm btn-secondary rounded-pill" style="width: 2rem; height:2rem;">
                    3
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples2", renderedHtml);

        uiDocumentation.documentSource("examples2");

    }


}
