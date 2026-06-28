package dev.rebelcraft.html.preview.j2html;

import dev.rebelcraft.html.preview.Preview;
import j2html.TagCreator;
import j2html.tags.DomContent;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class J2HtmlPreviewGeneratorTest {

    private final J2HtmlPreviewGenerator generator = new J2HtmlPreviewGenerator();

    public static class DomContentPreview {
        @Preview
        public DomContent page() {
            return TagCreator.div(TagCreator.text("Hello"));
        }
    }

    public static class StringPreview {
        @Preview
        public String page() {
            return "<p>hello</p>";
        }
    }

    @Test
    void supportsDomContentReturningMethods() throws Exception {
        Method method = DomContentPreview.class.getMethod("page");
        assertTrue(generator.supports(DomContentPreview.class, method));
    }

    @Test
    void doesNotSupportStringReturningMethods() throws Exception {
        Method method = StringPreview.class.getMethod("page");
        assertFalse(generator.supports(StringPreview.class, method));
    }

    @Test
    void generatesHtmlFromDomContentMethods() throws Exception {
        Method method = DomContentPreview.class.getMethod("page");
        Preview preview = method.getAnnotation(Preview.class);
        String html = generator.generate(DomContentPreview.class, method, preview);
        assertEquals("<div>Hello</div>", html);
    }
}
