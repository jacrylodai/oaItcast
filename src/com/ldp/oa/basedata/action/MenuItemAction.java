package com.ldp.oa.basedata.action;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ldp.oa.basedata.domain.MenuItem;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.MenuItemService;
import com.ldp.oa.basedata.service.UserService;
import com.ldp.oa.common.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@Controller(value="menuItemAction")
@Scope("prototype")
public class MenuItemAction extends BaseAction<MenuItem> {
	
	@Resource(name="menuItemService")
	private MenuItemService menuItemService;
	
	@Resource(name="userService")
	private UserService userService;
	
	private Collection<MenuItem> menuItemList;
	
	public Collection<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	@JSON(serialize=false)
	public String getAllMenuItem() throws Exception{
		menuItemList = menuItemService.getAllEntity();
		return SUCCESS;
	}
	
	public String listMenuItemListByPid() throws Exception{
		
		MenuItem model = getModel();
		Long pid = model.getPid();
		menuItemList = menuItemService.getMenuItemListByPid(pid);
		return SUCCESS;
	}
	
	public String listCurrUserMenuItemList() throws Exception{
		
		Map<String, Object> sessionMap = ActionContext.getContext().getSession();
		User user = (User) sessionMap.get(User.USER_SESSION_ID);
		
		Long userId = user.getUserId();
		this.menuItemList = menuItemService.getMenuItemListByUserId(userId);
		
		return SUCCESS;
	}

}
