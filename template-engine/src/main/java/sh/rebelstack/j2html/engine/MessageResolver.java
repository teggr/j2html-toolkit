package sh.rebelstack.j2html.engine;

import java.util.Locale;

public interface MessageResolver {
    String resolve(String key, Locale locale, Object... args);
}
