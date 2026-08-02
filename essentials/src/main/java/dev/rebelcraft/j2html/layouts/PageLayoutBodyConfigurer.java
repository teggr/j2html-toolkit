package dev.rebelcraft.j2html.layouts;

import java.util.List;

public interface PageLayoutBodyConfigurer {

    default List<String> scripts() {
        return List.of();
    }
}
