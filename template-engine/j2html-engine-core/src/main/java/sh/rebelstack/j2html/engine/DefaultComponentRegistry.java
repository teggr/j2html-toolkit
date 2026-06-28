package sh.rebelstack.j2html.engine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public final class DefaultComponentRegistry implements ComponentRegistry {
    private final Map<String, ComponentDescriptor> components;

    public DefaultComponentRegistry(Map<String, ComponentDescriptor> components) {
        this.components = Map.copyOf(new LinkedHashMap<>(components));
    }

    @Override
    public Optional<ComponentDescriptor> find(String name) {
        return Optional.ofNullable(components.get(name));
    }

    @Override
    public boolean contains(String name) {
        return components.containsKey(name);
    }
}
