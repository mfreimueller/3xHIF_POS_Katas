# Kata: Fix a Broken Singleton

`GameSession` is trying to be a Singleton, but it fails at it in two separate ways:

1. Its constructor is `public` — anything can call `new GameSession()` directly, bypassing `getInstance()` entirely.
2. `getInstance()` doesn't actually reuse anything — it always returns `new GameSession()`, so every call hands out a brand-new, empty session. The `instance` field exists but is never read or written. Points added through one call are lost the moment you call `getInstance()` again.

## Task

1. Make the constructor `private`.
2. Fix `getInstance()` so that the *first* call creates a `GameSession` and stores it in `instance`, and every later call returns that same cached object instead of creating a new one.
3. Add a one-line comment above `instance` stating what would happen if you forgot to store the created object back into the field.

## Verification

Run the `main` method in IntelliJ. Output must change from the buggy

```
0
false
```

to

```
15
true
```

(the score now accumulates across calls, and every call to `getInstance()` returns the identical object)
