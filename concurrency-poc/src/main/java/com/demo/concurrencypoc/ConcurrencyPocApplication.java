package com.demo.concurrencypoc;

import com.demo.concurrencypoc.service.MyAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@Slf4j
public class ConcurrencyPocApplication implements CommandLineRunner {

	@Autowired
	private MyAsyncService myAsyncService;

	@Autowired
	private ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyPocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		poc1();
	}

	public void poc2() throws ExecutionException, InterruptedException {

		Instant start = Instant.now();

		List<CompletableFuture<String>> allFutures = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			allFutures.add(myAsyncService.callMsgService());
		}

		CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();

		for (int i = 0; i < 10; i++) {
			System.out.println("response: " + allFutures.get(i).get().toString());
		}

		Instant finish = Instant.now();

		long timeElapsed = Duration.between(start, finish).toMillis();

		System.out.println("Total time: " + timeElapsed + " ms");

		System.exit(SpringApplication.exit(context));
	}

	public void poc1() throws ExecutionException, InterruptedException {
		CompletableFuture<String> result1 = myAsyncService.fetchDataAsync("source1");
		CompletableFuture<String> result2 = myAsyncService.fetchDataAsync("source2");

		// Combine results when both tasks are completed
		String combinedResult = myAsyncService.combineResults(result1.get(), result2.get());
		System.out.println(combinedResult);
		log.info("Both tasks are completed");
	}


}
