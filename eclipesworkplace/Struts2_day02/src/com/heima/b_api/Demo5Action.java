package com.heima.b_api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo5Action extends ActionSupport{


	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//并且每次访问action都会创建一个action对象，所以说action是线程安全的
		//通过数据中心获得各个  域
		//没次请求都会创建一个对应的actioncontext对象
		//里面其实包含所有域的集合
		ActionContext.getContext().put("name", "this is request");
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("name", "this is session");
		
		Map<String, Object> application = ActionContext.getContext().getApplication();
		application.put("name", "this is application");
		return "success";
	}
		
          
}
