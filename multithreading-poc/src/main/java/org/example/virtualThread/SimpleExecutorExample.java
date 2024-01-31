package org.example.virtualThread;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleExecutorExample {
    public static void main(String[] args) {
        final AtomicInteger atomicInteger = new AtomicInteger();

        Runnable runnable = () -> {
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch(Exception e) {
                System.out.println(e);
            }
            System.out.println("Work Done - " + atomicInteger.incrementAndGet());
        };

        Instant start = Instant.now();

        try (var executor = Executors.newFixedThreadPool(100)) {
            for(int i = 0; i < 1000; i++) {
                executor.submit(runnable);
            }
        }

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Total elapsed time : " + timeElapsed);
    }
}
