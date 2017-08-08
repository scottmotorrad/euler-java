import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Euler {
    int problem1() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 ==0 || i% 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    long problem2() {
        FibGenerator fibGen = new FibGenerator();
        long sum = 0;
        long fib = fibGen.getNextFib();
        while (fib < 4000000L) {
            if (fib % 2 == 0) {
                sum += fib;
            }
            fib = fibGen.getNextFib();
        }
        return sum;
    }

    long problem3() {
        long num = 600851475143L;
        for (long i = nearestOddIntegerLessThanSquareRoot(num); i > 0; i -= 2) {
            if (num % i == 0 && trialDivisionForPrime(i)) {
                return i;
            }
        }
        return 1L;
    }

    long problem4() {
        long max = 0L;
        for (long i = 100; i < 1000L; i++) {
            for (long j = i; j < 1000L; j++) {
                long n = i * j;
                if (isPalindromeNumber(n) && n > max)
                    max = n;
            }
        }
        return max;
    }

    long problem5() {
        for (long i = 2520L; true; i += 20) {
            if (isDivisibleByRange(i, 3, 20)) {
                return i;
            }
        }
    }

    boolean isDivisibleByRange(long candidate, long rangeStart, long rangeEnd) {
        for (long i = rangeStart; i < rangeEnd; i++) {
            if (candidate % i != 0)
                return false;
        }
        return true;
    }

    boolean isPalindromeNumber(long n) {
        ArrayList<Long> digits = new ArrayList<Long>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }

        for (int i = 0; i < digits.size() / 2; i++) {
            if (digits.get(i) != digits.get(digits.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    long nearestOddIntegerLessThanSquareRoot(long n) {
        long i = 1L;
        for (; i * i < n; i += 2);
        return i;
    }

    boolean trialDivisionForPrime(long n) {
        if (n == 1L || n == 2L) {
            return true;
        } else if (n % 2L == 0){
            return false;
        }
        for (long div = 3L; div * div < n; div +=2) {
            if (n % div == 0) {
                return false;
            }
        }
        return true;
    }

    class PrimeChecker {
        LinkedHashSet<Long> primes = new LinkedHashSet<Long>(50);

        PrimeChecker() {
            primes.add(1L);
            primes.add(2L);
            primes.add(3L);
        }

        boolean isPrime(long n) {
            if (primes.contains(n)) {
                return true;
            } else if (n % 2L == 0){
                return false;
            }
            for (long div = 3L; div * div < n; div +=2) {
                if (n % div == 0) {
                    return false;
                }
            }
            primes.add(n);
            return true;
        }
    }


    class FibGenerator {
        private long a = 1L;
        private long b = 2L;
        private long count = 0L;

        long getNextFib() {
            if (count == 0L) {
                count++;
                return 1L;
            } else if (count == 1L) {
                count++;
                return 2L;
            } else {
                long fib = a + b;
                a = b;
                b = fib;
                return fib;
            }
        }
    }
}
