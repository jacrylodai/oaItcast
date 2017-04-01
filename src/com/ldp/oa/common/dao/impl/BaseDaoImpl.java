package com.ldp.oa.common.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.ldp.oa.common.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	protected HibernateTemplate hibernateTemplate;
	
	private Class classType;
	
	public BaseDaoImpl(){
		
		ParameterizedType paraType = 
			(ParameterizedType) this.getClass().getGenericSuperclass();
		classType = (Class)paraType.getActualTypeArguments()[0];
		
		System.out.println("rawType:"+paraType.getRawType());
		System.out.println("ownerType:"+paraType.getOwnerType());
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void deleteEntityById(Serializable id) {

		T t = getEntityById(id);
		hibernateTemplate.delete(t);
	}

	@Override
	public Collection<T> getAllEntity() {
		
		String hql = "from " + classType.getSimpleName();
		System.out.println("hql:"+hql);
		
		return hibernateTemplate.find(hql);
	}

	@Override
	public T getEntityById(Serializable id) {
		
		return (T)hibernateTemplate.get(classType, id);
	}

	@Override
	public void saveEntity(T t) {

		hibernateTemplate.save(t);
	}

	@Override
	public void updateEntity(T t) {

		hibernateTemplate.update(t);
	}

}
