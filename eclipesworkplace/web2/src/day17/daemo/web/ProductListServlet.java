package day17.daemo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day17.daemo.service.ProductService;
import day17.demo.domin.Product;

public class ProductListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService=new ProductService();
	List<Product>ProductList=productService.findProduct();
	 /*request.setAttribute("ProductList", ProductList);
	 request.getRequestDispatcher("/product_list.jsp").forward(request, response);*/
	 
	for(Product pro:ProductList){
		System.out.println(pro.getPimage());
	}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}