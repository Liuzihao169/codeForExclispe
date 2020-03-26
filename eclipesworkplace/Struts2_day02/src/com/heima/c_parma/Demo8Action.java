package com.heima.c_parma;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Demo8Action extends ActionSupport implements ModelDriven<User>{
	//使用对象驱动的方式接收参数
	//要生成getset方法
	//利用成员变量的方法(成员变量是不包含get和set方法的  包含的叫做属性)
    private User user=new User();
	
	public String execute() throws Exception {
	System.out.println(user);
		return"success";
	}
	@Override
	public  User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
          
}
