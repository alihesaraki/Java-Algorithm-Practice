package Algorithms.SimplePractice;

public class PalindromeChecker {

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        String input = "madam";

        boolean isPalindrome = checker.isPalindrome(input);
        System.out.println(input + " is palindrome: " + isPalindrome);
    }

    private boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
}
