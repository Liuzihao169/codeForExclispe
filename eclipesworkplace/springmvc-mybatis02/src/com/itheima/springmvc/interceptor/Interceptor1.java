package com.itheima.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rep, Object obj) throws Exception {
			//判断是否是登陆压面 放行登陆页面
		String requestURI = req.getRequestURI();
		if(!requestURI.contains("login")){
			String attribute = (String) req.getSession().getAttribute("USERNAME");
			if(null==attribute){ 
				rep.sendRedirect(req.getContextPath()+"/login.jsp");
				return false;
			}
		}
		return true;
	}

}
