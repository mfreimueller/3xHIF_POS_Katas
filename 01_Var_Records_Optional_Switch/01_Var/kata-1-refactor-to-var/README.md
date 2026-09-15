# Kata: Refactor to `var`

You are given `InventoryReport.java`, a small program that generates a text report for a warehouse inventory. Every local variable uses an explicit type, even where the type is completely obvious from the right-hand side.

## Task

1. Go through every local variable declaration in `InventoryReport.java` and decide whether it should use `var`.
2. Replace the declaration with `var` wherever the type stays obvious to a reader.
3. For every declaration you leave with an explicit type, add a short comment explaining why `var` would hurt readability or would change the program's behavior there.
4. The program must still compile and produce the exact same output as before your changes.

## Verification

Run the program before and after your changes and confirm the console output is identical:

```
javac InventoryReport.java && java InventoryReport
```
