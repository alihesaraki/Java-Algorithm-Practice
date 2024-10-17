package Algorithms.SimplePractice;

public class Factorial {

    public static void main(String[] args) {
        Factorial factorialCalculator = new Factorial();
        int number = 5;

        long factorial = factorialCalculator.calculateFactorial(number);
        System.out.println("Factorial of " + number + ": " + factorial);
    }

    private long calculateFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
