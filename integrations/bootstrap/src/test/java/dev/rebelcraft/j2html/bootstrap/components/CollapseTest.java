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

class CollapseTest {

    public static final String multi_collapse = "multi-collapse";
    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
              p()
               .withClasses(Bootstrap.d_inline_flex, Bootstrap.gap_1)
               .with(
                  a()
                   .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                   .withData("bs-toggle","collapse")
                   .withHref("#collapseExample")
                   .attr(AriaRoles.roleButton)
                   .attr(
                      AriaStatesAndProperties.ariaExpanded("false")
                    )
                   .attr(
                      AriaStatesAndProperties.ariaControls("collapseExample")
                    )
                   .with(
                      text("Link with href")
                    ),
                  button()
                   .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                   .withType("button")
                   .withData("bs-toggle","collapse")
                   .withData("bs-target","#collapseExample")
                   .attr(
                      AriaStatesAndProperties.ariaExpanded("false")
                    )
                   .attr(
                      AriaStatesAndProperties.ariaControls("collapseExample")
                    )
                   .with(
                      text("Button with data-bs-target")
                    )
                ),
              div()
               .withClasses(Bootstrap.collapse)
               .withId("collapseExample")
               .with(
                  div()
                   .withClasses(Bootstrap.card, Bootstrap.card_body)
                   .with(
                      text("Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.")
                    )
                )
            )
        );

        //language=HTML
        assertEquals("""
            <p class="d-inline-flex gap-1">
              <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                Link with href
              </a>
              <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                Button with data-bs-target
              </button>
            </p>
            <div class="collapse" id="collapseExample">
              <div class="card card-body">
                Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void horizontal() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                .withType("button")
                                                .withData("bs-toggle","collapse")
                                                .withData("bs-target","#collapseWidthExample")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaControls("collapseWidthExample")
                                                )
                                                .with(
                                                        text("Toggle width collapse")
                                                )
                                ),
                        div()
                                .withStyle("min-height: 120px;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.collapse, Bootstrap.collapse_horizontal)
                                                .withId("collapseWidthExample")
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.card, Bootstrap.card_body)
                                                                .withStyle("width: 300px;")
                                                                .with(
                                                                        text("This is some placeholder content for a horizontal BootstrapClasses. It's hidden by default and shown when triggered.")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                    Toggle width collapse
                  </button>
                </p>
                <div style="min-height: 120px;">
                  <div class="collapse collapse-horizontal" id="collapseWidthExample">
                    <div class="card card-body" style="width: 300px;">
                      This is some placeholder content for a horizontal BootstrapClasses. It&#x27;s hidden by default and shown when triggered.
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal", renderedHtml);

        uiDocumentation.documentSource("horizontal");

    }

    @Test
    void multipleTogglesAndTargets() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Bootstrap.d_inline_flex, Bootstrap.gap_1)
                                .with(
                                        a()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                .withData("bs-toggle","collapse")
                                                .withHref("#multiCollapseExample1")
                                                .attr(AriaRoles.roleButton)
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaControls("multiCollapseExample1")
                                                )
                                                .with(
                                                        text("Toggle first element")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                .withType("button")
                                                .withData("bs-toggle","collapse")
                                                .withData("bs-target","#multiCollapseExample2")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaControls("multiCollapseExample2")
                                                )
                                                .with(
                                                        text("Toggle second element")
                                                ),
                                        button()
                                                .withClasses(Bootstrap.btn, Bootstrap.btn_primary)
                                                .withType("button")
                                                .withData("bs-toggle","collapse")
                                                .withData("bs-target",".multi-collapse")
                                                .attr(
                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaControls("multiCollapseExample1 multiCollapseExample2")
                                                )
                                                .with(
                                                        text("Toggle both elements")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.row)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.col)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.collapse, multi_collapse)
                                                                .withId("multiCollapseExample1")
                                                                .with(
                                                                        div()
                                                                                .withClasses(Bootstrap.card, Bootstrap.card_body)
                                                                                .with(
                                                                                        text("Some placeholder content for the first collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.")
                                                                                )
                                                                )
                                                ),
                                        div()
                                                .withClasses(Bootstrap.col)
                                                .with(
                                                        div()
                                                                .withClasses(Bootstrap.collapse, multi_collapse)
                                                                .withId("multiCollapseExample2")
                                                                .with(
                                                                        div()
                                                                                .withClasses(Bootstrap.card, Bootstrap.card_body)
                                                                                .with(
                                                                                        text("Some placeholder content for the second collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.")
                                                                                )
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <p class="d-inline-flex gap-1">
          <a class="btn btn-primary" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">
            Toggle first element
          </a>
          <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">
            Toggle second element
          </button>
          <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">
            Toggle both elements
          </button>
        </p>
        <div class="row">
          <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample1">
              <div class="card card-body">
                Some placeholder content for the first collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.
              </div>
            </div>
          </div>
          <div class="col">
            <div class="collapse multi-collapse" id="multiCollapseExample2">
              <div class="card card-body">
                Some placeholder content for the second collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.
              </div>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("multiple-toggles-and-targets", renderedHtml);

        uiDocumentation.documentSource("multiple-toggles-and-targets");

    }


}
