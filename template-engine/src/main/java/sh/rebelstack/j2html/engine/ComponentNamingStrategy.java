package sh.rebelstack.j2html.engine;

import java.util.Locale;

@FunctionalInterface
public interface ComponentNamingStrategy {
    String nameFor(Class<?> componentClass);

    static ComponentNamingStrategy defaultStrategy(String basePackage, String suffix) {
        return componentClass -> {
            String packageName = componentClass.getPackageName();
            String relativePackage = packageName;
            if (basePackage != null && !basePackage.isBlank() && packageName.startsWith(basePackage)) {
                relativePackage = packageName.substring(basePackage.length());
                if (relativePackage.startsWith(".")) {
                    relativePackage = relativePackage.substring(1);
                }
            }

            String className = componentClass.getSimpleName();
            if (suffix != null && !suffix.isBlank() && className.endsWith(suffix)) {
                className = className.substring(0, className.length() - suffix.length());
            }

            String normalizedClass = toKebabCase(className);
            if (relativePackage.isBlank()) {
                return normalizedClass;
            }

            return relativePackage.replace('.', '/') + "/" + normalizedClass;
        };
    }

    static ComponentNamingStrategy stripSuffix(String suffix) {
        return componentClass -> {
            String className = componentClass.getSimpleName();
            if (suffix != null && !suffix.isBlank() && className.endsWith(suffix)) {
                className = className.substring(0, className.length() - suffix.length());
            }
            return toKebabCase(className);
        };
    }

    static ComponentNamingStrategy packagePath(String basePackage) {
        return componentClass -> {
            String packageName = componentClass.getPackageName();
            if (basePackage == null || basePackage.isBlank()) {
                return packageName.replace('.', '/');
            }
            if (!packageName.startsWith(basePackage)) {
                return packageName.replace('.', '/');
            }
            String relative = packageName.substring(basePackage.length());
            if (relative.startsWith(".")) {
                relative = relative.substring(1);
            }
            return relative.replace('.', '/');
        };
    }

    private static String toKebabCase(String value) {
        return value
                .replaceAll("([a-z0-9])([A-Z])", "$1-$2")
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1-$2")
                .toLowerCase(Locale.ROOT);
    }
}
