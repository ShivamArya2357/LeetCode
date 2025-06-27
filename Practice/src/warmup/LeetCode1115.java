package Practice.src.warmup;

import java.util.concurrent.Semaphore;

public class LeetCode1115 {

    public static void main(String[] args) {

        FooBar fooBar = new FooBar(5);

        Runnable printFoo = () -> {
            System.out.print("foo");
        };
        Runnable printBar = () -> {
            System.out.print("bar");
        };

        Runnable task1 = () -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
            }
        };
        Runnable task2 = () -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
            }
        };
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
    }

//    static class FooBar {
//
//        private Object lock;
//
//        private int n;
//
//        private int count;
//
//        public FooBar(int n) {
//            this.n = n;
//            this.count = 0;
//            this.lock = new Object();
//        }
//
//        public void foo(Runnable printFoo) throws InterruptedException {
//
//            for (int i = 0; i < n; i++) {
//                synchronized (this.lock) {
//                    while (count % 2 == 1) {
//                        lock.wait();
//                    }
//                    // printFoo.run() outputs "foo". Do not change or remove this line.
//                    printFoo.run();
//                    count++;
//                    lock.notifyAll();
//                }
//            }
//        }
//
//        public void bar(Runnable printBar) throws InterruptedException {
//
//            for (int i = 0; i < n; i++) {
//                synchronized (this.lock) {
//                    while (count % 2 == 0) {
//                        lock.wait();
//                    }
//                    // printBar.run() outputs "bar". Do not change or remove this line.
//                    printBar.run();
//                    count++;
//                    lock.notifyAll();
//                }
//            }
//        }
//    }

    static class FooBar {

        private int n;

        private Semaphore fooSemaPhore = new Semaphore(1);
        private Semaphore barSemaPhore = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                fooSemaPhore.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                barSemaPhore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                barSemaPhore.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooSemaPhore.release();
            }
        }
    }
}
