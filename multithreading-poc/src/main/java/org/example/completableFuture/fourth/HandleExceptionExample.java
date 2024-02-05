package org.example.completableFuture.fourth;

import java.util.concurrent.CompletableFuture;

public class HandleExceptionExample {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()->getValue())
                .exceptionally(throwable -> handleError(throwable))
                .thenApply(num -> getAnotherValue(num))
                .thenApply(val -> val+8)
                .thenApply(val -> val+2)
                .exceptionally(throwable -> 91)
                .thenApply(val -> val+10)
                .thenAccept(System.out::println)
                .join();
    }

    public static int getValue(){
        //blowup();
        return 5;
    }

    public static int getAnotherValue(int num){
        blowup();
        return 500+num;
    }

    public static void blowup() {
        throw new RuntimeException();
    }

    public static int handleError(Throwable throwable) {
        return 100;
    }

}
