# Kata: Refactor Status Codes to an Enum

`Ticket`'s `status` field is a plain `int`, given "named" values only through the `OPEN`/`IN_PROGRESS`/`CLOSED` constants. Nothing stops `status` from holding any other `int` — `advance()` proves it: calling it a third time pushes `status` to `3`, a value none of the constants represent, and `describe()` needs a defensive `default` branch to avoid crashing on it.

## Task

1. Replace the three `int` constants with a `TicketStatus` enum: `OPEN, IN_PROGRESS, CLOSED`.
2. Change `Ticket.status`'s type from `int` to `TicketStatus`, initialized to `TicketStatus.OPEN`.
3. Rewrite `advance()` so it moves to the next status (using `values()`/`ordinal()`, or any other approach), but calling it while already `CLOSED` must leave the status unchanged.
4. Rewrite `describe()` as a `switch` expression over `TicketStatus` that covers all three constants with no `default` branch — the compiler should prove it's exhaustive on its own.
5. As a quick check, temporarily add the line `t.status = 42;` in `main` — with the old `int` field this compiled and produced the exact bug described above. Confirm it now fails to compile, then remove the line again.

## Verification

Run the `main` method in IntelliJ. Output must be:

```
waiting for triage
being worked on
resolved
resolved
```

(the fourth `advance()` call must no longer produce an invalid, unrepresentable status)
