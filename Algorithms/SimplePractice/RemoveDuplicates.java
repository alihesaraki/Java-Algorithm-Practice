package Algorithms.SimplePractice;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates remover = new RemoveDuplicates();
        int[] array = {1, 2, 2, 3, 4, 4, 5};

        int[] uniqueArray = remover.removeDuplicates(array);
        System.out.println("Array after removing duplicates: " + Arrays.toString(uniqueArray));
    }

    private int[] removeDuplicates(int[] array) {
        return Arrays.stream(array).distinct().toArray();
    }
}
