package day30.jdbc.DButils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import day29.jdbc.jdbclist.sort.Student;
import day29.jdbc.jdbcutil.JDBCutile;

public class BeanHandleListDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=JDBCutile.getconnection();
		QueryRunner qy=new QueryRunner();
		 String sql="SELECT * FROM student";
		 List<Student>list=qy.query(con, sql, new BeanListHandler<Student>(Student.class));
		 DbUtils.closeQuietly(con);
        for(Student stu:list){
        	System.out.println(stu);
        }
	}

}
