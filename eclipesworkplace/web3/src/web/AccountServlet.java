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
	/*	String out="����";
		String in="����";
		double money=1000;*/
				
		 AccountService accountService=new AccountService();
		 accountService.transfer(out, in, money);
		/* boolean folg=
		 if(folg){
			 response.getWriter().write("ת��ʧ��");
		 }
		 else{
			 response.getWriter().write("ת�˳ɹ�");
		 }*/
		
		 
				 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}