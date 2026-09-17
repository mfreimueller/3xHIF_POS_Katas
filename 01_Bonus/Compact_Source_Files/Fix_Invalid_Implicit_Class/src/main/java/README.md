# Kata: Fix an Invalid Implicit-Class Reference

`BrokenGreeter.java` does not compile. It has no `class` declaration, so the compiler wraps it in an implicit, unnamed top-level class — but that class has no name you can write in source code. `main` tries to call `BrokenGreeter.printSummary(...)`, qualifying the call with the file's base name as if it were a real class name, which the compiler rejects.

## Task

1. Fix the call in `main` so it invokes `printSummary` the way any other method in the same implicit class is called: unqualified.
2. Do not add a `class BrokenGreeter { ... }` wrapper — the file must stay a compact source file with no class declaration.
3. Do not rename `printSummary` or change its signature.

## Verification

```
javac BrokenGreeter.java && java BrokenGreeter
```

Expect it to compile cleanly and print two greeting lines followed by `Greeted 2 people`.
