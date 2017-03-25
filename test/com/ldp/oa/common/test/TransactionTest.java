package com.ldp.oa.common.test;

import org.junit.Test;

import com.ldp.oa.basedata.dao.UserDao;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.UserService;

public class TransactionTest extends BeanSpring{

	@Test
	public void testDao(){
		
		UserDao userDao = (UserDao)context.getBean("userDao");
		User user = userDao.loadById(1L);
		System.out.println();
	}
	
	@Test
	public void testService(){
		
		UserService userService = (UserService)context.getBean("userService");
		User user = userService.loadUserById(1L);
		System.out.println(user.getUsername());
	}
	
}
