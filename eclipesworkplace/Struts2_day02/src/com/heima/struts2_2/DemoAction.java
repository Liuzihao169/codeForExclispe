package com.heima.struts2_2;

public class DemoAction {
	public String add(){
		System.out.println("添加客户");
		return "success";
	
	}
	public String delete(){
		System.out.println("删除客户");
		return "success";
	
	}
	public String update(){
		System.out.println("更新客户");
		return "success";
	
	}
	public String find(){
		System.out.println("查找客户");
		return "success";
	
	}
}
