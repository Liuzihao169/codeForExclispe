package com.heima.dao;

import com.heima.entity.Customer;

public interface CustomerDao {
	public Customer findCustomerById(Long id);
}
