package com.heima.vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
  //��ǰҳ
	private int currentpage;
	//��ǰ��ʾ������
	private int currentcount;
	//������
	private int totalcount;
	//��ҳ����
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
