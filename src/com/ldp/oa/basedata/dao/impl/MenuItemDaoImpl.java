package com.ldp.oa.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.ldp.oa.basedata.dao.MenuItemDao;
import com.ldp.oa.basedata.domain.MenuItem;
import com.ldp.oa.common.dao.impl.BaseDaoImpl;

@Repository(value="menuItemDao")
public class MenuItemDaoImpl extends BaseDaoImpl<MenuItem> implements MenuItemDao {

}
