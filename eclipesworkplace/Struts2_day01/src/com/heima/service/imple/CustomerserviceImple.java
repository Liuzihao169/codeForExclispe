package com.heima.service.imple;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.heima.dao.Customerdao;
import com.heima.domain.Customer;
import com.heima.service.Customerservice;
import com.heima.utils.HibernateUtils;

public class CustomerserviceImple implements Customerservice {

	private Customerdao customerdao;

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

	@Override//筛选联系人
	public List<Customer> findcustomerbyname(DetachedCriteria dc) {
	 
		Session session = HibernateUtils.getcurrentSession();
		Transaction beginTransaction = session.beginTransaction();
		// TODO Auto-generated method stub
		List<Customer>list=customerdao.findcustomerbyname(dc);
		beginTransaction.commit();
		return list;
	}

	@Override//同样也是筛选，这个是为了熟悉再敲一遍代码
	public List<Customer> findcustomerlistByname(DetachedCriteria dc) {
		//获得session
		Session session=HibernateUtils.getcurrentSession();
		//获得并且开启事物
		Transaction ts = session.beginTransaction();
		//处理事务
		List<Customer>list=customerdao.findcustomerlistByname( dc);
		//提交事务
		ts.commit();
		return list;
		// TODO Auto-generated method stub
		
	}

	@Override//如果是空的 那么就查找全部的customerist
	public List<Customer> findAll(DetachedCriteria dc) {
		// 获得session
		Session session=HibernateUtils.getcurrentSession();
		//获得并且开启事物
		Transaction ts = session.beginTransaction();
		//执行事物
		 List<Customer> list=null ;
		try {
			list = customerdao.findAll(dc);
		} catch (Exception e) {
			// TODO: handle exception
			ts.rollback();
		}
		//提价事务
		 ts.commit();
		return list;
	}

	public void setCustomerdao(Customerdao customerdao) {
		this.customerdao = customerdao;
	}

	
	

}
