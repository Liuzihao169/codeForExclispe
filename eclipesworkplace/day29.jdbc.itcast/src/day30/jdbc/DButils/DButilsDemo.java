package day30.jdbc.DButils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import day29.jdbc.jdbcutil.JDBCutile;
//¡¢Ìí¼ÓÊý¾Ý
public class DButilsDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=JDBCutile.getconnection();
		QueryRunner qry=new QueryRunner();
		String sql="INSERT INTO student (id,studentname,grade)VALUES(?,?,?)";
		Object [] obj={9,"mimi",199};
		int row=qry.update(con, sql, obj);
		System.out.println(row);
		con.close();

	}

}
