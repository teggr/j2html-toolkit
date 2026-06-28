package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ZIndexTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.z_3, Bootstrap.position_absolute, Bootstrap.p_5, Bootstrap.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-3")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.z_2, Bootstrap.position_absolute, Bootstrap.p_5, Bootstrap.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-2")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.z_1, Bootstrap.position_absolute, Bootstrap.p_5, Bootstrap.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-1")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.z_0, Bootstrap.position_absolute, Bootstrap.p_5, Bootstrap.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-0")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.z_n1, Bootstrap.position_absolute, Bootstrap.p_5, Bootstrap.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-n1")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="z-3 position-absolute p-5 rounded-3">
                  <span>
                    z-3
                  </span>
                </div>
                <div class="z-2 position-absolute p-5 rounded-3">
                  <span>
                    z-2
                  </span>
                </div>
                <div class="z-1 position-absolute p-5 rounded-3">
                  <span>
                    z-1
                  </span>
                </div>
                <div class="z-0 position-absolute p-5 rounded-3">
                  <span>
                    z-0
                  </span>
                </div>
                <div class="z-n1 position-absolute p-5 rounded-3">
                  <span>
                    z-n1
                  </span>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

}
