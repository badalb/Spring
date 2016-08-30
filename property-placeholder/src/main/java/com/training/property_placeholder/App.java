package com.training.property_placeholder;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(SampleConfig.class);
		ctx.refresh();
		SampleService sservice = ctx.getBean(SampleService.class);
		System.out.println("Attr Value:" + sservice.getAttr());
		ctx.close();

	}
}
