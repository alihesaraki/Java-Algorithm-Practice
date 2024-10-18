package Algorithms.PatternAlgorithms;

class XPattern {
    public static void main(String[] args) {
        int n = 5; // size of X pattern
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i || j == n - i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

