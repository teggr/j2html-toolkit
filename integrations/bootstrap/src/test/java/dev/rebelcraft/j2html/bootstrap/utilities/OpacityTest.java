package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OpacityTest {

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
                                .withClasses(Bootstrap.opacity_100)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.opacity_75)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.opacity_50)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.opacity_25)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.opacity_0)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="opacity-100">
                  ...
                </div>
                <div class="opacity-75">
                  ...
                </div>
                <div class="opacity-50">
                  ...
                </div>
                <div class="opacity-25">
                  ...
                </div>
                <div class="opacity-0">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

}
