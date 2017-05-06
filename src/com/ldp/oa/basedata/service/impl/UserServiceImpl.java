package com.ldp.oa.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.oa.basedata.dao.UserDao;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.UserService;
import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.common.service.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;

	@Override
	protected BaseDao<User> getBaseDao() {
		return userDao;
	}

}
