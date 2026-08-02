package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.layouts.PageLayoutBodyConfigurer;
import dev.rebelcraft.j2html.layouts.PageLayoutHeadConfigurer;
import dev.rebelcraft.j2html.toolkit.integration.bootstrap.BootstrapConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebappPageLayoutConfigurer implements PageLayoutHeadConfigurer, PageLayoutBodyConfigurer {

    private final String pageTitle;
    private final List<String> extraScripts;

    public WebappPageLayoutConfigurer(String pageTitle) {
        this(pageTitle, List.of());
    }

    public WebappPageLayoutConfigurer(String pageTitle, List<String> extraScripts) {
        this.pageTitle = pageTitle;
        this.extraScripts = extraScripts == null ? List.of() : List.copyOf(extraScripts);
    }

    @Override
    public String title(String title) {
        return pageTitle;
    }

    @Override
    public List<String> stylesheets() {
        return List.of(
                "/css/ai-components.css",
                BootstrapConfig.CDN_MIN_CSS_URL
        );
    }

    @Override
    public List<String> scripts() {
        List<String> scripts = new ArrayList<>();
        scripts.add(BootstrapConfig.CDN_BUNDLE_MIN_JS_URL);
        scripts.addAll(extraScripts);
        return Collections.unmodifiableList(scripts);
    }
}
