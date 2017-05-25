package com.ldp.oa.basedata.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.oa.basedata.dao.UserDao;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.UserService;
import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.common.service.impl.BaseServiceImpl;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	@Override
	protected BaseDao<User> getBaseDao() {
		return userDao;
	}

	@Override
	public User getUserByUsername(String username) {

		User user = null;
		List<User> userList = userDao.getUserListByUsername(username);

		if (userList.size() == 0) {
			user = null;
		} else if (userList.size() == 1) {
			user = userList.get(0);
		} else if (userList.size() > 1) {
			throw new RuntimeException("有多个同名的用户");
		}
		return user;
	}

}
