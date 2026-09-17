# Kata: Design a `FeatureFlags` Enum Singleton

There is no starter file for this kata — you design and write `FeatureFlags.java` from scratch.

## Context

Your application needs one shared place to look up whether a named feature is enabled, e.g. `FeatureFlags.INSTANCE.isEnabled("dark-mode")`. It must be impossible to end up with two different `FeatureFlags` instances, even if two threads reach for it for the first time at once.

## Task

1. Create `FeatureFlags.java` as an **enum singleton** — a single enum constant (e.g. `INSTANCE`), following the enum singleton pattern from the lecture.
2. Give it a private field holding the flag state (e.g. a `Map<String, Boolean>`) — the map itself must not be exposed directly to callers.
3. Implement these methods:
   - `void enable(String key)` — marks a flag as enabled
   - `void disable(String key)` — marks a flag as disabled
   - `boolean isEnabled(String key)` — returns `false` for any key that was never explicitly enabled
4. Write a `main` method that:
   - checks an unknown flag `"dark-mode"` is `false` by default and prints the result
   - enables `"dark-mode"`, checks it is now `true`, and prints the result
   - disables `"dark-mode"` again, checks it is `false` again, and prints the result
5. Add a one-line comment above the enum declaration explaining why `enum` guarantees this class can never end up with a second instance, even under concurrent access — without you writing a single `synchronized` keyword yourself.

## Verification

Run the `main` method in IntelliJ. Expect three lines of output, each stating the flag's name and its correct boolean state given the calls that preceded it (e.g. `dark-mode: false`, `dark-mode: true`, `dark-mode: false`).
