package sh.rebelstack.j2html.engine;

import java.util.Locale;

public final class NoOpMessageResolver implements MessageResolver {
    @Override
    public String resolve(String key, Locale locale, Object... args) {
        return key;
    }
}
