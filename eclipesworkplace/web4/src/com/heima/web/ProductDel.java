package com.heima.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.service.ProductService;

public class ProductDel extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 ProductService productdel=new ProductService();
	 String pid=request.getParameter("pid");
	 productdel.Delproduct(pid);
	 response.sendRedirect(request.getContextPath()+"/productListServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}