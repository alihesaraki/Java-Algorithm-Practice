# Algorithms: A* Search and Bellman-Ford

This repository contains implementations of two important graph algorithms: A* Search Algorithm and Bellman-Ford Algorithm.

## 1. A* Search Algorithm

**A* Search Algorithm** is a popular pathfinding and graph traversal algorithm used to find the shortest path from a starting node to a target node. It combines the benefits of Dijkstra's algorithm and a heuristic approach.

### Key Features
- Uses a priority queue to evaluate nodes based on the total cost (`gCost + hCost`).
- Employs a heuristic function to estimate the cost from the current node to the goal.
- Provides the shortest path in a weighted graph.

### Example
- Given a graph with nodes `A`, `B`, `C`, `D`, `E`, and `Goal`, the algorithm finds the shortest path from `A` to `Goal`.

## 2. Bellman-Ford Algorithm

**Bellman-Ford Algorithm** is used to find the shortest paths from a single source node to all other nodes in a weighted graph. It can handle graphs with negative weight edges.

### Key Features
- Allows for the detection of negative weight cycles.
- Works by relaxing all edges repeatedly for a number of vertices minus one.
- Outputs the shortest distance from the source to all other vertices.

### Example
- For a graph with edges and weights, the algorithm computes the shortest distance from the source node to all reachable nodes, including checks for negative weight cycles.
