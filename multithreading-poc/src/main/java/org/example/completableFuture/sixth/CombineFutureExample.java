package org.example.completableFuture.sixth;

import java.util.concurrent.CompletableFuture;

public class CombineFutureExample {

    public static void main(String[] args) {
        int val=5;
//        getValueAsync(val)
//                .thenCombine(getValue2Async(val),(a,b)->a+b)
//                .thenAccept(System.out::println).join();

        getValueAsync(val)
                .thenCompose(value -> getValue2Async(value))
                .thenAccept(System.out::println).join();
    }

    public static CompletableFuture<Integer> getValueAsync(int val) {
        return CompletableFuture.supplyAsync(() -> process(val));
    }

    public static CompletableFuture<Integer> getValue2Async(int val) {
        return CompletableFuture.supplyAsync(() -> process2(val));
    }

    public static int process(int x) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x*4;
    }

    public static int process2(int x) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x*5;
    }
}
