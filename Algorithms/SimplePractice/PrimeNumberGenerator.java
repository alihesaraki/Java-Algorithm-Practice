package Algorithms.SimplePractice;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {

    public static void main(String[] args) {
        PrimeNumberGenerator generator = new PrimeNumberGenerator();
        int limit = 30;

        List<Integer> primes = generator.generatePrimes(limit);
        System.out.println("Prime numbers up to " + limit + ": " + primes);
    }

    private List<Integer> generatePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

