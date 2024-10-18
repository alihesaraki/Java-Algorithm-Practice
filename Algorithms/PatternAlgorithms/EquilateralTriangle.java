package Algorithms.PatternAlgorithms;

class EquilateralTriangle {
    public static void main(String[] args) {
        int n = 5; // height of triangle
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

