package org.example.atomic;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterExample {
    static class Counter {
        private AtomicInteger c = new AtomicInteger(0);
        //Atomic variables perform better than a synchronized keyword

        public void increment() {
            c.getAndIncrement();
        }

        public int value() {
            return c.get();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();

        final Counter counter = new Counter();

        //1000 threads
        for(int i = 0; i < 10000 ; i++) {

            new Thread(new Runnable() {
                public void run() {
                    counter.increment();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("Final number (should be 1000): " + counter.value());
        Instant end = Instant.now();
        long time = Duration.between(start, end).toMillis();
        System.out.println("\n"+time+" ms");
    }
}
