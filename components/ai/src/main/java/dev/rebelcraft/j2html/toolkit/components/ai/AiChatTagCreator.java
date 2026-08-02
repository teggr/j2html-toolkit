package dev.rebelcraft.j2html.toolkit.components.ai;

import j2html.tags.ContainerTag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.SelectTag;
import j2html.tags.specialized.TextareaTag;

import java.util.List;

import static j2html.TagCreator.article;
import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
import static j2html.TagCreator.h3;
import static j2html.TagCreator.label;
import static j2html.TagCreator.li;
import static j2html.TagCreator.option;
import static j2html.TagCreator.p;
import static j2html.TagCreator.pre;
import static j2html.TagCreator.select;
import static j2html.TagCreator.span;
import static j2html.TagCreator.textarea;
import static j2html.TagCreator.ul;

public final class AiChatTagCreator {
    private AiChatTagCreator() {
    }

    public static SelectTag modelChooser(String name, List<SelectOption> options) {
        return chooser("Model", "ai-model-chooser", name, options);
    }

    public static SelectTag agentChooser(String name, List<SelectOption> options) {
        return chooser("Agent", "ai-agent-chooser", name, options);
    }

    public static ContainerTag<?> chooserField(String labelText, SelectTag chooser) {
        return div().withClasses("ai-field", "ai-field-chooser", "mb-3").with(
                label(labelText).withClasses("ai-field-label"),
                chooser
        );
    }

    public static TextareaTag inputTextarea(String name, String placeholder, int rows) {
        return textarea().withName(name)
                .withRows(String.valueOf(rows))
                .withPlaceholder(placeholder)
                .withClasses("ai-textarea", "ai-input-textarea", "form-control");
    }

    public static TextareaTag systemPromptTextarea(String name, String placeholder, int rows) {
        return textarea().withName(name)
                .withRows(String.valueOf(rows))
                .withPlaceholder(placeholder)
                .withClasses("ai-textarea", "ai-system-textarea", "form-control");
    }

    public static DivTag transcript(String id, List<TranscriptMessage> messages) {
        DivTag transcript = div().withId(id).withClasses("ai-transcript", "list-group").attr("role", "log").attr("aria-live", "polite");
        for (TranscriptMessage message : messages) {
            transcript.with(message(message));
        }
        return transcript;
    }

    public static ContainerTag<?> message(TranscriptMessage message) {
        String roleClass = "ai-role-" + message.role().toLowerCase();
        return article().withClasses("ai-message", roleClass, "list-group-item")
                .attr("data-message-id", message.id())
                .attr("data-role", message.role())
                .with(
                        span(message.role()).withClasses("ai-message-role"),
                        p(message.content()).withClasses("ai-message-content")
                );
    }

    public static ContainerTag<?> toolOutput(String title, String output) {
        return div().withClasses("ai-tool-output", "card", "p-3").with(
                h3(title).withClasses("ai-tool-output-title"),
                pre(output).withClasses("ai-tool-output-body")
        );
    }

        public static DivTag streamingResponse(String id, List<StreamingToken> tokens) {
        DivTag stream = div().withId(id)
            .withClasses("ai-streaming-response", "card-body")
            .attr("role", "status")
            .attr("aria-live", "polite");

        for (StreamingToken token : tokens) {
            stream.with(span(token.text())
                .withClasses("ai-stream-token", token.terminal() ? "ai-stream-terminal" : "ai-stream-partial")
                .attr("data-sequence", String.valueOf(token.sequence()))
                .attr("data-terminal", String.valueOf(token.terminal())));
        }

        return stream;
        }

        public static ContainerTag<?> toolCallTimeline(List<ToolCallEvent> events) {
        var timeline = ul().withClasses("ai-tool-timeline");
        for (ToolCallEvent event : events) {
            timeline.with(li().withClasses("ai-tool-timeline-event")
                .attr("data-event-id", event.id())
                .attr("data-tool", event.tool())
                .attr("data-phase", event.phase())
                .with(
                    span(event.tool() + " · " + event.phase()).withClasses("ai-tool-timeline-title"),
                    p(event.detail()).withClasses("ai-tool-timeline-detail")
                ));
        }
        return div().withClasses("ai-tool-timeline-panel", "card", "p-3").with(
            h3("Tool call timeline").withClasses("ai-tool-timeline-heading"),
            timeline
        );
        }

    public static DivTag feedbackControls(String responseId, List<SelectOption> reasons) {
        DivTag controls = div().withClasses("ai-feedback-controls", "d-flex", "gap-2", "align-items-center").attr("data-response-id", responseId).with(
                button("Thumbs Up").withType("button").withClasses("ai-feedback", "ai-feedback-positive")
                        .attr("data-feedback", "up"),
                button("Thumbs Down").withType("button").withClasses("ai-feedback", "ai-feedback-negative")
                        .attr("data-feedback", "down")
        );

        if (!reasons.isEmpty()) {
            controls.with(chooserField("Feedback reason", chooser("Reason", "ai-feedback-reason", "feedbackReason", reasons)));
        }

        return controls;
    }

    public static DivTag notificationStack(List<NotificationMessage> notifications) {
        DivTag stack = div().withClasses("ai-notification-stack", "d-flex", "flex-column", "gap-2").attr("role", "status");
        for (NotificationMessage notification : notifications) {
            stack.with(notification(notification));
        }
        return stack;
    }

    public static DivTag notification(NotificationMessage notification) {
        return div().withId(notification.id())
                .withClasses("ai-notification", notification.tone().cssClass(), "alert", "p-3")
                .attr("aria-live", notification.tone().ariaLive())
                .with(
                        span(notification.title()).withClasses("ai-notification-title"),
                        p(notification.detail()).withClasses("ai-notification-detail")
                );
    }

    private static SelectTag chooser(String labelText, String cssClass, String name, List<SelectOption> options) {
        SelectTag chooser = select().withName(name).withClasses("ai-chooser", cssClass, "form-select")
                .attr("aria-label", labelText + " chooser");

        for (SelectOption optionValue : options) {
            var optionTag = option(optionValue.label()).withValue(optionValue.value());
            if (optionValue.selected()) {
                optionTag.attr("selected", "selected");
            }
            chooser.with(optionTag);
        }

        return chooser;
    }
}
