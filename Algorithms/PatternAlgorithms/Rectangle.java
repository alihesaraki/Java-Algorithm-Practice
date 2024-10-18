package Algorithms.PatternAlgorithms;

class Rectangle {
    public static void main(String[] args) {
        int rows = 5; // number of rows
        int cols = 9; // number of columns
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

