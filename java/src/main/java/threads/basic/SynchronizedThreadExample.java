package threads.basic;

public class SynchronizedThreadExample {

    static int counter = 0;


    // Intrensic locking . There is only one default intrensic lock for every object in java
    public static synchronized void increment() {
        counter++;
    }

    public static void incrementMonitorLock() {
        synchronized (SynchronizedThreadExample.class) {
            counter++;
        }
    }

    public void incrementDefault() {
        synchronized (this) {
            counter++;
        }
    }

    public synchronized void incrementAtObjectLevel() {
            counter++;
    }

    public static void execute() {

        Thread t1 = new Thread(() -> {
            for(int i =0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                increment();
            }

        });

        Thread t2 = new Thread(() -> {
            for(int i =0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               increment();
            }

        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(counter);

    }

    public static void main(String[] args) {
        execute();
    }
}
