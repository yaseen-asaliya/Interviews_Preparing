package Threads;

public class WaitAndNotify extends Thread {
    private final Object lock = new Object();
    private boolean isProduced = false;

    public void producer() throws InterruptedException {
        synchronized (lock) {
            System.out.println(1);
            Thread.sleep(2000);
            System.out.println(2);
            wait();
            System.out.println(3);
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock) {
            System.out.println(4);
            notify();
            System.out.println(5);
        }
    }

    public void run() {
        try {
            producer();
            consumer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        Thread t1 = new Thread(waitAndNotify);
        t1.start();
    }
}
