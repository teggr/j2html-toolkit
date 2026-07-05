package sh.rebelstack.j2html.engine;

import java.util.Collection;
import java.util.Set;

public interface ComponentScanner {
    Set<Class<?>> scan(Collection<String> basePackages);
}
