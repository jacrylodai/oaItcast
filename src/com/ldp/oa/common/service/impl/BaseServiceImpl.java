package com.ldp.oa.common.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.ldp.oa.common.dao.BaseDao;
import com.ldp.oa.common.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	
	protected abstract BaseDao<T> getBaseDao();

	@Override
	@Transactional(readOnly=false)
	public void deleteEntityById(Serializable id) {

		getBaseDao().deleteEntityById(id);
	}

	@Override
	public Collection<T> getAllEntity() {
		
		return getBaseDao().getAllEntity();
	}

	@Override
	public T getEntityById(Serializable id) {
		
		return getBaseDao().getEntityById(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void saveEntity(T t) {

		getBaseDao().saveEntity(t);
	}

	@Override
	@Transactional(readOnly=false)
	public void updateEntity(T t) {

		getBaseDao().updateEntity(t);
	}

	@Override
	@Transactional(readOnly=false)
	public void deleteEntity(T t) {

		getBaseDao().deleteEntity(t);
	}

}
