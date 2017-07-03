package com.ldp.oa.aop;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * AOP异常处理类
 * @author jacrylodai
 *
 */
public class OAExceptionHandler {
	
	private static final Logger logger = 
			Logger.getLogger(OAExceptionHandler.class);
	
	public static final String EXCEPTION_MESSAGE_KEY = "exceptionMessageKey";

	public void handleException(Exception ex){
		
		logger.info("OAExceptionHandler:handleException");
		
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.getContext().put(EXCEPTION_MESSAGE_KEY, ex.getMessage());

		logger.error(ex.getMessage(), ex);
	}
	
}
