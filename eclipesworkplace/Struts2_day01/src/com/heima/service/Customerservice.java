package com.heima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.domain.Customer;

public interface Customerservice {

	void save(Customer c);

	List<Customer> findcustomerlist();

	List<Customer> findcustomerbyname(DetachedCriteria dc);

	List<Customer> findcustomerlistByname(DetachedCriteria dc);

	List<Customer> findAll(DetachedCriteria dc);

}
