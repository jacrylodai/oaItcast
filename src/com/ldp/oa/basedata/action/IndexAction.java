package com.ldp.oa.basedata.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport{

	public String siteIndex() throws Exception{
		
		return "siteIndex";
	}

	public String leftPage() throws Exception{
		
		return "leftPage";
	}
	
	public String topPage() throws Exception{
		
		return "topPage";
	}

	public String rightPage() throws Exception{
		
		return "rightPage";
	}

	public String bottomPage() throws Exception{
		
		return "bottomPage";
	}
	
}
