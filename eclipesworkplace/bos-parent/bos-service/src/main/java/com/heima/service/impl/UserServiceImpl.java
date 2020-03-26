package com.heima.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.heima.bos.entity.Role;
import com.heima.bos.entity.User;
import com.heima.dao.UserDao;
import com.heima.service.UserService;
import com.heima.utils.PageBean;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;
	@Override
	public User findById(String Id) {
		// TODO Auto-generated method stub
		return userdao.findById(Id);
	}
	@Override
	public User findUserByUsernameAndPassWord(User u) {
		// TODO Auto-generated method stub
		return userdao.findUserByUsernameAndPassWord(u);
	}
	//是个object数组
	@Override
	public void excuteUpdate(String queryName, Object... object) {
		userdao.excuteUpdate(queryName, object);
	}
	public void save(User model, String[] roleTD) {
		//先保存 持久化数据
		//然后利用持久化数据的改变会动态的改变数据库的属性 对数据库的关系进行维护
		userdao.save(model);
		for (String id : roleTD) {
			Role role = new Role(id);
			model.getRoles().add(role);
		}
	}
	public void pageQuery(PageBean pageBean) {
		userdao.pageQuery(pageBean);
	}
}
