package com.test.view.rest.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.persistence.entities.User;

@RestController
@RequestMapping({ "/api/v1/", "" , "/test"})
public class HomeController {

	
	@RequestMapping(value = "/secured/hello", method = {RequestMethod.POST,RequestMethod.GET})
	public String hello() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUserName());
		return "Hello World";
	}



}
