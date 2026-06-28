package dev.rebelcraft.j2html.bootstrap.helpers;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VisuallyHiddenTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
              h2()
               .withClasses(Bootstrap.visually_hidden)
               .with(
                  text("Title for screen readers")
                ),
              a()
               .withClasses(Bootstrap.visually_hidden_focusable)
               .withHref("#content")
               .with(
                  text("Skip to main content")
                ),
              div()
               .withClasses(Bootstrap.visually_hidden_focusable)
               .with(
                  text("A container with a"),
                  a()
                   .withHref("#")
                   .with(
                      text("focusable element")
                    ),
                  text(".")
                )
            )
        );

        //language=HTML
        assertEquals("""
            <h2 class="visually-hidden">
              Title for screen readers
            </h2>
            <a class="visually-hidden-focusable" href="#content">
              Skip to main content
            </a>
            <div class="visually-hidden-focusable">
              A container with a
              <a href="#">
                focusable element
              </a>
              .
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

}
