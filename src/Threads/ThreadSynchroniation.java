package Threads;

public class ThreadSynchroniation {
    Object x= new Object();
    int xx = 0;
    public void staff(){
        synchronized (x) {
            for(int i=0;i<10;i++){
                System.out.println(i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void print(){
        System.out.println(xx);
        xx++;
    }
    public void doSomething()  {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                staff();
                print();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                staff();
            }
        });

        t1.start();
        t2.start();

    }


    public static void main(String[] args) {
        ThreadSynchroniation t = new ThreadSynchroniation();
        t.doSomething();
    }

}
