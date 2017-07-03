package com.ldp.oa.basedata.action;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ldp.oa.basedata.actionform.LoginForm;
import com.ldp.oa.basedata.domain.User;
import com.ldp.oa.basedata.service.UserService;
import com.ldp.oa.common.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<LoginForm> {
	
	@Resource(name="userService")
	private UserService userService;

	public String loginPrepare() throws Exception{
		
		return "loginPrepare";
	}

	public String validateLogin() throws Exception{
		
		LoginForm model = getModel();

		String username = model.getUsername();
		if(username == null || username.length() == 0){
			this.addActionError("用户名必须输入");
		}
		
		String password = model.getPassword();
		if(password == null || password.length() == 0){
			this.addActionError("密码必须输入");
		}else{

			Pattern passwordPattern = Pattern.compile("\\w{6,30}");
			Matcher matcher = passwordPattern.matcher(password);
			boolean result = matcher.matches();
			if(result == false){
				this.addActionError("密码只能是字母或数字，且6-30位");
			}
		}
		
		if(this.hasActionErrors()){
			return "fail";
		}
		
		User user = userService.getUserByUsername(username);
		
		if(user == null){
			this.addActionError("用户不存在");
			return "fail";
		}
		
		boolean isEquals = password.equals(user.getPassword());
		
		if(isEquals){
			
			Map<String,Object> sessionMap = ActionContext.getContext().getSession();
			sessionMap.put(User.USER_SESSION_ID, user);
			
			return "validateLoginSuccess";
		}else{
			this.addActionError("密码错误");
			return "fail";
		}
	}
	
	public String logout() throws Exception{
		
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		sessionMap.remove(User.USER_SESSION_ID);
		
		return "logout";
	}
	
}
