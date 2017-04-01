package com.ldp.oa.common.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	
	private T t;

	public static final String LIST_SUCCESS = "listSuccess";
	public static final String SAVE_PREPARE_SUCCESS = "savePrepareSuccess";
	public static final String SAVE_SUCCESS = "saveSuccess";
	public static final String UPDATE_PREPARE_SUCCESS = "updatePrepareSuccess";
	public static final String UPDATE_SUCCESS = "updateSuccess";
	public static final String DELETE_SUCCESS = "deleteSuccess";
	
	public static final String REDIRECT_TO_LIST_ACTION = "redirectToListAction";

	public BaseAction(){
		
		ParameterizedType paraType = 
			(ParameterizedType) this.getClass().getGenericSuperclass();
		Class classt = (Class) paraType.getActualTypeArguments()[0];
		try {
			t = (T) classt.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public T getModel() {
		return t;
	}
	
}
