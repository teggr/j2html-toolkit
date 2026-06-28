package dev.rebelcraft.j2html.bootstrap.helpers;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RatioTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                    .withClasses(Bootstrap.ratio, Bootstrap.ratio_16x9)
                     .with(
                        iframe()
                         .withSrc("https://www.youtube.com/embed/zpOULjyy-n8?rel=0")
                         .withTitle("YouTube video")
                         .attr("allowfullscreen")
                      )
        );

        //language=HTML
        assertEquals("""
            <div class="ratio ratio-16x9">
              <iframe src="https://www.youtube.com/embed/zpOULjyy-n8?rel=0" title="YouTube video" allowfullscreen>
              </iframe>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void aspectRatios() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.ratio, Bootstrap.ratio_1x1)
                                .with(
                                        div()
                                                .with(
                                                        text("1x1")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.ratio, Bootstrap.ratio_4x3)
                                .with(
                                        div()
                                                .with(
                                                        text("4x3")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.ratio, Bootstrap.ratio_16x9)
                                .with(
                                        div()
                                                .with(
                                                        text("16x9")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.ratio, Bootstrap.ratio_21x9)
                                .with(
                                        div()
                                                .with(
                                                        text("21x9")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="ratio ratio-1x1">
          <div>
            1x1
          </div>
        </div>
        <div class="ratio ratio-4x3">
          <div>
            4x3
          </div>
        </div>
        <div class="ratio ratio-16x9">
          <div>
            16x9
          </div>
        </div>
        <div class="ratio ratio-21x9">
          <div>
            21x9
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("aspect-ratios", renderedHtml);

        uiDocumentation.documentSource("aspect-ratios");

    }

    @Test
    void customRatios() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.ratio)
                        .withStyle("--bs-aspect-ratio: 50%;")
                        .with(
                                div()
                                        .with(
                                                text("2x1")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="ratio" style="--bs-aspect-ratio: 50%;">
          <div>
            2x1
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("custom-ratios", renderedHtml);

        uiDocumentation.documentSource("custom-ratios");

    }

    @Test
    void customRatios2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.ratio, Bootstrap.ratio_4x3)
                        .with(
                                div()
                                        .with(
                                                text("4x3, then 2x1")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="ratio ratio-4x3">
          <div>
            4x3, then 2x1
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("custom-ratios2", renderedHtml);

        uiDocumentation.documentSource("custom-ratios2");

    }


}
