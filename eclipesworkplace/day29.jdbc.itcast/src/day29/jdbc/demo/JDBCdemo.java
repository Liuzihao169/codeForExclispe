package day29.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ע������
		Class.forName("com.mysql.jdbc.Driver");
		// ������ݿ������
		String url = "jdbc:mysql://localhost:3306/mm1";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stat = con.createStatement();
		// int row= stat.executeUpdate("INSERT INTO student
		// VALUES(6,'�����',101)");
		// System.out.println(row);ֻ��ִ�� �� ɾ ��
		String sql = "select *from student;";
		ResultSet rus = stat.executeQuery(sql);
		while (rus.next()) {
			System.out.println(rus.getInt("id") + "   " + rus.getString("studentname") + "   " + rus.getInt("grade"));

		}

		con.close();
	stat.close();
  }
}
