package com.xiaomi.service;

import com.xiaomi.entity.User;

public interface UserService {
	//用户 登陆
	User userlogin(String username, String password);
	public boolean regist(User user);
}
