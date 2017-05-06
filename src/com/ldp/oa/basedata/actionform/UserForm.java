package com.ldp.oa.basedata.actionform;

import java.util.List;


public class UserForm {

	private Long userId;
	
	private String username;
	
	private String password;
	
	private String sex;
	
	private String phone;
	
	private String email;
	
	private Long departmentId;
	
	private List<Long> postIdList;

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

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public List<Long> getPostIdList() {
		return postIdList;
	}

	public void setPostIdList(List<Long> postIdList) {
		this.postIdList = postIdList;
	}

	
}
