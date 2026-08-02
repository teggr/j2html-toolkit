package dev.rebelcraft.j2html.toolkit.components.ai;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AiChatLayoutsTest {

    @Test
    void rendersAgentWorkspaceWithAllCoreSections() {
        AgentWorkspaceModel model = new AgentWorkspaceModel(
                "/chat/send",
                "Ask the coding agent",
                List.of(new SelectOption("gpt-5.3-codex", "GPT-5.3-Codex", true)),
                List.of(new SelectOption("code-review", "Code Review", true)),
                List.of(new TranscriptMessage("m-1", "assistant", "I found three refactors.")),
                List.of(new NotificationMessage("n-1", NotificationTone.INFO, "Connected", "Session ready")),
                List.of(new SelectOption("incorrect", "Incorrect answer", false)),
                "tool: search\\nresult: 3 files"
        );

        String html = AiChatLayouts.agentWorkspace(model).render();

        assertTrue(html.contains("ai-chat-workspace"));
        assertTrue(html.contains("ai-model-chooser"));
        assertTrue(html.contains("ai-agent-chooser"));
        assertTrue(html.contains("ai-transcript"));
        assertTrue(html.contains("ai-tool-output"));
        assertTrue(html.contains("ai-feedback-controls"));
        assertTrue(html.contains("ai-notification-stack"));
    }

    @Test
    void rendersStreamingWorkspaceWithTimeline() {
        AgentWorkspaceModel model = new AgentWorkspaceModel(
                "/chat/send",
                "Ask the coding agent",
                List.of(new SelectOption("gpt-5.3-codex", "GPT-5.3-Codex", true)),
                List.of(new SelectOption("code-review", "Code Review", true)),
                List.of(new TranscriptMessage("m-1", "assistant", "I found three refactors.")),
                List.of(new NotificationMessage("n-1", NotificationTone.INFO, "Connected", "Session ready")),
                List.of(new SelectOption("incorrect", "Incorrect answer", false)),
                "tool: search\nresult: 3 files"
        );

        String html = AiChatLayouts.streamingWorkspace(
                model,
                List.of(new StreamingToken(0, "Planning patch", false), new StreamingToken(1, " complete.", true)),
                List.of(new ToolCallEvent("e-1", "grep_search", "complete", "Found 3 hits"))
        ).render();

        assertTrue(html.contains("ai-chat-workspace-streaming"));
        assertTrue(html.contains("ai-streaming-response"));
        assertTrue(html.contains("ai-tool-timeline"));
    }

    @Test
    void rendersSessionHealthBoardWithMetricsAndAlerts() {
        SessionHealthModel model = new SessionHealthModel(
                "Session Health Board",
                "The agent is staying focused and close to budget.",
                "Code review",
                78,
                "214ms",
                "$0.08",
                List.of(new SignalBadge("Focused", "success"), new SignalBadge("Latency stable", "info")),
                List.of(new Checkpoint("Context loaded", "Loaded 6 files from the workspace", true),
                        new Checkpoint("Review complete", "Drafted 3 change suggestions", false)),
                List.of(new AlertBanner("warning", "Budget watch", "Only 2 prompts remain before the next handoff."))
        );

        String html = AiChatLayouts.sessionHealthBoard(model).render();

        assertTrue(html.contains("ai-session-health-board"));
        assertTrue(html.contains("ai-session-metrics"));
        assertTrue(html.contains("ai-checkpoint-list"));
        assertTrue(html.contains("ai-alert-stack"));
    }
}
