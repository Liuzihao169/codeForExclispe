package day14.demo.responsecontxt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//告诉response查询的码表是utf-8
		response.setCharacterEncoding("UTF-8");
		//告诉浏览器你使用个是utf-8的编码方式
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		//获得输出的对象
		PrintWriter writer=response.getWriter();
		writer.write("我爱你中国----------");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}