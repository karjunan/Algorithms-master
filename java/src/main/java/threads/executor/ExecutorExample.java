package threads.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        int val = Runtime.getRuntime().availableProcessors();
        System.out.println(" Total number of cores => " + val);
        try {
            ExecutorService service = Executors.newFixedThreadPool(val);

            for (int i = 0; i < 100; i++) {
                System.out.println(" Task number => " + i);
                service.execute(new Task());
            }
            service.shutdown();
            service.execute(new Task());
            System.out.println(" Completed the task !!");

        } catch (Exception ex) {
            System.out.println(" Not good !! Finding some exceptions " );
            ex.getStackTrace();
        }
    }
}
