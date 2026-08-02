package dev.rebelcraft.j2html.toolkit.ai;

import java.util.List;

public record SessionHealthModel(
        String title,
        String summary,
        String focusArea,
        int contextBudgetRemaining,
        String latency,
        String estimatedCost,
        List<SignalBadge> signals,
        List<Checkpoint> checkpoints,
        List<AlertBanner> alerts
) {
    public SessionHealthModel {
        title = (title == null || title.isBlank()) ? "Session health" : title;
        summary = (summary == null || summary.isBlank()) ? "The active agent session is in good shape." : summary;
        focusArea = (focusArea == null || focusArea.isBlank()) ? "General review" : focusArea;
        latency = latency == null ? "n/a" : latency;
        estimatedCost = estimatedCost == null ? "n/a" : estimatedCost;
        signals = signals == null ? List.of() : List.copyOf(signals);
        checkpoints = checkpoints == null ? List.of() : List.copyOf(checkpoints);
        alerts = alerts == null ? List.of() : List.copyOf(alerts);
    }
}
