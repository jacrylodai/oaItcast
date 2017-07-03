package com.ldp.oa.basedata.dao;

import java.util.Collection;

import com.ldp.oa.basedata.domain.MenuItem;
import com.ldp.oa.common.dao.BaseDao;

public interface MenuItemDao extends BaseDao<MenuItem> {
	
	public Collection<MenuItem> getMenuItemListByPid(Long pid);

	public Collection<MenuItem> getMenuItemListByUserId(Long userId);

}
