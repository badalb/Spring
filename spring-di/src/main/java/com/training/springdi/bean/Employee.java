package com.training.springdi.bean;

public class Employee {
	private Company company;
	private Address address;

	public Employee(Company company, Address address) {
		this.company = company;
		this.address = address;
	}

	public void print() {
		System.out.println("CompId:" + company.getCompId() + ", Company name:" + company.getCompName());
		System.out.println("AddId:" + address.getAddId() + ", City:" + address.getCity());
	}
}
