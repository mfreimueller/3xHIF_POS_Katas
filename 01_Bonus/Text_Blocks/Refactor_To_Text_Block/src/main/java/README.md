# Kata: Refactor to a Text Block

`buildReceipt` in `ReceiptFormatter.java` assembles a multi-line receipt by concatenating string literals, `"\n"` escapes, and a `String.format` call across five separate `+` operations.

## Task

1. Rewrite the literal parts of `buildReceipt` as a single text block (`"""..."""`).
2. Use `%s` and `%.2f` placeholders inside the text block together with `.formatted(customer, itemLines, total)` instead of concatenating the parameters in with `+`.
3. Keep `itemLines` as a parameter that gets substituted into the middle of the block — do not inline it as a literal.
4. The method must still return exactly the same string as before, including every newline.

## Verification

```
javac ReceiptFormatter.java && java ReceiptFormatter
```

The printed receipt must look pixel-for-pixel identical to the output before your refactor (same lines, same line breaks, same trailing newline).
