package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxConfig;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HtmxShowcaseViewTest {

    @Test
    void rendersHtmxShowcaseAndDemoHooks() {
        HtmxShowcaseView view = new HtmxShowcaseView();

        String html = view.render(RenderContext.empty()).render();

        assertTrue(html.contains("HTMX Showcase"));
        assertTrue(html.contains("hx-get=\"/htmx/snippet\""));
        assertTrue(html.contains("hx-target=\"#htmx-live-result\""));
        assertTrue(html.contains("htmx-live-result"));
        assertTrue(html.contains("hx-get=\"/htmx/search\""));
        assertTrue(html.contains("keyup delay:500ms changed"));
        assertTrue(html.contains("htmx-search-result"));
        assertTrue(html.contains(HtmxConfig.CDN_MIN_JS_URL));
    }
}
