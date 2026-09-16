# Kata: Fix Pattern Variable Scope Errors

`BrokenScope.java` does not compile. Both `describe` and `printIfDiscount` use a pattern-matching `instanceof`, but reference the pattern variable `discount` in a place where the compiler cannot prove it was definitely assigned.

## Task

1. Fix `describe` so `discount` is only used where it is guaranteed to be a `Discount` — without changing what gets printed for a real `Discount` and without throwing for a non-`Discount` voucher (returning `"n/a"` in that case is fine).
2. Fix `printIfDiscount` so it compiles, keeping the "not a discount" early message for non-`Discount` vouchers and only reaching the `discount.code()` print for an actual `Discount`.
3. Do not restructure the two methods more than necessary — the fix is about control flow (`return`, `else`, or rearranging the condition), not about introducing new pattern-matching syntax.

## Verification

```
javac BrokenScope.java && java BrokenScope
```

Expect it to compile cleanly and print a line for each voucher followed by the discount code line.
