package dev.rebelcraft.j2html.bootstrap.forms;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChecksAndRadiosTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void checks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("flexCheckDefault"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexCheckDefault")
                                                .with(
                                                        text("Default checkbox")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("flexCheckChecked")
                                                .withCondChecked(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexCheckChecked")
                                                .with(
                                                        text("Checked checkbox")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                  <label class="form-check-label" for="flexCheckDefault">
                    Default checkbox
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
                  <label class="form-check-label" for="flexCheckChecked">
                    Checked checkbox
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("checks", renderedHtml);

        uiDocumentation.documentSource("checks");

    }

    @Test
    void indeterminate() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.form_check)
                        .with(
                                input()
                                        .withClasses(Bootstrap.form_check_input)
                                        .withType("checkbox")
                                        .withValue("")
                                        .withId("flexCheckIndeterminate"),
                                label()
                                        .withClasses(Bootstrap.form_check_label)
                                        .withFor("flexCheckIndeterminate")
                                        .with(
                                                text("Indeterminate checkbox")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="flexCheckIndeterminate">
                  <label class="form-check-label" for="flexCheckIndeterminate">
                    Indeterminate checkbox
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("indeterminate", renderedHtml);

        uiDocumentation.documentSource("indeterminate");

    }

    @Test
    void disabled() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("flexCheckIndeterminateDisabled")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexCheckIndeterminateDisabled")
                                                .with(
                                                        text("Disabled indeterminate checkbox")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("flexCheckDisabled")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexCheckDisabled")
                                                .with(
                                                        text("Disabled checkbox")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("flexCheckCheckedDisabled")
                                                .withCondChecked(true)
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexCheckCheckedDisabled")
                                                .with(
                                                        text("Disabled checked checkbox")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="flexCheckIndeterminateDisabled" disabled>
                  <label class="form-check-label" for="flexCheckIndeterminateDisabled">
                    Disabled indeterminate checkbox
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="flexCheckDisabled" disabled>
                  <label class="form-check-label" for="flexCheckDisabled">
                    Disabled checkbox
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="flexCheckCheckedDisabled" checked disabled>
                  <label class="form-check-label" for="flexCheckCheckedDisabled">
                    Disabled checked checkbox
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled", renderedHtml);

        uiDocumentation.documentSource("disabled");

    }


    @Test
    void radios() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("flexRadioDefault")
                                                .withId("flexRadioDefault1"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexRadioDefault1")
                                                .with(
                                                        text("Default radio")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("flexRadioDefault")
                                                .withId("flexRadioDefault2")
                                                .withCondChecked(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexRadioDefault2")
                                                .with(
                                                        text("Default checked radio")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                  <label class="form-check-label" for="flexRadioDefault1">
                    Default radio
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                  <label class="form-check-label" for="flexRadioDefault2">
                    Default checked radio
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("radios", renderedHtml);

        uiDocumentation.documentSource("radios");

    }

    @Test
    void disabled2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("flexRadioDisabled")
                                                .withId("flexRadioDisabled")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexRadioDisabled")
                                                .with(
                                                        text("Disabled radio")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("flexRadioDisabled")
                                                .withId("flexRadioCheckedDisabled")
                                                .withCondChecked(true)
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexRadioCheckedDisabled")
                                                .with(
                                                        text("Disabled checked radio")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="flexRadioDisabled" id="flexRadioDisabled" disabled>
                  <label class="form-check-label" for="flexRadioDisabled">
                    Disabled radio
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="flexRadioDisabled" id="flexRadioCheckedDisabled" checked disabled>
                  <label class="form-check-label" for="flexRadioCheckedDisabled">
                    Disabled checked radio
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("disabled2", renderedHtml);

        uiDocumentation.documentSource("disabled2");

    }

    @Test
    void switches() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_switch)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .attr(AriaRoles.roleSwitch)
                                                .withId("flexSwitchCheckDefault"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexSwitchCheckDefault")
                                                .with(
                                                        text("Default switch checkbox input")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_switch)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .attr(AriaRoles.roleSwitch)
                                                .withId("flexSwitchCheckChecked")
                                                .withCondChecked(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexSwitchCheckChecked")
                                                .with(
                                                        text("Checked switch checkbox input")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_switch)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .attr(AriaRoles.roleSwitch)
                                                .withId("flexSwitchCheckDisabled")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexSwitchCheckDisabled")
                                                .with(
                                                        text("Disabled switch checkbox input")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_switch)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .attr(AriaRoles.roleSwitch)
                                                .withId("flexSwitchCheckCheckedDisabled")
                                                .withCondChecked(true)
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexSwitchCheckCheckedDisabled")
                                                .with(
                                                        text("Disabled checked switch checkbox input")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="form-check form-switch">
              <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault">
              <label class="form-check-label" for="flexSwitchCheckDefault">
                Default switch checkbox input
              </label>
            </div>
            <div class="form-check form-switch">
              <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckChecked" checked>
              <label class="form-check-label" for="flexSwitchCheckChecked">
                Checked switch checkbox input
              </label>
            </div>
            <div class="form-check form-switch">
              <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDisabled" disabled>
              <label class="form-check-label" for="flexSwitchCheckDisabled">
                Disabled switch checkbox input
              </label>
            </div>
            <div class="form-check form-switch">
              <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckCheckedDisabled" checked disabled>
              <label class="form-check-label" for="flexSwitchCheckCheckedDisabled">
                Disabled checked switch checkbox input
              </label>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("switches", renderedHtml);

        uiDocumentation.documentSource("switches");

    }

    @Test
    void defaultStacked() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("defaultCheck1"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("defaultCheck1")
                                                .with(
                                                        text("Default checkbox")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("defaultCheck2")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("defaultCheck2")
                                                .with(
                                                        text("Disabled checkbox")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                    Default checkbox
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck2" disabled>
                  <label class="form-check-label" for="defaultCheck2">
                    Disabled checkbox
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("default-stacked", renderedHtml);

        uiDocumentation.documentSource("default-stacked");

    }

    @Test
    void defaultStacked2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("exampleRadios")
                                                .withId("exampleRadios1")
                                                .withValue("option1")
                                                .withCondChecked(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("exampleRadios1")
                                                .with(
                                                        text("Default radio")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("exampleRadios")
                                                .withId("exampleRadios2")
                                                .withValue("option2"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("exampleRadios2")
                                                .with(
                                                        text("Second default radio")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("exampleRadios")
                                                .withId("exampleRadios3")
                                                .withValue("option3")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("exampleRadios3")
                                                .with(
                                                        text("Disabled radio")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1" checked>
                  <label class="form-check-label" for="exampleRadios1">
                    Default radio
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                  <label class="form-check-label" for="exampleRadios2">
                    Second default radio
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3" disabled>
                  <label class="form-check-label" for="exampleRadios3">
                    Disabled radio
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("default-stacked2", renderedHtml);

        uiDocumentation.documentSource("default-stacked2");

    }


    @Test
    void inline() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_check_inline)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withId("inlineCheckbox1")
                                                .withValue("option1"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("inlineCheckbox1")
                                                .with(
                                                        text("1")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_check_inline)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withId("inlineCheckbox2")
                                                .withValue("option2"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("inlineCheckbox2")
                                                .with(
                                                        text("2")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_check_inline)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withId("inlineCheckbox3")
                                                .withValue("option3")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("inlineCheckbox3")
                                                .with(
                                                        text("3 (disabled)")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                  <label class="form-check-label" for="inlineCheckbox1">
                    1
                  </label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                  <label class="form-check-label" for="inlineCheckbox2">
                    2
                  </label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3" disabled>
                  <label class="form-check-label" for="inlineCheckbox3">
                    3 (disabled)
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("inline", renderedHtml);

        uiDocumentation.documentSource("inline");

    }

    @Test
    void inline2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_check_inline)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("inlineRadioOptions")
                                                .withId("inlineRadio1")
                                                .withValue("option1"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("inlineRadio1")
                                                .with(
                                                        text("1")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_check_inline)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("inlineRadioOptions")
                                                .withId("inlineRadio2")
                                                .withValue("option2"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("inlineRadio2")
                                                .with(
                                                        text("2")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_check_inline)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("inlineRadioOptions")
                                                .withId("inlineRadio3")
                                                .withValue("option3")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("inlineRadio3")
                                                .with(
                                                        text("3 (disabled)")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                  <label class="form-check-label" for="inlineRadio1">
                    1
                  </label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                  <label class="form-check-label" for="inlineRadio2">
                    2
                  </label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3" disabled>
                  <label class="form-check-label" for="inlineRadio3">
                    3 (disabled)
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("inline2", renderedHtml);

        uiDocumentation.documentSource("inline2");

    }

    @Test
    void reverse() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_check_reverse)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("reverseCheck1"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("reverseCheck1")
                                                .with(
                                                        text("Reverse checkbox")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_check_reverse)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withValue("")
                                                .withId("reverseCheck2")
                                                .withCondDisabled(true),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("reverseCheck2")
                                                .with(
                                                        text("Disabled reverse checkbox")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.form_check, Bootstrap.form_switch, Bootstrap.form_check_reverse)
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withId("flexSwitchCheckReverse"),
                                        label()
                                                .withClasses(Bootstrap.form_check_label)
                                                .withFor("flexSwitchCheckReverse")
                                                .with(
                                                        text("Reverse switch checkbox input")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="form-check form-check-reverse">
                  <input class="form-check-input" type="checkbox" value="" id="reverseCheck1">
                  <label class="form-check-label" for="reverseCheck1">
                    Reverse checkbox
                  </label>
                </div>
                <div class="form-check form-check-reverse">
                  <input class="form-check-input" type="checkbox" value="" id="reverseCheck2" disabled>
                  <label class="form-check-label" for="reverseCheck2">
                    Disabled reverse checkbox
                  </label>
                </div>
                <div class="form-check form-switch form-check-reverse">
                  <input class="form-check-input" type="checkbox" id="flexSwitchCheckReverse">
                  <label class="form-check-label" for="flexSwitchCheckReverse">
                    Reverse switch checkbox input
                  </label>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("reverse", renderedHtml);

        uiDocumentation.documentSource("reverse");

    }

    @Test
    void withoutLabels() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("checkbox")
                                                .withId("checkboxNoLabel")
                                                .withValue("")
                                                .attr(AriaStatesAndProperties.ariaLabel("..."))
                                ),
                        div()
                                .with(
                                        input()
                                                .withClasses(Bootstrap.form_check_input)
                                                .withType("radio")
                                                .withName("radioNoLabel")
                                                .withId("radioNoLabel1")
                                                .withValue("")
                                                .attr(AriaStatesAndProperties.ariaLabel("..."))
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div>
                  <input class="form-check-input" type="checkbox" id="checkboxNoLabel" value="" aria-label="...">
                </div>
                <div>
                  <input class="form-check-input" type="radio" name="radioNoLabel" id="radioNoLabel1" value="" aria-label="...">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("without-labels", renderedHtml);

        uiDocumentation.documentSource("without-labels");

    }

    @Test
    void checkboxToggleButtons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        input()
                                .withType("checkbox")
                                .withClasses(Bootstrap.btn_check)
                                .withId("btn-check")
                                .attr("autocomplete", "off"),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withFor("btn-check")
                                .with(
                                        text("Single toggle")
                                ),
                        input()
                                .withType("checkbox")
                                .withClasses(Bootstrap.btn_check)
                                .withId("btn-check-2")
                                .withCondChecked(true)
                                .attr("autocomplete", "off"),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withFor("btn-check-2")
                                .with(
                                        text("Checked")
                                ),
                        input()
                                .withType("checkbox")
                                .withClasses(Bootstrap.btn_check)
                                .withId("btn-check-3")
                                .attr("autocomplete", "off")
                                .withCondDisabled(true),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                .withFor("btn-check-3")
                                .with(
                                        text("Disabled")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <input type="checkbox" class="btn-check" id="btn-check" autocomplete="off">
                <label class="btn btn-primary" for="btn-check">
                  Single toggle
                </label>
                <input type="checkbox" class="btn-check" id="btn-check-2" checked autocomplete="off">
                <label class="btn btn-primary" for="btn-check-2">
                  Checked
                </label>
                <input type="checkbox" class="btn-check" id="btn-check-3" autocomplete="off" disabled>
                <label class="btn btn-primary" for="btn-check-3">
                  Disabled
                </label>
                """, renderedHtml);

        // document
        uiDocumentation.document("toggle-buttons", renderedHtml);

        uiDocumentation.documentSource("toggle-buttons");

    }

    @Test
    void checkboxToggleButtons2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        input()
                                .withType("checkbox")
                                .withClasses(Bootstrap.btn_check)
                                .withId("btn-check-4")
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn)
                                .withFor("btn-check-4")
                                .with(
                                        text("Single toggle")
                                ),
                        input()
                                .withType("checkbox")
                                .withClasses(Bootstrap.btn_check)
                                .withId("btn-check-5")
                                .withCondChecked(true)
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn)
                                .withFor("btn-check-5")
                                .with(
                                        text("Checked")
                                ),
                        input()
                                .withType("checkbox")
                                .withClasses(Bootstrap.btn_check)
                                .withId("btn-check-6")
                                .attr("autocomplete","off")
                                .withCondDisabled(true),
                        label()
                                .withClasses(Bootstrap.btn)
                                .withFor("btn-check-6")
                                .with(
                                        text("Disabled")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <input type="checkbox" class="btn-check" id="btn-check-4" autocomplete="off">
            <label class="btn" for="btn-check-4">
              Single toggle
            </label>
            <input type="checkbox" class="btn-check" id="btn-check-5" checked autocomplete="off">
            <label class="btn" for="btn-check-5">
              Checked
            </label>
            <input type="checkbox" class="btn-check" id="btn-check-6" autocomplete="off" disabled>
            <label class="btn" for="btn-check-6">
              Disabled
            </label>
            """, renderedHtml);

        // document
        uiDocumentation.document("checkbox-toggle-buttons2", renderedHtml);

        uiDocumentation.documentSource("checkbox-toggle-buttons2");

    }

    @Test
    void radioToggleButtons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options")
                                .withId("option1")
                                .attr("autocomplete","off")
                                .withCondChecked(true),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withFor("option1")
                                .with(
                                        text("Checked")
                                ),
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options")
                                .withId("option2")
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withFor("option2")
                                .with(
                                        text("Radio")
                                ),
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options")
                                .withId("option3")
                                .attr("autocomplete","off")
                                .withCondDisabled(true),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withFor("option3")
                                .with(
                                        text("Disabled")
                                ),
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options")
                                .withId("option4")
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_secondary)
                                .withFor("option4")
                                .with(
                                        text("Radio")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <input type="radio" class="btn-check" name="options" id="option1" autocomplete="off" checked>
                <label class="btn btn-secondary" for="option1">
                  Checked
                </label>
                <input type="radio" class="btn-check" name="options" id="option2" autocomplete="off">
                <label class="btn btn-secondary" for="option2">
                  Radio
                </label>
                <input type="radio" class="btn-check" name="options" id="option3" autocomplete="off" disabled>
                <label class="btn btn-secondary" for="option3">
                  Disabled
                </label>
                <input type="radio" class="btn-check" name="options" id="option4" autocomplete="off">
                <label class="btn btn-secondary" for="option4">
                  Radio
                </label>
                """, renderedHtml);

        // document
        uiDocumentation.document("radio-toggle-buttons2", renderedHtml);

        uiDocumentation.documentSource("radio-toggle-buttons2");

    }

    @Test
    void radioToggleButtons2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options-base")
                                .withId("option5")
                                .attr("autocomplete","off")
                                .withCondChecked(true),
                        label()
                                .withClasses(Bootstrap.btn)
                                .withFor("option5")
                                .with(
                                        text("Checked")
                                ),
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options-base")
                                .withId("option6")
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn)
                                .withFor("option6")
                                .with(
                                        text("Radio")
                                ),
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options-base")
                                .withId("option7")
                                .attr("autocomplete","off")
                                .withCondDisabled(true),
                        label()
                                .withClasses(Bootstrap.btn)
                                .withFor("option7")
                                .with(
                                        text("Disabled")
                                ),
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options-base")
                                .withId("option8")
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn)
                                .withFor("option8")
                                .with(
                                        text("Radio")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <input type="radio" class="btn-check" name="options-base" id="option5" autocomplete="off" checked>
                <label class="btn" for="option5">
                  Checked
                </label>
                <input type="radio" class="btn-check" name="options-base" id="option6" autocomplete="off">
                <label class="btn" for="option6">
                  Radio
                </label>
                <input type="radio" class="btn-check" name="options-base" id="option7" autocomplete="off" disabled>
                <label class="btn" for="option7">
                  Disabled
                </label>
                <input type="radio" class="btn-check" name="options-base" id="option8" autocomplete="off">
                <label class="btn" for="option8">
                  Radio
                </label>
                """, renderedHtml);

        // document
        uiDocumentation.document("radio-toggle-buttons2", renderedHtml);

        uiDocumentation.documentSource("radio-toggle-buttons2");

    }

    @Test
    void outlinedStyles() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        input()
                                .withType("checkbox")
                                .withClasses(Bootstrap.btn_check)
                                .withId("btn-check-outlined")
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_primary)
                                .withFor("btn-check-outlined")
                                .with(
                                        text("Single toggle")
                                ),
                        br(),
                        input()
                                .withType("checkbox")
                                .withClasses(Bootstrap.btn_check)
                                .withId("btn-check-2-outlined")
                                .withCondChecked(true)
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_secondary)
                                .withFor("btn-check-2-outlined")
                                .with(
                                        text("Checked")
                                ),
                        br(),
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options-outlined")
                                .withId("success-outlined")
                                .attr("autocomplete","off")
                                .withCondChecked(true),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_success)
                                .withFor("success-outlined")
                                .with(
                                        text("Checked success radio")
                                ),
                        input()
                                .withType("radio")
                                .withClasses(Bootstrap.btn_check)
                                .withName("options-outlined")
                                .withId("danger-outlined")
                                .attr("autocomplete","off"),
                        label()
                                .withClasses(Bootstrap.btn, Bootstrap.btn_outline_danger)
                                .withFor("danger-outlined")
                                .with(
                                        text("Danger radio")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <input type="checkbox" class="btn-check" id="btn-check-outlined" autocomplete="off">
                <label class="btn btn-outline-primary" for="btn-check-outlined">
                  Single toggle
                </label>
                <br>
                <input type="checkbox" class="btn-check" id="btn-check-2-outlined" checked autocomplete="off">
                <label class="btn btn-outline-secondary" for="btn-check-2-outlined">
                  Checked
                </label>
                <br>
                <input type="radio" class="btn-check" name="options-outlined" id="success-outlined" autocomplete="off" checked>
                <label class="btn btn-outline-success" for="success-outlined">
                  Checked success radio
                </label>
                <input type="radio" class="btn-check" name="options-outlined" id="danger-outlined" autocomplete="off">
                <label class="btn btn-outline-danger" for="danger-outlined">
                  Danger radio
                </label>
                """, renderedHtml);

        // document
        uiDocumentation.document("outlined-styles", renderedHtml);

        uiDocumentation.documentSource("outlined-styles");

    }


}
