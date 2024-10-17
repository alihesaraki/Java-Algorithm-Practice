package Algorithms.SearchingAlgorithms;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {3, 7, 1, 9, 5, 11};
        int target = 9;
        int result = linearSearch(array, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }

    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

