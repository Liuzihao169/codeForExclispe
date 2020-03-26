package day30.jdbc.DButils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import day29.jdbc.jdbcutil.JDBCutile;

public class DButilsDmeo1 {
	public static void main(String [] args) throws SQLException{
		Connection con=JDBCutile.getconnection();
		QueryRunner qry=new QueryRunner();
		String sql="UPDATE student SET studentname=?,grade=? WHERE id=?";
		Object [] obj1={"ÓÆÓÆ",56,3};
		int row=qry.update(con,sql,obj1);
		System.out.println(row);
	}

}
