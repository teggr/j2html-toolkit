package dev.rebelcraft.j2html.toolkit.ai;

public record SignalBadge(String label, String tone) {
    public SignalBadge {
        label = label == null ? "Signal" : label;
        tone = tone == null ? "info" : tone;
    }
}
