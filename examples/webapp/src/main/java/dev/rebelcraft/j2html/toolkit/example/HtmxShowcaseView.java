package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.toolkit.integration.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxConfig;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import j2html.tags.DomContent;
import org.springframework.stereotype.Component;

import java.util.List;

import static dev.rebelcraft.j2html.toolkit.integration.htmx.Htmx.hx;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.click;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.changed;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.delay;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.hxGet;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.hxSwap;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.hxTarget;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.innerHTML;
import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.keyup;
import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.h2;
import static j2html.TagCreator.input;
import static j2html.TagCreator.p;
import static j2html.TagCreator.span;

@Component
public class HtmxShowcaseView implements HtmlComponent {

    @Override
    public DomContent render(RenderContext ctx) {
        DomContent body = div().with(
                div().withClasses(Bootstrap.container, "py-4", "py-lg-5").with(
                        h1("HTMX Showcase").withClasses("display-6", "mb-3"),
                        p("This page demonstrates HTMX helper usage from j2html-toolkit and a live server-fragment swap.")
                                .withClasses("text-muted", "mb-4"),
                        div().withClasses("row", "g-4").with(
                                div().withClasses("col-lg-6").with(
                                        div().withClasses("card", "shadow-sm", "border-0", "h-100").with(
                                                div().withClasses("card-body").with(
                                                        h2("Static HTMX API examples").withClasses("h4", "mb-3"),
                                                        p("Attribute helper style (hxGet/hxTarget/hxSwap):").withClasses("mb-2"),
                                                        button("Load fragment (attribute style)")
                                                                .withClasses("btn", "btn-outline-primary", "mb-3")
                                                                .attr(hxGet("/htmx/snippet"))
                                                                .attr(hxTarget("#htmx-live-result"))
                                                                .attr(hxSwap(innerHTML)),
                                                        p("Fluent helper style (Htmx.hx):").withClasses("mb-2"),
                                                        hx(
                                                                button("Load fragment (fluent style)")
                                                                        .withClasses("btn", "btn-outline-secondary"),
                                                                h -> h.get("/htmx/snippet")
                                                                        .target("#htmx-live-result")
                                                                        .swap(innerHTML)
                                                                        .trigger(click)
                                                        )
                                                )
                                        )
                                ),
                                div().withClasses("col-lg-6").with(
                                        div().withClasses("card", "shadow-sm", "border-0", "h-100").with(
                                                div().withClasses("card-body").with(
                                                        h2("Interactive swap demo").withClasses("h4", "mb-3"),
                                                        p("Click to request a server-rendered HTML fragment and swap it into the target area.")
                                                                .withClasses("mb-3"),
                                                        hx(
                                                                button("Run live HTMX request")
                                                                        .withClasses("btn", "btn-primary"),
                                                                h -> h.get("/htmx/snippet")
                                                                        .target("#htmx-live-result")
                                                                        .swap(innerHTML)
                                                                        .indicator("#htmx-live-indicator")
                                                        ),
                                                        span().withId("htmx-live-indicator")
                                                                .withClasses("spinner-border", "spinner-border-sm", "ms-2", "htmx-indicator")
                                                                .attr("role", "status"),
                                                        div().withId("htmx-live-result")
                                                                .withClasses("alert", "alert-light", "border", "mt-3", "mb-0")
                                                                .withText("Target region: waiting for HTMX response.")
                                                )
                                        )
                                )
                        ),
                        div().withClasses("row", "g-4", "mt-1").with(
                                div().withClasses("col-12").with(
                                        div().withClasses("card", "shadow-sm", "border-0").with(
                                                div().withClasses("card-body").with(
                                                        h2("Second example: live search trigger").withClasses("h4", "mb-3"),
                                                        p("This input uses hx-trigger on keyup with a delay to fetch targeted hints as you type.")
                                                                .withClasses("mb-3"),
                                                        hx(
                                                                input().withType("search")
                                                                        .withName("q")
                                                                        .withPlaceholder("Try: swap, trigger, or target")
                                                                        .withClasses("form-control"),
                                                                h -> h.get("/htmx/search")
                                                                        .trigger(keyup, delay("500ms"), changed)
                                                                        .target("#htmx-search-result")
                                                                        .swap(innerHTML)
                                                        ),
                                                        div().withId("htmx-search-result")
                                                                .withClasses("alert", "alert-light", "border", "mt-3", "mb-0")
                                                                .withText("Type to search HTMX toolkit demo hints.")
                                                )
                                        )
                                )
                        )
                )
        );

        return new WebappPageLayout().layout("HTMX Showcase", body, List.of(HtmxConfig.CDN_MIN_JS_URL));
    }
}
