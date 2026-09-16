# Kata: Fix Text Block Indentation

`MenuCard.java` compiles and runs, but its output is wrong in two ways:

- Every printed line has 4 unwanted leading spaces.
- The last line, `Padding row:`, is supposed to keep 3 trailing spaces after the colon (for a downstream fixed-width formatter), but they are missing from the output.

## Task

1. Fix the leading-space problem by changing where the closing `"""` delimiter sits, so the incidental indentation stripped from every content line matches the content's own indentation — without adding any manual `.strip()`/`.trim()` calls.
2. Fix the missing trailing spaces on the `Padding row:` line using the text block's `\s` escape, without changing the leading-space fix from step 1.
3. Do not change the visible text content (`Daily Menu`, `----------`, `Soup of the day .... EUR 4.50`, `Padding row:`).

## Verification

```
javac MenuCard.java && java MenuCard
```

Expected output (no leading spaces, `Padding row:` followed by exactly 3 trailing spaces):

```
Daily Menu
----------
Soup of the day .... EUR 4.50
Padding row:   
```
