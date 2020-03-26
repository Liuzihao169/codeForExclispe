package cn.jdbc.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class c3p0utilsDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=C3p0Utils.getconnection();
		 String sql="select * from stu";
	   	  PreparedStatement pst=con.prepareStatement(sql);
	   	  ResultSet rs=pst.executeQuery();
	while(rs.next()){
	   		  System.out.println( rs.getInt("id")+rs.getString("name")+rs.getString("gender"));
	   		  
	   	  }
				

	}

}
