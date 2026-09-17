# Kata: Refactor to Modern String and Collection APIs

`TagCleaner.java` reimplements several things the JDK already provides:

- `cleanTags` and `isBlankLine` use `.trim()` plus a manual `length() == 0` check instead of `.strip()` and `.isBlank()`.
- `separatorLine` builds a repeated `"-"` with a hand-rolled loop and a `StringBuilder`.
- `countNonBlankLines` splits the text on `"\n"` and loops over the array instead of using `String.lines()`.
- `main` builds `rawTags` with a mutable `ArrayList` and individual `add` calls, even though the tags never change after that.

## Task

1. Replace the `.trim()` + `length() == 0` checks in `cleanTags` and `isBlankLine` with `.strip()` and `.isBlank()`.
2. Replace `separatorLine`'s loop and `StringBuilder` with a single `"-".repeat(width)` call.
3. Replace `countNonBlankLines`'s `split("\n")` + loop with `text.lines()` combined with a stream `filter`/`count` (keep using `isBlankLine` inside the filter).
4. Replace the `rawTags` construction in `main` with `List.of(...)`, and make `cleanTags`'s return value immutable by wrapping the built result with `List.copyOf(...)` before returning it.

## Verification

```
javac TagCleaner.java && java TagCleaner
```

All three printed lines must stay exactly the same as before your refactor.
