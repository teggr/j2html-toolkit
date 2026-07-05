package dev.rebelcraft.j2html.toolkit.spring.templates;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;

import dev.rebelcraft.j2html.toolkit.templates.ComponentDescriptor;
import dev.rebelcraft.j2html.toolkit.templates.ComponentFactory;
import dev.rebelcraft.j2html.toolkit.templates.ReflectiveComponentFactory;

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
