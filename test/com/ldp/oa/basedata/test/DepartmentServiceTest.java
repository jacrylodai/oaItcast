package com.ldp.oa.basedata.test;

import org.junit.Test;

import com.ldp.oa.basedata.domain.Department;
import com.ldp.oa.basedata.service.DepartmentService;
import com.ldp.oa.common.test.BeanSpring;

public class DepartmentServiceTest extends BeanSpring{

	@Test
	public void testSave(){
		
		DepartmentService departmentService = 
			(DepartmentService) context.getBean("departmentService");
		
		Department department = new Department();
		department.setDepartmentName("研发部");
		department.setDepartmentDesc("软件，系统研发与维护");
		
		departmentService.saveDepartment(department);
	}
	
}
