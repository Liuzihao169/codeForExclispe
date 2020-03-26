package com.heima.vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
  //当前页
	private int currentpage;
	//当前显示的条数
	private int currentcount;
	//总条数
	private int totalcount;
	//总页数量
	private int totalpage;
	private List<T>productList=new ArrayList<T>();
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getCurrentcount() {
		return currentcount;
	}
	public void setCurrentcount(int currentcount) {
		this.currentcount = currentcount;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List<T> getProductList() {
		return productList;
	}
	public void setProductList(List<T> productList) {
		this.productList = productList;
	}
}
