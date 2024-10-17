package Algorithms.SimplePractice;

public class SwapTwoNumbers {

    public static void main(String[] args) {
        SwapTwoNumbers swapper = new SwapTwoNumbers();
        int a = 5, b = 10;

        System.out.println("Before swapping: a = " + a + ", b = " + b);
        swapper.swap(a, b);
    }

    private void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}
