package cn.heima.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo2action extends ActionSupport {
	private String name;

	public  String action1(){
		name="axin";
		System.out.println("�ͰͰְ�");
		return"success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
