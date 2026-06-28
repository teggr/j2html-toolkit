package dev.rebelcraft.html.preview;

import java.util.HashMap;
import java.util.Map;

import j2html.TagCreator;
import j2html.tags.DomContent;

/**
 * Example class demonstrating the @Preview annotation.
 * Each @Preview method can be executed from VS Code to see the HTML output.
 */
public class HelloWorldExample {

    @Preview("Hello World")
    public String hello() {
        return "<h1>Hello, World today!</h1>";
    }

    @Preview("Welcome Message")
    public String welcome() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Welcome</title>
                    <style>
                        body { font-family: Arial, sans-serif; padding: 20px; }
                        h1 { color: #007acc; }
                    </style>
                </head>
                <body>
                    <h1>Welcome to Java HTML Tooling!</h1>
                    <p>This is a preview of your HTML content.</p>
                </body>
                </html>
                """;
    }

    @Preview("Simple Card")
    public String card() {
        return """
                <div style="border: 1px solid #ddd; border-radius: 8px; padding: 20px; max-width: 300px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);">
                    <h2 style="margin-top: 0; color: #333;">Card Title</h2>
                    <p style="color: #666;">This is a simple card component with some example content.</p>
                    <button style="background: #007acc; color: white; border: none; padding: 10px 20px; border-radius: 4px; cursor: pointer;">
                        Click Me
                    </button>
                </div>
                """;
    }

    @Preview("A dom content")
    public DomContent h1WithParagraph() {

        Map<String, String> values = new HashMap<>();

        return render(values);
    }

    public static DomContent render(Map<String, String> values) {
        return TagCreator.div(
            TagCreator.h1("Today, Tomorrow"),
            TagCreator.p("This is the next genration"),
            TagCreator.input().withValue("does this work")
        );
    }

    @Preview("Styled Fragment")
    public String styledFragment() {
        return """
                <div class="card">
                    <h2>Styled Card Component</h2>
                    <p>This card uses CSS classes from styles.css instead of inline styles.</p>
                    <button>Styled Button</button>
                </div>
                """;
    }

    @Preview("Full Document with CSS")
    public String fullDocumentWithCss() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Full Document Test</title>
                </head>
                <body>
                    <h1>Full Document Example</h1>
                    <p>This is a full HTML document. The CSS should be injected into the head.</p>
                    <div class="card">
                        <h2>Card in Full Document</h2>
                        <p>CSS classes work here too!</p>
                    </div>
                </body>
                </html>
                """;
    }

    @Preview("Bootstrap Example")
    public String bootstrapExample() {
        return """
                <div class="container mt-4">
                    <div class="row">
                        <div class="col-md-8 offset-md-2">
                            <div class="card shadow">
                                <div class="card-header bg-primary text-white">
                                    <h3 class="mb-0">Bootstrap Card</h3>
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">Using External CDN CSS</h5>
                                    <p class="card-text">
                                        This example demonstrates using Bootstrap CSS from a CDN.
                                        Configure it in VS Code settings:
                                    </p>
                                    <pre class="bg-light p-3 rounded"><code>"java-html-tooling.cssFiles": [
  "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css",
  "src/main/resources/static/styles.css"
]</code></pre>
                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                        <button class="btn btn-primary" type="button">Primary Button</button>
                                        <button class="btn btn-secondary" type="button">Secondary Button</button>
                                    </div>
                                </div>
                                <div class="card-footer text-muted">
                                    Mix local and external CSS sources!
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                """;
    }
}