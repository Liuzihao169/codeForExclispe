package cn.heima.servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("hello haohao...servlet");
		ServletContext con=getServletContext();
		//String driver=con.getInitParameter("driver");
		//System.out.println(driver);
	 String realpath_a=con.getRealPath("/a.txt");
	 String realpath_b=con.getRealPath("/WEB-INF/b.txt");
	 String path= ContextServlet.class.getClassLoader().getResource("5.txt").getPath();
	 response.getWriter().write("hello haohao...servlet"+realpath_a+"--------"+realpath_b);
	System.out.println(path);
	con.setAttribute("name", "zhangsan");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}