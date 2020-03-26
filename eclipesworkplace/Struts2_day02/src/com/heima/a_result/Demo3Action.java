package com.heima.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo3Action extends ActionSupport{
	public String hello(){
		System.out.println("demo3action");
		return "success";
	}

}
