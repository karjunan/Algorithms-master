package threads.exercise.exercise1;

import java.util.Random;

public class StartThreads {

    static Random random = new Random();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "  :  " + random.nextInt(99));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "  :  " + random.nextFloat());
            }
        });

        t1.start();


        try {
            t1.join();
            t2.start();
           // t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        System.out.println();

    }

}
