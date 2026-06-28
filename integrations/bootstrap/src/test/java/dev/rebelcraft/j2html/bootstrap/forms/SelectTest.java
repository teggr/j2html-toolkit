package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void selectTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                select()
                        .withClasses(Bootstrap.form_select)
                        .attr(AriaStatesAndProperties.ariaLabel("Default select example"))
                        .with(
                                option()
                                        .withCondSelected(true)
                                        .with(
                                                text("Open this select menu")
                                        ),
                                option()
                                        .withValue("1")
                                        .with(
                                                text("One")
                                        ),
                                option()
                                        .withValue("2")
                                        .with(
                                                text("Two")
                                        ),
                                option()
                                        .withValue("3")
                                        .with(
                                                text("Three")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <select class="form-select" aria-label="Default select example">
                  <option selected>
                    Open this select menu
                  </option>
                  <option value="1">
                    One
                  </option>
                  <option value="2">
                    Two
                  </option>
                  <option value="3">
                    Three
                  </option>
                </select>
                """, renderedHtml);

        // document
        uiDocumentation.document("select", renderedHtml);

        uiDocumentation.documentSource("select");

    }

    @Test
    void sizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        select()
                                .withClasses(Bootstrap.form_select, Bootstrap.form_select_lg, Bootstrap.mb_3)
                                .attr(AriaStatesAndProperties.ariaLabel("Large select example"))
                                .with(
                                        option()
                                                .withCondSelected(true)
                                                .with(
                                                        text("Open this select menu")
                                                ),
                                        option()
                                                .withValue("1")
                                                .with(
                                                        text("One")
                                                ),
                                        option()
                                                .withValue("2")
                                                .with(
                                                        text("Two")
                                                ),
                                        option()
                                                .withValue("3")
                                                .with(
                                                        text("Three")
                                                )
                                ),
                        select()
                                .withClasses(Bootstrap.form_select, Bootstrap.form_select_sm)
                                .attr(AriaStatesAndProperties.ariaLabel("Small select example"))
                                .with(
                                        option()
                                                .withCondSelected(true)
                                                .with(
                                                        text("Open this select menu")
                                                ),
                                        option()
                                                .withValue("1")
                                                .with(
                                                        text("One")
                                                ),
                                        option()
                                                .withValue("2")
                                                .with(
                                                        text("Two")
                                                ),
                                        option()
                                                .withValue("3")
                                                .with(
                                                        text("Three")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <select class="form-select form-select-lg mb-3" aria-label="Large select example">
                  <option selected>
                    Open this select menu
                  </option>
                  <option value="1">
                    One
                  </option>
                  <option value="2">
                    Two
                  </option>
                  <option value="3">
                    Three
                  </option>
                </select>
                <select class="form-select form-select-sm" aria-label="Small select example">
                  <option selected>
                    Open this select menu
                  </option>
                  <option value="1">
                    One
                  </option>
                  <option value="2">
                    Two
                  </option>
                  <option value="3">
                    Three
                  </option>
                </select>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizing", renderedHtml);

        uiDocumentation.documentSource("sizing");

    }

    @Test
    void sizing2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                select()
                        .withClasses(Bootstrap.form_select)
                        .withCondMultiple(true)
                        .attr(AriaStatesAndProperties.ariaLabel("Multiple select example"))
                        .with(
                                option()
                                        .withCondSelected(true)
                                        .with(
                                                text("Open this select menu")
                                        ),
                                option()
                                        .withValue("1")
                                        .with(
                                                text("One")
                                        ),
                                option()
                                        .withValue("2")
                                        .with(
                                                text("Two")
                                        ),
                                option()
                                        .withValue("3")
                                        .with(
                                                text("Three")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <select class="form-select" multiple aria-label="Multiple select example">
                  <option selected>
                    Open this select menu
                  </option>
                  <option value="1">
                    One
                  </option>
                  <option value="2">
                    Two
                  </option>
                  <option value="3">
                    Three
                  </option>
                </select>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizing2", renderedHtml);

        uiDocumentation.documentSource("sizing2");

    }

    @Test
    void sizing3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                select()
                        .withClasses(Bootstrap.form_select)
                        .withSize("3")
                        .attr(AriaStatesAndProperties.ariaLabel("Size 3 select example"))
                        .with(
                                option()
                                        .withCondSelected(true)
                                        .with(
                                                text("Open this select menu")
                                        ),
                                option()
                                        .withValue("1")
                                        .with(
                                                text("One")
                                        ),
                                option()
                                        .withValue("2")
                                        .with(
                                                text("Two")
                                        ),
                                option()
                                        .withValue("3")
                                        .with(
                                                text("Three")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <select class="form-select" size="3" aria-label="Size 3 select example">
                  <option selected>
                    Open this select menu
                  </option>
                  <option value="1">
                    One
                  </option>
                  <option value="2">
                    Two
                  </option>
                  <option value="3">
                    Three
                  </option>
                </select>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizing3", renderedHtml);

        uiDocumentation.documentSource("sizing3");

    }

    @Test
    void sizing4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                select()
                        .withClasses(Bootstrap.form_select)
                        .attr(AriaStatesAndProperties.ariaLabel("Disabled select example"))
                        .withCondDisabled(true)
                        .with(
                                option()
                                        .withCondSelected(true)
                                        .with(
                                                text("Open this select menu")
                                        ),
                                option()
                                        .withValue("1")
                                        .with(
                                                text("One")
                                        ),
                                option()
                                        .withValue("2")
                                        .with(
                                                text("Two")
                                        ),
                                option()
                                        .withValue("3")
                                        .with(
                                                text("Three")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <select class="form-select" aria-label="Disabled select example" disabled>
                  <option selected>
                    Open this select menu
                  </option>
                  <option value="1">
                    One
                  </option>
                  <option value="2">
                    Two
                  </option>
                  <option value="3">
                    Three
                  </option>
                </select>
                """, renderedHtml);

        // document
        uiDocumentation.document("sizing4", renderedHtml);

        uiDocumentation.documentSource("sizing4");

    }


}
