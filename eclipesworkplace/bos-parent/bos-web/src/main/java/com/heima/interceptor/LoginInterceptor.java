package com.heima.interceptor;

import com.heima.bos.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User  user = (User) ActionContext.getContext().getSession().get("user");
		//���session���в����� ��ô�����ط��ص���½ҳ��
		if(user==null){
			return "tologin";
		}
		return invocation.invoke();
	}
}
