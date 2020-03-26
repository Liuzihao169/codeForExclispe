package cn.jdbc.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Democ3p0 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method st 但是
		ComboPooledDataSource datasource=new ComboPooledDataSource();//自动加载配置文件，参数自己传进去
		 Connection con=datasource.getConnection();
		 String sql="select * from product";
   	  PreparedStatement pst=con.prepareStatement(sql);
   	  ResultSet rs=pst.executeQuery();
while(rs.next()){
   		  System.out.println( rs.getString("pid")+rs.getString("pname")+rs.getDouble("price")+rs.getString("category_id"));
   		  
   	  }
	}

}
