package sh.rebelstack.j2html.engine;

import java.lang.invoke.MethodHandle;
import java.util.Objects;

public record ComponentDescriptor(
        String name,
        Class<?> componentClass,
        ComponentScope scope,
        MethodHandle renderHandle,
        boolean implementsInterface
) {
    public ComponentDescriptor {
        Objects.requireNonNull(name, "name must not be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        Objects.requireNonNull(componentClass, "componentClass must not be null");
        Objects.requireNonNull(scope, "scope must not be null");
        Objects.requireNonNull(renderHandle, "renderHandle must not be null");
    }
}
