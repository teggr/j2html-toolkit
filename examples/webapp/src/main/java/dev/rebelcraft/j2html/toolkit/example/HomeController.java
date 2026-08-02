package dev.rebelcraft.j2html.toolkit.example;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "home-view";
    }

    @GetMapping("/ai")
    public String aiShowcase() {
        return "ai-showcase-view";
    }

    @GetMapping("/ai/stream")
    public String aiStreamingShowcase() {
        return "ai-streaming-showcase-view";
    }

    @GetMapping("/ai/health")
    public String aiSessionHealthShowcase() {
        return "ai-session-health-showcase-view";
    }

    @GetMapping("/bootstrap")
    public String bootstrapShowcase() {
        return "bootstrap-showcase-view";
    }

    @GetMapping("/htmx")
    public String htmxShowcase() {
        return "htmx-showcase-view";
    }

    @ResponseBody
    @GetMapping(value = "/htmx/snippet", produces = MediaType.TEXT_HTML_VALUE)
    public String htmxSnippet() {
        return "<div class=\"alert alert-success mb-0\"><strong>HTMX update:</strong> Server-rendered fragment loaded successfully.</div>";
    }

    @ResponseBody
    @GetMapping(value = "/htmx/search", produces = MediaType.TEXT_HTML_VALUE)
    public String htmxSearch(@RequestParam(value = "q", defaultValue = "") String q) {
        String query = q.trim();
        if (query.isEmpty()) {
            return "<div class=\"text-muted\">Type to search HTMX toolkit demo hints.</div>";
        }

        String normalized = query.toLowerCase(Locale.ROOT);
        String suggestion;
        if (normalized.contains("swap")) {
            suggestion = "Use hx-swap with innerHTML or outerHTML for precise replacement behavior.";
        } else if (normalized.contains("trigger")) {
            suggestion = "Try hx-trigger with keyup delay:500ms changed for responsive search-like interactions.";
        } else if (normalized.contains("target")) {
            suggestion = "Use hx-target to direct fragment updates into a specific container.";
        } else {
            suggestion = "Try searching for: swap, trigger, target.";
        }

        return "<div class=\"alert alert-info mb-0\"><strong>Query:</strong> "
                + escapeHtml(query)
                + "<br/><strong>Suggestion:</strong> "
                + escapeHtml(suggestion)
                + "</div>";
    }

    private String escapeHtml(String value) {
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

}
