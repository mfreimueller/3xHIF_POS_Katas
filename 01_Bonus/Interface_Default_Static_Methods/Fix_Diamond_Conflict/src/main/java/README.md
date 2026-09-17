# Kata: Fix a Default Method Diamond Conflict

`BrokenNotifier.java` does not compile. `DualChannel` implements both `EmailChannel` and `SmsChannel`, and both interfaces provide a conflicting default `notify(String)` method. Java refuses to guess which one should win.

## Task

1. Make `DualChannel` compile by overriding `notify(String message)` explicitly.
2. In the override, call **both** `EmailChannel.super.notify(message)` and `SmsChannel.super.notify(message)`, so a `DualChannel` notification is sent over both channels.
3. Add a `static SmsChannel smsOnly()` static method to `SmsChannel` that returns a new anonymous `SmsChannel` instance, and use it once in `main` to send an SMS-only notification after the dual-channel one.
4. Do not change the existing default methods on `EmailChannel` or `SmsChannel`.

## Verification

```
javac BrokenNotifier.java && java BrokenNotifier
```

Expect the file to compile cleanly and print an `[Email]` line, an `[SMS]` line (both for the same dual-channel message), followed by one more `[SMS]` line for the SMS-only notification.
