package com.ldp.oa.basedata.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.ldp.oa.basedata.domain.MenuItem;
import com.ldp.oa.common.service.BaseService;

public interface MenuItemService extends BaseService<MenuItem>{

	public Collection<MenuItem> getMenuItemListByPid(Long pid);
	
	public Set<MenuItem> getMenuItemListByIdList(List<Long> menuIdList);

	public Collection<MenuItem> getMenuItemListByUserId(Long userId);
	
}
