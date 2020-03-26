package com.heima.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.heima.domain.Customer;
import com.heima.service.Customerservice;
import com.heima.service.imple.CustomerserviceImple;

public class AddcustomerServlce extends HttpServlet {
      //接口实现类的方法
	private Customerservice customerservice = new  CustomerserviceImple();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 // request.setCharacterEncoding("utf-8");
		Customer c=new Customer();
		try {
			// 结束客户信息
			BeanUtils.populate(c, request.getParameterMap());
			//调用service方法
			customerservice.save(c);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//重定向到list
		response.sendRedirect(request.getContextPath()+"/listcustomer");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}