package com.heima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.heima.domain.Customer;
import com.heima.domain.LinkMan;
import com.heima.utils.HibernateUtils;

public class One2Manytest {
	@Test
	public void fun1(){
		/*
		 * 获得session
		 * 获得线程并且开启事物
		 * 操作
		 * 提交
		 * 释放资源*/
		Session session=HibernateUtils.getcurrentSession();
		Transaction beginTransaction = session.beginTransaction();
		Customer c=new Customer();
		LinkMan l1=new LinkMan();
		LinkMan l2=new LinkMan();
		c.setCust_name("传智播课");
		l1.setLkm_name("刘总");
		l2.setLkm_name("张总");
		
		//一对多
		c.getLinkMans().add(l1);
		c.getLinkMans().add(l2);
		
		//多对一
		l1.setCustomer(c);
		l2.setCustomer(c);
		//对他们进行进行持久化
	    session.save(c);
	    //session.save(l1);
	    //session.save(l2);
	    
	    beginTransaction.commit();//提交事物
	}
	//添加联系人
	@Test
	public void fun2(){
		/* 释放资源*/
		Session session=HibernateUtils.getcurrentSession();
		Transaction beginTransaction = session.beginTransaction();
		//获得要操作的客户对象
		Customer customer = session.get(Customer.class, 1l);
		//新建联系人
		LinkMan l3=new LinkMan();
		l3.setLkm_name("郝老师");	
		//添加到set中
		customer.getLinkMans().add(l3);
		
		l3.setCustomer(customer);
		
		session.save(l3);
		
		//不能忘记提价事务
		beginTransaction.commit();
	
	}
	//删除联系人
	@Test
	public void fun3(){
		/* 释放资源*/
		Session session=HibernateUtils.getcurrentSession();
		Transaction beginTransaction = session.beginTransaction();
		//获得要操作的客户对象
		Customer customer = session.get(Customer.class, 1l);
		customer.setCust_name("啦啦啦");
		//新建联系人
        LinkMan linkMan = session.get(LinkMan.class, 3l);
        linkMan.setCustomer(null);
		linkMan.setLkm_name(null);
		//不能忘记提价事务s
		beginTransaction.commit();
}

	
	 
	
}
