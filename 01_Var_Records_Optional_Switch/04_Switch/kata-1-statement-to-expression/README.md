# Kata: Switch Statement to Switch Expression

`ShippingCalculator.java` calculates a shipping cost using a traditional `switch` statement: `case`/`break`, fall-through for the two international methods, and an assignment into a mutable local variable declared before the switch.

## Task

1. Rewrite `calculateCost` so the `switch` is an expression whose value is assigned directly to `cost` (`var cost = switch (method) { ... };`), instead of a statement that mutates a variable declared beforehand.
2. Use arrow (`->`) case labels throughout.
3. For the two international methods, keep computing the local `surcharge` value, but do it inside a `yield` block instead of relying on fall-through between two case labels.
4. Once every `ShippingMethod` value is handled, remove the `default` branch — let the compiler prove the switch is exhaustive over the enum. Try commenting out one of the `case` branches afterwards and see what the compiler says.

## Verification

```
javac ShippingCalculator.java && java ShippingCalculator
```

The five printed costs must stay exactly the same as before your refactor.
