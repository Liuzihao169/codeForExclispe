package com.heima.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo5Action extends ActionSupport{
	public String hello(){
		System.out.println("demo5action");
		return "success";
	}

}
