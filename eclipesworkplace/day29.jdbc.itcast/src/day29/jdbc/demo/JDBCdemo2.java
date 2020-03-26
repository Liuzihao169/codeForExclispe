package day29.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCdemo2 {
	public static void  main(String []args)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");//ע������
		String url="jdbc:mysql://localhost:3306/mm1";
		String user="root";
		String password="root";
		//�������
		Connection con=DriverManager.getConnection(url, user, password);//�������
	   String sql="UPDATE student SET studentname=?,grade=? WHERE id=?";
	    //���Ԥ�������
	 PreparedStatement pst= con.prepareStatement(sql);
	 pst.setObject(1, "������");
	 pst.setObject(2, 52);
	 pst.setObject(3, 5);
	pst.executeUpdate();
	}

}
