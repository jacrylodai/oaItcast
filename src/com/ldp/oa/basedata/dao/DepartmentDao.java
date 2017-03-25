package com.ldp.oa.basedata.dao;

import java.io.Serializable;
import java.util.Collection;

import com.ldp.oa.basedata.domain.Department;

public interface DepartmentDao {
	
	public void saveDepartment(Department department);
	
	public void deleteDepartmentById(Serializable departmentId,int deleteMode);
	
	public void updateDepartment(Department department);
	
	public Department getDepartmentById(Serializable departmentId);
	
	public Collection<Department> getAllDepartment();

}
