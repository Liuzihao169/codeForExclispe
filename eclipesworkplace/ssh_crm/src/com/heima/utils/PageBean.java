package com.heima.utils;

import java.util.List;

public class PageBean {
	//当前页数
	private Integer currentPage;
	//当前条数(每一页的条数)
	private Integer currentCount;
	//总的页条数
	private Integer totalPage;
	//总条数
	private Integer totalCount;
	//返回的customerlist集合
	private List list;
	
	//强制创建对象一定要传入的几个参数
	public PageBean(Integer currentPage, Integer currentCount, Integer totalCount) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.currentCount = currentCount;
		//如果是第一访问的 传过来的阐述为空，设置默认为第一页
		if(this.currentPage==null){
			this.currentPage=1;
		}
		//如果传过来每页的条数是null  那么默认的是每页3条
		
		if(this.currentCount==null){
			this.currentCount=3;
		}
		//进一步判断传过来的currentcount的合法性
		if(this.currentPage<1){
			this.currentPage=1;
		}
	      this.totalPage=(this.totalCount+this.currentCount-1)/this.currentCount;
	    if(this.currentPage>this.totalPage){
	    	this.currentPage=this.totalPage;
	    }
		  
	
	}
	public Integer getIndex(){
		return (this.currentPage-1)*this.currentCount;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", currentCount=" + currentCount + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", list=" + list + "]";
	}
	
	
	
}
