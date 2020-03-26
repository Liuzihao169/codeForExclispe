package com.heima.a_jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.heima.bean.User;

public class Daoimple  implements dao {
	// 需要spring容器注入模板
	private JdbcTemplate jt;
	@Override
	public void save(User u) {
        String sql="INSERT INTO t_user VALUES(NULL,?)"	;
        jt.update(sql, u.getName());
	}
	//删除
	@Override
	public void delete( Integer id) {
		String sql = "delete from t_user where id=?";
		jt.update(sql, id);

	}

	@Override
	public void update( User u) {
         String sql="update t_user set name=? where id=?";
         jt.update(sql, u.getName(),u.getId());
	}

	@Override
	public User find(Integer id) {
		String sql="select * from t_user where id=?";
		 return jt.queryForObject(sql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}}, id);
		
	}
	//查询所有的总数
	@Override
	public Integer findAllcount() {
		String sql="select count(*) from t_user";
		return jt.queryForObject(sql, Integer.class);
	}

	@Override
	public List<User> findall() {
		String sql="select * from t_user";
	List<User>list=	jt.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}});
		return list;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}



	

}
