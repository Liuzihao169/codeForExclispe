package jdbctuils.web1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcu {
	 private static Connection con;
	static{
		try{
		//FileInputStream fis=new FileInputStream("D:\\abc\\driver.properties");
		InputStream fis=jdbcu.class.getClassLoader().getResourceAsStream("dp.propreties");
			Properties pro=new Properties();
		pro.load(fis);
		String driver=pro.getProperty("driver");
		String url=pro.getProperty("url");
		String user="root";
		String password="root";
		Class.forName(driver);
		 con=DriverManager.getConnection(url, user, password);
	}catch(Exception ex){
		
	}
}
	 public static Connection getconnection(){
		 return con;
	 }
	 public static void release( Connection con,PreparedStatement pst){
		 if(con!=null){
			 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(pst!=null){
			 try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 }
	}
