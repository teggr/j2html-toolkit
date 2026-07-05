package dev.rebelcraft.j2html.htmx;

import j2html.tags.specialized.ScriptTag;

import static j2html.TagCreator.script;

public class HtmxTagCreator {

    public static ScriptTag cdnMinJSLink() {
        return script().withSrc(HtmxConfig.CDN_MIN_JS_URL)
                .attr("integrity", HtmxConfig.CDN_MIN_JS_INTEGRITY)
                .attr("crossorigin", "anonymous");
    }

    public static ScriptTag demoScript() {
        return script().withSrc(HtmxConfig.DEMO_JS_URL);
    }

}
