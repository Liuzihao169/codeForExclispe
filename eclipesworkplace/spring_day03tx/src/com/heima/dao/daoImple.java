package com.heima.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class daoImple extends JdbcDaoSupport implements dao {

	@Override
	public void addMonery(Integer id, Double money) {
		String sql="update t_customer set money=money+? where id=?";
		getJdbcTemplate().update(sql, money,id);
		
	}

	@Override
	public void removeMonery(Integer id, Double money) {
		String sql="update t_customer set money=money-? where id=?";
		getJdbcTemplate().update(sql, money,id);
	}

}
