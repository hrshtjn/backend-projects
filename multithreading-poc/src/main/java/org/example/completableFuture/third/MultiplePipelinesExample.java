package org.example.completableFuture.third;

import java.util.concurrent.CompletableFuture;

public class MultiplePipelinesExample {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        int val=7;
        getReady(future);
        getReady2(future);
        future.complete(val);
    }

    public static void getReady(CompletableFuture<Integer> future) {
        future.thenApply(val -> val*5)
                .thenApply(val -> val+20)
                .thenAccept(System.out::println);
    }

    public static void getReady2(CompletableFuture<Integer> future) {
        future.thenApply(val -> val*5)
                .thenApply(val -> val*100)
                .thenAccept(System.out::println);
    }
}
