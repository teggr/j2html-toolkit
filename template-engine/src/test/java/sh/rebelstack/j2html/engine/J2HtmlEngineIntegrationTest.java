package sh.rebelstack.j2html.engine;

import j2html.tags.DomContent;
import org.junit.jupiter.api.Test;

import static j2html.TagCreator.div;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class J2HtmlEngineIntegrationTest {

    @Test
    void supportsInterfaceAndAnnotationRegistrationAndInclude() {
        J2HtmlEngine engine = J2HtmlEngine.builder()
                .register("outer", OuterComponent.class)
                .register("inner", InnerTemplate.class)
                .build();

        String html = engine.process("outer", RenderContext.of("name", "Ada"));

        assertTrue(engine.isKnownTemplate("inner"));
        assertEquals("<div>Hello Ada and <div>Inner Ada</div></div>", html);
    }

    @Test
    void resolvesNamingStrategyWhenAnnotationNameIsAbsent() {
        J2HtmlEngine engine = J2HtmlEngine.builder()
                .namingStrategy(ComponentNamingStrategy.defaultStrategy("sh.rebelstack.j2html.engine", "Component"))
                .register("ignored", NamedByAnnotation.class)
                .build();

        assertEquals("<div>named</div>", engine.process("ignored", RenderContext.empty()));
    }

    public static class OuterComponent implements HtmlComponent {
        @Override
        public DomContent render(RenderContext ctx) {
            return div(text("Hello " + ctx.require("name", String.class) + " and "), ctx.include("inner"));
        }
    }

    @HtmlTemplate("inner")
    public static class InnerTemplate {
        public DomContent render(RenderContext ctx) {
            return div(text("Inner " + ctx.require("name", String.class)));
        }
    }

    @HtmlTemplate("ignored")
    public static class NamedByAnnotation implements HtmlComponent {
        @Override
        public DomContent render(RenderContext ctx) {
            return div(text("named"));
        }
    }
}
