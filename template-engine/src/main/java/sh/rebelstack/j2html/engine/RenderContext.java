package sh.rebelstack.j2html.engine;

import j2html.tags.DomContent;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public interface RenderContext {

    <T> T require(String name, Class<T> type);

    <T> Optional<T> find(String name, Class<T> type);

    boolean has(String name);

    Locale locale();

    String message(String key, Object... args);

    DomContent include(String templateName);

    DomContent include(String templateName, Map<String, Object> vars);

    DomContent include(String templateName, Consumer<Builder> child);

    Builder childContext();

    static RenderContext of(String key, Object value) {
        return new DefaultRenderContext.Builder().with(key, value).build();
    }

    static RenderContext of(Map<String, Object> vars) {
        return new DefaultRenderContext.Builder().with(vars).build();
    }

    static RenderContext empty() {
        return new DefaultRenderContext.Builder().build();
    }

    interface Builder {
        Builder with(String name, Object value);

        Builder with(Map<String, Object> vars);

        Builder locale(Locale locale);

        RenderContext build();
    }
}
