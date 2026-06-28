package sh.rebelstack.j2html.engine.spring.boot;

import sh.rebelstack.j2html.engine.EmptyTagStyle;
import sh.rebelstack.j2html.engine.IndentationStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ConfigurationProperties(prefix = "j2html")
public class J2HtmlEngineProperties {
    private List<String> basePackages = new ArrayList<>();
    private boolean cache = true;
    private Locale locale = Locale.getDefault();
    private Charset encoding = StandardCharsets.UTF_8;
    private String componentSuffix = "Component";
    private RenderProperties render = new RenderProperties();
    private MessagesProperties messages = new MessagesProperties();

    public List<String> getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(List<String> basePackages) {
        this.basePackages = basePackages;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Charset getEncoding() {
        return encoding;
    }

    public void setEncoding(Charset encoding) {
        this.encoding = encoding;
    }

    public String getComponentSuffix() {
        return componentSuffix;
    }

    public void setComponentSuffix(String componentSuffix) {
        this.componentSuffix = componentSuffix;
    }

    public RenderProperties getRender() {
        return render;
    }

    public void setRender(RenderProperties render) {
        this.render = render;
    }

    public MessagesProperties getMessages() {
        return messages;
    }

    public void setMessages(MessagesProperties messages) {
        this.messages = messages;
    }

    public static class RenderProperties {
        private IndentationStyle indentation = IndentationStyle.NONE;
        private EmptyTagStyle emptyTags = EmptyTagStyle.VOID;

        public IndentationStyle getIndentation() {
            return indentation;
        }

        public void setIndentation(IndentationStyle indentation) {
            this.indentation = indentation;
        }

        public EmptyTagStyle getEmptyTags() {
            return emptyTags;
        }

        public void setEmptyTags(EmptyTagStyle emptyTags) {
            this.emptyTags = emptyTags;
        }
    }

    public static class MessagesProperties {
        private String basename = "messages";
        private Charset encoding = StandardCharsets.UTF_8;

        public String getBasename() {
            return basename;
        }

        public void setBasename(String basename) {
            this.basename = basename;
        }

        public Charset getEncoding() {
            return encoding;
        }

        public void setEncoding(Charset encoding) {
            this.encoding = encoding;
        }
    }
}
