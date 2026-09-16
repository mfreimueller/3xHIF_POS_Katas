# Kata: Fix an Immutable Collection Crash

`ShoppingCart.java` compiles cleanly but throws an `UnsupportedOperationException` at runtime. `items` is created with `List.of(...)`, which returns an **immutable** list — calling `.add(...)` on it in `addItem` is not allowed.

## Task

1. Fix `addItem` so it can add new items without mutating the immutable list returned by `List.of(...)` — reassign `items` to a new list that contains the old contents plus the new item, using `List.copyOf(...)` together with a mutable intermediate (or an equivalent approach), rather than switching `items` to `ArrayList` from the start.
2. Keep `items` declared as `List<String>` (not `ArrayList<String>`), and keep it initialized with `List.of("Bread", "Milk")`.
3. Leave `prices` as `Map.of(...)` — it is only ever read, never mutated, so it does not need to change.

## Verification

```
javac ShoppingCart.java && java ShoppingCart
```

Expect it to run without throwing, printing one price line for each of `Bread`, `Milk`, and `Eggs`, in that order.
