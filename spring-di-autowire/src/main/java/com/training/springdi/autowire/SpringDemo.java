package com.training.springdi.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.springdi.autowire.bean.FarmerService;

public class SpringDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		FarmerService farmer = ctx.getBean(FarmerService.class);
		System.out.println("Field Area:" + farmer.getFieldArea());
		ctx.close();
	}
}