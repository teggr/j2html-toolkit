---
applyTo: "**/*"
---

# j2html-toolkit project instructions

This repository is a Java toolkit for extending and integrating the j2html library.

## Project purpose
- Fill the gaps between the raw j2html API and framework integrations, especially Spring Boot.
- Bridge integrations across ecosystems such as htmx and Bootstrap.
- Provide reusable component toolkits for common use cases, including AI-related UI components.

## Baseline and dependencies
- Target Java baseline: Java 21.
- Target j2html baseline: 1.6.0.
- Prefer idiomatic, modular Java code that fits the existing multi-module Maven structure.

## Architecture expectations
- Keep functionality aligned with the current module boundaries:
  - essentials: core layout and base utilities
  - integration: framework and ecosystem integrations
  - components: parent module for reusable component families
  - components/ai: reusable AI-oriented components and models (artifact: j2html-toolkit-components-ai)
  - examples/webapp: showcase and demo surface
- When adding new features, prefer reusable builders and composable abstractions over one-off implementations.
- Keep integrations focused on practical gaps that developers would encounter when using j2html with frameworks and UI libraries.
- When introducing a new component family, prefer adding a child module under components/ rather than placing it in the root or an unrelated module.

## Feature and showcase conventions
- New features should be documented as part of the project’s feature story and surfaced in the examples webapp.
- If a new capability is added, include or update an example showcase so it is visible and testable in the webapp.
- Favor small, demonstrable examples over large, opaque implementations.

## Coding preferences
- Prefer clear, readable Java with small focused classes and methods.
- Preserve the existing style of the codebase rather than introducing unrelated abstractions.
- Keep changes compatible with the current Maven module layout and existing public APIs where possible.
- When changing shared abstractions, ensure downstream modules and examples continue to work.

## Validation expectations
- Prefer verifying changes with the relevant Maven test target before considering work complete.
- When changing layout, integration, or example behavior, validate the affected module and, where practical, the examples webapp.
