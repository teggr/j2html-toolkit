package sh.rebelstack.j2html.engine.spring.boot;

import sh.rebelstack.j2html.engine.ComponentNamingStrategy;
import sh.rebelstack.j2html.engine.J2HtmlEngine;
import sh.rebelstack.j2html.engine.spring.J2HtmlViewResolver;
import sh.rebelstack.j2html.engine.spring.SpringComponentFactory;
import sh.rebelstack.j2html.engine.spring.SpringMessageResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration(afterName = "org.springframework.boot.webmvc.autoconfigure.WebMvcAutoConfiguration")
@EnableConfigurationProperties(J2HtmlEngineProperties.class)
@ConditionalOnClass(J2HtmlEngine.class)
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class J2HtmlEngineAutoConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(J2HtmlEngineAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public J2HtmlEngine j2htmlEngine(J2HtmlEngineProperties props, ApplicationContext ctx) {
        List<String> basePackages = resolveBasePackages(props, ctx);

        LOG.info("Configuring J2HtmlEngine: basePackages={}, cache={}, locale={}, encoding={}, componentSuffix={}, "
                        + "render.indentation={}, render.emptyTags={}, messages.basename={}, messages.encoding={}",
            basePackages,
                props.isCache(),
                props.getLocale(),
                props.getEncoding(),
                props.getComponentSuffix(),
                props.getRender().getIndentation(),
                props.getRender().getEmptyTags(),
                props.getMessages().getBasename(),
                props.getMessages().getEncoding());

        var builder = J2HtmlEngine.builder()
                .cache(props.isCache())
                .locale(props.getLocale())
                .encoding(props.getEncoding())
                .namingStrategy(ComponentNamingStrategy.defaultStrategy(
                        basePackages.isEmpty() ? null : basePackages.get(0),
                        props.getComponentSuffix()))
                .scanner(new SpringClassPathComponentScanner())
                .factory(new SpringComponentFactory(ctx))
                .messageResolver(new SpringMessageResolver(ctx))
                .j2html(cfg -> cfg
                        .indentationStyle(props.getRender().getIndentation())
                        .emptyTagStyle(props.getRender().getEmptyTags()));

            basePackages.forEach(builder::scan);
        J2HtmlEngine engine = builder.build();
        LOG.info("J2HtmlEngine bean initialized");
        return engine;
    }

    @Bean
    @ConditionalOnMissingBean(name = "j2htmlViewResolver")
    public J2HtmlViewResolver j2htmlViewResolver(J2HtmlEngine engine, J2HtmlEngineProperties props) {
        var resolver = new J2HtmlViewResolver(engine);
        resolver.setCharacterEncoding(props.getEncoding().name());
        LOG.info("Configured J2HtmlViewResolver with encoding {}", props.getEncoding().name());
        return resolver;
    }

    private List<String> resolveBasePackages(J2HtmlEngineProperties props, ApplicationContext ctx) {
        if (props.getBasePackages() != null && !props.getBasePackages().isEmpty()) {
            return props.getBasePackages();
        }

        if (AutoConfigurationPackages.has(ctx)) {
            List<String> autoPackages = AutoConfigurationPackages.get(ctx);
            LOG.info("No j2html.base-packages configured; defaulting scan to Spring Boot auto-configuration packages {}",
                    autoPackages);
            return autoPackages;
        }

        LOG.warn("No j2html.base-packages configured and no Spring Boot auto-configuration packages available; "
                + "component scanning is disabled");
        return List.of();
    }
}
