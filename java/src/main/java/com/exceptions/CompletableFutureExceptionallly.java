package com.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureExceptionallly {

    public static void main(String[] args) {

        Supplier<List<Integer>> integerSupplier = () -> {
//            throw new IllegalStateException();
            return List.of(1,2,3,4);

        };

         CompletableFuture.supplyAsync(integerSupplier)
                        .exceptionally(v -> {
                            System.out.println(v.getMessage());
                            return List.of();
                        })
                        .thenApply(v -> {
                            v.stream().forEach(System.out::println);
                            return new ArrayList();

                        });


//        future.join();
    }
}
