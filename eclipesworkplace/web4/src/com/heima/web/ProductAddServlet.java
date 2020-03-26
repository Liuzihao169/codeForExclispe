package com.heima.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.heima.domain.Product;
import com.heima.service.ProductService;

public class ProductAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post���ύ��ʽ���������ı��뷽ʽ   
		request.setCharacterEncoding("UTF-8");
		try {
			Product product=new Product();
			//���ݷ�װ��bean���󣬷���洢
			BeanUtils.populate(product, request.getParameterMap());
			//������Ҫ��װ���������
			/*
			 * pid
			 * pimage
			 * pdate
			 * pflag�Ƿ��¼�*/
			product.setPid(UUID.randomUUID().toString());
			product.setPimage("products/1/c_0050.jpg");
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");//��ʽ������
			Date date=new Date();
			String time=format.format(date);
			product.setPdate(time);
			product.setPflag(1);
			ProductService productAdd=new ProductService();
			productAdd.Addproduct(product);
			response.sendRedirect(request.getContextPath()+"/productListServlet");
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}