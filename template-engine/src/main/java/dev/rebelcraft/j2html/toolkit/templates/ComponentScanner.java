package dev.rebelcraft.j2html.toolkit.templates;

import java.util.Collection;
import java.util.Set;

public interface ComponentScanner {
    Set<Class<?>> scan(Collection<String> basePackages);
}
