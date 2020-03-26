package com.heima.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Noticebill;
import com.heima.service.Customer;
import com.heima.service.CustomerService;
import com.heima.service.NoticebillService;
@Controller("noticebillAction")
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill> {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private NoticebillService noticebillService;
	//根据电话 查询客户的方法
	public String findCustomerByTelephone(){
		Customer findCustomerByTelphone = customerService.findCustomerByTelphone(model.getTelephone());
		java2Json(findCustomerByTelphone, new String[]{});
		return null;
	}
	//添加业务清单的方法
	public String add(){
		noticebillService.save(model);
		return "noticebill_add";
}
}