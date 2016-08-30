package com.training.springdi.bean;

public class Product {
	private Company company;
	private Address address;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void print() {
		System.out.println("CompId:" + company.getCompId() + ", Company name:" + company.getCompName());
		System.out.println("AddId:" + address.getAddId() + ", City:" + address.getCity());
	}
}
