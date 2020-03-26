package com.heima.bean;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable {

	/**
	 * 
	 */
	private User user;
	private Integer[] ids;
	private List<Integer>idsList;
	private static final long serialVersionUID = 1L;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public List<Integer> getIdsList() {
		return idsList;
	}
	public void setIdsList(List<Integer> idsList) {
		this.idsList = idsList;
	}
	
}
