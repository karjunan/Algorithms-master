package threads.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableExample {

    public static void main(String[] args) {
        int val = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(val);
        List<Future> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            Future<Integer> future = service.submit(new Task1());
            list.add(future);
        }

        try {
          for(int i = 0; i < list.size(); i++) {
              Future<Integer> result = list.get(i);
              result.cancel(false);
              Integer in = result.get();

              System.out.println(" Result is " + in);
          }
          service.shutdown();
        } catch (Exception ex) {
            service.shutdown();
            ex.printStackTrace();
        }
    }
}
