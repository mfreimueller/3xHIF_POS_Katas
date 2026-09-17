# Kata: Eliminate Manual Null Checks with Optional

`UserDirectory.findEmailByUsername` returns `null` when a username is unknown, and `UserDirectoryDemo.java` handles that with three different hand-rolled null checks.

## Task

1. Change `UserDirectory.findEmailByUsername` to return `Optional<String>` instead of a plain `String` (use `Optional.ofNullable` internally).
2. In `UserDirectoryDemo.java`, replace each of the three call sites with the matching idiomatic `Optional` call:
   - the `if (email != null) ... else ...` block that only prints when present → `ifPresent`
   - the `if/else` that picks a fallback value → `orElse` (or `orElseGet`)
   - the `if (x == null) throw ...` guard → `orElseThrow`

## Verification

```
javac UserDirectory.java UserDirectoryDemo.java && java UserDirectoryDemo
```

The three lines of output must stay exactly the same as before your refactor.
