package com.heima.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heima.dao.CustomerDao;
import com.heima.entity.Customer;

public class CustomerDaoImplTest {

	@Test
	public void test() {
		//加载配置文件，获得applicationContext容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		//用接口来接收
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerdao");
		
		Customer customer = customerDao.findCustomerById(1l);
		System.out.println("888888888888"+customer.getCust_name());
	}

}
