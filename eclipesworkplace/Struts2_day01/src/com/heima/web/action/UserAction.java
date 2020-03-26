package com.heima.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.heima.domain.User;
import com.heima.service.Customerservice;
import com.heima.service.Userservice;
import com.heima.service.imple.UserserviceImple;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();

	public String login() {
		// 获得servletcontext
		ServletContext sc = ServletActionContext.getServletContext();
		// servletcontext域中获得applicationcontext,
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
		Userservice userservice = (Userservice) webApplicationContext.getBean("userService");
		System.out.println(user + "this");
		User u = userservice.login(user);
		// 如果返回了user 那么就把user传入session域当中
		ActionContext.getContext().getSession().put("user", u);
		// 重定向到index中，说明登陆成功，加入标识

		return "tomyhome";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
