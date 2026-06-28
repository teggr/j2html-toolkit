package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void linkOpacity() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_10)
                                                .withHref("#")
                                                .with(
                                                        text("Link opacity 10")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_25)
                                                .withHref("#")
                                                .with(
                                                        text("Link opacity 25")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_50)
                                                .withHref("#")
                                                .with(
                                                        text("Link opacity 50")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_75)
                                                .withHref("#")
                                                .with(
                                                        text("Link opacity 75")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_100)
                                                .withHref("#")
                                                .with(
                                                        text("Link opacity 100")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <a class="link-opacity-10" href="#">
                    Link opacity 10
                  </a>
                </p>
                <p>
                  <a class="link-opacity-25" href="#">
                    Link opacity 25
                  </a>
                </p>
                <p>
                  <a class="link-opacity-50" href="#">
                    Link opacity 50
                  </a>
                </p>
                <p>
                  <a class="link-opacity-75" href="#">
                    Link opacity 75
                  </a>
                </p>
                <p>
                  <a class="link-opacity-100" href="#">
                    Link opacity 100
                  </a>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("link-opacity", renderedHtml);

        uiDocumentation.documentSource("link-opacity");

    }

    @Test
    void linkOpacity2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_10_hover)
                                                .withHref("#")
                                                .with(
                                                        text("Link hover opacity 10")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_25_hover)
                                                .withHref("#")
                                                .with(
                                                        text("Link hover opacity 25")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_50_hover)
                                                .withHref("#")
                                                .with(
                                                        text("Link hover opacity 50")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_75_hover)
                                                .withHref("#")
                                                .with(
                                                        text("Link hover opacity 75")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_opacity_100_hover)
                                                .withHref("#")
                                                .with(
                                                        text("Link hover opacity 100")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <a class="link-opacity-10-hover" href="#">
                    Link hover opacity 10
                  </a>
                </p>
                <p>
                  <a class="link-opacity-25-hover" href="#">
                    Link hover opacity 25
                  </a>
                </p>
                <p>
                  <a class="link-opacity-50-hover" href="#">
                    Link hover opacity 50
                  </a>
                </p>
                <p>
                  <a class="link-opacity-75-hover" href="#">
                    Link hover opacity 75
                  </a>
                </p>
                <p>
                  <a class="link-opacity-100-hover" href="#">
                    Link hover opacity 100
                  </a>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("link-opacity2", renderedHtml);

        uiDocumentation.documentSource("link-opacity2");

    }

    @Test
    void underlineColor() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_underline_primary)
                                                .with(
                                                        text("Primary underline")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_underline_secondary)
                                                .with(
                                                        text("Secondary underline")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_underline_success)
                                                .with(
                                                        text("Success underline")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_underline_danger)
                                                .with(
                                                        text("Danger underline")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_underline_warning)
                                                .with(
                                                        text("Warning underline")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_underline_info)
                                                .with(
                                                        text("Info underline")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_underline_light)
                                                .with(
                                                        text("Light underline")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_underline_dark)
                                                .with(
                                                        text("Dark underline")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <a href="#" class="link-underline-primary">
                    Primary underline
                  </a>
                </p>
                <p>
                  <a href="#" class="link-underline-secondary">
                    Secondary underline
                  </a>
                </p>
                <p>
                  <a href="#" class="link-underline-success">
                    Success underline
                  </a>
                </p>
                <p>
                  <a href="#" class="link-underline-danger">
                    Danger underline
                  </a>
                </p>
                <p>
                  <a href="#" class="link-underline-warning">
                    Warning underline
                  </a>
                </p>
                <p>
                  <a href="#" class="link-underline-info">
                    Info underline
                  </a>
                </p>
                <p>
                  <a href="#" class="link-underline-light">
                    Light underline
                  </a>
                </p>
                <p>
                  <a href="#" class="link-underline-dark">
                    Dark underline
                  </a>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("underline-color", renderedHtml);

        uiDocumentation.documentSource("underline-color");

    }

    @Test
    void underlineOffset() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .with(
                                                        text("Default link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_1)
                                                .withHref("#")
                                                .with(
                                                        text("Offset 1 link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_2)
                                                .withHref("#")
                                                .with(
                                                        text("Offset 2 link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_3)
                                                .withHref("#")
                                                .with(
                                                        text("Offset 3 link")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <a href="#">
                    Default link
                  </a>
                </p>
                <p>
                  <a class="link-offset-1" href="#">
                    Offset 1 link
                  </a>
                </p>
                <p>
                  <a class="link-offset-2" href="#">
                    Offset 2 link
                  </a>
                </p>
                <p>
                  <a class="link-offset-3" href="#">
                    Offset 3 link
                  </a>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("underline-offset", renderedHtml);

        uiDocumentation.documentSource("underline-offset");

    }

    @Test
    void underlineOpacity() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_2, Bootstrap.link_underline, "link-underline-opacity-0")
                                                .withHref("#")
                                                .with(
                                                        text("Underline opacity 0")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_2, Bootstrap.link_underline, Bootstrap.link_underline_opacity_10)
                                                .withHref("#")
                                                .with(
                                                        text("Underline opacity 10")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_2, Bootstrap.link_underline, Bootstrap.link_underline_opacity_25)
                                                .withHref("#")
                                                .with(
                                                        text("Underline opacity 25")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_2, Bootstrap.link_underline, Bootstrap.link_underline_opacity_50)
                                                .withHref("#")
                                                .with(
                                                        text("Underline opacity 50")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_2, Bootstrap.link_underline, Bootstrap.link_underline_opacity_75)
                                                .withHref("#")
                                                .with(
                                                        text("Underline opacity 75")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withClasses(Bootstrap.link_offset_2, Bootstrap.link_underline, Bootstrap.link_underline_opacity_100)
                                                .withHref("#")
                                                .with(
                                                        text("Underline opacity 100")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <a class="link-offset-2 link-underline link-underline-opacity-0" href="#">
                    Underline opacity 0
                  </a>
                </p>
                <p>
                  <a class="link-offset-2 link-underline link-underline-opacity-10" href="#">
                    Underline opacity 10
                  </a>
                </p>
                <p>
                  <a class="link-offset-2 link-underline link-underline-opacity-25" href="#">
                    Underline opacity 25
                  </a>
                </p>
                <p>
                  <a class="link-offset-2 link-underline link-underline-opacity-50" href="#">
                    Underline opacity 50
                  </a>
                </p>
                <p>
                  <a class="link-offset-2 link-underline link-underline-opacity-75" href="#">
                    Underline opacity 75
                  </a>
                </p>
                <p>
                  <a class="link-offset-2 link-underline link-underline-opacity-100" href="#">
                    Underline opacity 100
                  </a>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("underline-opacity", renderedHtml);

        uiDocumentation.documentSource("underline-opacity");

    }

    @Test
    void hoverVariants() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                        .withClasses(Bootstrap.link_offset_2, Bootstrap.link_offset_3_hover, Bootstrap.link_underline, Bootstrap.link_underline_opacity_0, Bootstrap.link_underline_opacity_75_hover)
                        .withHref("#")
                        .with(
                                text("Underline opacity 0")
                        )
        );

        //language=HTML
        assertEquals("""
                <a class="link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover" href="#">
                  Underline opacity 0
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("hover-variants", renderedHtml);

        uiDocumentation.documentSource("hover-variants");

    }

    @Test
    void coloredLinks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_primary, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Primary link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_secondary, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Secondary link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_success, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Success link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_danger, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Danger link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_warning, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Warning link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_info, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Info link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_light, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Light link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_dark, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Dark link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(Bootstrap.link_body_emphasis, Bootstrap.link_offset_2, Bootstrap.link_underline_opacity_25, Bootstrap.link_underline_opacity_75_hover)
                                                .with(
                                                        text("Emphasis link")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p>
                  <a href="#" class="link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                    Primary link
                  </a>
                </p>
                <p>
                  <a href="#" class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                    Secondary link
                  </a>
                </p>
                <p>
                  <a href="#" class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                    Success link
                  </a>
                </p>
                <p>
                  <a href="#" class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                    Danger link
                  </a>
                </p>
                <p>
                  <a href="#" class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                    Warning link
                  </a>
                </p>
                <p>
                  <a href="#" class="link-info link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                    Info link
                  </a>
                </p>
                <p>
                  <a href="#" class="link-light link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                    Light link
                  </a>
                </p>
                <p>
                  <a href="#" class="link-dark link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
                    Dark link
                  </a>
                </p>
                <p>
                  <a href="#" class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover">
                    Emphasis link
                  </a>
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("colored-links", renderedHtml);

        uiDocumentation.documentSource("colored-links");

    }


}
