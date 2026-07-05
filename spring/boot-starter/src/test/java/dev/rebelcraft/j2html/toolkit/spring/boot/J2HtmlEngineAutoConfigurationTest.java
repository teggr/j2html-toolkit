package dev.rebelcraft.j2html.toolkit.spring.boot;

import j2html.tags.DomContent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;

import dev.rebelcraft.j2html.toolkit.spring.templates.J2HtmlViewResolver;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.HtmlTemplate;
import dev.rebelcraft.j2html.toolkit.templates.J2HtmlEngine;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;

import static j2html.TagCreator.div;
import static j2html.TagCreator.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class J2HtmlEngineAutoConfigurationTest {

    private final WebApplicationContextRunner contextRunner = new WebApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(J2HtmlEngineAutoConfiguration.class))
            .withPropertyValues("j2html.base-packages=sh.rebelstack.j2html.engine.spring.boot");

    @Test
    void createsEngineAndViewResolverBeans() {
        contextRunner.run(context -> {
            J2HtmlEngine engine = context.getBean(J2HtmlEngine.class);
            J2HtmlViewResolver resolver = context.getBean(J2HtmlViewResolver.class);

            assertNotNull(engine);
            assertNotNull(resolver);
            assertEquals("<div>boot</div>", engine.process("boot/sample", RenderContext.empty()));
        });
    }

    @HtmlTemplate("boot/sample")
    public static class SampleComponent implements HtmlComponent {
        @Override
        public DomContent render(RenderContext ctx) {
            return div(text("boot"));
        }
    }
}
