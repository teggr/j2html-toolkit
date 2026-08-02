package dev.rebelcraft.j2html.toolkit.ai;

import j2html.tags.ContainerTag;

import java.util.List;

import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
import static j2html.TagCreator.form;
import static j2html.TagCreator.h2;
import static j2html.TagCreator.h3;
import static j2html.TagCreator.h4;
import static j2html.TagCreator.p;
import static j2html.TagCreator.span;

public final class AiChatLayouts {
    private AiChatLayouts() {
    }

    public static ContainerTag<?> agentWorkspace(AgentWorkspaceModel model) {
        return div().withClasses("ai-shell", "ai-card", "ai-chat-workspace").with(
                controlsPanel(model),
                transcriptPanel(model),
                composerPanel(model),
                AiChatTagCreator.feedbackControls("latest-response", model.feedbackReasons()),
                AiChatTagCreator.notificationStack(model.notifications())
        );
    }

    public static ContainerTag<?> streamingWorkspace(AgentWorkspaceModel model,
                                                     List<StreamingToken> tokens,
                                                     List<ToolCallEvent> timelineEvents) {
        return div().withClasses("ai-shell", "ai-card", "ai-chat-workspace", "ai-chat-workspace-streaming").with(
                controlsPanel(model),
                transcriptPanel(model),
                div().withClasses("ai-streaming-panel").with(
                        h2("Streaming response").withClasses("ai-panel-title"),
                        AiChatTagCreator.streamingResponse("ai-streaming", tokens),
                        AiChatTagCreator.toolCallTimeline(timelineEvents)
                ),
                composerPanel(model),
                AiChatTagCreator.feedbackControls("latest-response", model.feedbackReasons()),
                AiChatTagCreator.notificationStack(model.notifications())
        );
    }

    public static ContainerTag<?> sessionHealthBoard(SessionHealthModel model) {
        return div().withClasses("ai-shell", "ai-card", "ai-session-health-board").with(
                div().withClasses("ai-session-header").with(
                        h2(model.title()).withClasses("ai-session-title"),
                        p(model.summary()).withClasses("ai-session-summary")
                ),
                div().withClasses("ai-session-metrics").with(
                        metricPill("Focus", model.focusArea()),
                        metricPill("Context", model.contextBudgetRemaining() + "%"),
                        metricPill("Latency", model.latency()),
                        metricPill("Cost", model.estimatedCost())
                ),
                div().withClasses("ai-signal-row").with(
                        model.signals().stream()
                                .map(signal -> span(signal.label()).withClasses("ai-signal", "ai-signal-" + signal.tone()))
                                .toList()
                ),
                div().withClasses("ai-checkpoint-list").with(
                        model.checkpoints().stream()
                                .map(checkpoint -> div().withClasses("ai-checkpoint").with(
                                        span(checkpoint.completed() ? "✓" : "•").withClasses("ai-checkpoint-marker"),
                                        div().withClasses("ai-checkpoint-copy").with(
                                                p(checkpoint.label()).withClasses("ai-checkpoint-label"),
                                                p(checkpoint.detail()).withClasses("ai-checkpoint-detail")
                                        )
                                ))
                                .toList()
                ),
                div().withClasses("ai-alert-stack").with(
                        model.alerts().stream()
                                .map(alert -> div().withClasses("ai-alert", "ai-alert-" + alert.tone()).with(
                                        h4(alert.title()).withClasses("ai-alert-title"),
                                        p(alert.detail()).withClasses("ai-alert-detail")
                                ))
                                .toList()
                )
        );
    }

    private static ContainerTag<?> controlsPanel(AgentWorkspaceModel model) {
        return div().withClasses("ai-controls-panel").with(
                h2("Agent Controls").withClasses("ai-panel-title"),
                AiChatTagCreator.chooserField("Model", AiChatTagCreator.modelChooser("model", model.models())),
                AiChatTagCreator.chooserField("Agent", AiChatTagCreator.agentChooser("agent", model.agents())),
                div().withClasses("ai-field").with(
                        h3("System Prompt").withClasses("ai-field-label"),
                        AiChatTagCreator.systemPromptTextarea("systemPrompt", "System instructions", 4)
                )
        );
    }

    private static ContainerTag<?> transcriptPanel(AgentWorkspaceModel model) {
        return div().withClasses("ai-transcript-panel").with(
                h2("Conversation").withClasses("ai-panel-title"),
                AiChatTagCreator.transcript("ai-transcript", model.transcript()),
                AiChatTagCreator.toolOutput("Tool output", model.toolOutput())
        );
    }

    private static ContainerTag<?> composerPanel(AgentWorkspaceModel model) {
        return form().withClasses("ai-composer-form")
                .withAction(model.formAction())
                .withMethod("post")
                .with(
                        h2("Prompt").withClasses("ai-panel-title"),
                        AiChatTagCreator.inputTextarea("prompt", model.composerPlaceholder(), 5),
                        button("Send to Agent").withType("submit").withClasses("ai-send-button")
                );
    }

    private static ContainerTag<?> metricPill(String label, String value) {
        return div().withClasses("ai-metric-pill").with(
                span(label).withClasses("ai-metric-label"),
                span(value).withClasses("ai-metric-value")
        );
    }
}
