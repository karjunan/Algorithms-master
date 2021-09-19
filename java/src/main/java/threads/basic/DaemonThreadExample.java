package threads.basic;

class Worker implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true) {
            System.out.println(" printing Daemon worker");
        }

    }
}

class Worker1 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" print worker 1 ");

    }
}

public class DaemonThreadExample {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new Worker());
        Thread t2 = new Thread(new Worker1());
        t1.setDaemon(true);
        t2.setDaemon(false);
        t1.start();
        t2.start();
    }
}
