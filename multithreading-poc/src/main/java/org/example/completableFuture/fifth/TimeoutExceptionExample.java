package org.example.completableFuture.fifth;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class TimeoutExceptionExample {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> getValue())
                .orTimeout(1,TimeUnit.SECONDS)
                //.completeOnTimeout(99,1, TimeUnit.SECONDS)
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
