package com.ldp.oa.basedata.service;

import java.io.Serializable;
import java.util.Collection;

import com.ldp.oa.basedata.domain.Department;

public interface DepartmentService {

	public void saveDepartment(Department department);
	
	public void deleteDepartmentById(Serializable departmentId);
	
	public void updateDepartment(Department department);
	
	public Department getDepartmentById(Serializable departmentId);
	
	public Collection<Department> getAllDepartment();

}
