package com.ldp.oa.common.service;

import java.io.Serializable;
import java.util.Collection;

public interface BaseService<T> {

	public void saveEntity(T t);
	
	public void deleteEntityById(Serializable id);
	
	public void updateEntity(T t);
	
	public T getEntityById(Serializable id);
	
	public Collection<T> getAllEntity();
	
}
