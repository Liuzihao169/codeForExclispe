package day29.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCdemo3 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.jdbc.Driver");// ע������
		String url = "jdbc:mysql://localhost:3306/mm1";
		String user = "root";
		String password = "root";
		// �������
		Connection con = DriverManager.getConnection(url, user, password);// �������
        String sql="SELECT * FROM student";
       PreparedStatement pst= con.prepareStatement(sql);
      ResultSet rus= pst.executeQuery();//����һ��result�Ľ����
      while(rus.next()){
    	  System.out.println(rus.getInt("id") + "   " + rus.getString("studentname") + "   " + rus.getInt("grade"));
    	  
      }
      rus.close();
      pst.cancel();
      con.close();//�ر���Դ
	} 

}
