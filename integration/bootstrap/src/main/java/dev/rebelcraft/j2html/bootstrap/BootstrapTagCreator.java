package dev.rebelcraft.j2html.bootstrap;

import j2html.attributes.Attr;
import j2html.tags.specialized.LinkTag;
import j2html.tags.specialized.MetaTag;
import j2html.tags.specialized.ScriptTag;

import static dev.rebelcraft.j2html.bootstrap.BootstrapConfig.*;
import static j2html.TagCreator.*;

public class BootstrapTagCreator {

    // head

    public static MetaTag utf8Charset() {

        return meta().attr(Attr.CHARSET, "utf-8");

    }

    public static MetaTag responsiveViewport() {

        return meta().withName("viewport")
                .withContent("width=device-width, initial-scale=1");

    }

    public static LinkTag cdnCSSLink() {

        return link().withHref(CDN_MIN_CSS_URL)
                .withRel("stylesheet")
                .attr("integrity", CDN_MIN_CSS_INTEGRITY)
                .attr("crossorigin", "anonymous");

    }

    public static ScriptTag cdnBundleMinJSLink() {

        return script().withSrc(CDN_BUNDLE_MIN_JS_URL)
                .attr("integrity", CDN_BUNDLE_MIN_JS_INTEGRITY)
                .attr("crossorigin", "anonymous");

    }

}
