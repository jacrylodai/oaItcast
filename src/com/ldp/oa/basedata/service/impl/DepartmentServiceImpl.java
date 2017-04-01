package com.ldp.oa.basedata.service.impl;

import java.io.Serializable;
import java.util.Collection;

import com.ldp.oa.basedata.dao.DepartmentDao;
import com.ldp.oa.basedata.domain.Department;
import com.ldp.oa.basedata.service.DepartmentService;
import com.ldp.oa.utils.proj.DeleteMode;

public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDao<Department> departmentDao;

	public void setDepartmentDao(DepartmentDao<Department> departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public void deleteDepartmentById(Serializable departmentId) {

		departmentDao.deleteDepartmentById(departmentId,
				DeleteMode.DELETE_MODE_PRE_DETACH);
	}

	@Override
	public Collection<Department> getAllDepartment() {
		
		return departmentDao.getAllEntity();
	}

	@Override
	public Department getDepartmentById(Serializable departmentId) {
		
		return departmentDao.getEntityById(departmentId);
	}

	@Override
	public void saveDepartment(Department department) {
		
		departmentDao.saveEntity(department);
	}

	@Override
	public void updateDepartment(Department department) {
		
		departmentDao.updateEntity(department);
	}

}
