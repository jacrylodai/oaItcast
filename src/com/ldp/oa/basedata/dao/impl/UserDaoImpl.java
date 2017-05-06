package com.ldp.oa.basedata.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ldp.oa.basedata.dao.UserDao;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.common.dao.impl.BaseDaoImpl;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public Collection<User> getAllEntity() {
		
		Collection<User> userList = 
			hibernateTemplate.find(
					"from User user" +
					" left join fetch user.department department");
		return userList;
	}
	
}
