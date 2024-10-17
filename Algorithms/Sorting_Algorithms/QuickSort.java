package Algorithms.Sorting_Algorithms;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array before sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        quickSort.sort(array, 0, array.length - 1);

        System.out.println("Array after sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    private void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
