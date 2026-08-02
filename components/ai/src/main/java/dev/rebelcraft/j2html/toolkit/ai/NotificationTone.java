package dev.rebelcraft.j2html.toolkit.ai;

public enum NotificationTone {
    INFO,
    SUCCESS,
    WARNING,
    ERROR;

    public String cssClass() {
        return "ai-notification-" + name().toLowerCase();
    }

    public String ariaLive() {
        return this == ERROR ? "assertive" : "polite";
    }
}
