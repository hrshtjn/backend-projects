package org.example.completableFuture.first;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MultiplyValueCompletable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Instant start = Instant.now();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> longNetworkProcess(5));
        //int result=longNetworkProcess(5);
        someTask();
        System.out.println("result::: "+future.get());

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
            System.out.println(Thread.currentThread().getName()+" completed...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
