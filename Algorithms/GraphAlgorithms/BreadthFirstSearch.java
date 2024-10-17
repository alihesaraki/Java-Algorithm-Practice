package Algorithms.GraphAlgorithms;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("Breadth-First Search starting from vertex 0:");
        graph.bfs(0);
    }

    private static class Graph {
        private final int vertices;
        private final LinkedList<Integer>[] adjacencyList;

        private Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        private void addEdge(int source, int destination) {
            adjacencyList[source].add(destination);
        }

        private void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices];
            LinkedList<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");

                for (int adjacentVertex : adjacencyList[vertex]) {
                    if (!visited[adjacentVertex]) {
                        visited[adjacentVertex] = true;
                        queue.add(adjacentVertex);
                    }
                }
            }
        }
    }
}

