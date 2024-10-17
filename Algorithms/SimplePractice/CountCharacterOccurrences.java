package Algorithms.SimplePractice;

public class CountCharacterOccurrences {

    public static void main(String[] args) {
        CountCharacterOccurrences counter = new CountCharacterOccurrences();
        String input = "Hello World";
        char character = 'o';

        int count = counter.countOccurrences(input, character);
        System.out.println("Occurrences of '" + character + "': " + count);
    }

    private int countOccurrences(String input, char character) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == character) {
                count++;
            }
        }
        return count;
    }
}
