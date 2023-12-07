package com.demo.concurrencypoc;

import com.demo.concurrencypoc.service.MyAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
@EnableAsync
@Slf4j
public class ConcurrencyPocApplication implements CommandLineRunner {

	@Autowired
	private MyAsyncService myAsyncService;

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyPocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CompletableFuture<String> result1 = myAsyncService.fetchDataAsync("source1");
		CompletableFuture<String> result2 = myAsyncService.fetchDataAsync("source2");

		// Wait for both CompletableFuture tasks to complete
		CompletableFuture<Void> combinedResult = CompletableFuture.allOf(result1, result2);

		combinedResult.join();
		// Combine results when both tasks are completed
		//String combinedResult = myAsyncService.combineResults(result1.get(), result2.get());
		//System.out.println(combinedResult);
		log.info("Both tasks are completed");
	}
}
