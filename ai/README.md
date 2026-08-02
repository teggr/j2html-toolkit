# j2html-toolkit-components-ai

Reusable, style-agnostic j2html components for AI chat and agent-style user interfaces.

## Component groups

- input controls for prompt submission
- output/transcript containers for model and tool responses
- text areas for user prompt and system instructions
- model chooser and agent chooser selectors
- feedback controls (thumbs up/down and reason selection)
- notifications/toasts for status and errors
- streaming response chunks for token-by-token output
- tool-call timeline blocks for SDK-style trace visibility

## Add dependency

```xml
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>j2html-toolkit-components-ai</artifactId>
</dependency>
```

## Example

```java
import dev.rebelcraft.j2html.toolkit.ai.AiChatLayouts;
import dev.rebelcraft.j2html.toolkit.ai.AgentWorkspaceModel;
import dev.rebelcraft.j2html.toolkit.ai.NotificationMessage;
import dev.rebelcraft.j2html.toolkit.ai.NotificationTone;
import dev.rebelcraft.j2html.toolkit.ai.SelectOption;
import dev.rebelcraft.j2html.toolkit.ai.TranscriptMessage;

import java.util.List;

AgentWorkspaceModel model = new AgentWorkspaceModel(
        "/chat/send",
        "Ask the coding agent",
        List.of(new SelectOption("gpt-5.3-codex", "GPT-5.3-Codex", true)),
        List.of(new SelectOption("code-review", "Code Review Agent", true)),
        List.of(new TranscriptMessage("m-1", "assistant", "How can I help with this PR?")),
        List.of(new NotificationMessage("n-1", NotificationTone.INFO, "Connected", "Agent session is ready.")),
        List.of(new SelectOption("hallucination", "Possible hallucination", false)),
        "tool: search\\nresult: 3 files updated"
);

String html = AiChatLayouts.agentWorkspace(model).render();
```

Streaming and tool timeline layout:

```java
import dev.rebelcraft.j2html.toolkit.ai.StreamingToken;
import dev.rebelcraft.j2html.toolkit.ai.ToolCallEvent;

String html = AiChatLayouts.streamingWorkspace(
    model,
    List.of(
        new StreamingToken(0, "Planning", false),
        new StreamingToken(1, " complete.", true)
    ),
    List.of(
        new ToolCallEvent("e-1", "file_search", "start", "Scanning spring module"),
        new ToolCallEvent("e-2", "file_search", "complete", "6 matches")
    )
).render();
```
