package dev.rebelcraft.j2html.bootstrap.components;

import org.junit.jupiter.api.Test;

import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccordionTest {


    @Test
    void shouldAddBsParentAttribute() {

        String formatted = div()
                .attr("bs-parent", "#some-id")
                .renderFormatted();

        assertEquals("""
                <div bs-parent="#some-id">
                </div>
                """, formatted);

    }

}