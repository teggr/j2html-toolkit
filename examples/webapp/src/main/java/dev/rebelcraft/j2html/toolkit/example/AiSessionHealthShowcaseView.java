package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.toolkit.components.ai.AiChatLayouts;
import dev.rebelcraft.j2html.toolkit.components.ai.AlertBanner;
import dev.rebelcraft.j2html.toolkit.components.ai.Checkpoint;
import dev.rebelcraft.j2html.toolkit.components.ai.SessionHealthModel;
import dev.rebelcraft.j2html.toolkit.components.ai.SignalBadge;
import dev.rebelcraft.j2html.toolkit.integration.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import j2html.tags.DomContent;
import org.springframework.stereotype.Component;

import java.util.List;

import static j2html.TagCreator.div;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.p;

@Component
public class AiSessionHealthShowcaseView implements HtmlComponent {

    @Override
    public DomContent render(RenderContext ctx) {
        SessionHealthModel model = new SessionHealthModel(
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
                h1("AI Session Health Showcase"),
                p("This page demonstrates a compact session-health board for AI agent sessions, with metrics, signals, checkpoints, and alerts."),
                AiChatLayouts.sessionHealthBoard(model)
        );

        return new WebappPageLayout().layout("AI Session Health Showcase", body);
    }
}
