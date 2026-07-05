package dev.rebelcraft.j2html.toolkit.templates;

import java.util.Locale;

public interface MessageResolver {
    String resolve(String key, Locale locale, Object... args);
}
