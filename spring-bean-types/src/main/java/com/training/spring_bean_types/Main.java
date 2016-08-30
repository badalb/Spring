package com.training.spring_bean_types;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);

		context.refresh();

		CustomerService custA = (CustomerService) context.getBean("customerService");
		System.out.println(custA.toString());

		CustomerService custB = (CustomerService) context.getBean("customerService");
		System.out.println(custB.toString());
		
		System.out.println(custA.equals(custB));
		
		MessageService msg = (MessageService) context.getBean("messageService");
		System.out.println(msg.toString());
		
		MessageService msg1 = (MessageService) context.getBean("messageService");
		System.out.println(msg1.toString());
		
		System.out.println(msg.equals(msg1));
		
		context.close();
	}
}
