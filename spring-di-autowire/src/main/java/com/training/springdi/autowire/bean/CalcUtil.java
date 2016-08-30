package com.training.springdi.autowire.bean;

import org.springframework.stereotype.Component;

@Component
public class CalcUtil {
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
}
