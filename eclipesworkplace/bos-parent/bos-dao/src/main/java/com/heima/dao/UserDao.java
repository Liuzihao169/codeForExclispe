package com.heima.dao;


import com.heima.bos.entity.User;

public interface UserDao extends BaseDao<User> {
	User findUserByUsernameAndPassWord(User u);

	User findUserByUserName(String username);

	
}
