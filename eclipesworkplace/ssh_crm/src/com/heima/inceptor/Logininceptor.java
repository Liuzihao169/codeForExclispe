package com.heima.inceptor;

import java.util.Map;

import com.heima.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Logininceptor extends MethodFilterInterceptor {
	//	只要是经过拦截器的都判断是否登录
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//获得session域 取出当中的user 如果user存在 那么继续访问， 如果user不存在 那么重定向到登陆页面
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		//判断
		if(user==null){
			return "tologin";
		}
		return invocation.invoke();
	}

}
