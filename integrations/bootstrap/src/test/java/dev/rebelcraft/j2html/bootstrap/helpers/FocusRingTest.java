package dev.rebelcraft.j2html.bootstrap.helpers;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.a;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FocusRingTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                 .withHref("#")
                 .withClasses(Bootstrap.d_inline_flex, Bootstrap.focus_ring, Bootstrap.py_1, Bootstrap.px_2, Bootstrap.text_decoration_none, Bootstrap.border, Bootstrap.rounded_2)
                 .with(
                    text("Custom focus ring")
                  )
        );

        //language=HTML
        assertEquals("""
            <a href="#" class="d-inline-flex focus-ring py-1 px-2 text-decoration-none border rounded-2">
              Custom focus ring
            </a>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

}
