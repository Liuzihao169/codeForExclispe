package com.heima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.domain.Customer;

public interface Customerdao {

	void save(Customer c);

	List<Customer> findcustomerlist();

	List<Customer> findcustomerbyname(DetachedCriteria dc);

}
