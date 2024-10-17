package Algorithms.SimplePractice;

public class CountWords {

    public static void main(String[] args) {
        CountWords counter = new CountWords();
        String input = "Hello World! This is a test.";

        int wordCount = counter.countWords(input);
        System.out.println("Number of words: " + wordCount);
    }

    private int countWords(String input) {
        String[] words = input.trim().split("\\s+");
        return words.length;
    }
}

