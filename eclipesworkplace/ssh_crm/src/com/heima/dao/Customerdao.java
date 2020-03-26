package com.heima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.heima.domain.Customer;

public interface Customerdao extends BaseDao<Customer>{


	List<Customer> findlist(DetachedCriteria criteria, Integer index, Integer currentCount);

	Integer findcountByname(DetachedCriteria criteria);

	List<Object[]> findindustyCount();

}
