package dev.rebelcraft.j2html.toolkit.components.ai;

import java.util.Objects;

public record StreamingToken(int sequence, String text, boolean terminal) {
    public StreamingToken {
        if (sequence < 0) {
            throw new IllegalArgumentException("sequence must be >= 0");
        }
        Objects.requireNonNull(text, "text must not be null");
    }
}
