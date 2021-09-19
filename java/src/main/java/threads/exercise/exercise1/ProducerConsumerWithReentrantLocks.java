package threads.exercise.exercise1;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithReentrantLocks {

    static LinkedList<Integer> list = new LinkedList<>();
    static  Random random = new Random();

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition isFull = lock.newCondition();

        Thread t1 = new Thread(() -> {
            while(true) {
                lock.lock();
                try {
                    if(list.isEmpty()) {
                        for(int i = 0; i < 3; i++) {
                            list.addFirst(random.nextInt(1000));
                        }
                        System.out.println("Added Elements are => " + list);
                        isFull.signal();
                    } else {
                        isFull.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });

        Thread t2 = new Thread(() -> {
            while(true) {
                lock.lock();
                try {
                   if(!list.isEmpty()) {
                       for(int i = 0; i < list.size(); i++) {
                           System.out.println("Removing elements => " + list.removeLast());
                       }
                       isFull.signal();
                   } else {
                       isFull.wait();
                   }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });

        t1.start();
        t2.start();
    }
}
