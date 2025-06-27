package Practice.src.warmup;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class LeetCode1116 {

    public static void main(String[] args) throws InterruptedException {

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        IntConsumer print = value -> {
            System.out.println(value);
        };
        Runnable runnable1 = () -> {
            try {
                zeroEvenOdd.zero(print);
            } catch (InterruptedException e) {
            }
        };
        Runnable runnable2 = () -> {
            try {
                zeroEvenOdd.even(print);
            } catch (InterruptedException e) {
            }
        };
        Runnable runnable3 = () -> {
            try {
                zeroEvenOdd.odd(print);
            } catch (InterruptedException e) {
            }
        };
        Thread printZeroThread = new Thread(runnable1);
        printZeroThread.setName("printZero");
        printZeroThread.start();
        Thread printEvenThread = new Thread(runnable2);
        printEvenThread.setName("printEven");
        printEvenThread.start();
        Thread printOddThread = new Thread(runnable3);
        printOddThread.setName("printOdd");
        printOddThread.start();

        printZeroThread.join();
        printEvenThread.join();
        printOddThread.join();
    }

    static class ZeroEvenOdd {

        private int n;

        private int count;

        private Semaphore zeroSemaphore = new Semaphore(1);

        private Semaphore evenSemaphore = new Semaphore(0);

        private Semaphore oddSemaphore = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
            this.count = 1;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {

            for (int i = 1; i <= n; i++) {
                zeroSemaphore.acquire();
                printNumber.accept(0);
                if (i % 2 == 1) {
                    oddSemaphore.release();
                } else {
                    evenSemaphore.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {

            for (int i = 2; i <= n; i += 2) {
                evenSemaphore.acquire();
                printNumber.accept(i);
                zeroSemaphore.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {

            for (int i = 1; i <= n; i += 2) {
                oddSemaphore.acquire();
                printNumber.accept(i);
                zeroSemaphore.release();
            }
        }
    }
}
