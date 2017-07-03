package com.ldp.oa.basedata.action;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ldp.oa.basedata.actionform.PrivilegeForm;
import com.ldp.oa.basedata.domain.MenuItem;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.MenuItemService;
import com.ldp.oa.basedata.service.UserService;
import com.ldp.oa.common.action.BaseAction;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<PrivilegeForm>{
	
	@Resource(name="menuItemService")
	private MenuItemService menuItemService;
	
	@Resource(name="userService")
	private UserService userService;
	
	private Collection<MenuItem> menuItemList;
	
	private List<Long> selectedMenuIdList;
	
	public Collection<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public List<Long> getSelectedMenuIdList() {
		return selectedMenuIdList;
	}

	public String listPrivilege() throws Exception{
		
		PrivilegeForm model = getModel();
		Long userId = model.getUserId();
		
		User user = userService.getEntityById(userId);
		Set<MenuItem> menuItemSet = user.getMenuItemSet();
		
		List<Long> menuIdList = new ArrayList<Long>();
		
		Iterator<MenuItem> iterator = menuItemSet.iterator();
		while(iterator.hasNext()){
			MenuItem menuItem = iterator.next();
			menuIdList.add(menuItem.getMenuId());
		}
		
		selectedMenuIdList = menuIdList;
		
		menuItemList = menuItemService.getAllEntity();
		return SUCCESS;
	}

	public String savePrivilege() throws Exception{
		
		PrivilegeForm model = getModel();
		String menuIdListJson = model.getMenuIdListJson();
																																									 
		Gson gson = new Gson();
		Type type = new TypeToken<List<Long>>(){}.getType();
		List<Long> menuIdList = gson.fromJson(menuIdListJson, type);
		
		Set<MenuItem> menuItemSet = menuItemService.getMenuItemListByIdList(menuIdList);
		
		Long userId = model.getUserId();
		User user = userService.getEntityById(userId);
		
		user.setMenuItemSet(menuItemSet);
		userService.updateEntity(user);
		return SUCCESS;
	}
	
}
