package Algorithms.AdvanceAlgorithms;

import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, -1},  // Edge from vertex 0 to 1 with weight -1
                {0, 2, 4},   // Edge from vertex 0 to 2 with weight 4
                {1, 2, 3},   // Edge from vertex 1 to 2 with weight 3
                {1, 3, 2},   // Edge from vertex 1 to 3 with weight 2
                {1, 4, 2},   // Edge from vertex 1 to 4 with weight 2
                {3, 2, 5},   // Edge from vertex 3 to 2 with weight 5
                {3, 1, 1},   // Edge from vertex 3 to 1 with weight 1
                {4, 3, -3}   // Edge from vertex 4 to 3 with weight -3
        };

        int vertices = 5; // Number of vertices
        int source = 0;   // Starting vertex
        bellmanFord(edges, vertices, source);
    }

    private static void bellmanFord(int[][] edges, int vertices, int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0; // Distance from source to itself is 0

        // Relax edges |V| - 1 times
        for (int i = 1; i < vertices; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print the distance array
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }
}

