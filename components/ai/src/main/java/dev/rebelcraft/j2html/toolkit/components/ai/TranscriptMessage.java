package dev.rebelcraft.j2html.toolkit.components.ai;

import java.util.Objects;

public record TranscriptMessage(String id, String role, String content) {
    public TranscriptMessage {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(role, "role must not be null");
        Objects.requireNonNull(content, "content must not be null");
    }
}
