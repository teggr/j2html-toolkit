package sh.rebelstack.j2html.engine;

import j2html.tags.DomContent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ComponentValidatorTest {

    @Test
    void validatesCompliantRenderMethod() {
        var handle = ComponentValidator.validateAndResolveRenderHandle(ValidComponent.class, "valid/component");
        assertNotNull(handle);
    }

    @Test
    void rejectsInvalidRenderSignature() {
        assertThrows(J2HtmlEngineInitializationException.class,
                () -> ComponentValidator.validateAndResolveRenderHandle(InvalidComponent.class, "invalid/component"));
    }

    public static class ValidComponent {
        public DomContent render(RenderContext ctx) {
            return j2html.TagCreator.text("ok");
        }
    }

    public static class InvalidComponent {
        public String render() {
            return "bad";
        }
    }
}
