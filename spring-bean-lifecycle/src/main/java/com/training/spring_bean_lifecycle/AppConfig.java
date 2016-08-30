package com.training.spring_bean_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.training.spring_bean_lifecycle.bean.Employee;
import com.training.spring_bean_lifecycle.service.MyEmployeeService;

@Configuration
@ComponentScan
public class AppConfig {

	@Bean(name = "employee")
	public Employee getEmployee() {
		Employee employee = new Employee();
		return employee;

	}

	@Bean(name = "myEmployeeService", initMethod = "init", destroyMethod = "destroy")
	public MyEmployeeService getMyEmployeeService() {
		MyEmployeeService myEmployeeService = new MyEmployeeService();
		myEmployeeService.setEmployee(getEmployee());
		return myEmployeeService;
	}
}
