package com.ldp.oa.basedata.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ldp.oa.basedata.dao.UserDao;
import com.ldp.oa.basedata.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void save(User user) {

		getHibernateTemplate().save(user);
	}

	@Override
	public User loadById(Serializable userId) {
		User user = (User) getHibernateTemplate().load(User.class, userId);
		return user;
	}

}
