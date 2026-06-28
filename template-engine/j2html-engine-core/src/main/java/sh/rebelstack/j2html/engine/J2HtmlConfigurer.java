package sh.rebelstack.j2html.engine;

import j2html.Config;
import j2html.utils.Indenter;

public final class J2HtmlConfigurer {

    private final IndentationStyle indentationStyle;
    private final EmptyTagStyle emptyTagStyle;

    private J2HtmlConfigurer(IndentationStyle indentationStyle, EmptyTagStyle emptyTagStyle) {
        this.indentationStyle = indentationStyle;
        this.emptyTagStyle = emptyTagStyle;
    }

    public static Builder builder() {
        return new Builder();
    }

    void applyToGlobal() {
        Config.global()
                .withIndenter(indenterFor(indentationStyle))
                .withEmptyTagsClosed(emptyTagStyle == EmptyTagStyle.CLOSED);
    }

    private static Indenter indenterFor(IndentationStyle style) {
        return switch (style) {
            case NONE -> (level, text) -> text;
            case SPACES_2 -> (level, text) -> "  ".repeat(Math.max(0, level)) + text;
            case SPACES_4 -> (level, text) -> "    ".repeat(Math.max(0, level)) + text;
            case TABS -> (level, text) -> "\t".repeat(Math.max(0, level)) + text;
        };
    }

    public static final class Builder {
        private IndentationStyle indentationStyle = IndentationStyle.NONE;
        private EmptyTagStyle emptyTagStyle = EmptyTagStyle.VOID;

        public Builder indentationStyle(IndentationStyle indentationStyle) {
            this.indentationStyle = indentationStyle;
            return this;
        }

        public Builder emptyTagStyle(EmptyTagStyle emptyTagStyle) {
            this.emptyTagStyle = emptyTagStyle;
            return this;
        }

        public J2HtmlConfigurer build() {
            return new J2HtmlConfigurer(indentationStyle, emptyTagStyle);
        }
    }
}
