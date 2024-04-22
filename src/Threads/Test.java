package Threads;


class Runer implements Runnable {
    int x = 0;
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            x+=i;
        }
        synchronized (this) {
            notify();
        }
        doWork();
    }

    void doWork() {
        System.out.println(x);
    }
}
class x{

}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        /*Thread t1 = new Thread(new Runer());
        synchronized (t1) {
            t1.start();
            t1.wait();
        }
        x x;*/


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 - Count: " + i);
                Thread.yield(); // Hint to the scheduler to potentially switch to another thread
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2 - Count: " + i);
                Thread.yield(); // Hint to the scheduler to potentially switch to another thread
            }
        });

        thread1.start();
        thread2.start();



    }
}
