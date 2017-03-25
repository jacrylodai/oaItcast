package com.ldp.oa.basedata.dao;

import java.io.Serializable;

import com.ldp.oa.basedata.domain.User;

public interface UserDao {

	public void save(User user);

	public User loadById(Serializable userId);
	
}
