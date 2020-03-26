 package com.heima.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.heima.domain.Customer;
import com.heima.service.Customerservice;
import com.heima.service.imple.CustomerserviceImple;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	    private Customer customer=new Customer();
	   //客户列表 
	    public String listcustomer() throws Exception {
	    	//获得servletcontext
	    	ServletContext sc = ServletActionContext.getServletContext();
	    	//servletcontext域中获得applicationcontext容器 即  spring的容器,
		    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
		    //向application当中索要  名为 “customerservice” 的对象
		    Customerservice service=  (Customerservice) webApplicationContext.getBean("customerService");
		// TODO Auto-generated method stub
		//接收参数
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		//创建离线查询对象
		DetachedCriteria dc= DetachedCriteria.forClass(Customer.class);
		List<Customer>list=null;
		//System.out.println("cus_name"+cust_name);
		//传递数据
		/*
		 * 其实可以一个like查找查找包含条件的，和不包含条件的
		 * 
		 * */
           if(StringUtils.isNotBlank(cust_name)){
        	//   System.out.println("1111111");
        	   dc.add(Restrictions.like("cust_name","%"+cust_name+"%" ));
        	 list=service.findcustomerlistByname(dc);
        //	 System.out.println(list);
           }//判断是否为空
           else{//如果是空的那么传离线criteria
        	  list=service.findAll(dc);  
        	//System.out.println(list);
           }
		//将结果集存储到request于当中
          // ServletActionContext.getRequest().setAttribute("list", list);
           ActionContext.getContext().put("list", list);//直接存储在ActionContext中去
		return "list";
	}
	    public String addCustomer(){
	    	//获得servletcontext
	    	ServletContext sc = ServletActionContext.getServletContext();
	    	//servletcontext域中获得applicationcontext,
		    WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
		    Customerservice service=  (Customerservice) webApplicationContext.getBean("customerService");
	      service.save(customer);
	    	return "tolist";
	    }

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	

}
