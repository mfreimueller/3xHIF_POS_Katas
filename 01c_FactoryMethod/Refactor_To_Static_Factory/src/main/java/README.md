# Kata: Refactor to a Static Factory

`main` calls `new Espresso(-1)` directly — nothing validates the constructor argument, so a beverage with a negative shot count (and therefore a negative price) is created without complaint. Callers also have to know the concrete classes `Espresso`/`Latte` exist at all, even though they only ever use them as a `Beverage`.

## Task

1. Add two `static` factory methods to the `Beverage` interface: `espresso(int shots)` and `latte(int shots, boolean oatMilk)`.
2. Each factory method must validate `shots >= 1` and throw `new IllegalArgumentException("shots must be >= 1")` otherwise, *before* constructing the concrete class.
3. Change `Espresso` and `Latte`'s constructors from `public` to package-private (just remove the `public` modifier) so they can no longer be called from outside `CoffeeShop`.
4. Update `main` to build both beverages through `Beverage.espresso(...)` / `Beverage.latte(...)` instead of `new`, using a valid, positive shot count for the first call.
5. Add a `try`/`catch` block in `main` that calls `Beverage.espresso(-1)`, catches the `IllegalArgumentException`, and prints its message — proving invalid input is now rejected instead of silently accepted.

## Verification

Run the `main` method in IntelliJ. Expect two valid prices followed by the caught exception's message, e.g. (with `Beverage.espresso(1)`):

```
1.80
6.20
shots must be >= 1
```

(the first line's exact value depends on the positive shot count you chose; the second line, from the unchanged `Latte(2, true)` call, must stay `6.20`)
