# rebel-ui-test

A proof of concept UI testing framework based on [Spring MockMvc](https://docs.spring.io/spring-framework/reference/testing/mockmvc/overview.html).

* Useful for validating HTML output
* Integrates with JUnit test framework
* Generates snippets of code for integrating with documentation tools

```java
  import dev.rebelcraft.j2html.toolkit.integration.bootstrap.Bootstrap;
  import dev.rebelcraft.uitest.UiDocumentation;
  import org.junit.jupiter.api.BeforeEach;
  import org.junit.jupiter.api.Test;
  import org.junit.jupiter.api.TestInfo;
  import static j2html.TagCreator.*;
  import static org.junit.jupiter.api.Assertions.assertEquals;

class AlertsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_primary)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple primary alert—check it out!")
                        )
                    )
                );

        //language=HTML
        assertEquals("""
            <div class="alert alert-primary" role="alert">
              A simple primary alert—check it out!
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

}

```