package threads.completableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {



    }

    public void process() {
        CompletableFuture.supplyAsync(()-> fetchOrder())
                .thenAccept(order -> processOrder(order))
                .thenAccept(order -> sendEmail())
                .exceptionally(f -> {
                    return null;
                });
    }

    public Integer fetchOrder() {

        return Integer.MAX_VALUE;
    }

    public void processOrder(Integer order) {

    }

    public void sendEmail() {

    }
}

