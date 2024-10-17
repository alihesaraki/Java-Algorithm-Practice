package Algorithms.SimplePractice;

public class FindMaximum {

    public static void main(String[] args) {
        FindMaximum maxFinder = new FindMaximum();
        int[] array = {10, 20, 5, 45, 30};

        int max = maxFinder.findMax(array);
        System.out.println("Maximum value in the array: " + max);
    }

    private int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}

