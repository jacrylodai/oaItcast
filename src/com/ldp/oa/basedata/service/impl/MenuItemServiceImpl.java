package com.ldp.oa.basedata.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldp.oa.basedata.dao.MenuItemDao;
import com.ldp.oa.basedata.domain.MenuItem;
import com.ldp.oa.basedata.service.MenuItemService;
import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.common.service.impl.BaseServiceImpl;

@Service(value="menuItemService")
public class MenuItemServiceImpl extends BaseServiceImpl<MenuItem> implements MenuItemService {

	@Resource(name="menuItemDao")
	private MenuItemDao menuItemDao;
	
	@Override
	protected BaseDao<MenuItem> getBaseDao() {
		return menuItemDao;
	}

	@Override
	public Collection<MenuItem> getMenuItemListByPid(Long pid) {
		return menuItemDao.getMenuItemListByPid(pid);
	}

	@Override
	public Set<MenuItem> getMenuItemListByIdList(List<Long> menuIdList) {
		
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		
		for(Long menuId:menuIdList){
			MenuItem menuItem = menuItemDao.getEntityById(menuId);
			menuItemList.add(menuItem);
		}
		
		return new HashSet<MenuItem>(menuItemList);
	}

	@Override
	public Collection<MenuItem> getMenuItemListByUserId(Long userId) {

		return menuItemDao.getMenuItemListByUserId(userId);
	}

}
