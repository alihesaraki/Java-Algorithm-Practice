package Algorithms.RecursiveAlgorithms;

public class NQueens {

    public static void main(String[] args) {
        int n = 4; // Number of queens
        solveNQueens(n);
    }

    private static void solveNQueens(int n) {
        int[] board = new int[n];
        if (placeQueens(board, 0, n)) {
            printBoard(board, n);
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean placeQueens(int[] board, int row, int n) {
        if (row == n) {
            return true; // All queens are placed
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row] = col; // Place queen
                if (placeQueens(board, row + 1, n)) {
                    return true;
                }
                // Backtrack
                board[row] = -1;
            }
        }
        return false; // No valid position found
    }

    private static boolean isSafe(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false; // Check column and diagonals
            }
        }
        return true;
    }

    private static void printBoard(int[] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}

