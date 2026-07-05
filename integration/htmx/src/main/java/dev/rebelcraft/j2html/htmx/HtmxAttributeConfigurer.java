package dev.rebelcraft.j2html.htmx;

public interface HtmxAttributeConfigurer<T extends HtmxAttributeConfigurer<T>> {

    T get(String url);

    T post(String url);

    T put(String url);

    T patch(String url);

    T delete(String url);

    T trigger(String... events);

    T indicator(String cssSelector);

    T disabledElt();

    T target(String target);

    T swap(String... names);

    T sync(String cssSelector);

    T sync(String cssSelector, String strategy);

    T swapOob(String value);

    T include(String cssSelector);

    T params(String value);

    T encoding();

    T vals();

    T vars();

    T confirm(String message);

    T boost(String value);

    T pushUrl(String value);

    T historyElt(String cssSelector);

    T history(String value);

    T select(String cssSelector);

    T prompt(String prompt);

}
