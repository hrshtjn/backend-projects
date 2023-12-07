package com.demo.concurrencypoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class MyAsyncService {


    private final Executor taskExecutor;

    public MyAsyncService(Executor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    private String fetchDataFromSource(String source) {
        try {
            // Simulating time-consuming operation
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Data from " + source+ " "+ Thread.currentThread().getName();
    }

    @Async
    public CompletableFuture<String> fetchDataAsync(String source) {

        CompletableFuture<String> future = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> {
            fetchDataFromSource(source);
            future.complete(null);
        }, taskExecutor);
        return future;

//        return CompletableFuture.supplyAsync(
//                () -> {fetchDataFromSource(source);},taskExecutor);
    }

    // Combine results when both CompletableFuture tasks are completed
    public String combineResults(String result1, String result2) {
        return "Combined Result: " + result1 + " | " + result2;
    }

}
