package sh.rebelstack.j2html.engine.spring;

import sh.rebelstack.j2html.engine.ComponentDescriptor;
import sh.rebelstack.j2html.engine.ComponentFactory;
import sh.rebelstack.j2html.engine.ReflectiveComponentFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import java.util.Objects;

public class SpringComponentFactory implements ComponentFactory {
    private final ApplicationContext applicationContext;
    private final ReflectiveComponentFactory fallbackFactory = new ReflectiveComponentFactory();

    public SpringComponentFactory(ApplicationContext applicationContext) {
        this.applicationContext = Objects.requireNonNull(applicationContext, "applicationContext must not be null");
    }

    @Override
    public Object getInstance(ComponentDescriptor descriptor) {
        try {
            return applicationContext.getBean(descriptor.componentClass());
        } catch (NoSuchBeanDefinitionException ex) {
            return fallbackFactory.getInstance(descriptor);
        }
    }
}
