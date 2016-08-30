package com.training.spring_bean_types;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}