package com.ldp.oa.basedata.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.ldp.oa.basedata.dao.MenuItemDao;
import com.ldp.oa.basedata.domain.MenuItem;
import com.ldp.oa.common.dao.impl.BaseDaoImpl;

@Repository(value="menuItemDao")
public class MenuItemDaoImpl extends BaseDaoImpl<MenuItem> implements MenuItemDao {

	@Override
	public Collection<MenuItem> getMenuItemListByPid(Long pid) {
		
		Collection<MenuItem> menuItemList = 
			getHibernateTemplate().find(
					"from MenuItem menuItem where menuItem.pid=?"
					, pid);
		return menuItemList;
	}

	@Override
	public Collection<MenuItem> getMenuItemListByUserId(Long userId) {
		
		String hql = 
				"select menuItem from MenuItem menuItem" +
				" inner join menuItem.userSet user" +
				" where user.userId=?";
		Collection<MenuItem> menuItemList = getHibernateTemplate().find(hql,userId);
		
		return menuItemList;
	}

}
