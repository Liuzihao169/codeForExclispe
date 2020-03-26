package day14.demo.responsecontxt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Context extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����response��ѯ�������utf-8
		response.setCharacterEncoding("UTF-8");
		//�����������ʹ�ø���utf-8�ı��뷽ʽ
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		//�������Ķ���
		PrintWriter writer=response.getWriter();
		writer.write("�Ұ����й�----------");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}