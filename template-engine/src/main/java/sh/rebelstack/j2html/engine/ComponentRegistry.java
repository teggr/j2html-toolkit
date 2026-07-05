package sh.rebelstack.j2html.engine;

import java.util.Optional;

public interface ComponentRegistry {
    Optional<ComponentDescriptor> find(String name);

    boolean contains(String name);
}
