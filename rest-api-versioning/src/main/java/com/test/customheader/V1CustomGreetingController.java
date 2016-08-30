package com.test.customheader;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.Greeting;

@RestController
public class V1CustomGreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE, headers = "X-API-Version=v1")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World Custom Header Custom Header 1") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
