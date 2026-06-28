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

class ProgressTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void howItWorks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Basic example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar)
                                                .withStyle("width: 0%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Basic example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("25")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar)
                                                .withStyle("width: 25%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Basic example")
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
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar)
                                                .withStyle("width: 50%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Basic example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("75")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar)
                                                .withStyle("width: 75%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Basic example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("100")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar)
                                                .withStyle("width: 100%")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="progress" role="progressbar" aria-label="Basic example" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100">
                  <div class="progress-bar" style="width: 0%">
                  </div>
                </div>
                <div class="progress" role="progressbar" aria-label="Basic example" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
                  <div class="progress-bar" style="width: 25%">
                  </div>
                </div>
                <div class="progress" role="progressbar" aria-label="Basic example" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">
                  <div class="progress-bar" style="width: 50%">
                  </div>
                </div>
                <div class="progress" role="progressbar" aria-label="Basic example" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">
                  <div class="progress-bar" style="width: 75%">
                  </div>
                </div>
                <div class="progress" role="progressbar" aria-label="Basic example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
                  <div class="progress-bar" style="width: 100%">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("how-it-works", renderedHtml);

        uiDocumentation.documentSource("how-it-works");

    }

    @Test
    void width() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.progress)
                        .attr(AriaRoles.roleProgressbar)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Basic example")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuenow("75")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemin("0")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemax("100")
                        )
                        .with(
                                div()
                                        .withClasses(Bootstrap.progress_bar, Bootstrap.w_75)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="progress" role="progressbar" aria-label="Basic example" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">
                  <div class="progress-bar w-75">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("width", renderedHtml);

        uiDocumentation.documentSource("width");

    }

    @Test
    void height() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Example 1px high")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("25")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .withStyle("height: 1px")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar)
                                                .withStyle("width: 25%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Example 20px high")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("25")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .withStyle("height: 20px")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar)
                                                .withStyle("width: 25%")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="progress" role="progressbar" aria-label="Example 1px high" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="height: 1px">
              <div class="progress-bar" style="width: 25%">
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Example 20px high" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="height: 20px">
              <div class="progress-bar" style="width: 25%">
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("height", renderedHtml);

        uiDocumentation.documentSource("height");

    }

    @Test
    void labels() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.progress)
                        .attr(AriaRoles.roleProgressbar)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Example with label")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuenow("25")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemin("0")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemax("100")
                        )
                        .with(
                                div()
                                        .withClasses(Bootstrap.progress_bar)
                                        .withStyle("width: 25%")
                                        .with(
                                                text("25%")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="progress" role="progressbar" aria-label="Example with label" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar" style="width: 25%">
                25%
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("labels", renderedHtml);

        uiDocumentation.documentSource("labels");

    }

    @Test
    void labels2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.progress)
                        .attr(AriaRoles.roleProgressbar)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Example with label")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuenow("10")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemin("0")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemax("100")
                        )
                        .with(
                                div()
                                        .withClasses(Bootstrap.progress_bar, Bootstrap.overflow_visible, Bootstrap.text_dark)
                                        .withStyle("width: 10%")
                                        .with(
                                                text("Long label text for the progress bar, set to a dark color")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="progress" role="progressbar" aria-label="Example with label" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar overflow-visible text-dark" style="width: 10%">
                Long label text for the progress bar, set to a dark color
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("labels2", renderedHtml);

        uiDocumentation.documentSource("labels2");

    }

    @Test
    void backgrounds() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Success example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("25")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.bg_success)
                                                .withStyle("width: 25%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Info example")
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
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.bg_info)
                                                .withStyle("width: 50%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Warning example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("75")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.bg_warning)
                                                .withStyle("width: 75%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Danger example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("100")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.bg_danger)
                                                .withStyle("width: 100%")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="progress" role="progressbar" aria-label="Success example" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar bg-success" style="width: 25%">
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Info example" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar bg-info" style="width: 50%">
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Warning example" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar bg-warning" style="width: 75%">
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Danger example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar bg-danger" style="width: 100%">
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("backgrounds", renderedHtml);

        uiDocumentation.documentSource("backgrounds");

    }

    @Test
    void backgrounds2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Success example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("25")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.bg_success)
                                                .withStyle("width: 25%")
                                                .with(
                                                        text("25%")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Info example")
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
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.bg_info, Bootstrap.text_dark)
                                                .withStyle("width: 50%")
                                                .with(
                                                        text("50%")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Warning example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("75")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.bg_warning, Bootstrap.text_dark)
                                                .withStyle("width: 75%")
                                                .with(
                                                        text("75%")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Danger example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("100")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.bg_danger)
                                                .withStyle("width: 100%")
                                                .with(
                                                        text("100%")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="progress" role="progressbar" aria-label="Success example" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar bg-success" style="width: 25%">
                25%
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Info example" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar bg-info text-dark" style="width: 50%">
                50%
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Warning example" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar bg-warning text-dark" style="width: 75%">
                75%
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Danger example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar bg-danger" style="width: 100%">
                100%
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("backgrounds2", renderedHtml);

        uiDocumentation.documentSource("backgrounds2");

    }

    @Test
    void backgrounds3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.progress)
                        .attr(AriaRoles.roleProgressbar)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Warning example")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuenow("75")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemin("0")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemax("100")
                        )
                        .with(
                                div()
                                        .withClasses(Bootstrap.progress_bar, Bootstrap.text_bg_warning)
                                        .withStyle("width: 75%")
                                        .with(
                                                text("75%")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="progress" role="progressbar" aria-label="Warning example" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar text-bg-warning" style="width: 75%">
                75%
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("backgrounds3", renderedHtml);

        uiDocumentation.documentSource("backgrounds3");

    }

    @Test
    void multipleBars() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.progress_stacked)
                        .with(
                                div()
                                        .withClasses(Bootstrap.progress)
                                        .attr(AriaRoles.roleProgressbar)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Segment one")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuenow("15")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemin("0")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemax("100")
                                        )
                                        .withStyle("width: 15%")
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.progress_bar)
                                        ),
                                div()
                                        .withClasses(Bootstrap.progress)
                                        .attr(AriaRoles.roleProgressbar)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Segment two")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuenow("30")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemin("0")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemax("100")
                                        )
                                        .withStyle("width: 30%")
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.progress_bar, Bootstrap.bg_success)
                                        ),
                                div()
                                        .withClasses(Bootstrap.progress)
                                        .attr(AriaRoles.roleProgressbar)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Segment three")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuenow("20")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemin("0")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemax("100")
                                        )
                                        .withStyle("width: 20%")
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.progress_bar, Bootstrap.bg_info)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="progress-stacked">
                  <div class="progress" role="progressbar" aria-label="Segment one" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100" style="width: 15%">
                    <div class="progress-bar">
                    </div>
                  </div>
                  <div class="progress" role="progressbar" aria-label="Segment two" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                    <div class="progress-bar bg-success">
                    </div>
                  </div>
                  <div class="progress" role="progressbar" aria-label="Segment three" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                    <div class="progress-bar bg-info">
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("multiple-bars", renderedHtml);

        uiDocumentation.documentSource("multiple-bars");

    }

    @Test
    void striped() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Default striped example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("10")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.progress_bar_striped)
                                                .withStyle("width: 10%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Success striped example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("25")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.progress_bar_striped, Bootstrap.bg_success)
                                                .withStyle("width: 25%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Info striped example")
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
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.progress_bar_striped, Bootstrap.bg_info)
                                                .withStyle("width: 50%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Warning striped example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("75")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.progress_bar_striped, Bootstrap.bg_warning)
                                                .withStyle("width: 75%")
                                ),
                        div()
                                .withClasses(Bootstrap.progress)
                                .attr(AriaRoles.roleProgressbar)
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("Danger striped example")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuenow("100")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemin("0")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaValuemax("100")
                                )
                                .with(
                                        div()
                                                .withClasses(Bootstrap.progress_bar, Bootstrap.progress_bar_striped, Bootstrap.bg_danger)
                                                .withStyle("width: 100%")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="progress" role="progressbar" aria-label="Default striped example" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar progress-bar-striped" style="width: 10%">
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Success striped example" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar progress-bar-striped bg-success" style="width: 25%">
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Info striped example" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar progress-bar-striped bg-info" style="width: 50%">
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Warning striped example" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar progress-bar-striped bg-warning" style="width: 75%">
              </div>
            </div>
            <div class="progress" role="progressbar" aria-label="Danger striped example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar progress-bar-striped bg-danger" style="width: 100%">
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("striped", renderedHtml);

        uiDocumentation.documentSource("striped");

    }

    @Test
    void animatedStripes() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.progress)
                        .attr(AriaRoles.roleProgressbar)
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Animated striped example")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuenow("75")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemin("0")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaValuemax("100")
                        )
                        .with(
                                div()
                                        .withClasses(Bootstrap.progress_bar, Bootstrap.progress_bar_striped, Bootstrap.progress_bar_animated)
                                        .withStyle("width: 75%")
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="progress" role="progressbar" aria-label="Animated striped example" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100">
              <div class="progress-bar progress-bar-striped progress-bar-animated" style="width: 75%">
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("animated-stripes", renderedHtml);

        uiDocumentation.documentSource("animated-stripes");

    }


}
