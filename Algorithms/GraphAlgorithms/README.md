# Graph Algorithms

This folder contains implementations of popular graph algorithms in Java. Each algorithm is placed in its own class and demonstrates how to perform graph traversals and find the shortest paths between nodes.

## Algorithms in This Folder:

1. **Breadth-First Search (BFS)**:
    - BFS is an algorithm used for traversing or searching tree or graph data structures. It starts at the root node (or an arbitrary node) and explores all its neighbors at the present depth prior to moving on to nodes at the next depth level.
    - Time complexity: O(V + E) where V is the number of vertices and E is the number of edges.

2. **Depth-First Search (DFS)**:
    - DFS is a traversal technique where you start at the root (or any arbitrary node) and explore as far as possible along each branch before backtracking.
    - Time complexity: O(V + E)

3. **Dijkstra's Algorithm**:
    - Dijkstra's algorithm is used to find the shortest path from a starting vertex to all other vertices in a graph. It works well with graphs that have non-negative weights.
    - Time complexity: O(V^2) or O(V + E log V) with priority queues.

4. **Floyd-Warshall Algorithm**:
    - Floyd-Warshall is an all-pairs shortest path algorithm. It computes the shortest paths between every pair of vertices in a weighted graph.
    - Time complexity: O(V^3)
