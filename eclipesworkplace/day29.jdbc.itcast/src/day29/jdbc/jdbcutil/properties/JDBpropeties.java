package day29.jdbc.jdbcutil.properties;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBpropeties {
	public static void main(String[]args) throws Exception{
		FileInputStream fis=new FileInputStream("D:\\abc\\driver.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String driver=pro.getProperty("driver");
		String url=pro.getProperty("url");
		String user="root";
		String password="root";
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		System.out.println(con);
		
	}
	

}
