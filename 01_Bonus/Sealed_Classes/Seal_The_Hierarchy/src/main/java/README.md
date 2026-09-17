# Kata: Seal the `PaymentMethod` Hierarchy

`PaymentProcessor.java` defines a plain (non-sealed) `PaymentMethod` interface with three record implementors. Because the compiler cannot know whether more implementors exist elsewhere, `fee`'s switch expression needs a defensive `default` branch that throws.

## Task

1. Turn `PaymentMethod` into a `sealed interface` that permits exactly `CreditCard`, `PayPal`, and `BankTransfer`.
2. Remove the `default` branch from `fee` — with a sealed, fully-covered switch, the compiler proves exhaustiveness on its own.
3. As a check, temporarily add a fourth record, `Crypto`, to the `permits` clause without adding a matching `case` to the switch, and observe the compiler error pointing at the now non-exhaustive switch. Then remove `Crypto` again.
4. Note in a one-line comment above the record declarations why none of `CreditCard`, `PayPal`, or `BankTransfer` need an explicit `final`/`sealed`/`non-sealed` modifier to satisfy the sealed hierarchy's rules.

## Verification

```
javac PaymentProcessor.java && java PaymentProcessor
```

The three printed fees must stay exactly the same as before your change.
