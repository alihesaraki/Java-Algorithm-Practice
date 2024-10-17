package Algorithms.SimplePractice;

public class PowerCalculator {

    public static void main(String[] args) {
        PowerCalculator calculator = new PowerCalculator();
        int base = 2;
        int exponent = 3;

        long result = calculator.calculatePower(base, exponent);
        System.out.println(base + " to the power of " + exponent + ": " + result);
    }

    private long calculatePower(int base, int exponent) {
        if (exponent == 0) return 1;
        return base * calculatePower(base, exponent - 1);
    }
}
