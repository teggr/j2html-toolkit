package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.layouts.PageLayoutBodyConfigurer;
import dev.rebelcraft.j2html.layouts.PageLayoutHeadConfigurer;
import dev.rebelcraft.j2html.toolkit.bootstrap.BootstrapConfig;

import java.util.List;

public class WebappPageLayoutConfigurer implements PageLayoutHeadConfigurer, PageLayoutBodyConfigurer {

    private final String pageTitle;

    public WebappPageLayoutConfigurer(String pageTitle) {
        this.pageTitle = pageTitle;
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
        return List.of(
                BootstrapConfig.CDN_BUNDLE_MIN_JS_URL
        );
    }
}
