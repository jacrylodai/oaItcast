package com.ldp.oa.basedata.service.impl;

import java.io.Serializable;

import com.ldp.oa.basedata.dao.UserDao;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public User loadUserById(Serializable userId) {
		User user =  userDao.loadById(userId);
		return user;
	}

}
