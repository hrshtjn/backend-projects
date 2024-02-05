package org.example.completableFuture.second;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

public class ChainingTasksExample {

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
        CompletableFuture.supplyAsync(() -> longNetworkProcess(7))
                .thenApply(ChainingTasksExample::performSomeOperation)
                //when we do thenApply we will continue to use the same background thread
                //and will not go back to the main thread
                .thenApply(ChainingTasksExample::performSomeOperation)
                .thenAccept(System.out::println)
                .thenRun(ChainingTasksExample::veryLongProcess)
        .thenRun(ChainingTasksExample::veryLongProcess);


        Thread.sleep(8000);

        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Total elapsed time : " + timeElapsed);
    }

    public static  int longNetworkProcess(int value){
        try {
            System.out.println(Thread.currentThread().getName()+" is running...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" completed...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return value*10;
    }

    public static  void veryLongProcess(){
        try {
            System.out.println(Thread.currentThread().getName()+" is running...Very long process started");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" completed...done with very long process");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static int performSomeOperation(int value) {
        System.out.println(Thread.currentThread().getName()+" is running...");
        if(value %2==0) {
            value +=1;
        } else {
            value +=3;
        }

        return value;
    }
}
