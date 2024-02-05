package org.example.atomic;

import java.time.Duration;
import java.time.Instant;

public class SimpleCounterExample {

    static class Counter {
        private int c = 0; //we can make c volatile which will resolve visibility problem
        //but it will not resolve synchronization problem
        //to solve this, we can declare the methods synchronized
        //but this approach will create a bottleneck

        public synchronized void increment() {
            c++;
        }

        public int value() {
            return c;
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
        //i got 999 couple of times.
        Instant end = Instant.now();
        long time = Duration.between(start, end).toMillis();
        System.out.println("\n"+time+" ms");
    }
}
