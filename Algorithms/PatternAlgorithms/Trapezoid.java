package Algorithms.PatternAlgorithms;

class Trapezoid {
    public static void main(String[] args) {
        int n = 5; // height of trapezoid
        int topWidth = 3; // width of the top
        int bottomWidth = 7; // width of the bottom

        // Upper part
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (bottomWidth - topWidth) / 2 + (n - i); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < topWidth + 2 * i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower part
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (bottomWidth - topWidth) / 2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < bottomWidth; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
