package dev.rebelcraft.html.preview.j2html;

import java.lang.reflect.Method;

import dev.rebelcraft.html.preview.Preview;
import dev.rebelcraft.html.preview.spi.PreviewGenerator;
import j2html.tags.DomContent;

/**
 * Generator for j2html DomContent-returning preview methods.
 */
public final class J2HtmlPreviewGenerator implements PreviewGenerator {

    @Override
    public String id() {
        return "j2html-dom-content";
    }

    @Override
    public int priority() {
        return 100;
    }

    @Override
    public boolean supports(Class<?> clazz, Method method) {
        return method.getParameterCount() == 0
                && DomContent.class.isAssignableFrom(method.getReturnType());
    }

    @Override
    public String generate(Class<?> clazz, Method method, Preview preview) throws Exception {
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Object result = method.invoke(instance);

        if (result == null) {
            return "";
        }

        return ((DomContent) result).render();
    }
}
