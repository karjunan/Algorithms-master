package com.threading;

public class Thread1 {

   static Object lock = new Object();
   static  boolean bool = true;
    public static void main(String[] args) {

        Thread th = new Thread(new Ping(lock,false));
        Thread th1 = new Thread(new Pong(lock,true));
        th.start();
        th1.start();

        try {
            th.join();
            th1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static class Ping implements  Runnable {
       Object lock;
       boolean bool;

        public Ping(Object lock, boolean bool) {
            this.lock = lock;
            this.bool = bool;
        }

        @Override
        public void run() {
            synchronized (this.lock) {
                for(int i = 0 ; i< 10; i++) {
                    if(!bool) {
                        System.out.println();
                        bool = true;
                        this.lock.notify();
                    }
                    try {
                        this.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static class Pong implements  Runnable {
      Object lock;
      boolean bool;

        public Pong(Object lock, boolean bool) {
            this.lock = lock;
            this.bool = bool;
        }

        @Override
        public void run() {
            synchronized (this.lock) {
                for(int i = 0 ; i< 10; i++) {
                    if(bool) {
                        System.out.println();
                        bool = false;
                        this.lock.notify();
                    }
                    try {
                        this.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }



}