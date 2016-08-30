package com.training.springdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.springdi.bean.Address;
import com.training.springdi.bean.Company;
import com.training.springdi.bean.Employee;
import com.training.springdi.bean.Product;

@Configuration
public class AppConfig {
	@Bean(name = "mycompany")
	public Company getCompany() {
		Company comp = new Company();
		comp.setCompId(100);
		comp.setCompName("ConcretePage");
		return comp;
	}

	@Bean(name = "myaddress")
	public Address getAddress() {
		Address add = new Address(200, "Varanasi");
		return add;
	}

	@Bean(name = "product")
	public Product getProduct() {
		Product product = new Product();
		product.setAddress(getAddress());
		product.setCompany(getCompany());
		return product;
	}

	@Bean(name = "employee")
	public Employee getEmployee() {
		Employee employee = new Employee(getCompany(), getAddress());
		return employee;
	}
}
