package org.example.completableFuture.fifth;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class HandlingTimeoutExample {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> getValue())
                .completeOnTimeout(99,1, TimeUnit.SECONDS)
                .thenAccept(System.out::println)
                .join();
    }

    public static int getValue() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return 5;
    }
}
