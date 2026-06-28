package dev.rebelcraft.j2html.bootstrap.helpers;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void fixedTop() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
             .withClasses(Bootstrap.fixed_top)
             .with(
                text("...")
              )
        );

        //language=HTML
        assertEquals("""
            <div class="fixed-top">
              ...
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("fixed-top", renderedHtml);

        uiDocumentation.documentSource("fixed-top");

    }

    @Test
    void fixedBottom() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.fixed_bottom)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="fixed-bottom">
          ...
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("fixed-bottom", renderedHtml);

        uiDocumentation.documentSource("fixed-bottom");

    }

    @Test
    void stickyTop() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.sticky_top)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="sticky-top">
          ...
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("sticky-top", renderedHtml);

        uiDocumentation.documentSource("sticky-top");

    }

    @Test
    void responsiveStickyTop() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses("sticky-sm-top")
                                .with(
                                        text("Stick to the top on viewports sized SM (small) or wider")
                                ),
                        div()
                                .withClasses("sticky-md-top")
                                .with(
                                        text("Stick to the top on viewports sized MD (medium) or wider")
                                ),
                        div()
                                .withClasses("sticky-lg-top")
                                .with(
                                        text("Stick to the top on viewports sized LG (large) or wider")
                                ),
                        div()
                                .withClasses("sticky-xl-top")
                                .with(
                                        text("Stick to the top on viewports sized XL (extra-large) or wider")
                                ),
                        div()
                                .withClasses("sticky-xxl-top")
                                .with(
                                        text("Stick to the top on viewports sized XXL (extra-extra-large) or wider")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="sticky-sm-top">
          Stick to the top on viewports sized SM (small) or wider
        </div>
        <div class="sticky-md-top">
          Stick to the top on viewports sized MD (medium) or wider
        </div>
        <div class="sticky-lg-top">
          Stick to the top on viewports sized LG (large) or wider
        </div>
        <div class="sticky-xl-top">
          Stick to the top on viewports sized XL (extra-large) or wider
        </div>
        <div class="sticky-xxl-top">
          Stick to the top on viewports sized XXL (extra-extra-large) or wider
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("responsive-sticky-top", renderedHtml);

        uiDocumentation.documentSource("responsive-sticky-top");

    }

    @Test
    void stickyBottom() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.sticky_bottom)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="sticky-bottom">
          ...
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("sticky-bottom", renderedHtml);

        uiDocumentation.documentSource("sticky-bottom");

    }

    @Test
    void responsiveStickyBottom() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses("sticky-sm-bottom")
                                .with(
                                        text("Stick to the bottom on viewports sized SM (small) or wider")
                                ),
                        div()
                                .withClasses("sticky-md-bottom")
                                .with(
                                        text("Stick to the bottom on viewports sized MD (medium) or wider")
                                ),
                        div()
                                .withClasses("sticky-lg-bottom")
                                .with(
                                        text("Stick to the bottom on viewports sized LG (large) or wider")
                                ),
                        div()
                                .withClasses("sticky-xl-bottom")
                                .with(
                                        text("Stick to the bottom on viewports sized XL (extra-large) or wider")
                                ),
                        div()
                                .withClasses("sticky-xxl-bottom")
                                .with(
                                        text("Stick to the bottom on viewports sized XXL (extra-extra-large) or wider")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="sticky-sm-bottom">
          Stick to the bottom on viewports sized SM (small) or wider
        </div>
        <div class="sticky-md-bottom">
          Stick to the bottom on viewports sized MD (medium) or wider
        </div>
        <div class="sticky-lg-bottom">
          Stick to the bottom on viewports sized LG (large) or wider
        </div>
        <div class="sticky-xl-bottom">
          Stick to the bottom on viewports sized XL (extra-large) or wider
        </div>
        <div class="sticky-xxl-bottom">
          Stick to the bottom on viewports sized XXL (extra-extra-large) or wider
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("responsive-sticky-bottom", renderedHtml);

        uiDocumentation.documentSource("responsive-sticky-bottom");

    }


}
