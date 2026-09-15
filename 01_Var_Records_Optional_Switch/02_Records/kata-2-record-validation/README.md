# Kata: Record Validation & Deconstruction

`Reservation.java` is a record with no validation at all — you can currently create a reservation with a blank guest name, a check-out date that is before (or equal to) the check-in date, or a negative room number, and nothing complains.

`ReservationDemo.java` also already calls a `nights()` method that does not exist yet, so the project does not compile until you add it.

## Task

1. Add a compact constructor to `Reservation` that rejects:
   - a blank `guestName`
   - a `checkOut` date that is not strictly after `checkIn`
   - a `roomNumber` less than 1

   Throw an `IllegalArgumentException` with a clear message in each case.
2. Add a `nights()` method to the record that returns the number of nights stayed (the number of days between `checkIn` and `checkOut`).
3. In `ReservationDemo.java`, replace the `instanceof` check followed by a cast and four separate field accesses with a single pattern-matching `instanceof` that deconstructs the record directly into `guestName`, `checkIn`, `checkOut`, and `roomNumber`.

## Verification

```
javac Reservation.java ReservationDemo.java && java ReservationDemo
```

You should see the valid reservation printed together with its `nights()` value, followed by two validation errors instead of a crash or a silently accepted invalid reservation.
