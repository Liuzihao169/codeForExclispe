package com.itheima.service;

public class HelloServiceImpl implements HelloService{
	public String sayHello(String name) {
		System.out.println("���Ƿ���������hello");
		return "hello " + name;
	}
}
