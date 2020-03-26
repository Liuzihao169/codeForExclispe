package day15.demo.rescontent;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serveltcontent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String[]str=request.getParameterValues("hoppy");
		System.out.println(username+password);
		Map<String, String[]> parameterMap = request.getParameterMap();
		for(Map.Entry<String, String[]> entrey:parameterMap.entrySet()){
			System.out.println(entrey.getKey());
			for(String str1:entrey.getValue()){
				System.out.println(str1);
			}
			System.out.println("-----------------------");
			
		}
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}