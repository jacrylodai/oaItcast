package com.ldp.oa.basedata.dao;

import java.io.Serializable;

import com.ldp.oa.common.dao.BaseDao;

public interface DepartmentDao<T> extends BaseDao<T> {

	public void deleteDepartmentById(Serializable departmentId, int deleteMode);
	
}
