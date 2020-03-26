package com.heima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.domain.Customer;
import com.heima.utils.PageBean;

public interface Customerservice {

	PageBean getpageBean(DetachedCriteria criteria, Integer currentCount, Integer currentPage);

	void save(Customer customer);

	Customer getById(Long cust_id);

	List<Object[]> findindustyCount();


	


}
