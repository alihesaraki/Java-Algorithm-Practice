package Algorithms.Sorting_Algorithms;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array before sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        mergeSort.sort(array);

        System.out.println("Array after sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    private void sort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right;

        if (array.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }

        System.arraycopy(array, 0, left, 0, mid);

        System.arraycopy(array, mid, right, 0, right.length);

        sort(left);
        sort(right);

        merge(array, left, right);
    }

    private void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}
