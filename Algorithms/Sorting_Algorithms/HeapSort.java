package Algorithms.Sorting_Algorithms;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array before sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        heapSort.sort(array);

        System.out.println("Array after sorting:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    private void sort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // One by one extract elements from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            swap(array, 0, i);
            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(array, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

