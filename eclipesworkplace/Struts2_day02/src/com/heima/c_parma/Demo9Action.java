package com.heima.c_parma;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Demo9Action extends ActionSupport {
	//使用集合方式接收对象
	//要生成getset方法
    //使用成员属性的方法 
	private List<String>list;
	public List<String> getList() {
		return list;
	}


	public void setList(List<String> list) {
		this.list = list;
	}


	public Map<String, String> getMap() {
		return map;
	}


	public void setMap(Map<String,String> map) {
		this.map = map;
	}


	private Map<String,String>map;
	
	
	public String execute() throws Exception {
	System.out.println(list);
	System.out.println(map);
		return"success";
	}
	
	
          
}
