package dev.rebelcraft.j2html.toolkit.ai;

public record AlertBanner(String tone, String title, String detail) {
    public AlertBanner {
        tone = tone == null ? "info" : tone;
        title = title == null ? "Alert" : title;
        detail = detail == null ? "" : detail;
    }
}
