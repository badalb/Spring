package com.training.springdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.springdi.bean.Employee;
import com.training.springdi.bean.Product;

public class SpringDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		System.out.println("--Result by Setter based Dependency Injection--");
		Product product = (Product) ctx.getBean("product");
		product.print();
		System.out.println("--Result by Constructor based Dependency Injection--");
		Employee employee = ctx.getBean(Employee.class);
		employee.print();
		ctx.close();
	}
}