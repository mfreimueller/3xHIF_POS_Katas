# Kata: Design a `Notification` Factory Method API

There is no starter file for this kata — you design and write `Notification.java` from scratch.

## Context

A messaging module needs to create notifications for different channels (email, SMS) without callers ever writing `new EmailNotification(...)` or `new SmsNotification(...)` directly, and without callers being able to construct an invalid notification.

## Task

1. Create a `Notification` interface with a method `String render()` that returns the text that would be sent.
2. Create two package-private (non-`public`) implementing classes, `EmailNotification` and `SmsNotification`, each with a non-`public` constructor so they cannot be created from outside the file.
3. Add these `static` factory methods to `Notification`:
   - `Notification.email(String address, String body)` — throws `IllegalArgumentException` if `address` does not contain `"@"`.
   - `Notification.sms(String phoneNumber, String body)` — throws `IllegalArgumentException` if `body` is longer than 160 characters.
   - `Notification.silent()` — always returns the exact same shared instance (any implementation with an empty body is fine), so `Notification.silent() == Notification.silent()` must be `true`.
4. Write a `main` method that:
   - creates one valid email notification and prints its `render()` output
   - creates one valid SMS notification and prints its `render()` output
   - calls `Notification.email("not-an-email", "hi")`, catches the `IllegalArgumentException`, and prints its message
   - prints the result of `Notification.silent() == Notification.silent()`

## Verification

Run the `main` method in IntelliJ. Expect four lines: the two valid `render()` outputs, the caught validation message, and `true` for the `silent()` identity check.
