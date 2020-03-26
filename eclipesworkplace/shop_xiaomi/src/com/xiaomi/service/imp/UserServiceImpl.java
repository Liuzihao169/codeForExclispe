package com.xiaomi.service.imp;

import com.xiaomi.dao.UserDao;
import com.xiaomi.dao.impl.UserDaoImpl;
import com.xiaomi.entity.User;
import com.xiaomi.service.UserService;

public class UserServiceImpl implements UserService{
		private UserDao userDao = new  UserDaoImpl();
	public User userlogin(String username, String password) {
		// TODO Auto-generated method stub
		return  userDao.userlogin( username,  password);
	}
	public boolean regist(User user){
		//先判断用户是否存在
		 boolean isExist = userDao.Checkusername(user);
		 //判断是否存在 ，如果存在那么返回false 到web层
		if(isExist){
			return false;
		}
		int regist = userDao.regist(user);
		return regist>0?true :false;
	}

}
