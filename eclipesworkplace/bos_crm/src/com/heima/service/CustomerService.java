package com.heima.service;

import java.util.List;

import javax.jws.WebService;

import com.heima.entity.Customer;

/*
 * CustomerService 
 */
@WebService
public interface CustomerService {
	public List<Customer> findAll();
	public List<Customer> findNotAssocition();
	public List<Customer> findHasAssocition(String decidedzone_id);
	public void assigncustomerstodecidedzone(Integer [] ids,String id);
	//* 根据电话查询 客户的信息 在crm上扩展相应的方法
	public Customer findCustomerByTelphone(String telphone);
	//* 根据地址查询对应定区的id
	public String findDecidedzoneIdByAdderss(String address);
}
