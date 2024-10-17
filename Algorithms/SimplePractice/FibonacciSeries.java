package Algorithms.SimplePractice;

public class FibonacciSeries {

    public static void main(String[] args) {
        FibonacciSeries fibonacci = new FibonacciSeries();
        int n = 10;

        System.out.println("Fibonacci series up to " + n + ":");
        fibonacci.printFibonacciSeries(n);
    }

    private void printFibonacciSeries(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
