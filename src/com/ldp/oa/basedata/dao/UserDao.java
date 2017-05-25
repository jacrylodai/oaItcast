package com.ldp.oa.basedata.dao;

import java.util.List;

import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.common.dao.BaseDao;

public interface UserDao extends BaseDao<User>{
	
	public List<User> getUserListByUsername(String username);
	
}
