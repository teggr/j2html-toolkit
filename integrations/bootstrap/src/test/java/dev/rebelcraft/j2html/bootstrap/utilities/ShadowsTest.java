package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShadowsTest {

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
                                .withClasses(Bootstrap.shadow_none, Bootstrap.p_3, Bootstrap.mb_5, Bootstrap.bg_body_tertiary, Bootstrap.rounded)
                                .with(
                                        text("No shadow")
                                ),
                        div()
                                .withClasses(Bootstrap.shadow_sm, Bootstrap.p_3, Bootstrap.mb_5, Bootstrap.bg_body_tertiary, Bootstrap.rounded)
                                .with(
                                        text("Small shadow")
                                ),
                        div()
                                .withClasses(Bootstrap.shadow, Bootstrap.p_3, Bootstrap.mb_5, Bootstrap.bg_body_tertiary, Bootstrap.rounded)
                                .with(
                                        text("Regular shadow")
                                ),
                        div()
                                .withClasses(Bootstrap.shadow_lg, Bootstrap.p_3, Bootstrap.mb_5, Bootstrap.bg_body_tertiary, Bootstrap.rounded)
                                .with(
                                        text("Larger shadow")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="shadow-none p-3 mb-5 bg-body-tertiary rounded">
                  No shadow
                </div>
                <div class="shadow-sm p-3 mb-5 bg-body-tertiary rounded">
                  Small shadow
                </div>
                <div class="shadow p-3 mb-5 bg-body-tertiary rounded">
                  Regular shadow
                </div>
                <div class="shadow-lg p-3 mb-5 bg-body-tertiary rounded">
                  Larger shadow
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

}
