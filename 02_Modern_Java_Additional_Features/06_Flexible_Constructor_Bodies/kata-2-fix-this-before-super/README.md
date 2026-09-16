# Kata: Fix a `this` Reference Before `super()`

`BrokenAuditedAccount.java` does not compile. Java 22's flexible constructor bodies allow statements before `super(...)`, but only as long as they don't reference the instance being constructed. `AuditedAccount`'s constructor calls `logCreation(owner)` before `super(initialDeposit)` — an instance method call implicitly reads `this`, which is not allowed yet at that point.

## Task

1. Make the constructor compile by moving the `logCreation(owner)` call to after `super(initialDeposit)`.
2. Keep the validation (`if (initialDeposit < 0) throw ...`) before `super(...)` — that part is fine, since it does not touch `this`.
3. Keep `this.owner = owner;` where it already is, after `super(...)`.
4. Do not turn `logCreation` into a `static` method — the fix is about ordering, not about avoiding instance methods altogether.

## Verification

```
javac BrokenAuditedAccount.java && java BrokenAuditedAccount
```

Expect it to compile cleanly and print the "Creating account for Alice" line followed by "Alice: 100.0".
