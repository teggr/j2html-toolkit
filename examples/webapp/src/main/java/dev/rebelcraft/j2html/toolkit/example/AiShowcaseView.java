package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.toolkit.components.ai.AiChatLayouts;
import dev.rebelcraft.j2html.toolkit.components.ai.AgentWorkspaceModel;
import dev.rebelcraft.j2html.toolkit.components.ai.AlertBanner;
import dev.rebelcraft.j2html.toolkit.components.ai.Checkpoint;
import dev.rebelcraft.j2html.toolkit.components.ai.NotificationMessage;
import dev.rebelcraft.j2html.toolkit.components.ai.NotificationTone;
import dev.rebelcraft.j2html.toolkit.components.ai.SelectOption;
import dev.rebelcraft.j2html.toolkit.components.ai.SessionHealthModel;
import dev.rebelcraft.j2html.toolkit.components.ai.SignalBadge;
import dev.rebelcraft.j2html.toolkit.components.ai.TranscriptMessage;
import dev.rebelcraft.j2html.toolkit.integration.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import j2html.tags.DomContent;
import org.springframework.stereotype.Component;

import java.util.List;

import static j2html.TagCreator.a;
import static j2html.TagCreator.div;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.p;

@Component
public class AiShowcaseView implements HtmlComponent {

    @Override
    public DomContent render(RenderContext ctx) {
        AgentWorkspaceModel workspace = new AgentWorkspaceModel(
                "/ai/chat",
                "Ask for code changes, reviews, or docs updates",
                List.of(
                        new SelectOption("gpt-5.3-codex", "GPT-5.3-Codex", true),
                        new SelectOption("gpt-4.1", "GPT-4.1", false)
                ),
                List.of(
                        new SelectOption("code-review", "Code Review Agent", true),
                        new SelectOption("release-notes", "Release Notes Agent", false),
                        new SelectOption("test-writer", "Test Writer Agent", false)
                ),
                List.of(
                        new TranscriptMessage("m-1", "user", "Summarize changes in the spring module."),
                        new TranscriptMessage("m-2", "assistant", "I found 4 modified files and 2 docs updates."),
                        new TranscriptMessage("m-3", "tool", "search(tool): matched spring/template-engine and spring/boot-starter")
                ),
                List.of(
                        new NotificationMessage("n-1", NotificationTone.INFO, "Connected", "Using local project context."),
                        new NotificationMessage("n-2", NotificationTone.SUCCESS, "Ready", "Agent tools are available.")
                ),
                List.of(
                        new SelectOption("incorrect", "Incorrect answer", false),
                        new SelectOption("missing-context", "Missing context", false),
                        new SelectOption("unsafe-change", "Unsafe change", false)
                ),
                "tool: file_search\\nquery: spring/**\\nresults: 6"
        );

        SessionHealthModel sessionHealth = new SessionHealthModel(
                "Session Health Board",
                "The active agent stayed focused and close to budget while reviewing the workspace.",
                "Code review",
                78,
                "214ms",
                "$0.08",
                List.of(
                        new SignalBadge("Focused", "success"),
                        new SignalBadge("Latency stable", "info")
                ),
                List.of(
                        new Checkpoint("Context loaded", "Loaded 6 files from the workspace", true),
                        new Checkpoint("Draft review ready", "Prepared 3 change suggestions", false)
                ),
                List.of(
                        new AlertBanner("warning", "Budget watch", "Only 2 prompts remain before the next handoff.")
                )
        );

        DomContent body = div().withClasses(Bootstrap.container, "py-4").with(
                h1("AI Agent SDK Showcase"),
                p("This page demonstrates reusable AI chat components with model and agent selection, transcript, tool output, feedback controls, notifications, and a session-health board."),
                p().with(a("Open streaming + tool timeline showcase").withHref("/ai/stream")),
                AiChatLayouts.agentWorkspace(workspace),
                div().withClasses("mt-4"),
                AiChatLayouts.sessionHealthBoard(sessionHealth)
        );

        return new WebappPageLayout().layout("AI Agent SDK Showcase", body);
    }
}
