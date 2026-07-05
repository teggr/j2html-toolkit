package sh.rebelstack.j2html.engine.spring.boot;

import sh.rebelstack.j2html.engine.ComponentScanner;
import sh.rebelstack.j2html.engine.HtmlComponent;
import sh.rebelstack.j2html.engine.HtmlTemplate;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Spring Framework-native component scanner using {@link ClassPathScanningCandidateComponentProvider}.
 * This avoids external classpath scanning libraries and leverages Spring's official APIs.
 */
public class SpringClassPathComponentScanner implements ComponentScanner {

    @Override
    public Set<Class<?>> scan(Collection<String> basePackages) {
        Set<Class<?>> classes = new LinkedHashSet<>();

        if (basePackages == null || basePackages.isEmpty()) {
            return classes;
        }

        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(HtmlComponent.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(HtmlTemplate.class));

        for (String basePackage : basePackages) {
            for (BeanDefinition beanDefinition : scanner.findCandidateComponents(basePackage)) {
                try {
                    classes.add(Class.forName(beanDefinition.getBeanClassName()));
                } catch (ClassNotFoundException e) {
                    // Skip classes that cannot be loaded
                }
            }
        }

        return classes;
    }
}
