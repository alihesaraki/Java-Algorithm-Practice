package Algorithms.SimplePractice;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverser = new ReverseString();
        String input = "Hello World";

        String reversed = reverser.reverse(input);
        System.out.println("Reversed string: " + reversed);
    }

    private String reverse(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }
}
