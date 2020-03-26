package jdbctuils.web;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TextUtils {
	 private static Connection con;
	
	static{
		try{
		//FileInputStream fis=new FileInputStream("dp.properties");
		InputStream in=TextUtils.class.getClassLoader().getResourceAsStream("dp.properties");
		Properties pro=new Properties();
		pro.load(in);
		String driver=pro.getProperty("driver");
		String url=pro.getProperty("url");
		String user=pro.getProperty("user");
		String password=pro.getProperty("password");
		Class.forName(driver);
		con=DriverManager.getConnection(url, user, password);
		
	}
		catch(Exception ex){
			System.out.println(ex);
			
		}
}
	public static Connection getconnection(){
		return con;
	}
}	

