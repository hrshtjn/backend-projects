package org.example.completableFuture.first;

import java.time.Duration;
import java.time.Instant;

public class MultiplyValueRegular {

    public static void main(String[] args) {
        Instant start = Instant.now();
        int result=longNetworkProcess(5);
        System.out.println("result::: "+result);
        someTask();
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Total elapsed time : " + timeElapsed);
    }

    public static  int longNetworkProcess(int value){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return value*10;
    }

    public static  void someTask(){
        try {
            System.out.println(Thread.currentThread().getName()+" is running...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
