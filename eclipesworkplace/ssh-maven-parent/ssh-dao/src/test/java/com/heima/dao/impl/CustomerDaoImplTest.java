package com.heima.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heima.dao.CustomerDao;
import com.heima.entity.Customer;
@ContextConfiguration("classpath:applicationContext-dao.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoImplTest {
	@Autowired
private CustomerDao customerdao;
	@Test
	public void test() {
		Customer findCustomerById = customerdao.findCustomerById(2l);
		System.out.println("888888888"+findCustomerById.getCust_name());
	}

}
