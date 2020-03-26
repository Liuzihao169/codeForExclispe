package day15.demo.register;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import day15.demo.domainuser.User;
import utils.C3p0Utils;
public class Servletregister extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*1.��������
		 * 2.�����ݷ�װ��һ��Javabeanʵ��
		 * �������ݿ�*/
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		 String checkcode_session=(String)request.getSession().getAttribute("checkcode_session");
		 String paaacode=request.getParameter("passcode");
		 System.out.println(checkcode_session);
		 System.out.println(paaacode);
  if(!checkcode_session.equals(paaacode)){
         response.getWriter().write("�����֤�벻��ȷ");
//        	//request.getRequestDispatcher("/register").forward(request, response);
           return;//����ֱ�Ӳ���������Ĳ���
    
  }
		Map<String, String[]> properties = request.getParameterMap();
		//ӳ��map���ϸ�user��������Ӧ
		User user=new User(); 
		try {
			BeanUtils.populate(user, properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		user.setId(0);
		register(user);
		response.sendRedirect("/webservlet/login.html");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void register(User user){
		QueryRunner qy=new QueryRunner(C3p0Utils.getDataSource());
		String sql="insert into user values(?,?,?,?)";
	 try {
		qy.update(sql, user.getId(),user.getUsername(),user.getPassword(),user.getEmila());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		
	}
}