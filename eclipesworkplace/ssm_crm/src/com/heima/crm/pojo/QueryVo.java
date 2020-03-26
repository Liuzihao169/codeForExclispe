package com.heima.crm.pojo;

public class QueryVo {
	private String custName;
	private String custSource;
	private String  custIndustry;
	private String  custLevel;
	//在包装类中初始化参数
	private Integer page=1;
	
	private Integer size;
	
	private Integer start;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size=size ;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start =start;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName==null?null:custName.trim();
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource==null?null:custSource.trim();
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry==null?null:custIndustry.trim() ;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel ==null?null:custLevel.trim();
	}

	
}
