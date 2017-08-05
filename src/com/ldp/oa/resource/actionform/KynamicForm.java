package com.ldp.oa.resource.actionform;

public class KynamicForm {
	
	private Long kynamicId;

	private Long pid;
	
	private String kynamicName;
	
	private Boolean isParent;

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getKynamicId() {
		return kynamicId;
	}

	public void setKynamicId(Long kynamicId) {
		this.kynamicId = kynamicId;
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
