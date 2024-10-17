package Algorithms.GraphAlgorithms;

import java.util.*;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("Depth-First Search starting from vertex 0:");
        graph.dfs(0);
    }

    private static class Graph {
        private int vertices;
        private LinkedList<Integer>[] adjacencyList;
        private boolean[] visited;

        private Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            visited = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        private void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
        }

        private void dfs(int vertex) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            for (int adjacentVertex : adjacencyList[vertex]) {
                if (!visited[adjacentVertex]) {
                    dfs(adjacentVertex);
                }
            }
        }
    }
}
