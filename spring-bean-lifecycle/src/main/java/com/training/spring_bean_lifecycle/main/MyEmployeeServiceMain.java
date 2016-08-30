package com.training.spring_bean_lifecycle.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.spring_bean_lifecycle.AppConfig;

public class MyEmployeeServiceMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		ctx.getBean("myEmployeeService");
		ctx.close();

	}
}
