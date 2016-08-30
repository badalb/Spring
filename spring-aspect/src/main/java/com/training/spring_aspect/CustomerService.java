package com.training.spring_aspect;

public interface CustomerService {

	public void addCustomer();

	public String addCustomerReturnValue();

	public void addCustomerThrowException() throws Exception;

	public void addCustomerAround(String name);
}