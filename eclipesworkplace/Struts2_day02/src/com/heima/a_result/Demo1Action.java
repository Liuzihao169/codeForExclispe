package com.heima.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport{
	public String hello(){
		System.out.println("demo1action");
		return "success";
	}

}
