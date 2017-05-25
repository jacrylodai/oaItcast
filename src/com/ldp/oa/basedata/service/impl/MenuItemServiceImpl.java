package com.ldp.oa.basedata.service.impl;

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

}
