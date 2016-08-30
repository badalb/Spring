package com.test.springsecurity.service;

import org.springframework.stereotype.Service;

import com.test.springsecurity.persistence.entity.User;

@Service
public interface UserService {
	public User findByUserName(String userName);

	public User findUserById(String userId);

}
