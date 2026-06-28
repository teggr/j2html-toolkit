package dev.rebelcraft.j2html.bootstrap;

import j2html.tags.DomContent;

import java.util.Arrays;

import static dev.rebelcraft.j2html.bootstrap.BootstrapTagCreator.*;
import static j2html.TagCreator.*;
import static j2html.TagCreator.body;

public class TestUtils {

    public static String demo(DomContent... demoContent) {

        return html().withLang("en")
                .with(
                        head(
                                utf8Charset(),
                                responsiveViewport(),
                                title("Bootstrap demo"),
                                cdnCSSLink()
                        ),
                        body(
                                merge(
                                        demoContent,
                                        cdnBundleMinJSLink()
                                )
                        )
                ).renderFormatted();

    }

    public static DomContent[] merge(DomContent[] content, DomContent extra) {
        // Create a new array with one more element than the original array
        DomContent[] newArray = Arrays.copyOf(content, content.length + 1);

        // Add the new string to the last position of the new array
        newArray[content.length] = extra;  // Replace "newString" with the actual string you want to add

        // Return the new array
        return newArray;
    }

}
