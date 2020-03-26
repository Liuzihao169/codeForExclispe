package day30.jdbc.DButils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import day29.jdbc.jdbcutil.JDBCutile;

public class MapHandleDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=JDBCutile.getconnection();
		QueryRunner qy=new QueryRunner();
		 String sql="SELECT * FROM student";
		 Map<String,Object>map=qy.query(con, sql, new MapHandler());
     for(String key:map.keySet()){
    	 System.out.println(key+"\t"+map.get(key));
     }
     DbUtils.closeQuietly(con);
	}

}
