package com.training.spring_bean_lifecycle.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring_bean_lifecycle.bean.Employee;

@Service("employeeService")
public class EmployeeService implements InitializingBean, DisposableBean {

	@Autowired
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeService() {
		System.out.println("EmployeeService no-args constructor called");
	}

	// @Override
	public void destroy() throws Exception {
		System.out.println("Disposable bean destroy method...");
		System.out.println("EmployeeService Closing resources");
	}

	// @Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean after properties set..");
		System.out.println("EmployeeService initializing to dummy value");
		if (employee.getName() == null) {
			employee.setName("Badal");
		}
	}
}
