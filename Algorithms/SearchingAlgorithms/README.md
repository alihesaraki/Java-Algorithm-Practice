# Searching Algorithms

This folder contains implementations of two fundamental searching algorithms in Java: Binary Search and Linear Search. Each algorithm is implemented in its own class, and the usage of both is demonstrated with simple examples.

## 1. Binary Search

The Binary Search algorithm works on sorted arrays by repeatedly dividing the search interval in half. If the value of the search key is less than the item in the middle of the interval, the search continues in the lower half; otherwise, it continues in the upper half.

- **Time Complexity:** O(log n)
- **Space Complexity:** O(1)

### Example:
- Input: A sorted array `{2, 4, 6, 8, 10, 12, 14, 16, 18, 20}` and a target value `14`.
- Output: Element found at index `6`.

## 2. Linear Search

The Linear Search algorithm checks each element of the array one by one until the target value is found or the array is exhausted. It does not require the array to be sorted.

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

### Example:
- Input: An array `{3, 7, 1, 9, 5, 11}` and a target value `9`.
- Output: Element found at index `3`.

## Usage

To run these algorithms, simply execute the `main` method in each respective class. The input array and target values can be modified within the `main` method to test different cases.

Feel free to modify the code to better understand the implementation of searching algorithms!
