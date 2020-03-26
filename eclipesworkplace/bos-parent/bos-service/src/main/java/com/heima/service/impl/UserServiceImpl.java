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
	//�Ǹ�object����
	@Override
	public void excuteUpdate(String queryName, Object... object) {
		userdao.excuteUpdate(queryName, object);
	}
	public void save(User model, String[] roleTD) {
		//�ȱ��� �־û�����
		//Ȼ�����ó־û����ݵĸı�ᶯ̬�ĸı����ݿ������ �����ݿ�Ĺ�ϵ����ά��
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
