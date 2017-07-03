package com.ldp.oa.basedata.domain;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable{
	
	public static final String USER_SESSION_ID = "userSessionId";

	private Long userId;
	
	private String username;
	
	private String password;
	
	private String sex;
	
	private String phone;
	
	private String email;
	
	private Department department;
	
	private Set<Post> postSet;
	
	private Set<MenuItem> menuItemSet;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Post> getPostSet() {
		return postSet;
	}

	public void setPostSet(Set<Post> postSet) {
		this.postSet = postSet;
	}

	public Set<MenuItem> getMenuItemSet() {
		return menuItemSet;
	}

	public void setMenuItemSet(Set<MenuItem> menuItemSet) {
		this.menuItemSet = menuItemSet;
	}
	
}
