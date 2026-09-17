# Kata: Extract Magic Numbers

`LoanCalculator.java` works correctly, but `monthlyPayment` and `classify` are full of unexplained numeric and string literals — a reader has to guess what `0.045`, `12`, `360`, `500000`, `1000`, `"JUMBO"`, `"REJECTED"`, and `"STANDARD"` each mean.

## Task

1. Find every magic number and magic string in `monthlyPayment` and `classify`.
2. Replace each one with a named `static final` constant using `UPPER_SNAKE_CASE`.
3. Decide placement per the "Constants: Where to Put Them" rule: a constant used only inside one method belongs as a `private static final` field close to that method (at the top of the class is fine); if you find any constant that is conceptually reused between both methods, pull it up so both methods share the one declaration instead of duplicating it.
4. The program must still compile and produce identical output.

## Verification

Run the `main` method in IntelliJ. Output must stay exactly:

```
Payment: 1912.48
Classification: JUMBO
Classification: REJECTED
Classification: STANDARD
```
