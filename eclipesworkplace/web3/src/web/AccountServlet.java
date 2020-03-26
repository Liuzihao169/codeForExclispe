package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;

public class AccountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");	
		request.setCharacterEncoding("UTF-8");
		String out=request.getParameter("outname");
		String in=request.getParameter("inname");
		 String money1=request.getParameter("moneysize");
		 double money=Double.parseDouble(money1);
	/*	String out="王五";
		String in="赵三";
		double money=1000;*/
				
		 AccountService accountService=new AccountService();
		 accountService.transfer(out, in, money);
		/* boolean folg=
		 if(folg){
			 response.getWriter().write("转账失败");
		 }
		 else{
			 response.getWriter().write("转账成功");
		 }*/
		
		 
				 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}