package day29.jdbc.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCutileText {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection con=JDBCutile.getconnection();
		String sql="SELECT * FROM student";
	PreparedStatement pst=	con.prepareStatement(sql);//���ִ��sql����
       ResultSet rst=	pst.executeQuery();//ִ��sql select���
       while(rst.next()){
    	   System.out.println(rst.getInt("id")+"   "+rst.getString("studentname")+"   "+rst.getString("grade"));
       }
       
		

	}

}
