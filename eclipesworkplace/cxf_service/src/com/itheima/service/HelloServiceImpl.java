package com.itheima.service;

public class HelloServiceImpl implements HelloService{
	public String sayHello(String name) {
		System.out.println("这是服务器调用hello");
		return "hello " + name;
	}
}
