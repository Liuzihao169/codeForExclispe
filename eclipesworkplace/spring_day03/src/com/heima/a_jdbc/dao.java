package com.heima.a_jdbc;

import java.util.List;

import com.heima.bean.User;

public interface dao {
	//��
	void save(User u);
	//ɾ��
	void delete(Integer i);
	//��
	void update(User u);
	//�鵥��
	User find(Integer id);
	//��count
	Integer findAllcount();
	//��list
	List<User>findall();

}
