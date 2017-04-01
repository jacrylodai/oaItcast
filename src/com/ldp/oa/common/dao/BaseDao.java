package com.ldp.oa.common.dao;

import java.io.Serializable;
import java.util.Collection;

public interface BaseDao<T> {

	public void saveEntity(T t);
	
	public void deleteEntityById(Serializable id);
	
	public void updateEntity(T t);
	
	public T getEntityById(Serializable id);
	
	public Collection<T> getAllEntity();
	
}
