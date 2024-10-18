package Algorithms.AdvanceAlgorithms;

import java.util.*;

public class AStarSearch {

    static class Node {
        String name;
        int gCost; // Cost from start node
        int hCost; // Heuristic cost to goal
        Node parent;

        public Node(String name, int gCost, int hCost) {
            this.name = name;
            this.gCost = gCost;
            this.hCost = hCost;
        }

        public int getFCost() {
            return gCost + hCost; // Total cost
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency list
        Map<String, List<Node>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Node("B", 1, 6), new Node("C", 4, 3)));
        graph.put("B", Arrays.asList(new Node("D", 2, 2), new Node("E", 3, 1)));
        graph.put("C", Arrays.asList(new Node("E", 3, 1)));
        graph.put("D", Arrays.asList(new Node("Goal", 1, 0)));
        graph.put("E", Arrays.asList(new Node("Goal", 1, 0)));

        String start = "A";
        String goal = "Goal";
        aStarSearch(graph, start, goal);
    }

    private static void aStarSearch(Map<String, List<Node>> graph, String start, String goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(Node::getFCost));
        Set<String> closedSet = new HashSet<>();

        openSet.add(new Node(start, 0, heuristic(start, goal))); // Add start node

        while (!openSet.isEmpty()) {
            Node currentNode = openSet.poll();

            if (currentNode.name.equals(goal)) {
                System.out.println("Path found to goal: " + reconstructPath(currentNode));
                return;
            }

            closedSet.add(currentNode.name);

            for (Node neighbor : graph.get(currentNode.name)) {
                if (closedSet.contains(neighbor.name)) {
                    continue; // Ignore already evaluated nodes
                }

                int tentativeGCost = currentNode.gCost + neighbor.gCost;

                // If neighbor is not in openSet or tentativeGCost is lower
                if (!openSet.contains(neighbor) || tentativeGCost < neighbor.gCost) {
                    neighbor.gCost = tentativeGCost;
                    neighbor.parent = currentNode;

                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        System.out.println("No path found to goal.");
    }

    private static String reconstructPath(Node node) {
        StringBuilder path = new StringBuilder();
        while (node != null) {
            path.insert(0, node.name + " ");
            node = node.parent;
        }
        return path.toString().trim();
    }

    private static int heuristic(String current, String goal) {
        // Simple heuristic function: returns a static value for demo purposes
        // In a real application, this should be calculated based on problem specifics
        switch (current) {
            case "A":
                return 6;
            case "B":
                return 5;
            case "C":
                return 4;
            case "D":
                return 2;
            case "E":
                return 1;
            default:
                return 0;
        }
    }
}

