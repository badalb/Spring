package com.test.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransactionAnnotation {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation.xml");
		PurchaseProductAnnotation purchase = (PurchaseProductAnnotation) context.getBean("purchaseProduct");
		purchase.buyProduct("user1", 101);
		purchase.displayState("user1", 101);
		purchase.buyProduct("user2", 102);
		purchase.displayState("user2", 102);
	}
}