package day30.jdbc.DBCP;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPpoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       BasicDataSource datasource=new BasicDataSource();
       datasource.setDriverClassName("com.mysql.jdbc.Driver");
       datasource.setUrl("jdbc:mysql://localhost:3306/mm1");
       datasource.setUsername("root");
       datasource.setPassword("root");
       try {
		Connection con=datasource.getConnection();
		System.out.println(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
	}

}
