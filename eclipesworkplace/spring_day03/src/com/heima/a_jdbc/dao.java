package com.heima.a_jdbc;

import java.util.List;

import com.heima.bean.User;

public interface dao {
	//增
	void save(User u);
	//删除
	void delete(Integer i);
	//改
	void update(User u);
	//查单个
	User find(Integer id);
	//查count
	Integer findAllcount();
	//查list
	List<User>findall();

}
