# Kata: Extract a Default Method

`Priced.java` declares the `Priced` interface with a single abstract method, `price()`. Its three nested records — `Book`, `TrainTicket`, and `GymMembership` — each implement the exact same `discountedPrice(double rate)` and `formatPrice()` logic, copy-pasted into every record.

## Task

1. Move `discountedPrice(double rate)` and `formatPrice()` out of the three records and into `Priced` as default methods, so every implementor gets them for free.
2. Delete the now-duplicate implementations from `Book`, `TrainTicket`, and `GymMembership`.
3. Add a `static Priced cheapest(Priced a, Priced b)` static method to `Priced` that returns whichever of the two has the lower `price()`, and use it once in `PricedDemo.java` to print the cheaper of the book and the train ticket.
4. Keep the validation behavior of `discountedPrice` identical (it must still reject a `rate` outside `[0, 1]`).

## Verification

```
javac Priced.java PricedDemo.java && java PricedDemo
```

The three discounted-price lines must print exactly as before, followed by a new line naming the cheaper of the book and the train ticket.
