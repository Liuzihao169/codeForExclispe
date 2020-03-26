package com.heima.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.heima.utils.JDBCUtils;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

public class demotest {
		@Test//测试连接oracle数据库
		/*
		 * 
		 * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}
   {call <procedure-name>[(<arg1>,<arg2>, ...)]}
*/
		
		/*
		 * 
		 * */
	public void test1(){
			ResultSet rs =null;
			String sql="{call mypackage.QUERYEMPLIST(?,?)}";
			Connection con=null;
			CallableStatement callsta=null;
			con=JDBCUtils.getConnection();
			
			try {
				callsta = con.prepareCall(sql);
				callsta.setInt(1,10);
				/*
				 * 对于返回的参数，需要声明*/
				callsta.registerOutParameter(2, OracleTypes.CURSOR);
				//执行 
				callsta.execute();
				//输出
				//强制转换成Oracle的类型的
				 rs = ((OracleCallableStatement)callsta).getCursor(2);
				//遍历result
				while(rs.next()){
					//取出一个员工
					String name=rs.getString("ename");
					System.out.println(name);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtils.release(con, callsta, rs);
			}
			
		}
		
		@Test
		public void text2(){
			String sql="{call selecttest(?,?,?,?)}";
			Connection con=null;
			CallableStatement callsta=null;
			con=JDBCUtils.getConnection();
			
			try {
				callsta = con.prepareCall(sql);
				callsta.setInt(1,7369);
				/*
				 * 对于返回的参数，需要声明*/
				callsta.registerOutParameter(2, OracleTypes.VARCHAR);
				callsta.registerOutParameter(3, OracleTypes.NUMBER);
				callsta.registerOutParameter(4, OracleTypes.VARCHAR);
				
				//执行 
				callsta.execute();
				//输出
				String pname = callsta.getString(2);
				int sal = callsta.getInt(3);
				String job = callsta.getString(4);
				System.out.println(pname+"\t"+sal+"\t"+job);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtils.release(con, callsta, null);
			}
			
			
		}
}
