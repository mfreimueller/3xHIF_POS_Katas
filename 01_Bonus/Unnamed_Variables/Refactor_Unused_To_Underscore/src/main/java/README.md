# Kata: Refactor Unused Variables to `_`

`LogAnalyzer.java` has three spots where a variable is declared but never read:

- `countEntries`'s for-each loop never uses `entry`, only the fact that iteration happened.
- `countErrorEntries`'s record pattern deconstructs `LogEntry` into `level`, `message`, and `lineNumber`, but only `level` is ever used.
- `safeParse`'s catch block never uses the caught exception `e`.

## Task

1. Replace `entry` in `countEntries`'s for-each loop with the unnamed variable `_`.
2. In `countErrorEntries`'s record pattern, replace `message` and `lineNumber` with `_` each, keeping `level` named since it is actually used.
3. Replace `e` in `safeParse`'s catch clause with `_`.
4. The program's behavior must not change — only the unused names disappear.

## Verification

```
javac LogAnalyzer.java && java LogAnalyzer
```

All four printed lines must stay exactly the same as before your refactor.
