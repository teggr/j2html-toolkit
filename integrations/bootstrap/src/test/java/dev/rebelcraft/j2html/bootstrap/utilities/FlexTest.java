package dev.rebelcraft.j2html.bootstrap.utilities;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FlexTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void enableFlexBehaviours() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.p_2)
                        .with(
                                text("I'm a flexbox container!")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex p-2">
                  I&#x27;m a flexbox container!
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("enable-flex-behaviours", renderedHtml);

        uiDocumentation.documentSource("enable-flex-behaviours");

    }

    @Test
    void enableFlexBehaviours2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_inline_flex, Bootstrap.p_2)
                        .with(
                                text("I'm an inline flexbox container!")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-inline-flex p-2">
                  I&#x27;m an inline flexbox container!
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("enable-flex-behaviours2", renderedHtml);

        uiDocumentation.documentSource("enable-flex-behaviours2");

    }

    @Test
    void direction() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.flex_row, Bootstrap.mb_3)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 1")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 2")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 3")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.flex_row_reverse)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 1")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 2")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 3")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex flex-row mb-3">
                  <div class="p-2">
                    Flex item 1
                  </div>
                  <div class="p-2">
                    Flex item 2
                  </div>
                  <div class="p-2">
                    Flex item 3
                  </div>
                </div>
                <div class="d-flex flex-row-reverse">
                  <div class="p-2">
                    Flex item 1
                  </div>
                  <div class="p-2">
                    Flex item 2
                  </div>
                  <div class="p-2">
                    Flex item 3
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("direction", renderedHtml);

        uiDocumentation.documentSource("direction");

    }

    @Test
    void direction2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.flex_column, Bootstrap.mb_3)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 1")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 2")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 3")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.flex_column_reverse)
                                .with(
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 1")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 2")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item 3")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex flex-column mb-3">
                  <div class="p-2">
                    Flex item 1
                  </div>
                  <div class="p-2">
                    Flex item 2
                  </div>
                  <div class="p-2">
                    Flex item 3
                  </div>
                </div>
                <div class="d-flex flex-column-reverse">
                  <div class="p-2">
                    Flex item 1
                  </div>
                  <div class="p-2">
                    Flex item 2
                  </div>
                  <div class="p-2">
                    Flex item 3
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("direction", renderedHtml);

        uiDocumentation.documentSource("direction");

    }

    @Test
    void justifyContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.justify_content_start)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.justify_content_end)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.justify_content_center)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.justify_content_between)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.justify_content_around)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.justify_content_evenly)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex justify-content-start">
                  ...
                </div>
                <div class="d-flex justify-content-end">
                  ...
                </div>
                <div class="d-flex justify-content-center">
                  ...
                </div>
                <div class="d-flex justify-content-between">
                  ...
                </div>
                <div class="d-flex justify-content-around">
                  ...
                </div>
                <div class="d-flex justify-content-evenly">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("justify-content", renderedHtml);

        uiDocumentation.documentSource("justify-content");

    }

    @Test
    void alignItems() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.align_items_start)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.align_items_end)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.align_items_center)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.align_items_baseline)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.align_items_stretch)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-items-start">
                  ...
                </div>
                <div class="d-flex align-items-end">
                  ...
                </div>
                <div class="d-flex align-items-center">
                  ...
                </div>
                <div class="d-flex align-items-baseline">
                  ...
                </div>
                <div class="d-flex align-items-stretch">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("align-items", renderedHtml);

        uiDocumentation.documentSource("align-items");

    }

    @Test
    void alignSelf() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.align_self_start)
                                .with(
                                        text("Aligned flex item")
                                ),
                        div()
                                .withClasses(Bootstrap.align_self_end)
                                .with(
                                        text("Aligned flex item")
                                ),
                        div()
                                .withClasses(Bootstrap.align_self_center)
                                .with(
                                        text("Aligned flex item")
                                ),
                        div()
                                .withClasses(Bootstrap.align_self_baseline)
                                .with(
                                        text("Aligned flex item")
                                ),
                        div()
                                .withClasses(Bootstrap.align_self_stretch)
                                .with(
                                        text("Aligned flex item")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="align-self-start">
                  Aligned flex item
                </div>
                <div class="align-self-end">
                  Aligned flex item
                </div>
                <div class="align-self-center">
                  Aligned flex item
                </div>
                <div class="align-self-baseline">
                  Aligned flex item
                </div>
                <div class="align-self-stretch">
                  Aligned flex item
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("align-self", renderedHtml);

        uiDocumentation.documentSource("align-self");

    }

    @Test
    void fill() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex)
                        .with(
                                div()
                                        .withClasses(Bootstrap.p_2, Bootstrap.flex_fill)
                                        .with(
                                                text("Flex item with a lot of content")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, Bootstrap.flex_fill)
                                        .with(
                                                text("Flex item")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, Bootstrap.flex_fill)
                                        .with(
                                                text("Flex item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex">
                  <div class="p-2 flex-fill">
                    Flex item with a lot of content
                  </div>
                  <div class="p-2 flex-fill">
                    Flex item
                  </div>
                  <div class="p-2 flex-fill">
                    Flex item
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("fill", renderedHtml);

        uiDocumentation.documentSource("fill");

    }

    @Test
    void growAndShrink() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex)
                        .with(
                                div()
                                        .withClasses(Bootstrap.p_2, Bootstrap.flex_grow_1)
                                        .with(
                                                text("Flex item")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2)
                                        .with(
                                                text("Flex item")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2)
                                        .with(
                                                text("Third flex item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex">
                  <div class="p-2 flex-grow-1">
                    Flex item
                  </div>
                  <div class="p-2">
                    Flex item
                  </div>
                  <div class="p-2">
                    Third flex item
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grow-and-shrink", renderedHtml);

        uiDocumentation.documentSource("grow-and-shrink");

    }

    @Test
    void growAndShrink2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex)
                        .with(
                                div()
                                        .withClasses(Bootstrap.p_2, Bootstrap.w_100)
                                        .with(
                                                text("Flex item")
                                        ),
                                div()
                                        .withClasses(Bootstrap.p_2, Bootstrap.flex_shrink_1)
                                        .with(
                                                text("Flex item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex">
                  <div class="p-2 w-100">
                    Flex item
                  </div>
                  <div class="p-2 flex-shrink-1">
                    Flex item
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grow-and-shrink2", renderedHtml);

        uiDocumentation.documentSource("grow-and-shrink2");

    }

    @Test
    void withAlignItems() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.align_items_start, Bootstrap.flex_column, Bootstrap.mb_3)
                                .withStyle("height: 200px;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.mb_auto, Bootstrap.p_2)
                                                .with(
                                                        text("Flex item")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item")
                                                )
                                ),
                        div()
                                .withClasses(Bootstrap.d_flex, Bootstrap.align_items_end, Bootstrap.flex_column, Bootstrap.mb_3)
                                .withStyle("height: 200px;")
                                .with(
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.p_2)
                                                .with(
                                                        text("Flex item")
                                                ),
                                        div()
                                                .withClasses(Bootstrap.mt_auto, Bootstrap.p_2)
                                                .with(
                                                        text("Flex item")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-items-start flex-column mb-3" style="height: 200px;">
                  <div class="mb-auto p-2">
                    Flex item
                  </div>
                  <div class="p-2">
                    Flex item
                  </div>
                  <div class="p-2">
                    Flex item
                  </div>
                </div>
                <div class="d-flex align-items-end flex-column mb-3" style="height: 200px;">
                  <div class="p-2">
                    Flex item
                  </div>
                  <div class="p-2">
                    Flex item
                  </div>
                  <div class="mt-auto p-2">
                    Flex item
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("with-align-items", renderedHtml);

        uiDocumentation.documentSource("with-align-items");

    }


    @Test
    void wrap() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.flex_nowrap)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex flex-nowrap">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("wrap", renderedHtml);

        uiDocumentation.documentSource("wrap");

    }

    @Test
    void wrap2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.flex_wrap)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex flex-wrap">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("wrap2", renderedHtml);

        uiDocumentation.documentSource("wrap2");

    }

    @Test
    void wrap3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.flex_wrap_reverse)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex flex-wrap-reverse">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("wrap3", renderedHtml);

        uiDocumentation.documentSource("wrap3");

    }

    @Test
    void order() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.flex_nowrap)
                        .with(
                                div()
                                        .withClasses(Bootstrap.order_3, Bootstrap.p_2)
                                        .with(
                                                text("First flex item")
                                        ),
                                div()
                                        .withClasses(Bootstrap.order_2, Bootstrap.p_2)
                                        .with(
                                                text("Second flex item")
                                        ),
                                div()
                                        .withClasses(Bootstrap.order_1, Bootstrap.p_2)
                                        .with(
                                                text("Third flex item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex flex-nowrap">
                  <div class="order-3 p-2">
                    First flex item
                  </div>
                  <div class="order-2 p-2">
                    Second flex item
                  </div>
                  <div class="order-1 p-2">
                    Third flex item
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("order", renderedHtml);

        uiDocumentation.documentSource("order");

    }

    @Test
    void alignContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.align_content_start, Bootstrap.flex_wrap)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-content-start flex-wrap">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("align-content", renderedHtml);

        uiDocumentation.documentSource("align-content");

    }

    @Test
    void alignContent2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.align_content_end, Bootstrap.flex_wrap)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-content-end flex-wrap">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("align-content", renderedHtml);

        uiDocumentation.documentSource("align-content");

    }

    @Test
    void alignContent3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.align_content_center, Bootstrap.flex_wrap)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-content-center flex-wrap">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("align-content3", renderedHtml);

        uiDocumentation.documentSource("align-content3");

    }

    @Test
    void alignContent4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.align_content_between, Bootstrap.flex_wrap)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-content-between flex-wrap">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("align-content4", renderedHtml);

        uiDocumentation.documentSource("align-content4");

    }

    @Test
    void alignContent5() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.align_content_around, Bootstrap.flex_wrap)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-content-around flex-wrap">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("align-content4", renderedHtml);

        uiDocumentation.documentSource("align-content4");

    }

    @Test
    void alignContent6() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.align_content_stretch, Bootstrap.flex_wrap)
                        .with(
                                text("...")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-content-stretch flex-wrap">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("align-content6", renderedHtml);

        uiDocumentation.documentSource("align-content6");

    }

    @Test
    void mediaObject() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex)
                        .with(
                                div()
                                        .withClasses(Bootstrap.flex_shrink_0)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withAlt("...")
                                        ),
                                div()
                                        .withClasses(Bootstrap.flex_grow_1, Bootstrap.ms_3)
                                        .with(
                                                text("This is some content from a media component. You can replace this with any content and adjust it as needed.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex">
                  <div class="flex-shrink-0">
                    <img src="..." alt="...">
                  </div>
                  <div class="flex-grow-1 ms-3">
                    This is some content from a media component. You can replace this with any content and adjust it as needed.
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("media-object", renderedHtml);

        uiDocumentation.documentSource("media-object");

    }

    @Test
    void mediaObject2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Bootstrap.d_flex, Bootstrap.align_items_center)
                        .with(
                                div()
                                        .withClasses(Bootstrap.flex_shrink_0)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withAlt("...")
                                        ),
                                div()
                                        .withClasses(Bootstrap.flex_grow_1, Bootstrap.ms_3)
                                        .with(
                                                text("This is some content from a media component. You can replace this with any content and adjust it as needed.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="d-flex align-items-center">
                  <div class="flex-shrink-0">
                    <img src="..." alt="...">
                  </div>
                  <div class="flex-grow-1 ms-3">
                    This is some content from a media component. You can replace this with any content and adjust it as needed.
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("media-object2", renderedHtml);

        uiDocumentation.documentSource("media-object2");

    }


}
