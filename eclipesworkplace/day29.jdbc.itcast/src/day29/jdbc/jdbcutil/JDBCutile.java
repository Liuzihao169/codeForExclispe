package day29.jdbc.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutile {
	private  static Connection con;
	private JDBCutile(){};
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/mm1";
		String user = "root";
		String password = "root";
		 try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//¾²Ì¬´úÂë¿é
	}
	public static Connection getconnection(){
		return con;
	}

}
