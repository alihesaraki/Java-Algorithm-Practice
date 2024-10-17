package Algorithms.SimplePractice;

public class FindEvenNumbers {

    public static void main(String[] args) {
        FindEvenNumbers finder = new FindEvenNumbers();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Even numbers in the array:");
        finder.printEvenNumbers(array);
    }

    private void printEvenNumbers(int[] array) {
        for (int num : array) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
