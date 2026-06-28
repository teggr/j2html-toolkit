package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OverflowTest {

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
                                .withClasses(Bootstrap.overflow_auto)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_hidden)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_visible)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_scroll)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="overflow-auto">
                  ...
                </div>
                <div class="overflow-hidden">
                  ...
                </div>
                <div class="overflow-visible">
                  ...
                </div>
                <div class="overflow-scroll">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

    @Test
    void overflowX() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.overflow_x_auto)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_x_hidden)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_x_visible)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_x_scroll)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="overflow-x-auto">
                  ...
                </div>
                <div class="overflow-x-hidden">
                  ...
                </div>
                <div class="overflow-x-visible">
                  ...
                </div>
                <div class="overflow-x-scroll">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("overflow-x", renderedHtml);

        uiDocumentation.documentSource("overflow-x");

    }

    @Test
    void overflowY() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.overflow_y_auto)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_y_hidden)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_y_visible)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.overflow_y_scroll)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="overflow-y-auto">
                  ...
                </div>
                <div class="overflow-y-hidden">
                  ...
                </div>
                <div class="overflow-y-visible">
                  ...
                </div>
                <div class="overflow-y-scroll">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("overflow-y", renderedHtml);

        uiDocumentation.documentSource("overflow-y");

    }

}
