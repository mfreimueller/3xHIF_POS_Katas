# Kata: Fix a Non-Exhaustive Sealed Switch

`BrokenNotifications.java` does not compile, for two separate reasons:

1. `PushNotification` is named in `Notification`'s `permits` clause, but a sealed interface's direct subtypes must each be declared `final`, `sealed`, or `non-sealed` — `PushNotification` has none of the three.
2. `render`'s switch expression only covers `EmailNotification` and `SmsNotification`. Since `Notification` is sealed, the compiler can see that `PushNotification` is a possible third case and refuses to compile a switch that does not handle it.

## Task

1. Give `PushNotification` the modifier that best fits it: it has no further subtypes of its own, so pick the modifier that closes off further extension.
2. Add a `case PushNotification push -> ...` branch to `render` that produces a string in the same style as the other two branches (e.g. `"Push to " + push.deviceToken() + ": " + push.text()`).
3. To keep that branch consistent with the other two records, convert `PushNotification` from a plain class into a `record` — but keep the accessor calls you just wrote pointing at record components (`deviceToken()`, `text()`), not fields.
4. Do not add a `default` branch — the whole point of a sealed hierarchy is that the compiler proves exhaustiveness without one.

## Verification

```
javac BrokenNotifications.java && java BrokenNotifications
```

Expect it to compile cleanly and print one rendered line per notification, in the order they appear in the array.
