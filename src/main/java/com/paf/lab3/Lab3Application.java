package com.paf.lab3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Lab3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

	@GetMapping("/Hello")
	public String rootEndpoint() {
		String message = "Hello World! This is my first Spring Boot application.";
		return message;
	}

	// 1. Basic greeting endpoint
	@GetMapping("/greet")
	public String greet() {
		return "Welcome to Spring Boot!";
	}

	@GetMapping("/greet/{name}")
	public String greetWithName(
			@PathVariable String name,
			@RequestParam(required = false) String message) {

		if (message != null && !message.isEmpty()) {
			return "Hello " + name + "! " + message;
		}
		return "Hello " + name + "! Welcome to Spring Boot!";
	}

}