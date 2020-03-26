package com.heima.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class Useraction extends ActionSupport {
	public String  login(){
		 System.out.println("i can very happy");
		return"tohome";
	}

}
