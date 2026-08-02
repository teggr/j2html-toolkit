package dev.rebelcraft.j2html.toolkit.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
