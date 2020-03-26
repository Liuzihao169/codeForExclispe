package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.User;

import utils.DataSourceUtils;

public class LoginDao {

	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where username=? and password=?";
		User user=qy.query(sql, new BeanHandler<User>(User.class), username,password);
		return user;
	}

}
