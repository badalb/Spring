package com.test.springsecurity.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springsecurity.persistence.entity.User;
import com.test.springsecurity.persistence.repository.UserRepository;
import com.test.springsecurity.persistence.util.CommonConstant;

@Service
public class UserServiceImpl implements UserService {
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository users;

	@Override
	public User findByUserName(String userName) {
		return users.findByUserName(userName);
	}

	@Override
	public User findUserById(String userId) {
		log.info("Request to fetch user with Id : " + userId);
		User user = users.findByUserIdAndIsDeleted(userId, CommonConstant.IS_NOT_DELETED);
		log.info("Request to fetch user with Id success : " + user);
		return user;
	}

}
