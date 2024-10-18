package Algorithms.DivideAndConquer;

public class StrassensMatrixMultiplication {

    public static void main(String[] args) {
        int[][] A = {
                {1, 2},
                {3, 4}
        };

        int[][] B = {
                {5, 6},
                {7, 8}
        };

        int[][] result = strassen(A, B);

        System.out.println("Resulting Matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static int[][] strassen(int[][] A, int[][] B) {
        int n = A.length;

        // Base case when the matrix is 1x1
        if (n == 1) {
            return new int[][]{{A[0][0] * B[0][0]}};
        }

        // Split the matrices into quarters
        int newSize = n / 2;
        int[][] a11 = new int[newSize][newSize];
        int[][] a12 = new int[newSize][newSize];
        int[][] a21 = new int[newSize][newSize];
        int[][] a22 = new int[newSize][newSize];

        int[][] b11 = new int[newSize][newSize];
        int[][] b12 = new int[newSize][newSize];
        int[][] b21 = new int[newSize][newSize];
        int[][] b22 = new int[newSize][newSize];

        split(A, a11, a12, a21, a22);
        split(B, b11, b12, b21, b22);

        // Calculate the 7 products using Strassen's formulas
        int[][] p1 = strassen(add(a11, a22), add(b11, b22)); // p1 = (a11 + a22) * (b11 + b22)
        int[][] p2 = strassen(add(a21, a22), b11);           // p2 = (a21 + a22) * b11
        int[][] p3 = strassen(a11, subtract(b12, b22));      // p3 = a11 * (b12 - b22)
        int[][] p4 = strassen(a22, subtract(b21, b11));      // p4 = a22 * (b21 - b11)
        int[][] p5 = strassen(add(a11, a12), b22);           // p5 = (a11 + a12) * b22
        int[][] p6 = strassen(subtract(a21, a11), add(b11, b12)); // p6 = (a21 - a11) * (b11 + b12)
        int[][] p7 = strassen(subtract(a12, a22), add(b21, b22)); // p7 = (a12 - a22) * (b21 + b22)

        // Calculate the resulting quarters
        int[][] c11 = add(subtract(add(p1, p4), p5), p7); // c11 = p1 + p4 - p5 + p7
        int[][] c12 = add(p3, p5);                       // c12 = p3 + p5
        int[][] c21 = add(p2, p4);                       // c21 = p2 + p4
        int[][] c22 = add(subtract(add(p1, p3), p2), p6); // c22 = p1 + p3 - p2 + p6

        // Combine the quarters into the final matrix
        int[][] C = new int[n][n];
        combine(C, c11, c12, c21, c22);

        return C;
    }

    // Helper method to add two matrices
    private static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Helper method to subtract two matrices
    private static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // Split a matrix into 4 submatrices
    private static void split(int[][] P, int[][] C11, int[][] C12, int[][] C21, int[][] C22) {
        int n = P.length / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C11[i][j] = P[i][j];              // Top-left
                C12[i][j] = P[i][j + n];          // Top-right
                C21[i][j] = P[i + n][j];          // Bottom-left
                C22[i][j] = P[i + n][j + n];      // Bottom-right
            }
        }
    }

    // Combine 4 submatrices into one
    private static void combine(int[][] C, int[][] C11, int[][] C12, int[][] C21, int[][] C22) {
        int n = C11.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = C11[i][j];              // Top-left
                C[i][j + n] = C12[i][j];          // Top-right
                C[i + n][j] = C21[i][j];          // Bottom-left
                C[i + n][j + n] = C22[i][j];      // Bottom-right
            }
        }
    }
}

