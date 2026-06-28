package sh.rebelstack.j2html.engine;

import j2html.tags.DomContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public final class J2HtmlEngine {
    private static final Logger LOG = LoggerFactory.getLogger(J2HtmlEngine.class);

    private final ComponentRegistry registry;
    private final ComponentFactory factory;
    private final MessageResolver messageResolver;
    private final Locale defaultLocale;
    private final Charset encoding;
    private final boolean cacheEnabled;
    private final Map<String, ComponentDescriptor> descriptorCache = new ConcurrentHashMap<>();

    private J2HtmlEngine(ComponentRegistry registry,
                         ComponentFactory factory,
                         MessageResolver messageResolver,
                         Locale defaultLocale,
                         Charset encoding,
                         boolean cacheEnabled) {
        this.registry = registry;
        this.factory = factory;
        this.messageResolver = messageResolver;
        this.defaultLocale = defaultLocale;
        this.encoding = encoding;
        this.cacheEnabled = cacheEnabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public DomContent render(String templateName, RenderContext context) {
        ComponentDescriptor descriptor = resolveDescriptor(templateName);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Rendering template '{}' with component '{}' (scope={}, interfaceBased={})",
                    templateName,
                    descriptor.componentClass().getName(),
                    descriptor.scope(),
                    descriptor.implementsInterface());
        }
        try {
            Object component = factory.getInstance(descriptor);
            RenderContext boundContext = bindContext(context);
            if (descriptor.implementsInterface() && component instanceof HtmlComponent htmlComponent) {
                return htmlComponent.render(boundContext);
            }
            return (DomContent) descriptor.renderHandle().invoke(component, boundContext);
        } catch (J2HtmlEngineRenderException e) {
            throw e;
        } catch (Throwable throwable) {
            throw new J2HtmlEngineRenderException("Failed to render template '" + templateName + "'", throwable);
        }
    }

    public String process(String templateName, RenderContext context) {
        return render(templateName, context).render();
    }

    public boolean isKnownTemplate(String templateName) {
        if (cacheEnabled && descriptorCache.containsKey(templateName)) {
            return true;
        }
        return registry.contains(templateName);
    }

    public Charset encoding() {
        return encoding;
    }

    private ComponentDescriptor resolveDescriptor(String templateName) {
        if (cacheEnabled) {
            final boolean[] cacheMiss = {false};
            ComponentDescriptor descriptor = descriptorCache.computeIfAbsent(templateName, key -> {
                cacheMiss[0] = true;
                return lookupDescriptor(key);
            });
            if (LOG.isTraceEnabled()) {
                LOG.trace("Template descriptor cache {} for '{}'", cacheMiss[0] ? "miss" : "hit", templateName);
            }
            return descriptor;
        }
        if (LOG.isTraceEnabled()) {
            LOG.trace("Template descriptor cache disabled, looking up '{}' directly", templateName);
        }
        return lookupDescriptor(templateName);
    }

    private ComponentDescriptor lookupDescriptor(String templateName) {
        ComponentDescriptor descriptor = registry.find(templateName).orElse(null);
        if (descriptor == null) {
            LOG.warn("Unknown template '{}' requested", templateName);
            throw new J2HtmlEngineRenderException("Unknown template '" + templateName + "'");
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Resolved template '{}' to component '{}' (scope={})",
                    templateName,
                    descriptor.componentClass().getName(),
                    descriptor.scope());
        }
        return descriptor;
    }

    private RenderContext bindContext(RenderContext context) {
        if (context instanceof DefaultRenderContext defaultRenderContext) {
            return defaultRenderContext.withEngine(this);
        }
        return new DefaultRenderContext.Builder()
                .locale(defaultLocale)
                .messageResolver(messageResolver)
                .engine(this)
                .build();
    }

    public static final class Builder {
        private final Map<String, Class<?>> explicitRegistrations = new LinkedHashMap<>();
        private final List<String> basePackages = new ArrayList<>();
        private boolean loadFromServiceLoader;
        private ComponentNamingStrategy namingStrategy = ComponentNamingStrategy.defaultStrategy(null, "Component");
        private ComponentFactory factory = new ReflectiveComponentFactory();
        private MessageResolver messageResolver = new NoOpMessageResolver();
        private ComponentScanner scanner = new ClassGraphComponentScanner();
        private Locale locale = Locale.getDefault();
        private Charset encoding = StandardCharsets.UTF_8;
        private boolean cacheEnabled = true;
        private J2HtmlConfigurer configurer = J2HtmlConfigurer.builder().build();

        public Builder register(String name, Class<?> componentClass) {
            explicitRegistrations.put(name, componentClass);
            return this;
        }

        public Builder scan(String... packages) {
            if (packages != null) {
                for (String pkg : packages) {
                    if (pkg != null && !pkg.isBlank()) {
                        basePackages.add(pkg);
                    }
                }
            }
            return this;
        }

        public Builder fromServiceLoader() {
            this.loadFromServiceLoader = true;
            return this;
        }

        public Builder namingStrategy(ComponentNamingStrategy namingStrategy) {
            this.namingStrategy = Objects.requireNonNull(namingStrategy, "namingStrategy must not be null");
            return this;
        }

        public Builder factory(ComponentFactory factory) {
            this.factory = Objects.requireNonNull(factory, "factory must not be null");
            return this;
        }

        public Builder messageResolver(MessageResolver messageResolver) {
            this.messageResolver = Objects.requireNonNull(messageResolver, "messageResolver must not be null");
            return this;
        }

        public Builder scanner(ComponentScanner scanner) {
            this.scanner = Objects.requireNonNull(scanner, "scanner must not be null");
            return this;
        }

        public Builder cache(boolean cache) {
            this.cacheEnabled = cache;
            return this;
        }

        public Builder locale(Locale locale) {
            this.locale = Objects.requireNonNull(locale, "locale must not be null");
            return this;
        }

        public Builder encoding(Charset encoding) {
            this.encoding = Objects.requireNonNull(encoding, "encoding must not be null");
            return this;
        }

        public Builder j2html(Consumer<J2HtmlConfigurer.Builder> customizer) {
            J2HtmlConfigurer.Builder builder = J2HtmlConfigurer.builder();
            customizer.accept(builder);
            this.configurer = builder.build();
            return this;
        }

        public J2HtmlEngine build() {
            if (LOG.isInfoEnabled()) {
                LOG.info("Building J2HtmlEngine with cache={}, locale={}, encoding={}, basePackages={}, serviceLoader={}"
                                + ", namingStrategy={}, factory={}, messageResolver={}",
                        cacheEnabled,
                        locale,
                        encoding,
                        basePackages,
                        loadFromServiceLoader,
                        namingStrategy.getClass().getName(),
                        factory.getClass().getName(),
                        messageResolver.getClass().getName());
            }
            configurer.applyToGlobal();

            Map<String, ComponentDescriptor> descriptors = new LinkedHashMap<>();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Registering {} explicit template mappings", explicitRegistrations.size());
            }
            explicitRegistrations.forEach((name, type) -> addDescriptor(descriptors, name, type));

            if (!basePackages.isEmpty()) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Scanning template components in base packages {}", basePackages);
                }
                Set<Class<?>> discovered = scanner.scan(basePackages);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Discovered {} candidate component classes from scan", discovered.size());
                }
                discovered.forEach(type -> addDescriptor(descriptors, null, type));
            }

            if (loadFromServiceLoader) {
                ServiceLoader<HtmlComponent> loader = ServiceLoader.load(HtmlComponent.class);
                int loadedCount = 0;
                for (HtmlComponent component : loader) {
                    loadedCount++;
                    addDescriptor(descriptors, null, component.getClass());
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Loaded {} components from ServiceLoader", loadedCount);
                }
            }

            if (LOG.isInfoEnabled()) {
                LOG.info("J2HtmlEngine initialized with {} templates: {}", descriptors.size(), descriptors.keySet());
            }

            return new J2HtmlEngine(
                    new DefaultComponentRegistry(descriptors),
                    factory,
                    messageResolver,
                    locale,
                    encoding,
                    cacheEnabled);
        }

        private void addDescriptor(Map<String, ComponentDescriptor> descriptors, String explicitName, Class<?> componentClass) {
            HtmlTemplate annotation = componentClass.getAnnotation(HtmlTemplate.class);
            String resolvedName = resolveName(componentClass, annotation, explicitName);
            ComponentScope scope = annotation == null ? ComponentScope.PROTOTYPE : annotation.scope();
            boolean implementsInterface = HtmlComponent.class.isAssignableFrom(componentClass);
            String registrationSource;
            if (explicitName != null && !explicitName.isBlank()) {
                registrationSource = "explicit";
            } else if (annotation != null && !annotation.value().isBlank()) {
                registrationSource = "annotation";
            } else {
                registrationSource = "naming-strategy";
            }
            warnIfSuspiciousSingleton(componentClass, scope, resolvedName);

            var handle = ComponentValidator.validateAndResolveRenderHandle(componentClass, resolvedName);
            ComponentDescriptor descriptor = new ComponentDescriptor(resolvedName, componentClass, scope, handle,
                    implementsInterface);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Registering template '{}' -> '{}' (scope={}, source={}, interfaceBased={})",
                        resolvedName,
                        componentClass.getName(),
                        scope,
                        registrationSource,
                        implementsInterface);
            }

            ComponentDescriptor existing = descriptors.putIfAbsent(resolvedName, descriptor);
            if (existing != null && existing.componentClass() != componentClass) {
                LOG.error("Duplicate template name '{}' for classes '{}' and '{}'",
                        resolvedName,
                        existing.componentClass().getName(),
                        componentClass.getName());
                throw new J2HtmlEngineInitializationException("Duplicate template name '" + resolvedName
                        + "' for classes '" + existing.componentClass().getName() + "' and '"
                        + componentClass.getName() + "'");
            }
        }

        private String resolveName(Class<?> componentClass, HtmlTemplate annotation, String explicitName) {
            if (explicitName != null && !explicitName.isBlank()) {
                return explicitName;
            }
            if (annotation != null && !annotation.value().isBlank()) {
                return annotation.value();
            }
            String generated = namingStrategy.nameFor(componentClass);
            if (generated == null || generated.isBlank()) {
                throw new J2HtmlEngineInitializationException("Resolved template name is blank for class '"
                        + componentClass.getName() + "'");
            }
            return generated;
        }

        private void warnIfSuspiciousSingleton(Class<?> componentClass, ComponentScope scope, String templateName) {
            if (scope != ComponentScope.SINGLETON) {
                return;
            }
            Collection<Field> mutableFields = new LinkedHashSet<>();
            for (Field field : componentClass.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers)) {
                    mutableFields.add(field);
                }
            }
            if (!mutableFields.isEmpty()) {
                LOG.warn("Template '{}' declared as SINGLETON but has mutable instance fields in class '{}': {}",
                        templateName,
                        componentClass.getName(),
                        mutableFields.stream().map(Field::getName).toList());
            }
        }
    }
}
