package day30.jdbc.DButils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import day29.jdbc.jdbcutil.JDBCutile;

public class ArarylisthandlerDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con =JDBCutile.getconnection();
		QueryRunner qy=new QueryRunner();
		 String sql="SELECT * FROM student";
		 List<Object[]>list=qy.query(con, sql,new ArrayListHandler());
         for(Object []objs:list){
        	 for(Object obj:objs){
        		 System.out.print(obj+"\t");
        		 
        	 }
        	 System.out.println("");
         }
         DbUtils.closeQuietly(con);
	}

}
