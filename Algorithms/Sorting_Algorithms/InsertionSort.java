package Algorithms.Sorting_Algorithms;

public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array before sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        insertionSort.sort(array);

        System.out.println("Array after sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    private void sort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
