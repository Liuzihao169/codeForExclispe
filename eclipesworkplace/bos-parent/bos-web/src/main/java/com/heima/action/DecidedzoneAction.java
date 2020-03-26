package com.heima.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heima.bos.entity.Decidedzone;
import com.heima.service.Customer;
import com.heima.service.CustomerService;
import com.heima.service.DecidedzoneService;
/*
 * 定区
 */
@Controller("decidedzoneAction")
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
	@Autowired
	private DecidedzoneService decidedzoneService;
	@Autowired
	private CustomerService customerService;
	private List<Integer> customerIds;
	//findCustomerListByid?id="+data.id,
	private String [] subareaid;
	private String toCutomersid;
	public String add(){
	    decidedzoneService.save(model,subareaid);
		return "list";
	}
	public String pageQuery(){
		decidedzoneService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","subareas","decidedzones"});
		return null;
	}
	/**
	 * 加载没有被关联的客户
	 *
	 */
	public String findNotAssocition(){
		List<Customer> list = customerService.findNotAssocition();
		java2Json(list, new String[]{});
		return null;
	}
	/*8
	 *  根据定区id加载已经被关联的客户
	 */
	public String findHasAssocition(){
		List<Customer> list = customerService.findHasAssocition(model.getId());
		java2Json(list, new String[]{});
		return null;
	}
	/**
	 * 通过分区id查找相应的客户
	 * @return
	 */
	public String findCustomerListByid(){
		List<Customer> list = customerService.findHasAssocition(toCutomersid);
		java2Json(list, new String[]{});
		return null;
	}
	/*
	 * 
	 * 关联客户
	 */
	public String assigncustomerstodecidedzone(){
		customerService.assigncustomerstodecidedzone(customerIds , model.getId());
	  return null;
	}
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}
	public void setToCutomersid(String toCutomersid) {
		this.toCutomersid = toCutomersid;
	}

	
}
