package com.ldp.oa.basedata.service;

import java.io.Serializable;

import com.ldp.oa.basedata.domain.User;

public interface UserService {

	public void saveUser(User user);
	
	public User loadUserById(Serializable userId);
	
}
