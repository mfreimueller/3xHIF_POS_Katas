# Kata: Validate Before `super()`

Before Java 22, a constructor could not run any code of its own before calling `super(...)`, so `ValidatedList`'s constructor works around that by pushing its validation into a private static helper method, `requireNonEmpty`, and calling it *inside* the `super(...)` argument list.

## Task

1. Move the null/empty check out of `requireNonEmpty` and into the constructor body, as plain statements that run **before** `super(source)`.
2. Delete the now-unused `requireNonEmpty` helper method.
3. Keep the exact same validation rule (reject `null` or empty `source`) and the exact same exception type and message.

## Verification

```
javac ValidatedList.java && java ValidatedList
```

Both printed lines must stay exactly the same as before your refactor.
