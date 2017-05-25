package com.ldp.oa.utils.result;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;

public class AjaxResult implements Result{

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		
		HttpServletResponse response = ServletActionContext.getResponse();

		ValueStack valueStack = ActionContext.getContext().getValueStack();
		String result = (String)valueStack.pop();
		
		PrintWriter writer = response.getWriter();
		writer.print(result);
	}

}
