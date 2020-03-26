package com.heima.c_parma;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo6Action extends ActionSupport{
	//要生成getset方法
     private String username;
     private Integer age;
     private Date birthday;
	public String execute() throws Exception {
		System.out.println("username"+ username);
		System.out.println("age"+ age);
		System.out.println("username"+birthday );
		return"success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
		
          
}
