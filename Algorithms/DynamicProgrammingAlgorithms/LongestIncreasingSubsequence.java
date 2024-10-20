package Algorithms.DynamicProgrammingAlgorithms;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("Length of Longest Increasing Subsequence: " + lis(arr));
    }

    private static int lis(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int maxLIS = 0;

        for (int i = 0; i < n; i++) {
            lis[i] = 1; // Every element is a subsequence of length 1
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (maxLIS < lis[i]) {
                maxLIS = lis[i];
            }
        }

        return maxLIS;
    }
}

