package Algorithms.SimplePractice;

public class CountVowels {

    public static void main(String[] args) {
        CountVowels vowelCounter = new CountVowels();
        String input = "Hello World";

        int count = vowelCounter.countVowels(input);
        System.out.println("Number of vowels: " + count);
    }

    private int countVowels(String input) {
        int count = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
