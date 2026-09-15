# Kata: Fix Invalid `var` Usage

`BrokenVarUsage.java` does not compile. It contains several uses of `var` that are illegal in Java, plus one line where the fix requires an explicit type instead of `var`.

## Task

1. Get the file to compile without deleting any functionality — every method must still do the job it was clearly meant to do.
2. For each error, choose between two kinds of fixes:
   - keep `var` and give it what it needs (e.g. an initializer), or
   - replace `var` with an explicit type where the language does not allow `var` at all (fields, parameters, return types), or where the compiler cannot infer a type on its own (e.g. from `null`).
3. Leave a one-line comment on each line you changed, stating which rule you had to fix.

## Verification

```
javac BrokenVarUsage.java && java BrokenVarUsage
```

Expect it to compile cleanly and print a small label report to the console.
