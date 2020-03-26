package com.heima.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.domain.Category;
import com.heima.domain.Product;
import com.heima.service.ProductService;

public class ProductUpudateUi extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ProductService productAddUi=new ProductService();
		    List<Category>categorylist= productAddUi.findAllCateogry();
		request.setAttribute("categorylist", categorylist);
		String pid=request.getParameter("pid");
		ProductService productUpdataUi=new ProductService();
	Product product=productAddUi.UpdateproductUi(pid);
	request.setAttribute("product", product);
	request.getRequestDispatcher("/admin/product/edit.jsp").forward(request, response);
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}