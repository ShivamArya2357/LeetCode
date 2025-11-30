package Practice.src.warmup;

public class LeetCode1114 {

    public static void main(String[] args) {

        Runnable firstTask = () -> {
            System.out.println("first");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable secondTask = () -> {
            System.out.println("second");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable thirdTask = () -> {
            System.out.println("third");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Foo foo = new Foo();

        Runnable runnable1 = () -> {
            try {
                foo.first(firstTask);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2 = () -> {
            try {
                foo.second(secondTask);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable3 = () -> {
            try {
                foo.third(thirdTask);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        Thread thread3 = new Thread(runnable3);
        thread3.start();
    }

    static class Foo {

        private int count1;

        private int count2;

        public Foo() {
            count1 = 0;
            count2 = 0;
        }

        public synchronized void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            count1++;
            notify();
        }

        public synchronized void second(Runnable printSecond) throws InterruptedException {

            while (count1 != 1) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            count2++;
            notify();
        }

        public synchronized void third(Runnable printThird) throws InterruptedException {

            while (count2 != 1) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
