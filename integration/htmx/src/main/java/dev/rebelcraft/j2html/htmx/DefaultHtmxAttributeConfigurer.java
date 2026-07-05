package dev.rebelcraft.j2html.htmx;

import j2html.tags.Tag;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;

public class DefaultHtmxAttributeConfigurer implements HtmxAttributeConfigurer<DefaultHtmxAttributeConfigurer> {

    private final Tag<?> tag;

    public DefaultHtmxAttributeConfigurer(Tag<?> tag) {
        this.tag = tag;
    }

    @Override
    public DefaultHtmxAttributeConfigurer get(String url) {
        tag.attr(hxGet(url));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer post(String url) {
        tag.attr(hxPost(url));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer put(String url) {
        tag.attr(hxPut(url));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer patch(String url) {
        tag.attr(hxPatch(url));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer delete(String url) {
        tag.attr(hxDelete(url));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer trigger(String... events) {
        tag.attr(hxTrigger(events));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer indicator(String cssSelector) {
        tag.attr(hxIndicator(cssSelector));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer disabledElt() {
        tag.attr(hxDisabledElt());
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer target(String target) {
        tag.attr(hxTarget(target));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer swap(String... names) {
        tag.attr(hxSwap(names));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer sync(String cssSelector) {
        tag.attr(hxSync(cssSelector));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer sync(String cssSelector, String strategy) {
        tag.attr(hxSync(cssSelector,strategy));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer swapOob(String value) {
        tag.attr(hxSwapOob(value));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer include(String cssSelector) {
        tag.attr(hxInclude(cssSelector));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer params(String value) {
        tag.attr(hxParams(value));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer encoding() {
        tag.attr(hxEncoding());
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer vals() {
        tag.attr(hxVals());
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer vars() {
        tag.attr(hxVars());
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer confirm(String message) {
        tag.attr(hxConfirm(message));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer boost(String value) {
        tag.attr(hxBoost(value));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer pushUrl(String value) {
        tag.attr(hxPushUrl(value));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer historyElt(String cssSelector) {
        tag.attr(hxHistoryElt(cssSelector));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer history(String value) {
        tag.attr(hxHistory(value));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer select(String cssSelector) {
        tag.attr(hxSelect(cssSelector));
        return this;
    }

    @Override
    public DefaultHtmxAttributeConfigurer prompt(String prompt) {
        tag.attr(hxPrompt(prompt));
        return this;
    }

}
