package dev.rebelcraft.j2html.toolkit.templates;

import j2html.tags.DomContent;

@FunctionalInterface
public interface HtmlComponent {
    DomContent render(RenderContext ctx);
}
