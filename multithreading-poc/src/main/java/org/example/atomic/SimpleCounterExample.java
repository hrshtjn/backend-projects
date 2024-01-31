package org.example.atomic;

public class SimpleCounterExample {

    static class Counter {
        private int c = 0; //we can make c volatile which will resolve visibility problem
        //but it will not resolve synchronization problem
        //to solve this, we can declare the methods synchronized
        //but this approach will create a bottleneck

        public void increment() {
            c++;
        }

        public int value() {
            return c;
        }
    }

    public static void main(String[] args) throws InterruptedException {
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
    }
}
