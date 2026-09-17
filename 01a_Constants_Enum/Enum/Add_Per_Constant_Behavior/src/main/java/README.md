# Kata: Add Per-Constant Behavior

`ShippingMethod` is currently a bare enum with no data of its own — every piece of per-method knowledge (base fee, per-kg rate, delivery days) lives in two free-standing `switch` methods outside the enum. Adding a fourth shipping method means touching both switches and hoping you didn't miss a `case`.

## Task

1. Give `ShippingMethod` two `private final` fields, `baseFee` and `days`, populated through a constructor:
   - `STANDARD(2.0, 5)`
   - `EXPRESS(5.0, 2)`
   - `OVERNIGHT(12.0, 1)`
2. Replace the free-standing `cost(ShippingMethod, double)` method with an **abstract method** `abstract double cost(double weightKg)` declared on the enum, and give each constant its own per-constant body that adds its weight-based surcharge on top of `baseFee`:
   - `STANDARD`: `+ weightKg * 0.5`
   - `EXPRESS`: `+ weightKg * 0.8`
   - `OVERNIGHT`: `+ weightKg * 1.2`
3. Replace the free-standing `estimatedDays(ShippingMethod)` method with a plain (non-abstract) instance method `estimatedDays()` on the enum that simply returns `days`.
4. Delete both now-unused static methods and update `main` to call `m.cost(3.0)` and `m.estimatedDays()` directly on each constant.
5. Output must stay numerically identical.

## Verification

Run the `main` method in IntelliJ. Output must stay exactly:

```
STANDARD: cost=3.50, days=5
EXPRESS: cost=7.40, days=2
OVERNIGHT: cost=15.60, days=1
```
