# Kata: Fix Optional Misuse

`ProductCatalog.java` uses `Optional` in four places that all violate the best practices from the lecture.

## Task

Find and fix all four misuses:

1. A field is declared as `Optional<String>`. Change it to a plain, nullable `String` field.
2. A method parameter is declared as `Optional<Double>`. Change it to a plain `Double` and adjust the call site in `ProductCatalogDemo.java` accordingly.
3. A method calls `.get()` on an `Optional` after checking `.isPresent()`. Replace that check-then-get pattern with a single expression using `orElse`, `orElseGet`, or `map`.
4. A method calls `.get()` on an `Optional` with no presence check at all. Replace it with `orElseThrow` (using a meaningful exception) or `orElse`.

Do not change `findPrice`, which correctly returns `Optional<Double>` — that is the one place in this class `Optional` belongs, since it is a return type signaling "may be absent".

## Verification

```
javac ProductCatalog.java ProductCatalogDemo.java && java ProductCatalogDemo
```

The console output must be unchanged after your refactor.
