package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FloatTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void overview() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.float_start)
                                .with(
                                        text("Float start on all viewport sizes")
                                ),
                        br(),
                        div()
                                .withClasses(Bootstrap.float_end)
                                .with(
                                        text("Float end on all viewport sizes")
                                ),
                        br(),
                        div()
                                .withClasses(Bootstrap.float_none)
                                .with(
                                        text("Don't float on all viewport sizes")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="float-start">
                  Float start on all viewport sizes
                </div>
                <br>
                <div class="float-end">
                  Float end on all viewport sizes
                </div>
                <br>
                <div class="float-none">
                  Don&#x27;t float on all viewport sizes
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("overview", renderedHtml);

        uiDocumentation.documentSource("overview");

    }

    @Test
    void responsive() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.float_sm_end)
                                .with(
                                        text("Float end on viewports sized SM (small) or wider")
                                ),
                        br(),
                        div()
                                .withClasses(Bootstrap.float_md_end)
                                .with(
                                        text("Float end on viewports sized MD (medium) or wider")
                                ),
                        br(),
                        div()
                                .withClasses(Bootstrap.float_lg_end)
                                .with(
                                        text("Float end on viewports sized LG (large) or wider")
                                ),
                        br(),
                        div()
                                .withClasses(Bootstrap.float_xl_end)
                                .with(
                                        text("Float end on viewports sized XL (extra large) or wider")
                                ),
                        br(),
                        div()
                                .withClasses(Bootstrap.float_xxl_end)
                                .with(
                                        text("Float end on viewports sized XXL (extra extra large) or wider")
                                ),
                        br()
                )
        );

        //language=HTML
        assertEquals("""
                <div class="float-sm-end">
                  Float end on viewports sized SM (small) or wider
                </div>
                <br>
                <div class="float-md-end">
                  Float end on viewports sized MD (medium) or wider
                </div>
                <br>
                <div class="float-lg-end">
                  Float end on viewports sized LG (large) or wider
                </div>
                <br>
                <div class="float-xl-end">
                  Float end on viewports sized XL (extra large) or wider
                </div>
                <br>
                <div class="float-xxl-end">
                  Float end on viewports sized XXL (extra extra large) or wider
                </div>
                <br>
                """, renderedHtml);

        // document
        uiDocumentation.document("responsive", renderedHtml);

        uiDocumentation.documentSource("responsive");

    }


}
