package com.heima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private static Connection con;
	private  static String driver="oracle.jdbc.OracleDriver";
	private static String url="jdbc:oracle:thin:@192.168.21.128:1521/orcl";
	private static String username="scott";
	private static String password="tiger";
	
	static{
		//加载数据库驱动
		try {
			Class.forName(driver);
			try {
				con=DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//获得连接
	public static Connection getConnection(){
		return con;
	}
	//定义方法释放数据库资源
	
	public static void release(Connection con,Statement st,ResultSet rs){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				con=null;//让java垃圾回收站 更快的来寻找它
				}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				st=null;
			}
		}
		
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				rs=null;
			}
		}
	}
}
