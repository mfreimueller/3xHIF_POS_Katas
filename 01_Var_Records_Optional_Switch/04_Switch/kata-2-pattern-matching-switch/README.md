# Kata: Pattern Matching in Switch

`Shapes.java` defines a sealed `Shape` hierarchy (`Circle`, `Rectangle`, `Triangle`, each a record), but `area` and `describe` compute their result with a chain of `instanceof` checks, casts, and `if`/`else if`/`else`.

## Task

1. Rewrite `area` as a switch expression that uses type patterns with record deconstruction, e.g. `case Circle(double radius) -> ...`.
2. Rewrite `describe` as a switch expression that uses simple type patterns (e.g. `case Circle c -> "circle"`), then still calls `area(shape)` to build the final string.
3. Remove the `else`/`default` throwing branches from both methods — because `Shape` is `sealed` and permits only `Circle`, `Rectangle`, and `Triangle`, the compiler can prove the switches are exhaustive without one.
4. As a check, temporarily add a fourth record (e.g. `record Square(double side) implements Shape {}`) to the `permits` clause and observe how the compiler now forces you to handle it in both switches. Remove `Square` again afterwards.

## Verification

```
javac Shapes.java && java Shapes
```

The three printed descriptions must stay exactly the same as before your refactor.
