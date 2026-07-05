package sh.rebelstack.j2html.engine;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClassGraphComponentScanner implements ComponentScanner {

    @Override
    public Set<Class<?>> scan(Collection<String> basePackages) {
        ClassGraph classGraph = new ClassGraph().enableClassInfo().enableAnnotationInfo();
        if (basePackages != null && !basePackages.isEmpty()) {
            classGraph = classGraph.acceptPackages(basePackages.toArray(String[]::new));
        }

        try (ScanResult scanResult = classGraph.scan()) {
            Set<Class<?>> classes = new LinkedHashSet<>();
            scanResult.getClassesImplementing(HtmlComponent.class).forEach(info -> classes.add(info.loadClass()));
            scanResult.getClassesWithAnnotation(HtmlTemplate.class).forEach(info -> classes.add(info.loadClass()));
            return classes;
        }
    }
}
