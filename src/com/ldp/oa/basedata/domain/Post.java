package com.ldp.oa.basedata.domain;

import java.io.Serializable;
import java.util.Set;

public class Post implements Serializable{

	private Long postId;
	
	private String postName;
	
	private String postDesc;
	
	private Set<User> userSet;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	
}
