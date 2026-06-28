package sh.rebelstack.j2html.engine;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;

public final class ResourceBundleMessageResolver implements MessageResolver {
    private final String basename;

    public ResourceBundleMessageResolver(String basename) {
        this.basename = Objects.requireNonNull(basename, "basename must not be null");
    }

    @Override
    public String resolve(String key, Locale locale, Object... args) {
        Locale useLocale = locale == null ? Locale.getDefault() : locale;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle(basename, useLocale);
            String pattern = bundle.getString(key);
            return MessageFormat.format(pattern, args);
        } catch (MissingResourceException ex) {
            return key;
        }
    }
}
