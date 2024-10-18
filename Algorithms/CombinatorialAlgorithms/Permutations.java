package Algorithms.CombinatorialAlgorithms;

import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Permutations of the array: " + Arrays.toString(nums));
        generatePermutations(nums, 0);
    }

    private static void generatePermutations(int[] nums, int start) {
        if (start == nums.length - 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            generatePermutations(nums, start + 1);
            swap(nums, start, i); // backtrack
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
