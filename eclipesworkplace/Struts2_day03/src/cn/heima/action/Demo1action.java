package cn.heima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1action extends ActionSupport {
	public  String action1(){
		System.out.println("aaaaa1");
		return"success";
	}

}
