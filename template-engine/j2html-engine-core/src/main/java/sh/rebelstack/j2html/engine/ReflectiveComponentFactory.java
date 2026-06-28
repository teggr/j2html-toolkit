package sh.rebelstack.j2html.engine;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectiveComponentFactory implements ComponentFactory {
    private final Map<Class<?>, MethodHandle> constructors = new ConcurrentHashMap<>();
    private final Map<Class<?>, Object> singletons = new ConcurrentHashMap<>();

    @Override
    public Object getInstance(ComponentDescriptor descriptor) {
        if (descriptor.scope() == ComponentScope.SINGLETON) {
            return singletons.computeIfAbsent(descriptor.componentClass(), this::instantiate);
        }
        return instantiate(descriptor.componentClass());
    }

    private Object instantiate(Class<?> componentClass) {
        MethodHandle constructorHandle = constructors.computeIfAbsent(componentClass, this::resolveConstructor);
        try {
            return constructorHandle.invoke();
        } catch (Throwable throwable) {
            throw new J2HtmlEngineInitializationException("Failed to instantiate component class '"
                    + componentClass.getName() + "'", throwable);
        }
    }

    private MethodHandle resolveConstructor(Class<?> componentClass) {
        try {
            Constructor<?> constructor = componentClass.getDeclaredConstructor();
            if (!constructor.canAccess(null)) {
                constructor.setAccessible(true);
            }
            return MethodHandles.lookup().unreflectConstructor(constructor);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new J2HtmlEngineInitializationException("Component class '" + componentClass.getName()
                    + "' must declare an accessible no-arg constructor", e);
        }
    }
}
