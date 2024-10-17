package Algorithms.GraphAlgorithms;


public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        int INF = 99999;  // A value to represent infinity

        // Graph represented as a matrix with edge weights. INF means no direct edge.
        int[][] graph = {
                {0, 3, INF, 5},
                {2, 0, INF, 4},
                {INF, 1, 0, INF},
                {INF, INF, 2, 0}
        };

        int vertices = graph.length;
        floydWarshall(graph, vertices, INF);
    }

    private static void floydWarshall(int[][] graph, int vertices, int INF) {
        // Create a distance matrix and initialize it with graph's values
        int[][] dist = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            System.arraycopy(graph[i], 0, dist[i], 0, vertices);
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist, vertices, INF);
    }

    private static void printSolution(int[][] dist, int vertices, int INF) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
