package sh.rebelstack.j2html.engine;

import j2html.tags.DomContent;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class ComponentValidator {

    private ComponentValidator() {
    }

    public static MethodHandle validateAndResolveRenderHandle(Class<?> componentClass, String templateName) {
        Method validMethod = Arrays.stream(componentClass.getMethods())
                .filter(m -> m.getName().equals("render"))
                .filter(m -> Modifier.isPublic(m.getModifiers()))
                .filter(m -> !Modifier.isStatic(m.getModifiers()))
                .filter(m -> !Modifier.isAbstract(m.getModifiers()))
                .filter(m -> m.getParameterCount() == 1 && m.getParameterTypes()[0] == RenderContext.class)
                .filter(m -> DomContent.class.isAssignableFrom(m.getReturnType()))
                .findFirst()
                .orElse(null);

        if (validMethod == null) {
            throw new J2HtmlEngineInitializationException(formatError(componentClass, templateName));
        }

        try {
            return MethodHandles.publicLookup().unreflect(validMethod);
        } catch (IllegalAccessException e) {
            throw new J2HtmlEngineInitializationException(
                    "Component class '" + componentClass.getSimpleName() + "' annotated with @HtmlTemplate(\""
                            + templateName + "\") has inaccessible render method",
                    e);
        }
    }

    private static String formatError(Class<?> componentClass, String templateName) {
        List<String> methods = Arrays.stream(componentClass.getMethods())
                .filter(m -> m.getName().equals("render"))
                .sorted(Comparator.comparing(Method::toString))
                .map(ComponentValidator::signature)
                .toList();

        String found = methods.isEmpty() ? "[none]" : methods.toString();

        return "Component class '" + componentClass.getSimpleName() + "' annotated with @HtmlTemplate(\""
                + templateName + "\") has no valid render method. Expected: public DomContent render(RenderContext ctx)"
                + System.lineSeparator()
                + "Found methods named 'render': " + found;
    }

    private static String signature(Method method) {
        String modifiers = Modifier.toString(method.getModifiers());
        String params = Arrays.stream(method.getParameterTypes()).map(Class::getSimpleName)
                .reduce((a, b) -> a + ", " + b).orElse("");
        return (modifiers.isBlank() ? "" : modifiers + " ") + method.getReturnType().getSimpleName() + " "
                + method.getName() + "(" + params + ")";
    }
}
