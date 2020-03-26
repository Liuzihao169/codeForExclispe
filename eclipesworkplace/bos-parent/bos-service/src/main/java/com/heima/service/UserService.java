package com.heima.service;

import com.heima.bos.entity.User;
import com.heima.utils.PageBean;

public interface UserService {
	public User findById(String Id);
	//登陆查看数据库是否存在该用户
	User findUserByUsernameAndPassWord(User u); 
	public void excuteUpdate(String queryName, Object... object) ;
	public void save(User model, String[] roleTD);
	public void pageQuery(PageBean pageBean);
}
