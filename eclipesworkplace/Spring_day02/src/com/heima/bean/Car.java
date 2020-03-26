package com.heima.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("car")
public class Car {
	@Value("兰博基尼")
	private String name;
	@Value("白色")
	private String color;
	public Car(){
		System.out.println("执行构造方法创建car");
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
