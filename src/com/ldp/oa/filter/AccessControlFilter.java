package com.ldp.oa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ldp.oa.basedata.domain.User;

public class AccessControlFilter implements Filter{
	
	private static final String LOGIN_SERVLET_PATH_PREFIX = "/basedata/login";

	private static final String LOGIN_SERVLET_PATH = "/basedata/login/loginAction_loginPrepare.action";

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String contextPath = req.getContextPath();
		String requestURI = req.getRequestURI();
		String servletPath = req.getServletPath();
		
		if(servletPath.startsWith(LOGIN_SERVLET_PATH_PREFIX)){
			chain.doFilter(request, response);
			return;
		}else{
			
			User user = (User) req.getSession().getAttribute(User.USER_SESSION_ID);
			if(user == null){
				
				resp.sendRedirect(contextPath+LOGIN_SERVLET_PATH);
				return;
			}else{
				chain.doFilter(request, response);
				return;
			}
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
