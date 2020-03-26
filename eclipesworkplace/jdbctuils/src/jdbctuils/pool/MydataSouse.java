package jdbctuils.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import jdbctuils.web.TextUtils;

public class MydataSouse implements DataSource {
	  private static Connection con;
	 private static LinkedList <Connection> pool= new LinkedList <Connection>();
	 static{
		 for(int i=0;i<5;i++){
		 Connection con=TextUtils.getconnection();
		 pool.add(con);
	                       }
		   }
	  
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		if(pool.size()==0){//如果他是空的就添加
			
			 for(int i=0;i<5;i++){
				 Connection con=TextUtils.getconnection();
				 pool.add(con);
			                       }
		}
		 System.out.println("取出之前"+pool.size());
		 Connection con=pool.remove(0);
		 System.out.println("取出之后"+pool.size());
		return con;
	}
	
	public void backConnection(Connection con){
		pool.add(con);
		System.out.println("放回之后"+pool.size());
		
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
