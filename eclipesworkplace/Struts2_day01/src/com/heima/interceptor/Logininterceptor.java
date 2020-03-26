package com.heima.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Logininterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//从session中拿到对象
          Object object = session.get("user");
		if(object==null){
			//判断如果为空，那么就跳转到登陆页面
			
			return "tologin";
		}
		else{
		    //不为空那么放行
			return invocation.invoke();
		}
	}

}
