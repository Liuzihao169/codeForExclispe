package com.xiaomi.entity;

public class Product {

	/*
	 * 
	 * `id` varchar(32) NOT NULL, `pname` varchar(50) DEFAULT NULL,
	 * `market_price` double DEFAULT NULL, `shop_price` double DEFAULT NULL,
	 * `pimage` varchar(200) DEFAULT NULL, `pdate` date DEFAULT NULL, `is_hot`
	 * int(11) DEFAULT NULL, `pdesc` varchar(255) DEFAULT NULL, `pflag` int(11)
	 * DEFAULT NULL, `cid` varchar(32) DEFAULT NULL,
	 * pid pname market_price  shop_price pimage pdate is_hot pdesc pflag
	 */
	private String pid;
	private String pname;
	private double price;
	private String pimage;
	private String pdesc;
	private String pversion;
	public String getPid() {
		return pid;
	}
	public String getPversion() {
		return pversion;
	}
	public void setPversion(String pversion) {
		this.pversion = pversion;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	
	
}

