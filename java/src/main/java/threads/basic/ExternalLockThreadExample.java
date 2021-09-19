package threads.basic;

public class ExternalLockThreadExample {

    static int counter1 = 0;
    static int counter2 = 0;

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void execute() {

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                synchronized (lock1) {
                    counter1++;
                }

            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                synchronized (lock2) {
                    counter2++;
                }

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

        System.out.println("Counter 1 value is =>>> " + counter1);
        System.out.println("Counter 2 value is =>>> " + counter2);
    }

    public static void main(String[] args) {
        execute();
    }

}
