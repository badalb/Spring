package com.training.spring_bean_lifecycle.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.spring_bean_lifecycle.AppConfig;
import com.training.spring_bean_lifecycle.service.EmployeeService;

public class EmployeeServiceMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();

		EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
		System.out.println(employeeService.getEmployee().getName());
		ctx.close();

	}

}
