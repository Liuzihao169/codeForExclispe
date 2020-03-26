package com.heima.bean;

public class User {
	private String name;
	private Integer age;
	private Car car;
	public User( String name,Car car){
		System.out.println("----- User( String name,Car car)--------");
		this.name=name;
		this.car=car;
		
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public User(){
		System.out.println("执行空参数构造方法创建对象");
	}
	public String getName() {
		return name;
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
