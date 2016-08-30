package com.training.springdi.autowire.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmerService {
	@Autowired
	private CalcUtil calcUtil;

	public int getFieldArea() {
		return calcUtil.multiply(12, 15);
	}
}
