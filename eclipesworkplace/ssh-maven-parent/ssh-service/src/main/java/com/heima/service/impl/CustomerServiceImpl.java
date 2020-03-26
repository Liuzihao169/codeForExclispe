package com.heima.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heima.dao.CustomerDao;
import com.heima.entity.Customer;
import com.heima.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Resource(name="customerdao")
	private CustomerDao customerdao;
	@Override
	public Customer findCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerdao.findCustomerById(id);
	}

}
