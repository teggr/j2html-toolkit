package dev.rebelcraft.j2html.toolkit.ai;

import java.util.List;

public record AgentWorkspaceModel(
        String formAction,
        String composerPlaceholder,
        List<SelectOption> models,
        List<SelectOption> agents,
        List<TranscriptMessage> transcript,
        List<NotificationMessage> notifications,
        List<SelectOption> feedbackReasons,
        String toolOutput
) {
    public AgentWorkspaceModel {
        formAction = (formAction == null || formAction.isBlank()) ? "#" : formAction;
        composerPlaceholder = (composerPlaceholder == null || composerPlaceholder.isBlank())
                ? "Message your agent"
                : composerPlaceholder;
        models = models == null ? List.of() : List.copyOf(models);
        agents = agents == null ? List.of() : List.copyOf(agents);
        transcript = transcript == null ? List.of() : List.copyOf(transcript);
        notifications = notifications == null ? List.of() : List.copyOf(notifications);
        feedbackReasons = feedbackReasons == null ? List.of() : List.copyOf(feedbackReasons);
        toolOutput = toolOutput == null ? "" : toolOutput;
    }
}
