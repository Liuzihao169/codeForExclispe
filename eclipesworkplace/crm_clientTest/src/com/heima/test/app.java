package com.heima.test;

import java.util.List;
import com.heima.service.Customer;
import com.heima.service.impl.CustomerService;
import com.heima.service.impl.CustomerServiceImplService;
public class app {
	public static void main(String[] args) {
		CustomerServiceImplService cs= new CustomerServiceImplService();
		CustomerService customerServiceImplPort = cs.getCustomerServiceImplPort();
		List<Customer> findAll = customerServiceImplPort.findAll();
		for (Customer customer : findAll) {
			System.out.println(customer);
		}
	}

}
