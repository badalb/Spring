package com.test.apiURL;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.Greeting;

@RestController
@RequestMapping("/api/v1")
public class URLV1GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World URL V1") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
