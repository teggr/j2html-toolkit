package sh.rebelstack.j2html.engine;

import j2html.tags.DomContent;

@FunctionalInterface
public interface HtmlComponent {
    DomContent render(RenderContext ctx);
}
