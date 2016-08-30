package com.training.springdi.bean;

public class Address {
	private int addId;
	private String city;

	public Address(int addId, String city) {
		this.addId = addId;
		this.city = city;
	}

	public int getAddId() {
		return addId;
	}

	public String getCity() {
		return city;
	}
}
