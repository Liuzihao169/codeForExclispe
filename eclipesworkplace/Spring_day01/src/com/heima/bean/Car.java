package com.heima.bean;

public class Car {
	private String name;
	private String color;
	public Car(){
		System.out.println("这是调用car构造方法创建对象");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}

}
