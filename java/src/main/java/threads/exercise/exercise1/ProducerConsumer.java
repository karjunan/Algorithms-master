package threads.exercise.exercise1;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {

    static LinkedList<Integer> list = new LinkedList<>();
    static Random random = new Random();

    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {

            while(true) {
                synchronized (lock) {
                    if(list.isEmpty()) {
                        for(int i = 0; i < 3; i++) {
                            list.addFirst(random.nextInt(1000));
                        }
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread t2 = new Thread(() -> {
            while(true) {
                synchronized (lock) {
                    while(!list.isEmpty()) {
                        System.out.println(list.removeLast());
                        lock.notify();
                    }
                    System.out.println("----------------------");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        t1.start();
        t2.start();


    }
}
