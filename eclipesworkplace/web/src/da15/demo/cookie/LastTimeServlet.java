package da15.demo.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		Cookie cookie = new Cookie("LastAccessTime", time);
		response.addCookie(cookie);
		Cookie[] cookies = request.getCookies();
		String ti=null;
		for(Cookie coo:cookies){
			if ((coo.getName()).equals("LastAccessTime")) {
				ti = coo.getValue();
//				if(ti==null){
//					response.getWriter().write("這是你第一次訪問該網站");
//				}
			
				
			}
		}
		if(ti==null){
			response.getWriter().write("这是你第一次访问该网站");
		}
		else{
		response.getWriter().write("你上次的访问时间是" +ti);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}