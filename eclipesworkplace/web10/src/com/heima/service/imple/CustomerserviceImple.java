package com.heima.service.imple;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.heima.dao.Customerdao;
import com.heima.dao.imple.CustomerdaoImple;
import com.heima.domain.Customer;
import com.heima.service.Customerservice;
import com.heima.utils.HibernateUtils;

public class CustomerserviceImple implements Customerservice {

	private Customerdao customerdao = new CustomerdaoImple();

	@Override
	public void save(Customer c) {
		// TODO Auto-generated method stub
          customerdao.save(c);
	}

	@Override
	public List<Customer> findcustomerlist() {
		// TODO Auto-generated method stub
		return customerdao.findcustomerlist();
	}

	@Override
	public List<Customer> findcustomerbyname(DetachedCriteria dc) {
	 
		Session session = HibernateUtils.getcurrentSession();
		Transaction beginTransaction = session.beginTransaction();
		// TODO Auto-generated method stub
		List<Customer>list=customerdao.findcustomerbyname(dc);
		beginTransaction.commit();
		return list;
	}

}
