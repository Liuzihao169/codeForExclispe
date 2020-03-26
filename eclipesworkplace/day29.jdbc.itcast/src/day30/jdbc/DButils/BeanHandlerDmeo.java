package day30.jdbc.DButils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import day29.jdbc.jdbclist.sort.Student;
import day29.jdbc.jdbcutil.JDBCutile;

public class BeanHandlerDmeo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=JDBCutile.getconnection();
		QueryRunner qy=new QueryRunner();
		 String sql="SELECT * FROM student";
		 Student stu=qy.query(con, sql, new BeanHandler<Student>(Student.class));
		 System.out.println(stu);
		 DbUtils.closeQuietly(con);
	}

}
