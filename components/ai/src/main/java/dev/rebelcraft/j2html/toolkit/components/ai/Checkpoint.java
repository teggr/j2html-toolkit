package dev.rebelcraft.j2html.toolkit.components.ai;

public record Checkpoint(String label, String detail, boolean completed) {
    public Checkpoint {
        label = label == null ? "Checkpoint" : label;
        detail = detail == null ? "" : detail;
    }
}
