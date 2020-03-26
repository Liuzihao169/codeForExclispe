package com.heima.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heima.domain.Product;
import com.heima.service.ProductService;
import com.heima.vo.PageBean;

public class ProductListClothes extends HttpServlet {
	// 分页技术
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int currentcount = 12;
		// ProductService productlist=new ProductService();
		// List<Product>list=productlist.findAllPhone();
		String current = request.getParameter("currentpage");
		int currentpage = 0;
		//第一次访问时默认为零
		if (current == null || current.equals("")) {
			currentpage = 1;
		} else {
			currentpage = Integer.parseInt(current);
		}

		ProductService productListClothes = new ProductService();
		PageBean<Product> pageBean = null;
		try {
			pageBean = productListClothes.findPageBean(currentpage, currentcount);
			// request.setAttribute("list", list);
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}