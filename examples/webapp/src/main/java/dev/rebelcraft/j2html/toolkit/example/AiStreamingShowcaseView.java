package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.layouts.PageLayout;
import dev.rebelcraft.j2html.toolkit.ai.AiChatLayouts;
import dev.rebelcraft.j2html.toolkit.ai.AgentWorkspaceModel;
import dev.rebelcraft.j2html.toolkit.ai.NotificationMessage;
import dev.rebelcraft.j2html.toolkit.ai.NotificationTone;
import dev.rebelcraft.j2html.toolkit.ai.SelectOption;
import dev.rebelcraft.j2html.toolkit.ai.StreamingToken;
import dev.rebelcraft.j2html.toolkit.ai.ToolCallEvent;
import dev.rebelcraft.j2html.toolkit.ai.TranscriptMessage;
import dev.rebelcraft.j2html.toolkit.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import j2html.tags.DomContent;
import org.springframework.stereotype.Component;

import java.util.List;

import static j2html.TagCreator.div;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.p;

@Component
public class AiStreamingShowcaseView implements HtmlComponent {

    @Override
    public DomContent render(RenderContext ctx) {
        AgentWorkspaceModel workspace = new AgentWorkspaceModel(
                "/ai/chat/stream",
                "Ask for a streamed analysis",
                List.of(
                        new SelectOption("gpt-5.3-codex", "GPT-5.3-Codex", true),
                        new SelectOption("gpt-4.1", "GPT-4.1", false)
                ),
                List.of(
                        new SelectOption("execution", "Execution Agent", true),
                        new SelectOption("discovery", "Discovery Agent", false)
                ),
                List.of(
                        new TranscriptMessage("s-1", "user", "Find all view resolver tests and summarize failures."),
                        new TranscriptMessage("s-2", "assistant", "Starting scoped search and compiling a short report.")
                ),
                List.of(
                        new NotificationMessage("sn-1", NotificationTone.INFO, "Streaming", "Tokens are arriving live."),
                        new NotificationMessage("sn-2", NotificationTone.SUCCESS, "Tooling", "Search and grep tools are active.")
                ),
                List.of(
                        new SelectOption("truncated", "Response looked truncated", false),
                        new SelectOption("slow", "Response was too slow", false)
                ),
                "tool: grep_search\\nquery: ViewResolverTest\\nresults: 2"
        );

        List<StreamingToken> tokens = List.of(
                new StreamingToken(0, "I found ", false),
                new StreamingToken(1, "two test classes", false),
                new StreamingToken(2, " and zero failures in the latest run.", true)
        );

        List<ToolCallEvent> timeline = List.of(
                new ToolCallEvent("t-1", "file_search", "start", "Scanning spring/** for resolver tests"),
                new ToolCallEvent("t-2", "file_search", "complete", "Matched 2 files"),
                new ToolCallEvent("t-3", "grep_search", "complete", "No failure markers found")
        );

        DomContent body = div().withClasses(Bootstrap.container, "py-4").with(
                h1("AI Streaming + Tool Timeline Showcase"),
                p("This page demonstrates streamed response chunks and a tool-call timeline alongside the base chat workspace components."),
                AiChatLayouts.streamingWorkspace(workspace, tokens, timeline)
        );

        return new WebappPageLayout().layout("AI Streaming + Tool Timeline Showcase", body);
    }
}
