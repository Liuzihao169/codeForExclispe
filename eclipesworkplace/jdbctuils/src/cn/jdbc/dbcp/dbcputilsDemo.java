package cn.jdbc.dbcp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

public class dbcputilsDemo {
	public static void main(String[] args) throws SQLException{
		Connection con=dbcputilsproperties.getConnection();
		System.out.println(con);
		QueryRunner qy=new QueryRunner();
		String sql="select*from product";
		try{
		List<Object[]>list=qy.query(con,sql,new ArrayListHandler());
		for(Object[] obj:list){
			for(Object objs:obj){
				System.out.println(objs);
			}
		}
		}catch(Exception ex){
			
		}
	}

}
