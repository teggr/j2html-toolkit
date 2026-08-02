package dev.rebelcraft.j2html.toolkit.ai;

import java.util.Objects;

public record ToolCallEvent(String id, String tool, String phase, String detail) {
    public ToolCallEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(tool, "tool must not be null");
        Objects.requireNonNull(phase, "phase must not be null");
        Objects.requireNonNull(detail, "detail must not be null");
    }
}
