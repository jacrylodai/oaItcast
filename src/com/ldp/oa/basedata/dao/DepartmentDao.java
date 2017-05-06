package com.ldp.oa.basedata.dao;

import java.io.Serializable;

import com.ldp.oa.basedata.domain.Department;
import com.ldp.oa.common.dao.BaseDao;

public interface DepartmentDao extends BaseDao<Department> {

	public void deleteDepartmentById(Serializable departmentId, int deleteMode);
	
}
