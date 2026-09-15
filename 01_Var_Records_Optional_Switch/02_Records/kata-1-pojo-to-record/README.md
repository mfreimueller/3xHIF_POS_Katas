# Kata: From POJO to Record

`Money.java` is a classic immutable value class: private final fields, a validating constructor, getters, and hand-written `equals`, `hashCode`, and `toString`.

## Task

1. Rewrite `Money` as a `record`.
2. Keep the validation from the constructor by moving it into a compact constructor.
3. Keep the `add` method — records can declare additional methods just like classes.
4. Remove the hand-written `getAmountInCents`, `getCurrency`, `equals`, `hashCode`, and `toString` — let the record generate them for you.
5. Update `MoneyDemo.java`, which currently calls the old getter names (`getAmountInCents()` / `getCurrency()`), to use the record's generated accessor methods (`amountInCents()` / `currency()`) instead.

## Verification

```
javac Money.java MoneyDemo.java && java MoneyDemo
```

The output should show a correct sum, a validation exception for a negative amount, and two equal `Money` values comparing as equal.
