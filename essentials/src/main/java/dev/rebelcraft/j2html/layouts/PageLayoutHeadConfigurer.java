package dev.rebelcraft.j2html.layouts;

import java.util.List;

public interface PageLayoutHeadConfigurer {

    default String title(String title) {
        return title;
    }

    default List<String> stylesheets() {
        return List.of();
    }
}
