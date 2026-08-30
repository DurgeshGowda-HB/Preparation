package OS;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz {

    // Last number to print
    private int n;

    // Shared variable (all threads use this)
    // Current number to process
    private int current = 1;

    // Lock to avoid race condition
    private Lock lock = new ReentrantLock();

    // Used to make threads wait and wake them up
    private Condition condition = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // ------ FIZZ THREAD --------
    public void fizz(Runnable printFizz) throws InterruptedException {

        while (true) {

            lock.lock();          // Enter critical section

            try {

                // Wait until:
                // 1. Current number is divisible by 3
                // 2. NOT divisible by 5
                while (current <= n &&
                        !(current % 3 == 0 && current % 5 != 0)) {

                    condition.await();    // Sleep and release lock
                }

                // If all numbers are printed
                // wake everyone and exit
                if (current > n) {
                    condition.signalAll();
                    return;
                }

                // Print "fizz"
                printFizz.run();

                // Move to next number
                current++;

                // Wake all waiting threads
                condition.signalAll();

            } finally {

                // Always release lock
                lock.unlock();
            }
        }
    }

    // ---------------- BUZZ THREAD ----------------
    public void buzz(Runnable printBuzz) throws InterruptedException {

        while (true) {

            lock.lock();

            try {

                // Wait until number is divisible by 5
                // but NOT divisible by 3
                while (current <= n &&
                        !(current % 5 == 0 && current % 3 != 0)) {

                    condition.await();
                }

                if (current > n) {
                    condition.signalAll();
                    return;
                }

                printBuzz.run();

                current++;

                condition.signalAll();

            } finally {

                lock.unlock();
            }
        }
    }

    // ---------------- FIZZBUZZ THREAD ----------------
    public void fizzbuzz(Runnable printFizzBuzz)
            throws InterruptedException {

        while (true) {

            lock.lock();

            try {

                // Wait until divisible by BOTH 3 and 5
                while (current <= n &&
                        !(current % 15 == 0)) {

                    condition.await();
                }

                if (current > n) {
                    condition.signalAll();
                    return;
                }

                printFizzBuzz.run();

                current++;

                condition.signalAll();

            } finally {

                lock.unlock();
            }
        }
    }

    // ---------------- NUMBER THREAD ----------------
    public void number(IntConsumer printNumber)
            throws InterruptedException {

        while (true) {

            lock.lock();

            try {

                // Wait until NOT divisible by 3
                // AND NOT divisible by 5
                while (current <= n &&
                        !(current % 3 != 0 &&
                          current % 5 != 0)) {

                    condition.await();
                }

                if (current > n) {
                    condition.signalAll();
                    return;
                }

                // Print current number
                printNumber.accept(current);

                current++;

                condition.signalAll();

            } finally {

                lock.unlock();
            }
        }
    }
}
