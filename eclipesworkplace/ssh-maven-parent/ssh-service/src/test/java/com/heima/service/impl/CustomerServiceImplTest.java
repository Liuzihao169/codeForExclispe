package com.heima.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heima.entity.Customer;
import com.heima.service.CustomerService;
/*@ContextConfiguration(locations={"classpath:applicationContext-service.xml","classpath:applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {
	@Autowired
private CustomerService customerService;
	@Test
	public void test() {
		Customer findCustomerById = customerService.findCustomerById(2l);
		System.out.println(findCustomerById.getCust_name());
	}

}
*/