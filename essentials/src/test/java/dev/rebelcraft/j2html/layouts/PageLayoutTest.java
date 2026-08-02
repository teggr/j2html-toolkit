package dev.rebelcraft.j2html.layouts;

import j2html.tags.DomContent;
import org.junit.jupiter.api.Test;

import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PageLayoutTest {

    @Test
    void rendersPageShellWithOptionalHeader() {
        DomContent layout = new PageLayout().layout("Home", div("Body content"));
        String html = layout.render();

        assertTrue(html.contains("<html"));
        assertTrue(html.contains("Home"));
        assertTrue(html.contains("Body content"));
    }
}
