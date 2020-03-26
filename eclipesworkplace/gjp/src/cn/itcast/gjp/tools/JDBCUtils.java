package cn.itcast.gjp.tools;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	 private static BasicDataSource datasource=new BasicDataSource();
   static{
	   datasource.setDriverClassName("com.mysql.jdbc.Driver");
	   datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
	   datasource.setUsername("root");
	   datasource.setPassword("root");    
	   }
   public static DataSource getDataSource(){
	   return datasource;
   }
   
   }

