package com.ldp.oa.basedata.actionform;

public class PrivilegeForm {

	private Long userId;
	
	private String menuIdListJson;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMenuIdListJson() {
		return menuIdListJson;
	}

	public void setMenuIdListJson(String menuIdListJson) {
		this.menuIdListJson = menuIdListJson;
	}
	
}
