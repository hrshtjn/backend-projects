package org.example.completableFuture;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExecutorExample {
    public static void main(String[] args) {
        Instant start = Instant.now();
        // Create a fixed-size thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Create CompletableFuture tasks and submit them to the thread pool
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> compute(1), executor);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> compute(2), executor);
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> compute(3), executor);

        // Combine the results of CompletableFuture tasks when they are complete
        CompletableFuture<Integer> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + result2)
                .thenCombine(future3, (result12, result3) -> result12 + result3);

        // Block and wait for the combined result
        try {
            int combinedResult = combinedFuture.get();
            System.out.println("Combined result: " + combinedResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Shutdown the thread pool
        executor.shutdown();
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Total elapsed time : " + timeElapsed);
    }

    public static int compute(int value) {
        // Simulate a long-running computation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * 10;
    }

}
