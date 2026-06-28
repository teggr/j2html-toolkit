package dev.rebelcraft.j2html.bootstrap.components;

import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BreadcrumbTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        nav()
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("breadcrumb")
                                )
                                .with(
                                        ol()
                                                .withClasses(Bootstrap.breadcrumb)
                                                .with(
                                                        li()
                                                                .withClasses(Bootstrap.breadcrumb_item, Bootstrap.active)
                                                                .attr(AriaStatesAndProperties.ariaCurrent("page"))
                                                                .with(
                                                                        text("Home")
                                                                )
                                                )
                                ),
                        nav()
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("breadcrumb")
                                )
                                .with(
                                        ol()
                                                .withClasses(Bootstrap.breadcrumb)
                                                .with(
                                                        li()
                                                                .withClasses(Bootstrap.breadcrumb_item)
                                                                .with(
                                                                        a()
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Home")
                                                                                )
                                                                ),
                                                        li()
                                                                .withClasses(Bootstrap.breadcrumb_item, Bootstrap.active)
                                                                .attr(AriaStatesAndProperties.ariaCurrent("page"))
                                                                .with(
                                                                        text("Library")
                                                                )
                                                )
                                ),
                        nav()
                                .attr(
                                        AriaStatesAndProperties.ariaLabel("breadcrumb")
                                )
                                .with(
                                        ol()
                                                .withClasses(Bootstrap.breadcrumb)
                                                .with(
                                                        li()
                                                                .withClasses(Bootstrap.breadcrumb_item)
                                                                .with(
                                                                        a()
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Home")
                                                                                )
                                                                ),
                                                        li()
                                                                .withClasses(Bootstrap.breadcrumb_item)
                                                                .with(
                                                                        a()
                                                                                .withHref("#")
                                                                                .with(
                                                                                        text("Library")
                                                                                )
                                                                ),
                                                        li()
                                                                .withClasses(Bootstrap.breadcrumb_item, Bootstrap.active)
                                                                .attr(AriaStatesAndProperties.ariaCurrent("page"))
                                                                .with(
                                                                        text("Data")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item active" aria-current="page">
                      Home
                    </li>
                  </ol>
                </nav>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <a href="#">
                        Home
                      </a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Library
                    </li>
                  </ol>
                </nav>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <a href="#">
                        Home
                      </a>
                    </li>
                    <li class="breadcrumb-item">
                      <a href="#">
                        Library
                      </a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Data
                    </li>
                  </ol>
                </nav>
                """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void dividers() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withStyle("--bs-breadcrumb-divider: '>';")
                        .attr(
                                AriaStatesAndProperties.ariaLabel("breadcrumb")
                        )
                        .with(
                                ol()
                                        .withClasses(Bootstrap.breadcrumb)
                                        .with(
                                                li()
                                                        .withClasses(Bootstrap.breadcrumb_item)
                                                        .with(
                                                                a()
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Home")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.breadcrumb_item, Bootstrap.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .with(
                                                                text("Library")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <nav style="--bs-breadcrumb-divider: &#x27;&gt;&#x27;;" aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <a href="#">
                        Home
                      </a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Library
                    </li>
                  </ol>
                </nav>
                """, renderedHtml);

        // document
        uiDocumentation.document("dividers", renderedHtml);

        uiDocumentation.documentSource("dividers");

    }

    @Test
    void dividers2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withStyle("--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%236c757d'/%3E%3C/svg%3E&#34;);")
                        .attr(
                                AriaStatesAndProperties.ariaLabel("breadcrumb")
                        )
                        .with(
                                ol()
                                        .withClasses(Bootstrap.breadcrumb)
                                        .with(
                                                li()
                                                        .withClasses(Bootstrap.breadcrumb_item)
                                                        .with(
                                                                a()
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Home")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.breadcrumb_item, Bootstrap.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .with(
                                                                text("Library")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <nav style="--bs-breadcrumb-divider: url(&amp;#34;data:image/svg+xml,%3Csvg xmlns=&#x27;http://www.w3.org/2000/svg&#x27; width=&#x27;8&#x27; height=&#x27;8&#x27;%3E%3Cpath d=&#x27;M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z&#x27; fill=&#x27;%236c757d&#x27;/%3E%3C/svg%3E&amp;#34;);" aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <a href="#">
                        Home
                      </a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Library
                    </li>
                  </ol>
                </nav>
                """, renderedHtml);

        // document
        uiDocumentation.document("dividers2", renderedHtml);

        uiDocumentation.documentSource("dividers2");

    }

    @Test
    void dividers3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withStyle("--bs-breadcrumb-divider: '';")
                        .attr(
                                AriaStatesAndProperties.ariaLabel("breadcrumb")
                        )
                        .with(
                                ol()
                                        .withClasses(Bootstrap.breadcrumb)
                                        .with(
                                                li()
                                                        .withClasses(Bootstrap.breadcrumb_item)
                                                        .with(
                                                                a()
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Home")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(Bootstrap.breadcrumb_item, Bootstrap.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .with(
                                                                text("Library")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <nav style="--bs-breadcrumb-divider: &#x27;&#x27;;" aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <a href="#">
                        Home
                      </a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Library
                    </li>
                  </ol>
                </nav>
                """, renderedHtml);

        // document
        uiDocumentation.document("dividers3", renderedHtml);

        uiDocumentation.documentSource("dividers3");

    }


}
