package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AiShowcaseViewTest {

    @Test
    void rendersAgentSdkLikeUiSections() {
        AiShowcaseView view = new AiShowcaseView();

        String html = view.render(RenderContext.empty()).render();

        assertTrue(html.contains("AI Agent SDK Showcase"));
        assertTrue(html.contains("ai-chat-workspace"));
        assertTrue(html.contains("ai-model-chooser"));
        assertTrue(html.contains("ai-agent-chooser"));
        assertTrue(html.contains("ai-feedback-controls"));
        assertTrue(html.contains("ai-notification-stack"));
    }
}

class AiSessionHealthShowcaseViewTest {

    @Test
    void rendersSessionHealthBoard() {
        AiSessionHealthShowcaseView view = new AiSessionHealthShowcaseView();

        String html = view.render(RenderContext.empty()).render();

        assertTrue(html.contains("AI Session Health Showcase"));
        assertTrue(html.contains("ai-session-health-board"));
        assertTrue(html.contains("ai-session-metrics"));
        assertTrue(html.contains("ai-checkpoint-list"));
    }
}

class BootstrapShowcaseViewTest {

    @Test
    void rendersBootstrapComponentsAndForm() {
        BootstrapShowcaseView view = new BootstrapShowcaseView();

        String html = view.render(RenderContext.empty()).render();

        assertTrue(html.contains("Bootstrap Showcase"));
        assertTrue(html.contains("form-control"));
        assertTrue(html.contains("btn-primary"));
        assertTrue(html.contains("alert-primary"));
    }
}
