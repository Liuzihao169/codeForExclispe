package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.LoginService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //通过那个接收数据
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginService loginservice=new LoginService();
		User user=null;
		HttpSession session = request.getSession();
		System.out.println("asfasd");
		try {
			 user=loginservice.login(username,password);
			 System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null){
			/*
			 * 
			 * 用户登录成立*/
			//用户登陆成功； 
			//登陆成功之前要判断自动登陆是否被选中
			//若是被选中，把其存到cookie中
			
			if(request.getParameter("autologin")!=null){
				Cookie username_cookie=new Cookie("username",user.getUsername());
				Cookie password_cookie=new Cookie("password",user.getPassword());
				username_cookie.setMaxAge(60*60);
				password_cookie.setMaxAge(60*60);
				username_cookie.setPath("/web8");
				password_cookie.setPath("/web8");
				response.addCookie(password_cookie);
				response.addCookie(username_cookie);
			}
			session.setAttribute("user", user);
			
			response.sendRedirect(request.getContextPath());
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		//返回登陆页面并且告诉用户名或者是否登录
		else{
			System.out.println("这是错误的");
			request.setAttribute("info", "用户名或者密码dfgs错处");
			//request.setAttribute("info", "用户名或者密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}