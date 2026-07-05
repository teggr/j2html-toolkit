package sh.rebelstack.j2html.engine.spring;

import sh.rebelstack.j2html.engine.J2HtmlEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;
import java.util.Objects;

public class J2HtmlViewResolver implements ViewResolver, Ordered {
    private static final Logger LOG = LoggerFactory.getLogger(J2HtmlViewResolver.class);

    private final J2HtmlEngine engine;
    private String contentType = "text/html";
    private String characterEncoding = "UTF-8";
    private int order = Ordered.LOWEST_PRECEDENCE - 5;

    public J2HtmlViewResolver(J2HtmlEngine engine) {
        this.engine = Objects.requireNonNull(engine, "engine must not be null");
    }

    @Override
    @Nullable
    public View resolveViewName(String viewName, Locale locale) {
        boolean knownTemplate = engine.isKnownTemplate(viewName);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Resolving MVC view '{}' for locale {}: {}",
                    viewName,
                    locale,
                    knownTemplate ? "template found" : "template not found");
        }

        if (!knownTemplate) {
            return null;
        }

        return new J2HtmlView(engine, viewName, locale, contentType, characterEncoding);
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }
}
