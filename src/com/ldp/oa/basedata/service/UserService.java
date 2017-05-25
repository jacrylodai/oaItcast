package com.ldp.oa.basedata.service;

import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.common.service.BaseService;

public interface UserService extends BaseService<User> {
	
	public User getUserByUsername(String username);
	
}
