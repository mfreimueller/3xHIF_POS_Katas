# Kata: Deconstruct Nested Records with `instanceof`

`RecipientPrinter.java` prints shipping recipients. Both branches of `printRecipient` use the classic `instanceof` check followed by a cast, then pull `address()` off the result just to reach `street()` and `city()`.

## Task

1. Replace the `Person` branch with a single pattern-matching `instanceof` that deconstructs straight down to `name`, `street`, and `city` in one pattern, e.g. `recipient instanceof Person(String name, Address(String street, String city))`.
2. Do the same for the `Company` branch, deconstructing into `companyName`, `vatId`, `street`, and `city`.
3. Remove the now-unused local variables (`person`, `company`, `address`) — the pattern variables replace them entirely.
4. Leave the `else` branch and the overall `if`/`else if`/`else` structure as they are.

## Verification

```
javac RecipientPrinter.java && java RecipientPrinter
```

The three printed lines must stay exactly the same as before your refactor.
