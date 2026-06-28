package dev.rebelcraft.j2html.spring.webmvc;

import j2html.rendering.IndentedHtml;
import j2html.tags.DomContent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.AbstractView;

import java.util.Map;

import static j2html.TagCreator.document;
import static j2html.TagCreator.each;

public abstract class J2HtmlView extends AbstractView {

    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // build the ui
        DomContent html = renderMergedOutputModelDomContent(model, request, response);

        // output the response
        setResponseContentType(request, response);
        each(document(), html).render(IndentedHtml.into(response.getWriter()));

    }

    protected abstract DomContent renderMergedOutputModelDomContent(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
