package com.heima.service;

import com.heima.bos.entity.User;
import com.heima.utils.PageBean;

public interface UserService {
	public User findById(String Id);
	//��½�鿴���ݿ��Ƿ���ڸ��û�
	User findUserByUsernameAndPassWord(User u); 
	public void excuteUpdate(String queryName, Object... object) ;
	public void save(User model, String[] roleTD);
	public void pageQuery(PageBean pageBean);
}
