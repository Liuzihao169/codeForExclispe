package com.heima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.heima.domain.Customer;
import com.heima.service.Customerservice;
import com.heima.service.imple.CustomerserviceImple;
import com.heima.utils.HibernateUtils;

public class ListCustomerServlet extends HttpServlet {

	private Customerservice service=new CustomerserviceImple();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String cust_name=request.getParameter("cust_name");
	     DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
	     List<Customer>list=null;
	     if(cust_name!=null&&!"".equals(cust_name)){
	    	 dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
	    	list= service.findcustomerbyname(dc);
	     }else
		//从数据库读取数据，调用service层的方法， 向上寻找查取
		 list=service.findcustomerlist();
		request.setAttribute("customerlist", list);
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
		//转发数据
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}