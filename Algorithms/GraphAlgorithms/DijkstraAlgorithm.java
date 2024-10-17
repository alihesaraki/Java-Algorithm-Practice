package Algorithms.GraphAlgorithms;

import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int vertices = 6;
        int[][] graph = new int[][] {
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0}
        };

        dijkstra(graph, 0, vertices); // Starting from vertex 0
    }

    private static void dijkstra(int[][] graph, int startVertex, int vertices) {
        int[] shortestDistances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(shortestDistances, Integer.MAX_VALUE);
        shortestDistances[startVertex] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int nearestVertex = findNearestVertex(shortestDistances, visited, vertices);
            visited[nearestVertex] = true;

            for (int adjacentVertex = 0; adjacentVertex < vertices; adjacentVertex++) {
                if (!visited[adjacentVertex] && graph[nearestVertex][adjacentVertex] != 0 &&
                        shortestDistances[nearestVertex] + graph[nearestVertex][adjacentVertex] < shortestDistances[adjacentVertex]) {
                    shortestDistances[adjacentVertex] = shortestDistances[nearestVertex] + graph[nearestVertex][adjacentVertex];
                }
            }
        }

        printShortestDistances(shortestDistances, startVertex, vertices);
    }

    private static int findNearestVertex(int[] shortestDistances, boolean[] visited, int vertices) {
        int minDistance = Integer.MAX_VALUE;
        int nearestVertex = -1;

        for (int vertex = 0; vertex < vertices; vertex++) {
            if (!visited[vertex] && shortestDistances[vertex] < minDistance) {
                minDistance = shortestDistances[vertex];
                nearestVertex = vertex;
            }
        }

        return nearestVertex;
    }

    private static void printShortestDistances(int[] distances, int startVertex, int vertices) {
        System.out.println("Shortest distances from vertex " + startVertex + ":");
        for (int vertex = 0; vertex < vertices; vertex++) {
            System.out.println("To vertex " + vertex + ": " + distances[vertex]);
        }
    }
}
