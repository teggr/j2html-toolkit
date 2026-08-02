package dev.rebelcraft.j2html.toolkit.example;

import dev.rebelcraft.j2html.layouts.PageLayout;
import dev.rebelcraft.j2html.toolkit.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import j2html.tags.DomContent;
import org.springframework.stereotype.Component;

import static j2html.TagCreator.a;
import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
import static j2html.TagCreator.form;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.h2;
import static j2html.TagCreator.input;
import static j2html.TagCreator.label;
import static j2html.TagCreator.p;
import static j2html.TagCreator.span;

@Component
public class BootstrapShowcaseView implements HtmlComponent {

    @Override
    public DomContent render(RenderContext ctx) {
        DomContent body = div().withClasses(Bootstrap.container, "py-4", "py-lg-5").with(
                h1("Bootstrap Showcase").withClasses("display-6", "mb-3"),
                p("A compact example of Bootstrap-styled components and a simple form.").withClasses("text-muted", "mb-4"),
                div().withClasses("row", "g-4").with(
                        div().withClasses("col-lg-7").with(
                                div().withClasses("card", "shadow-sm", "border-0").with(
                                        div().withClasses("card-body").with(
                                                h2("Registration form").withClasses("h4", "mb-3"),
                                                form().withClasses("row", "g-3").with(
                                                        div().withClasses("col-md-6").with(
                                                                label("First name").withClasses("form-label"),
                                                                input().withType("text").withClasses("form-control")
                                                        ),
                                                        div().withClasses("col-md-6").with(
                                                                label("Email").withClasses("form-label"),
                                                                input().withType("email").withClasses("form-control")
                                                        ),
                                                        div().withClasses("col-12").with(
                                                                label("Message").withClasses("form-label"),
                                                                input().withType("text").withClasses("form-control")
                                                        ),
                                                        div().withClasses("col-12").with(
                                                                button("Submit").withType("submit").withClasses("btn", "btn-primary")
                                                        )
                                                )
                                        )
                                )
                        ),
                        div().withClasses("col-lg-5").with(
                                div().withClasses("alert", "alert-primary", "shadow-sm").with(
                                        h2("Bootstrap styling").withClasses("h5", "alert-heading"),
                                        p("This page uses utility classes for spacing, cards, buttons, and form controls."),
                                        a("Open the AI showcase").withHref("/ai").withClasses("btn", "btn-outline-primary", "mt-2")
                                ),
                                div().withClasses("mt-3", "d-flex", "flex-wrap", "gap-2").with(
                                        span("Primary").withClasses("badge", "bg-primary"),
                                        span("Success").withClasses("badge", "bg-success"),
                                        span("Warning").withClasses("badge", "bg-warning", "text-dark")
                                )
                        )
                )
        );

        return new WebappPageLayout().layout("Bootstrap Showcase", body);
    }
}
