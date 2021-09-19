package threads.executor;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(" Task data !!" + Thread.currentThread().getName());
    }
}
