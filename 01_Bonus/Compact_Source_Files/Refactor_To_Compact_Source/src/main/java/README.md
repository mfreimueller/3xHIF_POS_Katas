# Kata: Refactor to a Compact Source File

`WordCounter.java` is a tiny program wrapped in the usual boilerplate: a `public class` declaration, a `private static` field, a `public static void main(String[] args)`, and a `private static` helper method — even though nothing here needs to be `public`, `static`, or take `args`.

## Task

1. Remove the `public class WordCounter { ... }` wrapper so the file becomes an implicit top-level class (the compiler still names the class after the file, `WordCounter`).
2. Change `totalWords` from a `static` field to a plain instance field.
3. Change `main` to an instance method with no parameters: `void main()`.
4. Change `countWords` to a plain (non-static) instance method.
5. Keep the exact same behavior and output.

## Verification

```
javac WordCounter.java && java WordCounter
```

The printed line must stay exactly the same as before your refactor.
