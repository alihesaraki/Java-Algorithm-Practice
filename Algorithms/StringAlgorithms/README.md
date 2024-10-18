# String Algorithms

This folder contains implementations of various string searching algorithms in Java. Each algorithm demonstrates a different technique for searching a pattern within a given text. The following algorithms are included:

## 1. Knuth-Morris-Pratt (KMP) Algorithm
The **KMP Algorithm** is an efficient string matching algorithm that avoids redundant comparisons. It preprocesses the pattern to create a partial match (or "failure") table that allows it to skip ahead in the search when a mismatch occurs.

- **Time Complexity**: O(n + m), where n is the length of the text and m is the length of the pattern.
- **Usage**: Optimal for searching patterns in texts where backtracking is expensive.

## 2. Rabin-Karp Algorithm
The **Rabin-Karp Algorithm** is a string searching algorithm that uses hashing to find any one of a set of pattern strings in a text. It computes a hash value for the pattern and for the text's substrings, allowing for quick checks of pattern matches.

- **Time Complexity**: O(n + m) in the best case, O(n*m) in the worst case due to hash collisions.
- **Usage**: Often used when multiple patterns need to be searched simultaneously.

## 3. Z-Algorithm
The **Z-Algorithm** is a linear time algorithm for finding all occurrences of a pattern in a text. It constructs a Z-array for the concatenated pattern and text, which efficiently stores the length of the longest substring starting from each position that matches the prefix of the pattern.
