package dev.rebelcraft.j2html.toolkit.components.ai;

import java.util.Objects;

public record NotificationMessage(String id, NotificationTone tone, String title, String detail) {
    public NotificationMessage {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(tone, "tone must not be null");
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(detail, "detail must not be null");
    }
}
