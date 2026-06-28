package sh.rebelstack.j2html.engine.spring;

import sh.rebelstack.j2html.engine.HtmlComponent;
import sh.rebelstack.j2html.engine.J2HtmlEngine;
import sh.rebelstack.j2html.engine.RenderContext;
import j2html.tags.DomContent;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.Locale;
import java.util.Map;

import static j2html.TagCreator.div;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class J2HtmlViewResolverTest {

    @Test
    void resolvesKnownViewsAndRendersModel() throws Exception {
        J2HtmlEngine engine = J2HtmlEngine.builder().register("greeting", GreetingComponent.class).build();
        J2HtmlViewResolver resolver = new J2HtmlViewResolver(engine);

        var view = resolver.resolveViewName("greeting", Locale.UK);
        assertNotNull(view);

        MockHttpServletResponse response = new MockHttpServletResponse();
        view.render(Map.of("name", "Sam"), new MockHttpServletRequest(), response);

        assertEquals("<div>Hello Sam</div>", response.getContentAsString());
    }

    @Test
    void returnsNullForUnknownTemplate() {
        J2HtmlEngine engine = J2HtmlEngine.builder().register("greeting", GreetingComponent.class).build();
        J2HtmlViewResolver resolver = new J2HtmlViewResolver(engine);

        assertNull(resolver.resolveViewName("missing", Locale.UK));
    }

    public static class GreetingComponent implements HtmlComponent {
        @Override
        public DomContent render(RenderContext ctx) {
            return div(text("Hello " + ctx.require("name", String.class)));
        }
    }
}
