package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VerticalAlignTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Bootstrap.align_baseline)
                                .with(
                                        text("baseline")
                                ),
                        span()
                                .withClasses(Bootstrap.align_top)
                                .with(
                                        text("top")
                                ),
                        span()
                                .withClasses(Bootstrap.align_middle)
                                .with(
                                        text("middle")
                                ),
                        span()
                                .withClasses(Bootstrap.align_bottom)
                                .with(
                                        text("bottom")
                                ),
                        span()
                                .withClasses(Bootstrap.align_text_top)
                                .with(
                                        text("text-top")
                                ),
                        span()
                                .withClasses(Bootstrap.align_text_bottom)
                                .with(
                                        text("text-bottom")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <span class="align-baseline">
                  baseline
                </span>
                <span class="align-top">
                  top
                </span>
                <span class="align-middle">
                  middle
                </span>
                <span class="align-bottom">
                  bottom
                </span>
                <span class="align-text-top">
                  text-top
                </span>
                <span class="align-text-bottom">
                  text-bottom
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

    @Test
    void examples2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                table()
                        .withStyle("height: 100px;")
                        .with(
                                tbody()
                                        .with(
                                                tr()
                                                        .with(
                                                                td()
                                                                        .withClasses(Bootstrap.align_baseline)
                                                                        .with(
                                                                                text("baseline")
                                                                        ),
                                                                td()
                                                                        .withClasses(Bootstrap.align_top)
                                                                        .with(
                                                                                text("top")
                                                                        ),
                                                                td()
                                                                        .withClasses(Bootstrap.align_middle)
                                                                        .with(
                                                                                text("middle")
                                                                        ),
                                                                td()
                                                                        .withClasses(Bootstrap.align_bottom)
                                                                        .with(
                                                                                text("bottom")
                                                                        ),
                                                                td()
                                                                        .withClasses(Bootstrap.align_text_top)
                                                                        .with(
                                                                                text("text-top")
                                                                        ),
                                                                td()
                                                                        .withClasses(Bootstrap.align_text_bottom)
                                                                        .with(
                                                                                text("text-bottom")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <table style="height: 100px;">
                  <tbody>
                    <tr>
                      <td class="align-baseline">
                        baseline
                      </td>
                      <td class="align-top">
                        top
                      </td>
                      <td class="align-middle">
                        middle
                      </td>
                      <td class="align-bottom">
                        bottom
                      </td>
                      <td class="align-text-top">
                        text-top
                      </td>
                      <td class="align-text-bottom">
                        text-bottom
                      </td>
                    </tr>
                  </tbody>
                </table>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples2", renderedHtml);

        uiDocumentation.documentSource("examples2");

    }

}
