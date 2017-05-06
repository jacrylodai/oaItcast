package com.ldp.oa.basedata.dao.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.ldp.oa.basedata.dao.DepartmentDao;
import com.ldp.oa.basedata.domain.Department;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.common.dao.impl.BaseDaoImpl;
import com.ldp.oa.utils.proj.DeleteMode;

@Repository(value="departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {

	@Override
	public void deleteDepartmentById(Serializable departmentId, int deleteMode) {

		Department department = 
			(Department) getHibernateTemplate().get(Department.class, departmentId);
		if(DeleteMode.DELETE_MODE_NORMAL == deleteMode){
			
			getHibernateTemplate().delete(department);
		}else
			if(DeleteMode.DELETE_MODE_PRE_DETACH == deleteMode){
				
				Set<User> userSet = department.getUserSet();
				Iterator<User> userIt = userSet.iterator();
				while(userIt.hasNext()){
					User user = userIt.next();
					user.setDepartment(null);
					getHibernateTemplate().save(user);
				}
				
				getHibernateTemplate().delete(department);
			}else
				if(DeleteMode.DELETE_MODE_CASCADE == deleteMode){
					
					//do no support
				}
	}

}
