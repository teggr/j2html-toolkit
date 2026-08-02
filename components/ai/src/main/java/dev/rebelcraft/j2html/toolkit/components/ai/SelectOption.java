package dev.rebelcraft.j2html.toolkit.components.ai;

import java.util.Objects;

public record SelectOption(String value, String label, boolean selected) {
    public SelectOption {
        Objects.requireNonNull(value, "value must not be null");
        Objects.requireNonNull(label, "label must not be null");
    }
}
