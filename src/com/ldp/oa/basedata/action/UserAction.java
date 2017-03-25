package com.ldp.oa.basedata.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	public UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String saveUser() throws Exception{
		User user = new User();
		user.setUsername("newUser");
		
		userService.saveUser(user);
		return SUCCESS;
	}
	
	public String loadUserById() throws Exception{
		
		User user = userService.loadUserById(1L);
		ServletActionContext.getRequest().setAttribute("user", user);
		
		return "viewUser";
	}
	
}
