package dev.rebelcraft.j2html.htmx;

import org.junit.jupiter.api.Test;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;

class HtmxAttributesTest {

    @Test
    public void test() {

        String render = html(
                head(
                        HtmxTagCreator.demoScript()
                ),
                body(
                        div(
                                button("Get messages")
                                        .attr(hxGet("/messages")),
                                button("Post to messages")
                                        .attr(hxPost("/messages")),
                                button("Put to messages")
                                        .attr(hxPut("/messages")),
                                button("Patch to messages")
                                        .attr(hxPatch("/messages")),
                                button("Delete to messages")
                                        .attr(hxDelete("/messages"))
                        ),
                        div(
                                button("On Mouse")
                                        .attr(hxPost("/mouse_entered"))
                                        .attr(hxTrigger("mouseenter"))
                        ),
                        div(
                                button("Click me")
                                        .attr(hxGet("/click"))
                                        .attr(hxIndicator("#indicator")),
                                img().withSrc("/spinner.gif")
                                        .withClass(htmx_indicator)
                        ),
                        div(
                                input()
                                        .withType("text")
                                        .withName("q")
                                        .attr(hxGet("/trigger_delay"))
                                        .attr(hxTrigger("keyup delay:500ms changed"))
                                        .attr(hxTarget("#search-results"))
                                        .withPlaceholder("Search..."),
                                div().withId("search-results")
                        ),
                        div(
                                div()
                                        .attr(hxGet("/example"))
                                        .attr(hxParams(all)),
                                div()
                                        .attr(hxGet("/example"))
                                        .attr(hxParams(none)),
                                div()
                                        .attr(hxGet("/example"))
                                        .attr(hxParams(not(paramList("aValue")))),
                                div()
                                        .attr(hxGet("/example"))
                                        .attr(hxParams(paramList("aValue")))
                        ),
                        div(
                                a("New Link")
                                        .attr(hxPost("/new-link"))
                                        .attr(hxTarget(thisElt()))
                                        .attr(hxSwap("outerHTNL")),
                                a("New Link")
                                        .attr(hxPost("/new-link"))
                                        .attr(hxTarget(HtmxAttributes.next("p")))
                                        .attr(hxSwap("outerHTNL"))
                        ),
                        div(
                                input().withId("name")
                                        .attr(hxGet("/validation"))
                                        .attr(hxSwap("outerHTNL", modifier(focus_scroll, "true"))
                                        )
                        ),
                        template(
                                p("Hello World")
                        ).attr("url", "/messages"),
                        template(
                                div("This was one result")
                        ).attr("url", "/trigger_delay")
                )
        ).renderFormatted();

        System.out.println(render);

    }

}