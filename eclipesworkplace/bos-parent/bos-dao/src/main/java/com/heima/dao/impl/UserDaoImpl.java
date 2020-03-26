package com.heima.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.heima.bos.entity.Function;
import com.heima.bos.entity.User;
import com.heima.dao.UserDao;
/*
 * 
 * */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findUserByUsernameAndPassWord(User u) {
		//hql语句当中不会出现数据库的信息 这个是面向对象的查询
		String hql="from User where username=? and password=?";
		List<User> findUser = (List<User>) this.getHibernateTemplate().find(hql, u.getUsername(),u.getPassword());
		if(findUser!=null&&findUser.size()>0){
			return findUser.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public User findUserByUserName(String username) {
		//hql语句当中不会出现数据库的信息 这个是面向对象的查询
		String hql="from User where username=? ";
		List<User> findUser = (List<User>) this.getHibernateTemplate().find(hql, username);
		if(findUser!=null&&findUser.size()>0){
			return findUser.get(0);
		}else{
			return null;
		}
	}
	//
	
	
}
