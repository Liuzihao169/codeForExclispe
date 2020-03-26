package com.heima.test;

import com.opensymphony.xwork2.ActionSupport;

public class DemoAction extends ActionSupport{
	public String text(){
		System.out.println("this is a test");
		return "hh";
	}
	
}
