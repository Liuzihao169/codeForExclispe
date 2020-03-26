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
		//session�ĳ־û�ʱ�䣬�Լ�����һ��cookie���Դ洢ID�������������־û���ʱ��
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