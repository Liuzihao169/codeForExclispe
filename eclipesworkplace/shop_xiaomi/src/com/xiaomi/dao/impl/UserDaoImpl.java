package com.xiaomi.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xiaomi.dao.UserDao;
import com.xiaomi.entity.User;
import com.xiaomi.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {

	public User userlogin(String username, String password) {
		// 通过连接池 拿到DataSource
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from t_user where username=? and password=?";
		User user=null;
		try {
			user=qy.query(sql, new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		return user;
	}
	public int regist(User user) {
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into t_user(username,password) values(?,?)";
		//如果插入数据成功那么返回1
		int row=0;
		try {
			 row = qy.update(sql, user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	@Override
	public boolean Checkusername(User user) {
		QueryRunner qy=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select count(*) from t_user where username=?";
		Long count=null;
		try {
			count=(Long) qy.query(sql, new ScalarHandler(),user.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count.intValue()>0?true:false;
	}
	
}
