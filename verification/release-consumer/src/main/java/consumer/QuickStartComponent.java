package consumer;

import dev.rebelcraft.j2html.toolkit.integration.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.toolkit.templates.HtmlComponent;
import dev.rebelcraft.j2html.toolkit.templates.RenderContext;
import j2html.tags.DomContent;

import static dev.rebelcraft.j2html.toolkit.integration.htmx.HtmxAttributes.hxGet;
import static j2html.TagCreator.button;
import static j2html.TagCreator.div;

public class QuickStartComponent implements HtmlComponent {
    @Override
    public DomContent render(RenderContext context) {
        return div().withClasses(Bootstrap.container)
                .with(button("Load").attr(hxGet("/fragment")));
    }
}
