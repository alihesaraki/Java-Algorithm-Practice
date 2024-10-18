package Algorithms.StringAlgorithms;

public class ZAlgorithm {
    public static void main(String[] args) {
        String text = "aaabcxyzaaaabczaaczabbaaaaaabc";
        String pattern = "aaabc";

        search(pattern, text);
    }

    private static void search(String pattern, String text) {
        String concat = pattern + "$" + text;  // Concatenate pattern and text with a unique delimiter
        int l = concat.length();
        int[] Z = new int[l];

        computeZArray(concat, Z);

        // Now look for the pattern in the Z array
        for (int i = 0; i < l; i++) {
            if (Z[i] == pattern.length()) {
                System.out.println("Pattern found at index " + (i - pattern.length() - 1));
            }
        }
    }

    private static void computeZArray(String str, int[] Z) {
        int n = str.length();
        int L = 0, R = 0, K;

        for (int i = 1; i < n; i++) {
            // Case 1: i is outside the current Z-box
            if (i > R) {
                L = R = i;

                // Calculate Z[i] manually by comparing characters
                while (R < n && str.charAt(R) == str.charAt(R - L)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                // Case 2: i is within the current Z-box
                K = i - L;

                // If the value at Z[K] is less than the remaining length in the Z-box, copy Z[K]
                if (Z[K] < R - i + 1) {
                    Z[i] = Z[K];
                } else {
                    // Otherwise, start matching characters manually beyond the current Z-box
                    L = i;
                    while (R < n && str.charAt(R) == str.charAt(R - L)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }
}
