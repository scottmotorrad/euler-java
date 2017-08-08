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
        PrimeChecker p = new PrimeChecker();
        long lpf = 1L;
        for (long i = 3L; i * i < num; i += 2) {
            if (num % i == 0 && p.isPrime(i)) {
                lpf = i;
            }
        }
        return lpf;
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
