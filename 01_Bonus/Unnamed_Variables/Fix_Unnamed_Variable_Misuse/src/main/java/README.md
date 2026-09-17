# Kata: Fix Unnamed Variable Misuse

`BrokenUnnamed.java` does not compile. Both `sumIgnoringY` and `reportShape` declare a component as the unnamed variable `_` and then try to read `_` back later, which the language forbids — `_` marks a value as intentionally discarded, so there is nothing to read.

## Task

1. Fix `sumIgnoringY` so it still sums only the `x` components of the points (the `y` component must stay unused/discarded) — give the component you actually need to read a real name instead of `_`.
2. Fix `reportShape` so the `String` branch still prints the matched string. Since you need to read the value, give that pattern variable a real name; keep the `Point` branch's two unused components as `_`.
3. Do not change what gets computed or printed for a valid `Point`/`String` input, other than fixing the compile errors.

## Verification

```
javac BrokenUnnamed.java && java BrokenUnnamed
```

Expect it to compile cleanly, print the sum of the x-components (`1 + 2 + 3 = 6`), then `Got a point`, then `Got: a label`.
