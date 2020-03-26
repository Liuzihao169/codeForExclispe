package day29.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCdemo3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.jdbc.Driver");// 注册驱动
		String url = "jdbc:mysql://localhost:3306/mm1";
		String user = "root";
		String password = "root";
		// 获得连接
		Connection con = DriverManager.getConnection(url, user, password);// 获得驱动
        String sql="SELECT * FROM student";
       PreparedStatement pst= con.prepareStatement(sql);
      ResultSet rus= pst.executeQuery();//返回一个result的结果集
      while(rus.next()){
    	  System.out.println(rus.getInt("id") + "   " + rus.getString("studentname") + "   " + rus.getInt("grade"));
    	  
      }
      rus.close();
      pst.cancel();
      con.close();//关闭资源
	} 

}
