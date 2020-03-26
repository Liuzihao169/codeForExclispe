package com.heima.c_parma;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo7Action extends ActionSupport{
	//使用对象驱动的方式接收参数
	//要生成getset方法
    private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String execute() throws Exception {
	System.out.println(user);
		return"success";
	}
	
          
}
