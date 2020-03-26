package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Userservice;

public class Checkusername extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.首先这个是个异步校验要在js中使用ajsx实现
		 * 2.绑定失去焦点的事件onblue
		 * 使用$.post()传递数据 到web层 使用三层架构传递数据
		 * 3.然后接收从数据库接收到的返回值
		 * 4.根据返回值判断用户是否存在
		 * 5.然后根据ajax通过servlet返回的json对象间接的反应用户是否存在、
		 * 要加强jquery*/
		
		
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		Userservice userservice=new Userservice();
	  int folg=userservice.CheckUsername(username);
	  System.out.println(folg);
	  if(folg==1){
         response.getWriter().write("{\"folg\":\"用户名已经存在\"}");
	  }else{
		  response.getWriter().write("{\"folg\":\"用户名可以使用\"}");
	  }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}