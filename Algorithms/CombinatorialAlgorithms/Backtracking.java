package Algorithms.CombinatorialAlgorithms;

public class Backtracking {

    public static void main(String[] args) {
        int n = 4; // Number of queens
        System.out.println("Solutions for " + n + "-Queens Problem:");
        solveNQueens(n);
    }

    private static void solveNQueens(int n) {
        int[][] board = new int[n][n];
        if (placeQueens(board, 0, n)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean placeQueens(int[][] board, int row, int n) {
        if (row == n) {
            return true; // All queens are placed
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1; // Place queen
                if (placeQueens(board, row + 1, n)) {
                    return true; // If placing queen leads to a solution
                }
                board[row][col] = 0; // Backtrack
            }
        }
        return false; // No place found for this queen
    }

    private static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check the column and diagonals for safety
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false; // Column check
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false; // Left diagonal check
            }
        }

        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false; // Right diagonal check
            }
        }

        return true; // Safe to place queen
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int col : row) {
                System.out.print((col == 1 ? " Q " : " . "));
            }
            System.out.println();
        }
    }
}

