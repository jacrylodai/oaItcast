package com.ldp.oa.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.ldp.oa.basedata.domain.MenuItem;
import com.ldp.oa.basedata.service.MenuItemService;
import com.ldp.oa.common.action.BaseAction;

@Controller(value="menuItemAction")
public class MenuItemAction extends BaseAction<MenuItem> {
	
	@Resource(name="menuItemService")
	private MenuItemService menuItemService;
	
	private Collection<MenuItem> menuItemList;
	
	public Collection<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	@JSON(serialize=false)
	public String getAllMenuItem() throws Exception{
		menuItemList = menuItemService.getAllEntity();
		return SUCCESS;
	}

}
