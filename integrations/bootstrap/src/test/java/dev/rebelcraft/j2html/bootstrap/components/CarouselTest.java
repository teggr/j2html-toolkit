package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarouselTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void basicExamples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                     .withId("carouselExample")
                     .withClasses(Bootstrap.carousel,Carousel.slide)
                     .with(
                        div()
                         .withClasses(Bootstrap.carousel_inner)
                         .with(
                            div()
                             .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                             .with(
                                img()
                                 .withSrc("...")
                                 .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                 .withAlt("...")
                              ),
                            div()
                             .withClasses(Bootstrap.carousel_item)
                             .with(
                                img()
                                 .withSrc("...")
                                 .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                 .withAlt("...")
                              ),
                            div()
                             .withClasses(Bootstrap.carousel_item)
                             .with(
                                img()
                                 .withSrc("...")
                                 .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                 .withAlt("...")
                              )
                          ),
                        button()
                         .withClasses(Bootstrap.carousel_control_prev)
                         .withType("button")
                         .withData("bs-target","#carouselExample")
                         .withData("bs-slide","prev")
                         .with(
                            span()
                             .withClasses(Bootstrap.carousel_control_prev_icon)
                             .attr(AriaStatesAndProperties.ariaHidden("true")),
                            span()
                             .withClasses(Bootstrap.visually_hidden)
                             .with(
                                text("Previous")
                              )
                          ),
                        button()
                         .withClasses(Bootstrap.carousel_control_next)
                         .withType("button")
                         .withData("bs-target","#carouselExample")
                         .withData("bs-slide","next")
                         .with(
                            span()
                             .withClasses(Bootstrap.carousel_control_next_icon)
                             .attr(AriaStatesAndProperties.ariaHidden("true")),
                            span()
                             .withClasses(Bootstrap.visually_hidden)
                             .with(
                                text("Next")
                              )
                          )
                      )
                );

        //language=HTML
        assertEquals("""
            <div id="carouselExample" class="carousel slide">
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img src="..." class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="..." class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                  <img src="..." class="d-block w-100" alt="...">
                </div>
              </div>
              <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true">
                </span>
                <span class="visually-hidden">
                  Previous
                </span>
              </button>
              <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true">
                </span>
                <span class="visually-hidden">
                  Next
                </span>
              </button>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("basic-examples", renderedHtml);

        uiDocumentation.documentSource("basic-examples");

    }

    @Test
    void indicators() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleIndicators")
                        .withClasses(Bootstrap.carousel,Carousel.slide)
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_indicators)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleIndicators")
                                                        .withData("bs-slide-to","0")
                                                        .withClasses(Bootstrap.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("true")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 1")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleIndicators")
                                                        .withData("bs-slide-to","1")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 2")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleIndicators")
                                                        .withData("bs-slide-to","2")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 3")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_prev)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleIndicators")
                                        .withData("bs-slide","prev")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_prev_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Previous")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_next)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleIndicators")
                                        .withData("bs-slide","next")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_next_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Next")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div id="carouselExampleIndicators" class="carousel slide">
                  <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1">
                    </button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2">
                    </button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3">
                    </button>
                  </div>
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Previous
                    </span>
                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Next
                    </span>
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("indicators", renderedHtml);

        uiDocumentation.documentSource("indicators");

    }

    @Test
    void captions() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleCaptions")
                        .withClasses(Bootstrap.carousel,Carousel.slide)
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_indicators)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleCaptions")
                                                        .withData("bs-slide-to","0")
                                                        .withClasses(Bootstrap.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("true")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 1")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleCaptions")
                                                        .withData("bs-slide-to","1")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 2")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleCaptions")
                                                        .withData("bs-slide-to","2")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 3")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.carousel_caption, Bootstrap.d_none, Bootstrap.d_md_block)
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("First slide label")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("Some representative placeholder content for the first slide.")
                                                                                        )
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.carousel_caption, Bootstrap.d_none, Bootstrap.d_md_block)
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Second slide label")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("Some representative placeholder content for the second slide.")
                                                                                        )
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.carousel_caption, Bootstrap.d_none, Bootstrap.d_md_block)
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Third slide label")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("Some representative placeholder content for the third slide.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_prev)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleCaptions")
                                        .withData("bs-slide","prev")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_prev_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Previous")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_next)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleCaptions")
                                        .withData("bs-slide","next")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_next_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Next")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                    <div id="carouselExampleCaptions" class="carousel slide">
                      <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1">
                        </button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2">
                        </button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3">
                        </button>
                      </div>
                      <div class="carousel-inner">
                        <div class="carousel-item active">
                          <img src="..." class="d-block w-100" alt="...">
                          <div class="carousel-caption d-none d-md-block">
                            <h5>
                              First slide label
                            </h5>
                            <p>
                              Some representative placeholder content for the first slide.
                            </p>
                          </div>
                        </div>
                        <div class="carousel-item">
                          <img src="..." class="d-block w-100" alt="...">
                          <div class="carousel-caption d-none d-md-block">
                            <h5>
                              Second slide label
                            </h5>
                            <p>
                              Some representative placeholder content for the second slide.
                            </p>
                          </div>
                        </div>
                        <div class="carousel-item">
                          <img src="..." class="d-block w-100" alt="...">
                          <div class="carousel-caption d-none d-md-block">
                            <h5>
                              Third slide label
                            </h5>
                            <p>
                              Some representative placeholder content for the third slide.
                            </p>
                          </div>
                        </div>
                      </div>
                      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true">
                        </span>
                        <span class="visually-hidden">
                          Previous
                        </span>
                      </button>
                      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true">
                        </span>
                        <span class="visually-hidden">
                          Next
                        </span>
                      </button>
                    </div>
                    """, renderedHtml);

        // document
        uiDocumentation.document("captions", renderedHtml);

        uiDocumentation.documentSource("captions");

    }

    @Test
    void crossFade() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleFade")
                        .withClasses(Bootstrap.carousel,Carousel.slide, Bootstrap.carousel_fade)
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_prev)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleFade")
                                        .withData("bs-slide","prev")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_prev_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Previous")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_next)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleFade")
                                        .withData("bs-slide","next")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_next_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Next")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div id="carouselExampleFade" class="carousel slide carousel-fade">
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Previous
                    </span>
                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Next
                    </span>
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("cross-fade", renderedHtml);

        uiDocumentation.documentSource("cross-fade");

    }


    @Test
    void autoplayingCarousels() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleAutoplaying")
                        .withClasses(Bootstrap.carousel,Carousel.slide)
                        .withData("bs-ride","carousel")
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_prev)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleAutoplaying")
                                        .withData("bs-slide","prev")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_prev_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Previous")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_next)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleAutoplaying")
                                        .withData("bs-slide","next")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_next_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Next")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Previous
                    </span>
                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Next
                    </span>
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("autoplaying-carousels", renderedHtml);

        uiDocumentation.documentSource("autoplaying-carousels");

    }

    @Test
    void autoplayingCarousels2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleRide")
                        .withClasses(Bootstrap.carousel,Carousel.slide)
                        .withData("bs-ride","true")
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_prev)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleRide")
                                        .withData("bs-slide","prev")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_prev_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Previous")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_next)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleRide")
                                        .withData("bs-slide","next")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_next_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Next")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div id="carouselExampleRide" class="carousel slide" data-bs-ride="true">
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Previous
                    </span>
                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Next
                    </span>
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("autoplaying-carousels2", renderedHtml);

        uiDocumentation.documentSource("autoplaying-carousels2");

    }

    @Test
    void individualCarouselItemInterval() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleInterval")
                        .withClasses(Bootstrap.carousel,Carousel.slide)
                        .withData("bs-ride","carousel")
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .withData("bs-interval","10000")
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .withData("bs-interval","2000")
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_prev)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleInterval")
                                        .withData("bs-slide","prev")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_prev_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Previous")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_next)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleInterval")
                                        .withData("bs-slide","next")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_next_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Next")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="10000">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Previous
                    </span>
                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Next
                    </span>
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("individual-carousel-item-interval", renderedHtml);

        uiDocumentation.documentSource("individual-carousel-item-interval");

    }

    @Test
    void autoplayingCarouselsWithoutControls() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleSlidesOnly")
                        .withClasses(Bootstrap.carousel,Carousel.slide)
                        .withData("bs-ride","carousel")
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("autoplaying-carousels-without-controls", renderedHtml);

        uiDocumentation.documentSource("autoplaying-carousels-without-controls");

    }

    @Test
    void disableTouchSwiping() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleControlsNoTouching")
                        .withClasses(Bootstrap.carousel,Carousel.slide)
                        .withData("bs-touch","false")
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("...")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_prev)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleControlsNoTouching")
                                        .withData("bs-slide","prev")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_prev_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Previous")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_next)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleControlsNoTouching")
                                        .withData("bs-slide","next")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_next_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Next")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div id="carouselExampleControlsNoTouching" class="carousel slide" data-bs-touch="false">
                  <div class="carousel-inner">
                    <div class="carousel-item active">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                    </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Previous
                    </span>
                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Next
                    </span>
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("disable-touch-swiping", renderedHtml);

        uiDocumentation.documentSource("disable-touch-swiping");

    }

    @Test
    void darkVariant() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withId("carouselExampleDark")
                        .withClasses(Bootstrap.carousel, Bootstrap.carousel_dark,Carousel.slide)
                        .with(
                                div()
                                        .withClasses(Bootstrap.carousel_indicators)
                                        .with(
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleDark")
                                                        .withData("bs-slide-to","0")
                                                        .withClasses(Bootstrap.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("true")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 1")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleDark")
                                                        .withData("bs-slide-to","1")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 2")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withData("bs-target","#carouselExampleDark")
                                                        .withData("bs-slide-to","2")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Slide 3")
                                                        )
                                        ),
                                div()
                                        .withClasses(Bootstrap.carousel_inner)
                                        .with(
                                                div()
                                                        .withClasses(Bootstrap.carousel_item, Bootstrap.active)
                                                        .withData("bs-interval","10000")
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.carousel_caption, Bootstrap.d_none, Bootstrap.d_md_block)
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("First slide label")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("Some representative placeholder content for the first slide.")
                                                                                        )
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .withData("bs-interval","2000")
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.carousel_caption, Bootstrap.d_none, Bootstrap.d_md_block)
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Second slide label")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("Some representative placeholder content for the second slide.")
                                                                                        )
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Bootstrap.carousel_item)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Bootstrap.d_block, Bootstrap.w_100)
                                                                        .withAlt("..."),
                                                                div()
                                                                        .withClasses(Bootstrap.carousel_caption, Bootstrap.d_none, Bootstrap.d_md_block)
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Third slide label")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("Some representative placeholder content for the third slide.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_prev)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleDark")
                                        .withData("bs-slide","prev")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_prev_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Previous")
                                                        )
                                        ),
                                button()
                                        .withClasses(Bootstrap.carousel_control_next)
                                        .withType("button")
                                        .withData("bs-target","#carouselExampleDark")
                                        .withData("bs-slide","next")
                                        .with(
                                                span()
                                                        .withClasses(Bootstrap.carousel_control_next_icon)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaHidden("true")
                                                        ),
                                                span()
                                                        .withClasses(Bootstrap.visually_hidden)
                                                        .with(
                                                                text("Next")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div id="carouselExampleDark" class="carousel carousel-dark slide">
                  <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1">
                    </button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2">
                    </button>
                    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3">
                    </button>
                  </div>
                  <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="10000">
                      <img src="..." class="d-block w-100" alt="...">
                      <div class="carousel-caption d-none d-md-block">
                        <h5>
                          First slide label
                        </h5>
                        <p>
                          Some representative placeholder content for the first slide.
                        </p>
                      </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                      <img src="..." class="d-block w-100" alt="...">
                      <div class="carousel-caption d-none d-md-block">
                        <h5>
                          Second slide label
                        </h5>
                        <p>
                          Some representative placeholder content for the second slide.
                        </p>
                      </div>
                    </div>
                    <div class="carousel-item">
                      <img src="..." class="d-block w-100" alt="...">
                      <div class="carousel-caption d-none d-md-block">
                        <h5>
                          Third slide label
                        </h5>
                        <p>
                          Some representative placeholder content for the third slide.
                        </p>
                      </div>
                    </div>
                  </div>
                  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Previous
                    </span>
                  </button>
                  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true">
                    </span>
                    <span class="visually-hidden">
                      Next
                    </span>
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("dark-variant", renderedHtml);

        uiDocumentation.documentSource("dark-variant");

    }


}
