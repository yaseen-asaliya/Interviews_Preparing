package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Runner implements Runnable{
    int id;

    Runner(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Started : " + id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished : " + id);
    }
}

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=0;i<10;i++){
            executor.submit(new Runner(i));
        }
        executor.shutdown();

        System.out.println("All tasks are submitted.");

        executor.awaitTermination(30, TimeUnit.SECONDS); // if the process didn't finish in 3 second it will terminate

        System.out.println("All tasks are completed.");
    }
}
