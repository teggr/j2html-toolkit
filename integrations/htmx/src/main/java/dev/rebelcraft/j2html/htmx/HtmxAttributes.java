package dev.rebelcraft.j2html.htmx;

import j2html.attributes.Attribute;

public class HtmxAttributes {

    public static final String hx_post = "hx-post";
    public static final String hx_get = "hx-get";
    public static final String hx_target = "hx-target";
    public static final String hx_patch = "hx-patch";
    public static final String hx_put = "hx-put";
    public static final String hx_delete = "hx-delete";
    public static final String htmx_indicator = "htmx-indicator";
    public static final String hx_sync = "hx-sync";
    public static final String hx_swap_oob = "hx-swap-oob";
    public static final String hx_boost = "hx-boost";
    public static final String hx_push_url = "hx-push-url";
    public static final String hx_trigger = "hx-trigger";
    public static final String hx_indicator = "hx-indicator";
    public static final String hx_disabled_elt = "hx-disabled-elt";
    public static final String hx_swap = "hx-swap";
    public static final String hx_include = "hx-include";
    public static final String hx_params = "hx-params";
    public static final String hx_encoding = "hx-encoding";
    public static final String hx_vals = "hx-vals";
    public static final String hx_vars = "hx-vars";
    public static final String hx_confirm = "hx-confirm";
    public static final String hx_history_elt = "hx-history-elt";
    public static final String hx_history = "hx-history";
    public static final String hx_select = "hx-select";
    public static final String hx_prompt = "hx-prompt";

    public static final String every = "every";
    public static final String once = "once";
    public static final String changed = "changed";
    public static final String delay = "delay";
    public static final String throttle = "throttle";
    public static final String from = "from";
    public static final String document = "document";
    public static final String window = "window";
    public static final String target = "target";
    public static final String consume = "consume";
    public static final String queue = "queue";
    public static final String load = "load";
    public static final String revealed = "revealed";
    public static final String intersect = "intersect";
    public static final String click = "click";
    public static final String mouseenter = "mouseenter";
    public static final String keyup = "keyup";
    public static final String change = "change";

    public static final String thisELt = "this";
    public static final String closest = "closest";
    public static final String find = "find";
    public static final String next = "next";
    public static final String previous = "previous";

    public static final String innerHTML = "innerHTML";
    public static final String outerHTML = "outerHTML";
    public static final String textContent = "textContent";
    public static final String beforebegin = "beforebegin";
    public static final String afterbegin = "afterbegin";
    public static final String beforeend = "beforeend";
    public static final String afterend = "afterend";
    public static final String delete = "delete";
    public static final String none = "none";

    public static final String transition = "transition";
    public static final String swap = "swap";
    public static final String settle = "settle";
    public static final String ignoreTitle = "ignoreTitle";
    public static final String scroll = "scroll";
    public static final String show = "show";
    public static final String focus_scroll = "focus-scroll";

    public static final String drop = "drop";
    public static final String abort = "abort";
    public static final String replace = "replace";

    public static final String qfirst = "first";
    public static final String qlast = "last";
    public static final String qall = "all";

    public static final String this_ = "this";

    public static final String all = "*";
    // public static final String none = "none";
    public static final String not = "not";

    public static final String unset = "unset";

    public static Attribute hxGet(String url) {
        return new Attribute(hx_get, url);
    }

    public static Attribute hxPost(String url) {
        return new Attribute(hx_post, url);
    }

    public static Attribute hxPut(String url) {
        return new Attribute(hx_put, url);
    }

    public static Attribute hxPatch(String url) {
        return new Attribute(hx_patch, url);
    }

    public static Attribute hxDelete(String url) {
        return new Attribute(hx_delete, url);
    }

    public static Attribute hxTrigger(String... events) {
        return new Attribute(hx_trigger, String.join(" ", events));
    }

    public static String delay(String amount) {
        return "%s:%s".formatted(delay, amount);
    }

    public static String every(String timing) {
        return "%s %s".formatted(every, timing);
    }

    public static String every(String timing, String filter) {
        return "%s %s[%s]".formatted(every, timing, filter);
    }

    public static String load(String delay) {
        return "%s %s".formatted(load, delay);
    }

    public static String filteredEvent(String event, String filter) {
        return "%s[%s]".formatted(event, filter);
    }

    public static Attribute hxIndicator(String cssSelector) {
        return new Attribute(hx_indicator, cssSelector);
    }

    public static Attribute hxDisabledElt() {
        return new Attribute(hx_disabled_elt, "");
    }

    public static String cssSelector(String cssSelector) {
        return cssSelector;
    }

    public static String thisElt() {
        return thisELt;
    }

    public static String closest(String cssSelector) {
        return "%s %s".formatted(closest, cssSelector);
    }

    public static String find(String cssSelector) {
        return "%s %s".formatted(find, cssSelector);
    }

    public static String next() {
        return next;
    }

    public static String next(String cssSelector) {
        return "%s %s".formatted(next, cssSelector);
    }

    public static String previous() {
        return previous;
    }

    public static String previous(String cssSelector) {
        return "%s %s".formatted(previous, cssSelector);
    }

    public static Attribute hxTarget(String cssSelector) {
        return new Attribute(hx_target, cssSelector);
    }

    public static Attribute hxSwap(String... names) {
        return new Attribute(hx_swap, String.join(" ", names));
    }

    public static String modifier(String name, String value) {
        return "%s:%s".formatted(name, value);
    }

    public static String ignoreTitle(String value) {
        return "%s:%s".formatted(ignoreTitle, value);
    }

    public static Attribute hxSync(String cssSelector) {
        return new Attribute(hx_sync, cssSelector);
    }

    public static Attribute hxSync(String cssSelector, String strategy) {
        return new Attribute(hx_sync, "%s:%s".formatted(cssSelector, strategy));
    }

    public static Attribute hxSwapOob(String value) {
        return new Attribute(hx_swap_oob, value);
    }

    public static Attribute hxInclude(String cssSelector) {
        return new Attribute(hx_include, cssSelector);
    }

    public static Attribute hxParams(String value) {
        return new Attribute(hx_params, value);
    }

    public static String not(String paramList) {
        return "not %s".formatted(paramList);
    }

    public static String paramList(String... params) {
        return String.join(",", params);
    }

    public static Attribute hxEncoding() {
        return new Attribute(hx_encoding, "");
    }

    public static Attribute hxVals() {
        return new Attribute(hx_vals, "");
    }

    public static Attribute hxVars() {
        return new Attribute(hx_vars, "");
    }

    public static Attribute hxConfirm(String message) {
        return new Attribute(hx_confirm, message);
    }

    public static Attribute hxBoost(String value) {
        return new Attribute(hx_boost, value);
    }

    public static Attribute hxPushUrl(String value) {
        return new Attribute(hx_push_url, value);
    }

    public static Attribute hxHistoryElt(String cssSelector) {
        return new Attribute(hx_history_elt, cssSelector);
    }

    public static Attribute hxHistory(String value) {
        return new Attribute(hx_history, value);
    }

    public static Attribute hxSelect(String cssSelector) {
        return new Attribute(hx_select, cssSelector);
    }

    public static Attribute hxPrompt(String prompt) {
        return new Attribute(hx_prompt, prompt);
    }

}
