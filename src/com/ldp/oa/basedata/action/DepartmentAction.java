package com.ldp.oa.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ldp.oa.basedata.domain.Department;
import com.ldp.oa.basedata.service.DepartmentService;
import com.ldp.oa.common.action.BaseAction;
import com.opensymphony.xwork2.util.ValueStack;

@Controller(value="departmentAction")
@Scope(value="prototype")
public class DepartmentAction extends BaseAction<Department> {
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;

	public String listDepartment() throws Exception{
		
		Collection<Department> departmentList = departmentService.getAllEntity();
		
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.getContext().put("departmentList", departmentList);
		
		return LIST_SUCCESS;
	}
	
	public String deleteDepartment() throws Exception{
		
		Department department = getModel();
		
		departmentService.deleteEntityById(department.getDepartmentId());
		return REDIRECT_TO_LIST_ACTION;
	}
	
	public String savePrepareDepartment() throws Exception{
		
		return SAVE_PREPARE_SUCCESS;
	}

	
	public String saveDepartment() throws Exception{
		
		Department model = getModel();
		Department department = new Department();
		
		BeanUtils.copyProperties(model, department);
		
		departmentService.saveEntity(department);
		
		return REDIRECT_TO_LIST_ACTION;
	}
	
	public String updatePrepareDepartment() throws Exception{
		
		Department model = getModel();
		Long departmentId = model.getDepartmentId();
		
		Department department = departmentService.getEntityById(departmentId);
		
		ServletActionContext.getContext().getValueStack().push(department);
		
		return UPDATE_PREPARE_SUCCESS;
	}
	
	public String updateDepartment() throws Exception{
		
		Department model = getModel();
		Long departmentId = model.getDepartmentId();
		
		Department department = departmentService.getEntityById(departmentId);
		
		BeanUtils.copyProperties(model, department);
		
		departmentService.updateEntity(department);
		
		return REDIRECT_TO_LIST_ACTION;
	}
	
}
