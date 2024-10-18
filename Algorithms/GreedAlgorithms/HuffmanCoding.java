package Algorithms.GreedAlgorithms;

import java.util.PriorityQueue;

class Node {
    int frequency;
    char character;
    Node left, right;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        left = right = null;
    }
}

public class HuffmanCoding {

    public static void main(String[] args) {
        String text = "huffman coding example"; // Example text
        System.out.println("Original text: " + text);
        Node root = buildHuffmanTree(text);
        String[] huffmanCodes = new String[256];
        generateHuffmanCodes(root, "", huffmanCodes);
        System.out.println("Huffman Codes:");
        printHuffmanCodes(huffmanCodes);
    }

    private static Node buildHuffmanTree(String text) {
        int[] frequency = new int[256];
        for (char character : text.toCharArray()) {
            frequency[character]++;
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);

        for (char character = 0; character < frequency.length; character++) {
            if (frequency[character] > 0) {
                priorityQueue.add(new Node(character, frequency[character]));
            }
        }

        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node newNode = new Node('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            priorityQueue.add(newNode);
        }
        return priorityQueue.poll();
    }

    private static void generateHuffmanCodes(Node root, String code, String[] huffmanCodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCodes[root.character] = code;
        }

        generateHuffmanCodes(root.left, code + '0', huffmanCodes);
        generateHuffmanCodes(root.right, code + '1', huffmanCodes);
    }

    private static void printHuffmanCodes(String[] huffmanCodes) {
        for (int i = 0; i < huffmanCodes.length; i++) {
            if (huffmanCodes[i] != null) {
                System.out.println((char) i + ": " + huffmanCodes[i]);
            }
        }
    }
}
