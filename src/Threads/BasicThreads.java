package Threads;
// Way 1
class MyThread extends Thread {
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DemoThread implements Runnable {

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class BasicThreads {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        DemoThread run1 = new DemoThread();
        Thread t3 = new Thread(run1);
        t3.start();




    }
}
