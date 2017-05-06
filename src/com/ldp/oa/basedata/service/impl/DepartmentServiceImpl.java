package com.ldp.oa.basedata.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldp.oa.basedata.dao.DepartmentDao;
import com.ldp.oa.basedata.domain.Department;
import com.ldp.oa.basedata.service.DepartmentService;
import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.common.service.impl.BaseServiceImpl;
import com.ldp.oa.utils.proj.DeleteMode;

@Service(value="departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> 
	implements DepartmentService{
	
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;

	@Override
	protected BaseDao<Department> getBaseDao() {
		return departmentDao;
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteEntityById(Serializable id) {

		departmentDao.deleteDepartmentById(id,
				DeleteMode.DELETE_MODE_PRE_DETACH);
	}

}
