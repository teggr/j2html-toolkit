package dev.rebelcraft.j2html.ext;

import dev.rebelcraft.j2html.ext.core.PathTag;
import dev.rebelcraft.j2html.ext.core.SvgTag;
import dev.rebelcraft.j2html.ext.core.SymbolTag;
import dev.rebelcraft.j2html.ext.core.UseTag;
import j2html.TagCreator;
import j2html.tags.DomContent;
import j2html.tags.UnescapedText;
import j2html.tags.specialized.HtmlTag;

public class ExtendedTagCreator {

    public static String document(HtmlTag htmlTag) {

        return TagCreator.document().render() +
               "\n" +
               htmlTag.renderFormatted();

    }

    public static DomContent comment(String text) {
        return new UnescapedText("<!-- " + text + " -->");
    }

    public static SvgTag svg() { return new SvgTag(); }

    public static PathTag path() { return new PathTag(); }

    public static UseTag use() { return new UseTag(); }

    public static SymbolTag symbol() { return new SymbolTag(); }

}
