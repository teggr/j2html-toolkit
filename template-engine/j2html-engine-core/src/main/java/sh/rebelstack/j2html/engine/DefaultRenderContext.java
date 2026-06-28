package sh.rebelstack.j2html.engine;

import j2html.tags.DomContent;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

final class DefaultRenderContext implements RenderContext {
    private final Map<String, Object> vars;
    private final Locale locale;
    private final MessageResolver messageResolver;
    private final J2HtmlEngine engine;

    DefaultRenderContext(Map<String, Object> vars, Locale locale, MessageResolver messageResolver, J2HtmlEngine engine) {
        Map<String, Object> filtered = new LinkedHashMap<>(vars);
        filtered.entrySet().removeIf(e -> e.getValue() == null);
        this.vars = Map.copyOf(filtered);
        this.locale = locale == null ? Locale.getDefault() : locale;
        this.messageResolver = Objects.requireNonNull(messageResolver, "messageResolver must not be null");
        this.engine = engine;
    }

    DefaultRenderContext withEngine(J2HtmlEngine engineRef) {
        return new DefaultRenderContext(vars, locale, messageResolver, engineRef);
    }

    @Override
    public <T> T require(String name, Class<T> type) {
        return find(name, type).orElseThrow(() -> new J2HtmlEngineRenderException(
                "Required variable '" + name + "' is missing"));
    }

    @Override
    public <T> Optional<T> find(String name, Class<T> type) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(type, "type must not be null");
        Object value = vars.get(name);
        if (value == null) {
            return Optional.empty();
        }
        if (!type.isInstance(value)) {
            throw new J2HtmlEngineRenderException("Variable '" + name + "' is not of expected type "
                    + type.getName() + " but was " + value.getClass().getName());
        }
        return Optional.of(type.cast(value));
    }

    @Override
    public boolean has(String name) {
        return vars.containsKey(name);
    }

    @Override
    public Locale locale() {
        return locale;
    }

    @Override
    public String message(String key, Object... args) {
        return messageResolver.resolve(key, locale, args);
    }

    @Override
    public DomContent include(String templateName) {
        if (engine == null) {
            throw new UnsupportedOperationException("include() requires engine-bound context");
        }
        return engine.render(templateName, this);
    }

    @Override
    public DomContent include(String templateName, Map<String, Object> newVars) {
        if (engine == null) {
            throw new UnsupportedOperationException("include() requires engine-bound context");
        }
        RenderContext.Builder builder = childContext();
        builder.with(newVars);
        return engine.render(templateName, builder.build());
    }

    @Override
    public DomContent include(String templateName, Consumer<RenderContext.Builder> child) {
        if (engine == null) {
            throw new UnsupportedOperationException("include() requires engine-bound context");
        }
        RenderContext.Builder builder = childContext();
        child.accept(builder);
        return engine.render(templateName, builder.build());
    }

    @Override
    public Builder childContext() {
        return new Builder(vars)
                .locale(locale)
                .messageResolver(messageResolver)
                .engine(engine);
    }

    static final class Builder implements RenderContext.Builder {
        private final Map<String, Object> vars = new LinkedHashMap<>();
        private Locale locale = Locale.getDefault();
        private MessageResolver messageResolver = new NoOpMessageResolver();
        private J2HtmlEngine engine;

        Builder() {
        }

        Builder(Map<String, Object> existingVars) {
            vars.putAll(existingVars);
        }

        Builder messageResolver(MessageResolver resolver) {
            this.messageResolver = resolver;
            return this;
        }

        Builder engine(J2HtmlEngine engine) {
            this.engine = engine;
            return this;
        }

        @Override
        public Builder with(String name, Object value) {
            vars.put(name, value);
            return this;
        }

        @Override
        public Builder with(Map<String, Object> vars) {
            this.vars.putAll(vars);
            return this;
        }

        @Override
        public Builder locale(Locale locale) {
            this.locale = locale;
            return this;
        }

        @Override
        public RenderContext build() {
            return new DefaultRenderContext(vars, locale, messageResolver, engine);
        }
    }
}
