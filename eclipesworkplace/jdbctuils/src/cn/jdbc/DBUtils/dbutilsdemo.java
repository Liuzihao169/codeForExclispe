package cn.jdbc.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.jdbc.dbcp.dbcputilsproperties;

public class dbutilsdemo{
	public static void main(String[]args) throws SQLException{
		//直接获取数据源
		QueryRunner qy=new QueryRunner(dbcputilsproperties.getDataSource());
		String sql="select * from stu ";
		//Object [] params={1};
		 List<Map<String,Object>> list=qy.query(sql,new MapListHandler() );
		 for(Map<String,Object> map:list){
			 for(Entry<String, Object> key:map.entrySet()){
				 System.out.print(key.getValue()+"\t"+key.getKey()+"\t");
				 
				 
			 }
			 System.out.println();
		 }
//		 for(Map<String,Object>map:list){
//        	 for(String key: map.keySet()){
//        		 System.out.print(key+"\t"+map.get(key)+"\t");
//        	 }
//        	 System.out.println("");
//         }
	}
	}
	
