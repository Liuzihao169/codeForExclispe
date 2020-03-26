package com.heima.a_action;

import com.heima.domain.User;
import com.heima.service.Userservice;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private Userservice userservice;
	private User user=new User();
	public  String login(){
		//执行登陆方法如果登陆成功把对象存入 
		//把对象存入session当中
		//重定向到首页 index.htm
		User userByCodepassword = userservice.getUserByCodepassword(user);
		ActionContext.getContext().getSession().put("user", userByCodepassword);
		return"success";
	}
	//用户注册页面、
	public String regist(){
		//从页面获得user对象
		
		//然后保存
		
		try {
			userservice.save(user);
		} catch (Exception e) {
			ActionContext.getContext().put("error", e.getMessage());
			//将错误信息转发到regist页面
			return "regist";
			// 
		}
		//跳转到登陆页面
		return "login";
	}
	public void setUserservice(Userservice userservice) {
		this.userservice = userservice;
	}
	@Override
	public User getModel() {
		//把user这个对象推进root栈当中
		return user;
	}
	
}
