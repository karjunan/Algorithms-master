package threads.exercise.exercise1;

public class FooBarPrinting {

    static boolean bool = false;

    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            while(true) {
                synchronized (lock) {
                    if(!bool) {
                        for(int i = 0; i < 3; i++)
                            System.out.println("foo");
                        bool = true;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        });

        Thread t2 = new Thread(() -> {
            while(true) {
                synchronized (lock) {
                    if(bool) {
                        for(int i = 0; i < 3; i++)
                            System.out.println("bar");
                        bool = false;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }

            }
        });

        t1.start();
        t2.start();

    }
}
