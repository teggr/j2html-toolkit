package dev.rebelcraft.j2html.bootstrap.content;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ImagesTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void responsiveImages() throws Exception {

        String renderedHtml = uiDocumentation.render(
                img()
                        .withSrc("...")
                        .withClasses(Bootstrap.img_fluid)
                        .withAlt("...")
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="img-fluid" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("responsive-images", renderedHtml);

        uiDocumentation.documentSource("responsive-images");

    }

    @Test
    void imageThumbnails() throws Exception {

        String renderedHtml = uiDocumentation.render(
                img()
                        .withSrc("...")
                        .withClasses(Bootstrap.img_thumbnail)
                        .withAlt("...")
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="img-thumbnail" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("image-thumbnails", renderedHtml);

        uiDocumentation.documentSource("image-thumbnails");

    }

    @Test
    void aligningImages() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        img()
                                .withSrc("...")
                                .withClasses(Bootstrap.rounded, Bootstrap.float_start)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Bootstrap.rounded, Bootstrap.float_end)
                                .withAlt("...")
                )
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="rounded float-start" alt="...">
                <img src="..." class="rounded float-end" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("aligning-images", renderedHtml);

        uiDocumentation.documentSource("aligning-images");

    }

    @Test
    void aligningImages2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                img()
                        .withSrc("...")
                        .withClasses(Bootstrap.rounded, Bootstrap.mx_auto, Bootstrap.d_block)
                        .withAlt("...")
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="rounded mx-auto d-block" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("aligning-images2", renderedHtml);

        uiDocumentation.documentSource("aligning-images2");

    }

    @Test
    void aligningImages3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.text_center)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Bootstrap.rounded)
                                        .withAlt("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="text-center">
                  <img src="..." class="rounded" alt="...">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("aligning-images3", renderedHtml);

        uiDocumentation.documentSource("aligning-images3");

    }

    @Test
    void pictureTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                picture()
                        .with(
                                source()
                                        .attr("srcset","...")
                                        .withType("image/svg+xml"),
                                img()
                                        .withSrc("...")
                                        .withClasses(Bootstrap.img_fluid, Bootstrap.img_thumbnail)
                                        .withAlt("...")
                        )
        );

        //language=HTML
        assertEquals("""
            <picture>
              <source srcset="..." type="image/svg+xml">
              <img src="..." class="img-fluid img-thumbnail" alt="...">
            </picture>
            """, renderedHtml);

        // document
        uiDocumentation.document("picture", renderedHtml);

        uiDocumentation.documentSource("picture");

    }


}
