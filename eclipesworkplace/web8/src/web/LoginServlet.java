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
	   //ͨ���Ǹ���������
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
			 * �û���¼����*/
			//�û���½�ɹ��� 
			//��½�ɹ�֮ǰҪ�ж��Զ���½�Ƿ�ѡ��
			//���Ǳ�ѡ�У�����浽cookie��
			
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
		//���ص�½ҳ�沢�Ҹ����û��������Ƿ��¼
		else{
			System.out.println("���Ǵ����");
			request.setAttribute("info", "�û�����������dfgs��");
			//request.setAttribute("info", "�û��������������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}