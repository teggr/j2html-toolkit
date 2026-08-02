package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AiStreamingShowcaseViewTest {

    @Test
    void rendersStreamingAndTimelineSections() {
        AiStreamingShowcaseView view = new AiStreamingShowcaseView();

        String html = view.render(RenderContext.empty()).render();

        assertTrue(html.contains("AI Streaming + Tool Timeline Showcase"));
        assertTrue(html.contains("ai-chat-workspace-streaming"));
        assertTrue(html.contains("ai-streaming-response"));
        assertTrue(html.contains("ai-tool-timeline"));
    }
}
