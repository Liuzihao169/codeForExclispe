package com.heima.b_aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {
	public void before(){
		System.out.println("前置通知");
	}
	public void after(){
		System.out.println("后置通知如果出现异常不会调用");
	}
	public  Object   arround( ProceedingJoinPoint procee) throws Throwable{
		//把连接点传进来了
		System.out.println("环绕通知之前的方法");
		Object proceed = procee.proceed();
		System.out.println("环绕通知之后的方法");
		return proceed;
	}
	public void afterRunner(){
		System.out.println("这是后置处理， 出现异常后可以执行");
	}
}
