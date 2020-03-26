package day29.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获得数据库的连接
		String url = "jdbc:mysql://localhost:3306/mm1";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stat = con.createStatement();
		// int row= stat.executeUpdate("INSERT INTO student
		// VALUES(6,'刘大大',101)");
		// System.out.println(row);只能执行 增 删 改
		String sql = "select *from student;";
		ResultSet rus = stat.executeQuery(sql);
		while (rus.next()) {
			System.out.println(rus.getInt("id") + "   " + rus.getString("studentname") + "   " + rus.getInt("grade"));

		}

		con.close();
	stat.close();
  }
}
