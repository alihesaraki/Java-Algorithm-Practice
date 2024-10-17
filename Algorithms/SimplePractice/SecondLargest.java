package Algorithms.SimplePractice;

public class SecondLargest {

    public static void main(String[] args) {
        SecondLargest finder = new SecondLargest();
        int[] array = {10, 20, 4, 45, 99};

        int secondLargest = finder.findSecondLargest(array);
        System.out.println("Second largest number: " + secondLargest);
    }

    private int findSecondLargest(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }
        return second;
    }
}
