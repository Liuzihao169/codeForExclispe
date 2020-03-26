package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import day17.demo.domin.Product;
import utils.C3p0Utils;

public class ProductList extends HttpServlet {
     //准备所有商品的集合
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      QueryRunner qy=new QueryRunner(C3p0Utils.getDataSource());
      String sql="select *from product";
      List<Product>list=null;
      try {
		 list=qy.query(sql, new BeanListHandler<Product>(Product.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     /* request.setAttribute("list", list);
      request.getRequestDispatcher("/product_list.jsp").forward(request, response);*/
      for(Product pro:list){
    	 System.out.println(pro.getPimage()); 
    	  System.out.println(pro.getPanme());
      }

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}