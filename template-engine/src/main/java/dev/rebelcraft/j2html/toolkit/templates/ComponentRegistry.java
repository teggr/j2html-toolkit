package dev.rebelcraft.j2html.toolkit.templates;

import java.util.Optional;

public interface ComponentRegistry {
    Optional<ComponentDescriptor> find(String name);

    boolean contains(String name);
}
