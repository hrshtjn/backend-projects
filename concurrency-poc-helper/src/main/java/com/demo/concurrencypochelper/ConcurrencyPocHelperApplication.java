package com.demo.concurrencypochelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConcurrencyPocHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyPocHelperApplication.class, args);
	}

	@GetMapping("/msg")
	public ResponseEntity<String> sayHello() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}
}
