# Algorithms: Huffman Coding and Activity Selection Problem

This repository contains implementations of two classic algorithms: Huffman Coding and Activity Selection Problem.

## 1. Huffman Coding

**Huffman Coding** is a lossless data compression algorithm that is used to compress data by assigning variable-length codes to input characters. The most frequent characters are assigned shorter codes, while less frequent characters receive longer codes.

### Key Features
- Constructs a binary tree to assign codes based on character frequencies.
- Utilizes a priority queue to build the Huffman tree efficiently.
- Outputs the generated Huffman codes for each character.

### Example
- For the input string "huffman coding example", the output might be:

## 2. Activity Selection Problem

The **Activity Selection Problem** is a classic optimization problem that aims to select the maximum number of activities that don't overlap in time. Each activity has a start and finish time.

### Key Features
- The algorithm sorts activities based on their finish times.
- Selects the first activity and iteratively chooses the next activity that starts after the last selected activity finishes.
- Efficiently maximizes the number of non-overlapping activities.

### Example
- Given the activities: `{ {0, 6}, {1, 4}, {3, 5}, {5, 7}, {5, 9}, {8, 9} }`, the selected activities might be:
