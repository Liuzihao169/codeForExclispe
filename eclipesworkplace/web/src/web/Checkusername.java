package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Userservice;

public class Checkusername extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.��������Ǹ��첽У��Ҫ��js��ʹ��ajsxʵ��
		 * 2.��ʧȥ������¼�onblue
		 * ʹ��$.post()�������� ��web�� ʹ������ܹ���������
		 * 3.Ȼ����մ����ݿ���յ��ķ���ֵ
		 * 4.���ݷ���ֵ�ж��û��Ƿ����
		 * 5.Ȼ�����ajaxͨ��servlet���ص�json�����ӵķ�Ӧ�û��Ƿ���ڡ�
		 * Ҫ��ǿjquery*/
		
		
		response.setContentType("text/html;charset=UTF-8");
		String username=request.getParameter("username");
		Userservice userservice=new Userservice();
	  int folg=userservice.CheckUsername(username);
	  System.out.println(folg);
	  if(folg==1){
         response.getWriter().write("{\"folg\":\"�û����Ѿ�����\"}");
	  }else{
		  response.getWriter().write("{\"folg\":\"�û�������ʹ��\"}");
	  }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}