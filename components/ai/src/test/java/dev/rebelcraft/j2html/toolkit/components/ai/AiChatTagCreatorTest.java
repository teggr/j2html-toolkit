package dev.rebelcraft.j2html.toolkit.components.ai;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AiChatTagCreatorTest {

    @Test
    void rendersModelChooserWithSelectedOption() {
        String html = AiChatTagCreator.modelChooser("model", List.of(
                new SelectOption("gpt-5.3-codex", "GPT-5.3-Codex", true),
                new SelectOption("gpt-4.1", "GPT-4.1", false)
        )).render();

        assertTrue(html.contains("name=\"model\""));
        assertTrue(html.contains("value=\"gpt-5.3-codex\""));
        assertTrue(html.contains("selected=\"selected\""));
    }

    @Test
    void rendersFeedbackControlsWithReasonChooser() {
        String html = AiChatTagCreator.feedbackControls("r-1", List.of(
                new SelectOption("hallucination", "Possible hallucination", false)
        )).render();

        assertTrue(html.contains("data-response-id=\"r-1\""));
        assertTrue(html.contains("Thumbs Up"));
        assertTrue(html.contains("Thumbs Down"));
        assertTrue(html.contains("feedbackReason"));
    }

    @Test
    void rendersNotificationStackWithToneClasses() {
        String html = AiChatTagCreator.notificationStack(List.of(
                new NotificationMessage("n-1", NotificationTone.SUCCESS, "Done", "Agent completed task")
        )).render();

        assertTrue(html.contains("ai-notification-success"));
        assertTrue(html.contains("Agent completed task"));
    }

    @Test
    void rendersStreamingResponseAndTimeline() {
        String streamHtml = AiChatTagCreator.streamingResponse("stream-1", List.of(
                new StreamingToken(0, "Searching", false),
                new StreamingToken(1, " done.", true)
        )).render();

        String timelineHtml = AiChatTagCreator.toolCallTimeline(List.of(
                new ToolCallEvent("e-1", "file_search", "start", "Scanning spring module"),
                new ToolCallEvent("e-2", "file_search", "complete", "6 matches")
        )).render();

        assertTrue(streamHtml.contains("ai-streaming-response"));
        assertTrue(streamHtml.contains("data-terminal=\"true\""));
        assertTrue(timelineHtml.contains("ai-tool-timeline"));
        assertTrue(timelineHtml.contains("file_search"));
        assertTrue(timelineHtml.contains("Scanning spring module"));
    }
}
