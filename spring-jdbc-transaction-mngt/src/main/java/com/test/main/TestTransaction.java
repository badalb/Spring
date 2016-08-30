package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.service.BuyProduct;

public class TestTransaction {

public static void main(String args[]){

ApplicationContext context =
   new ClassPathXmlApplicationContext("beans.xml"); 

 BuyProduct buy = (BuyProduct)context.getBean("buyProduct");  
 buy.buyProduct("user1", 101);  
 buy.displayState("user1", 101);  
 buy.buyProduct("user2", 102);
 buy.displayState("user2", 102);  
 
 
} 
}