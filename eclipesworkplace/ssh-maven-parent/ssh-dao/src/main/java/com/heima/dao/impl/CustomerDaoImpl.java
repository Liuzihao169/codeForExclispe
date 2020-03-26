package com.heima.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.heima.dao.CustomerDao;
import com.heima.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	public Customer findCustomerById(Long id){
		return getHibernateTemplate().get(Customer.class,id);
	}

}
