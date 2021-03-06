package com.heima.a_action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.heima.domain.Customer;
import com.heima.service.Customerservice;
import com.heima.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer=new Customer();
	private Integer currentCount;
	private Integer currentPage;
	private Customerservice customerservice;
	
	public String list(){
		//创建离线查询对象
		DetachedCriteria criteria =DetachedCriteria.forClass(Customer.class);
		if(customer.getCust_name()!=null){
			//参数名称要用
			criteria.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
		}
		//如果不为空那么，那么就是不设置条件 就是查询所有
		//获得pageBean
		//System.out.println("111111111"+getCurrentPage()+ getCurrentCount());
		PageBean pb=customerservice.getpageBean(criteria,currentCount,currentPage);
		//将pageBean放入request域当中 然后转发
		ActionContext.getContext().put("pb", pb);
		return "listcustomer";
		
	}
	public String add(){	
		System.out.println(customer);
		customerservice.save(customer);
		return "tolist"; 
	}
	public String toEdit(){
		//根据cust_id 查询customer 然后发送到request域当中 
		Customer c=customerservice.getById(customer.getCust_id());
		//存储在request域当中
		ActionContext.getContext().put("customer", c);
		//转发到edit页面 
		//在前台回显
		return "toedit";
	}
	public String industyCount(){
		//直接sql原生查询的方式
		List<Object[]>list=customerservice.findindustyCount();
		//将list直接转发到industyCount.jsp页面进行显示
		ActionContext.getContext().put("list", list);
		return "industyCount";
	}
	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public Integer getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}

	public Integer getCurrentPage() {
		return currentPage; 
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setCustomerservice(Customerservice customerservice) {
		this.customerservice = customerservice;
	}
	
}
