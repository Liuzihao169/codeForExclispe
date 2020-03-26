package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.C3p0Utils;

public class Userdao {

	public int CheckUsername(String username) {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(C3p0Utils.getDataSource());
		String sql="SELECT COUNT(*) FROM USER WHERE username=?";
		Long flog;
		try {
			flog = (Long)qy.query(sql, new ScalarHandler(),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return flog.intValue();
	}

	

}
