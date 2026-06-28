package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RangeTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void overview() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        label()
                                .withFor("customRange1")
                                .withClasses(Bootstrap.form_label)
                                .with(
                                        text("Example range")
                                ),
                        input()
                                .withType("range")
                                .withClasses(Bootstrap.form_range)
                                .withId("customRange1")
                )
        );

        //language=HTML
        assertEquals("""
                <label for="customRange1" class="form-label">
                  Example range
                </label>
                <input type="range" class="form-range" id="customRange1">
                """, renderedHtml);

        // document
        uiDocumentation.document("overview", renderedHtml);

        uiDocumentation.documentSource("overview");

    }

    @Test
    void disabled() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        label()
                                .withFor("disabledRange")
                                .withClasses(Bootstrap.form_label)
                                .with(
                                        text("Disabled range")
                                ),
                        input()
                                .withType("range")
                                .withClasses(Bootstrap.form_range)
                                .withId("disabledRange")
                                .withCondDisabled(true)
                )
        );

        //language=HTML
        assertEquals("""
                <label for="disabledRange" class="form-label">
                  Disabled range
                </label>
                <input type="range" class="form-range" id="disabledRange" disabled>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled", renderedHtml);

        uiDocumentation.documentSource("disabled");

    }

    @Test
    void minAndMax() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        label()
                                .withFor("customRange2")
                                .withClasses(Bootstrap.form_label)
                                .with(
                                        text("Example range")
                                ),
                        input()
                                .withType("range")
                                .withClasses(Bootstrap.form_range)
                                .withMin("0")
                                .withMax("5")
                                .withId("customRange2")
                )
        );

        //language=HTML
        assertEquals("""
                <label for="customRange2" class="form-label">
                  Example range
                </label>
                <input type="range" class="form-range" min="0" max="5" id="customRange2">
                """, renderedHtml);

        // document
        uiDocumentation.document("min-and-max", renderedHtml);

        uiDocumentation.documentSource("min-and-max");

    }

    @Test
    void steps() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        label()
                                .withFor("customRange3")
                                .withClasses(Bootstrap.form_label)
                                .with(
                                        text("Example range")
                                ),
                        input()
                                .withType("range")
                                .withClasses(Bootstrap.form_range)
                                .withMin("0")
                                .withMax("5")
                                .withStep("0.5")
                                .withId("customRange3")
                )
        );

        //language=HTML
        assertEquals("""
                <label for="customRange3" class="form-label">
                  Example range
                </label>
                <input type="range" class="form-range" min="0" max="5" step="0.5" id="customRange3">
                """, renderedHtml);

        // document
        uiDocumentation.document("steps", renderedHtml);

        uiDocumentation.documentSource("steps");

    }

}
