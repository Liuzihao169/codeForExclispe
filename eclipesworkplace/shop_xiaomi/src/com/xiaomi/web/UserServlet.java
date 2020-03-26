package com.xiaomi.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.xiaomi.entity.Cart;
import com.xiaomi.entity.User;
import com.xiaomi.service.UserService;
import com.xiaomi.service.imp.UserServiceImpl;

/**
 *
 *继承BasicServlet 
 *这个是用户模块
 */
public class UserServlet extends BasicServlet{
	//用户登陆的方法
	private String hint;
	private UserService userService=new UserServiceImpl();
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=userService.userlogin(username,password);
		if(user==null){
			//提示用户用户名或者密码不正确
			hint="您的用户名或密码不正正确";
			request.setAttribute("hint", hint);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;	
		}
		else{
			//如果不为空，那么久将个人信息储存在session域当中，然后转发到主页 并且显示用户的个人信息。
			session.setAttribute("user", user);
			//request.getContextPath()获得web工程项目
			//管理员与普通用户的权限跳转控制 admin root 
			String name=user.getUsername();
			if(name.equals("admin")||name.equals("root")){
				//管理员转发到管理的后台
				response.sendRedirect(request.getContextPath()+"/admin/home.jsp");
			}
			//普通用户到主页
		    response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
	//退出用戶的方法
	public void exituser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//退出的操作就是把session区域当中的user变成null
		HttpSession session = request.getSession();
		//同时也清空回收站
		   session.setAttribute("cart", null);
		   session.setAttribute("user", null);
		   response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	// 用户注册方法
		public void register(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			User user = new User();
			user.setPassword(password);
			user.setUsername(username);
			boolean  IsOrNotregist = userService.regist(user);
			if(!IsOrNotregist){
				hint="用户名已经存在";
				request.setAttribute("hint", hint);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}else{
				hint="注册成功,请登陆";
				request.setAttribute("hint", hint);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
}
