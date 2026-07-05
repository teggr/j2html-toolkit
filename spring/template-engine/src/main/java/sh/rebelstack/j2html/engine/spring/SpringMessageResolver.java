package sh.rebelstack.j2html.engine.spring;

import sh.rebelstack.j2html.engine.MessageResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.Objects;

public class SpringMessageResolver implements MessageResolver {
    private final MessageSource messageSource;

    public SpringMessageResolver(ApplicationContext applicationContext) {
        this.messageSource = applicationContext.getBeanProvider(MessageSource.class).getIfAvailable();
    }

    public SpringMessageResolver(MessageSource messageSource) {
        this.messageSource = Objects.requireNonNull(messageSource, "messageSource must not be null");
    }

    @Override
    public String resolve(String key, Locale locale, Object... args) {
        if (messageSource == null) {
            return key;
        }
        return messageSource.getMessage(key, args, key, locale == null ? Locale.getDefault() : locale);
    }
}
