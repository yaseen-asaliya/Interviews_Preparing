package Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDown {
    public static void main(String[] args) {
        // Create a CountDownLatch with a count of 2
        CountDownLatch latch = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0;i<15;i++){
            executorService.submit(new WorkerThread(i+"",latch));
        }
        executorService.shutdown();

        try {
            // Main thread waits for the latch count to reach zero
            latch.await();
            System.out.println("All workers have completed their tasks. Main thread continues.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WorkerThread extends Thread {
    private final CountDownLatch latch;

    public WorkerThread(String name, CountDownLatch latch) {
        super(name);
        this.latch = latch;
    }

    @Override
    public void run() {
        // Simulate some work
        System.out.println(getName() + " is performing a task.");

        // Worker has completed its task, decrement the latch count
        latch.countDown();
    }
}
