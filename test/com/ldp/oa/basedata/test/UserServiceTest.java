package com.ldp.oa.basedata.test;

import org.junit.Test;

import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.UserService;
import com.ldp.oa.common.test.BeanSpring;

public class UserServiceTest extends BeanSpring{

	@Test
	public void testSave(){
		UserService userService = (UserService)context.getBean("userService");
		
		User user = new User();
		user.setUsername("jacrylodai");
		
		userService.saveUser(user);
	}
	
}
