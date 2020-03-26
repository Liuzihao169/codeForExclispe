package com.xiaomi.dao;

import com.xiaomi.entity.User;

public interface UserDao {
	//用户 登陆
		User userlogin(String username, String password);
	//注册
		int regist(User user);
		//注册时判断用户是否存在
		boolean Checkusername(User user);
}
