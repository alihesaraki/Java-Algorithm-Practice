package Algorithms.SimplePractice;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        MergeSortedArrays merger = new MergeSortedArrays();
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 6};

        int[] mergedArray = merger.mergeArrays(array1, array2);
        System.out.println("Merged sorted array: " + Arrays.toString(mergedArray));
    }

    private int[] mergeArrays(int[] array1, int[] array2) {
        int[] merged = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                merged[k++] = array1[i++];
            } else {
                merged[k++] = array2[j++];
            }
        }
        while (i < array1.length) {
            merged[k++] = array1[i++];
        }
        while (j < array2.length) {
            merged[k++] = array2[j++];
        }
        return merged;
    }
}

