package com.heima.crm.service;

import com.heima.common.utils.Page;
import com.heima.crm.pojo.Customer;
import com.heima.crm.pojo.QueryVo;

public interface CustomerService {
	  public Page findPage(QueryVo vo);

	public Customer findCustomerById(Integer id);

	public void update(Customer cust);

	public void deleteById(Integer id);


}
