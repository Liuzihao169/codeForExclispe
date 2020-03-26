package com.heima.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.heima.domain.Category;
import com.heima.domain.Product;
import com.heima.service.ProductService;

public class ProducSeachServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Product seachpro=new Product();
			try {
				BeanUtils.populate(seachpro, request.getParameterMap());
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProductService seachproduct=new ProductService();
			
				try {
					ProductService productAddUi=new ProductService();
				    List<Category>categorylist= productAddUi.findAllCateogry();
				    request.setAttribute("categorylist", categorylist);
					List<Product>productlist=seachproduct.ProductSeach(seachpro);
				//	System.out.println(seachpro);
					
					request.setAttribute("productlist", productlist);
					//将获取的数据转发到list.jsp页面上让他们进行读取
					request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}