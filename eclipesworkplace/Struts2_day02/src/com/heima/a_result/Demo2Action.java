package com.heima.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport{
	public String hello(){
		System.out.println("demo2action");
		return "success";
	}

}
