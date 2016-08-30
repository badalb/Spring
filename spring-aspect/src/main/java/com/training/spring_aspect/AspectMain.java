package com.training.spring_aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		CustomerService customerService = (CustomerService) ctx.getBean("customerService");
		customerService.addCustomer();
		customerService.addCustomerReturnValue();
		customerService.addCustomerAround("Badal");
		try {
			customerService.addCustomerThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ctx.close();

	}

}
