package com.test.txnadvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTransaction {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-advice.xml");
		PurchaseProduct purchase = (PurchaseProduct) context.getBean("purchaseProduct");
		purchase.buyProduct("user1", 101);
		purchase.displayState("user1", 101);
		purchase.buyProduct("user2", 102);
		purchase.displayState("user2", 102);
	}
}