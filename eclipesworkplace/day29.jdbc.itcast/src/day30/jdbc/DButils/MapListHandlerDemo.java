package day30.jdbc.DButils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import day29.jdbc.jdbcutil.JDBCutile;

public class MapListHandlerDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=JDBCutile.getconnection();
		QueryRunner qy=new QueryRunner();
		 String sql="SELECT * FROM student";
		 List<Map<String, Object>>list=qy.query(con, sql, new MapListHandler());
         for(Map<String,Object>map:list){
        	 for(String key: map.keySet()){
        		 System.out.print(key+"\t"+map.get(key));
        	 }
        	 System.out.println("");
         }
	}

}
