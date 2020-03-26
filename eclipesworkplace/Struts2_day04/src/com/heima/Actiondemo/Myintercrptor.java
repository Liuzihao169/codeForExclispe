package com.heima.Actiondemo;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Myintercrptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行拦截器之前");
		//放行，然后迭代走完20个拦截器
		arg0.invoke();
		System.out.println("执行拦截器之后");
		//最后提交字符success到result结果，处理跳转页面
		return "success";
	}

}
