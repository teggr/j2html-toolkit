package dev.rebelcraft.j2html.bootstrap;

import java.io.IOException;
import java.util.Collections;
import dev.rebelcraft.uitest.ExtendedEscapeUtil;
import j2html.Config;
import j2html.rendering.IndentedHtml;
import j2html.tags.DomContent;

public class DocRenderer {

    private static final Config config;

    static {

        config = Config.global()
                .withIndenter((level, text) -> String.join("", Collections.nCopies(level, "  ")) + text)
                .withTextEscaper(ExtendedEscapeUtil::escape);

    }

    public static String domContentToString(DomContent content) throws IOException {

            try {
                return content.render(IndentedHtml.inMemory(config)).toString();
            } catch (Exception e) {
                return "Unable to render content " + e.getMessage();
            }

    }

}