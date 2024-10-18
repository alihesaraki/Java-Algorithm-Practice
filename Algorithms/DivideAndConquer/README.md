# Computational Geometry and Matrix Multiplication Algorithms

This repository contains implementations of important algorithms for computational geometry and matrix multiplication.

## 1. Closest Pair of Points

The **Closest Pair of Points** algorithm finds the pair of points with the smallest distance between them in a set of points on a 2D plane. This is done using a divide-and-conquer approach with a time complexity of O(n log n).

### Key features:
- **Divide-and-Conquer** method
- Efficient time complexity compared to brute-force O(n²)
- Useful for problems in computational geometry, such as clustering and nearest neighbor search.

## 2. Strassen’s Algorithm for Matrix Multiplication

The **Strassen’s Algorithm** is an advanced method for multiplying two square matrices faster than the standard algorithm. It reduces the number of multiplications required, achieving a time complexity of approximately O(n^2.81) compared to the classical O(n^3) complexity.

### Key features:
- **Faster Matrix Multiplication**: Reduces the time complexity by decreasing the number of multiplications.
- Splits matrices into 4 submatrices and uses 7 recursive multiplications.
- Useful for applications requiring large matrix multiplications, such as computer graphics and scientific computing.
