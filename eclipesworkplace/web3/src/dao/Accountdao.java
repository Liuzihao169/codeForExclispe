package dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import utils.C3p0Utils;

public class Accountdao {

	public void transferout(Connection con,String out, double money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner();
		String sql="update account set money=money-? where name=?";
		
			qy.update(con, sql, money,out);
	}

	public void transferint( Connection con ,String in, double money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner();
		String sql="update account set money=money+? where name=?";
		
			qy.update(con, sql, money,in);
		
		
	}

	
	}
	
