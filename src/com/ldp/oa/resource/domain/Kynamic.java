package com.ldp.oa.resource.domain;

import java.io.Serializable;

public class Kynamic implements Serializable{
	
	public static final Long ROOT_ID = 1L;
	
	private Long kynamicId;
	
	private Long pid;
	
	private String kynamicName;
	
	private Boolean isParent;

	public Long getKynamicId() {
		return kynamicId;
	}

	public void setKynamicId(Long kynamicId) {
		this.kynamicId = kynamicId;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getKynamicName() {
		return kynamicName;
	}

	public void setKynamicName(String kynamicName) {
		this.kynamicName = kynamicName;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	
}
