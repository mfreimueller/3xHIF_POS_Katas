# Kata: Fix the Constant Interface Anti-Pattern

`SalesReport` and `InvoiceReport` both `implements ReportDefaults` purely to get at `MAX_ROWS` and `DEFAULT_TITLE` without qualifying them. Neither class has an "is-a `ReportDefaults`" relationship — `ReportDefaults` isn't a capability, it's just a bag of constants, and implementing it leaks those constants into both classes' public API (and into every future subclass).

## Task

1. Remove `implements ReportDefaults` from both `SalesReport` and `InvoiceReport`.
2. Turn `ReportDefaults` into a plain, non-instantiable constants holder instead of an interface (keep it nested inside `ReportGenerator`, e.g. `static final class ReportConstants` with a private constructor and `public static final` fields).
3. Update both report classes to reference the constants explicitly (`ReportConstants.MAX_ROWS`, ...), or via a static import — pick one and be consistent.
4. Add a one-line comment above `ReportConstants` explaining what implementing an interface just for its constants used to leak into `SalesReport`'s and `InvoiceReport`'s public API.
5. The program must still compile and print the exact same three lines.

## Verification

Run the `main` method in IntelliJ. Output must stay exactly:

```
Untitled Report: 500 rows
Sales Q3: 120 rows
Invoices September: 42 rows
```
