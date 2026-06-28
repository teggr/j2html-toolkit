package sh.rebelstack.j2html.engine.spring;

import sh.rebelstack.j2html.engine.J2HtmlEngine;
import sh.rebelstack.j2html.engine.RenderContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;

final class J2HtmlView extends AbstractView {
    private static final Logger LOG = LoggerFactory.getLogger(J2HtmlView.class);

    private final J2HtmlEngine engine;
    private final String templateName;
    private final Locale locale;
    private final String characterEncoding;

    J2HtmlView(J2HtmlEngine engine, String templateName, Locale locale, String contentType, String characterEncoding) {
        this.engine = engine;
        this.templateName = templateName;
        this.locale = locale == null ? Locale.getDefault() : locale;
        this.characterEncoding = characterEncoding == null ? StandardCharsets.UTF_8.name() : characterEncoding;
        setContentType(contentType);
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Rendering template '{}' for locale {} with model keys {}",
                    templateName,
                    locale,
                    model.keySet());
        }

        response.setContentType(getContentType());
        response.setCharacterEncoding(characterEncoding);
        String html = engine.process(templateName, RenderContext.of(model).childContext().locale(locale).build());
        if (LOG.isDebugEnabled()) {
            LOG.debug("Rendered template '{}' as {} chars (contentType={}, encoding={})",
                    templateName,
                    html.length(),
                    getContentType(),
                    characterEncoding);
        }
        response.getWriter().write(html);
    }
}
