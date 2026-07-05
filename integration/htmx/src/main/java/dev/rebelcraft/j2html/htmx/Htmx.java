package dev.rebelcraft.j2html.htmx;

import j2html.tags.Tag;

import java.util.function.Consumer;

public class Htmx {

    /**
     * Append HTMX specific attributes and behaviours to the given tag.
     * <p>
     * Can be applied in two ways:
     * <p>
     * Wrap the entire tag
     * <pre><code>
     *     hx2(
     *         button().with(text("Click Me!")),
     *         (hx) -> hx.post("/clicked").trigger(click).target("#parent-div").swap(outerHTML)
     *       )
     * </code></pre>
     * or wrap the parent and continue with the calls
     * <pre><code>
     *     hx2(
     *         button(),
     *         (hx) -> hx.post("/clicked").trigger(click).target("#parent-div").swap(outerHTML)
     *       )
     *       .with(text("Click Me!")
     * </code></pre>
     *
     * @param tag a tag that we want to add some HTMX behaviour to
     * @param hx the {@link HtmxAttributeConfigurer} that will apply the necessary changes to the tag
     * @return the {@link Tag} that has been updated
     */
    public static <T extends Tag<T>> T hx(T tag, Consumer<HtmxAttributeConfigurer<?>> hx) {
        hx.accept(new DefaultHtmxAttributeConfigurer(tag));
        return tag;
    }

}


