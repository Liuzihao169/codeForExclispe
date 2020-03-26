package com.heima.action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.entity.Customer;
import com.heima.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("CustoemrAction")
@Scope("prototype")
public class CustomerAction extends ActionSupport{
	@Autowired
	private CustomerService customerService;
	private Long id;
	public String findNameById(){
		System.out.println(id);
		Customer custoemrbyid = customerService.findCustomerById(id);
		ActionContext.getContext().put("custoemrbyid", custoemrbyid);
		return "success";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
