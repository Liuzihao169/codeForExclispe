package com.heima.common.utils;

import java.util.List;

public class Page<T> {
    
	private Integer  total;
	private Integer  page;
	private Integer  size;
    private List<T> rows;
   

	public Integer  getTotal() {
		return total;
	}
	public void setTotal(Integer  total) {
		this.total = total;
	}
	public Integer  getPage() {
		return page;
	}
	public void setPage(Integer  page) {
		this.page = page;
	}
	public Integer  getSize() {
		return size;
	}
	public void setSize(Integer  size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
