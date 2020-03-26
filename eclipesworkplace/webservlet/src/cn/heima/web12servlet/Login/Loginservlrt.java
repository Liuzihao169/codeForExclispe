package cn.heima.web12servlet.Login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.heimai.domain.User;
import utilspropertise.C3p0Utils;

public class Loginservlrt extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		int count=1;
		this.getServletContext().setAttribute("count", count);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8"); 
		String username= request.getParameter("username");
		    String password =request.getParameter("password");
		    System.out.println(password+"szv");
		    System.out.println(username);
		    response.setCharacterEncoding("UTF-8");
			//告诉浏览器你使用个是utf-8的编码方式
			response.setHeader("Content-Type", "text/html;charset=UTF-8");
		   QueryRunner qy=new QueryRunner( C3p0Utils.getDataSource());
		  String sql="select * from user where username=? and password=?";
		  if(username==null||username.equals(""
				  )){
			  response.getWriter().write("用户名密码不能为空 ");
			  return;
			  
		  }
		 User user=null;
		  try {
			user=qy.query(sql,  new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  if(user==null){
			  response.getWriter().write("sorry your username or password is wrong ");
		  }
		  else{
			  ServletContext con=getServletContext();
			 Integer count= (Integer) con.getAttribute("count");
			  response.getWriter().write(user.toString()+"doing right"+"you are succed person"+count);
			  count++;
			  con.setAttribute("count", count);
		  }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}