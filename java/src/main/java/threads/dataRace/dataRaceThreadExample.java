package threads.dataRace;

public class dataRaceThreadExample {

    public static void main(String[] args) {

        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {

            for(int i = 0; i < Integer.MAX_VALUE; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {

            for(int i = 0; i < Integer.MAX_VALUE; i++) {
                counter.getValue();
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

        System.out.println("Final Result => " + counter.x + " == " + counter.y);

    }


    public static class Counter {
         volatile int  x = 0;
         volatile int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void getValue() {
            if(y > x) {
                System.out.println("Y is greater than x ==> " + y + " ==== " + x);
            }
        }

    }
}
