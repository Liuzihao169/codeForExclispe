package com.heima.utils;
public class HighchartsByPrivence {
	private String name;
	private Integer y;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public HighchartsByPrivence(String name, Integer y) {
		super();
		this.name = name;
		this.y = y;
	}
	public HighchartsByPrivence() {
	}
}
