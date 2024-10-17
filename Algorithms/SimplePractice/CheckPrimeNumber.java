package Algorithms.SimplePractice;

public class CheckPrimeNumber {

    public static void main(String[] args) {
        CheckPrimeNumber checker = new CheckPrimeNumber();
        int number = 29;

        boolean isPrime = checker.isPrime(number);
        System.out.println(number + " is prime: " + isPrime);
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

