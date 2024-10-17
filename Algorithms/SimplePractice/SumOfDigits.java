package Algorithms.SimplePractice;

public class SumOfDigits {

    public static void main(String[] args) {
        SumOfDigits sumCalculator = new SumOfDigits();
        int number = 12345;

        int sum = sumCalculator.calculateSumOfDigits(number);
        System.out.println("Sum of digits: " + sum);
    }

    private int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
