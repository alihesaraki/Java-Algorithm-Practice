package Algorithms.RecursiveAlgorithms;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3; // Number of disks
        System.out.println("Solution for Tower of Hanoi with " + n + " disks:");
        solveHanoi(n, 'A', 'C', 'B'); // A = source, C = target, B = auxiliary
    }

    private static void solveHanoi(int n, char source, char target, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        solveHanoi(n - 1, source, auxiliary, target);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        solveHanoi(n - 1, auxiliary, target, source);
    }
}

