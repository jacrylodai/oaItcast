package com.ldp.oa.basedata.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ldp.oa.basedata.dao.DepartmentDao;
import com.ldp.oa.basedata.domain.Department;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.utils.proj.DeleteMode;

public class DepartmentDaoImpl extends HibernateDaoSupport implements
		DepartmentDao {

	@Override
	public Collection<Department> getAllDepartment() {
		
		return getHibernateTemplate().find("from Department department");
	}

	@Override
	public Department getDepartmentById(Serializable departmentId) {
		
		Department department = 
			(Department) getHibernateTemplate().get(Department.class, departmentId);
		return department;
	}

	@Override
	public void saveDepartment(Department department) {
		
		getHibernateTemplate().save(department);
	}

	@Override
	public void updateDepartment(Department department) {
		
		getHibernateTemplate().update(department);
	}

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
					
					Set<User> userSet = department.getUserSet();
					Iterator<User> userIt = userSet.iterator();
					while(userIt.hasNext()){
						User user = userIt.next();
						getHibernateTemplate().delete(user);
					}
					getHibernateTemplate().delete(department);
				}
	}

}
