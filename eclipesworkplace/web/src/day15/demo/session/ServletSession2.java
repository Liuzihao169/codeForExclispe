package day15.demo.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletSession2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session的持久化时间，自己设置一个cookie可以存储ID，并且设置它持久化的时间
		HttpSession session = request.getSession();
		String se=(String) session.getAttribute("name");
		Cookie cook=new Cookie("JESESSIONID",se);
		cook.setPath("/web/");
		response.addCookie(cook);
		cook.setMaxAge(60*10);
		response.getWriter().write(se);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}