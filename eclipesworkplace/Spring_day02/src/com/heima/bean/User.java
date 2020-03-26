package com.heima.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
/*
 * @service 
 * @controller 
 * @repository 
 * */
public class User {
	@Value("刘大明")
	private String name;
	@Value("18")
	private Integer age;
	//指定注入名字为car的对象
	@Resource(name="car")
	private Car car;
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public User(){
		System.out.println("使用构造函数创建对象");
	}
	public String getName() {
		return name;
	}
	@PostConstruct//在执行构造函数之后，
	public void init(){
		System.out.println("执行创建的方法");
	}
	@PreDestroy
	public void destory(){
		System.out.println("执行销毁之后的方法");
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
	
}
