package com.heima.dao.imple;

import org.hibernate.Query;
import org.hibernate.Session;

import com.heima.dao.Userdao;
import com.heima.domain.User;
import com.heima.utils.HibernateUtils;

public class UserdaoImple implements Userdao {

	@Override
	public User login(String user_code) {
		// TODO Auto-generated method stub
		//获得session
		Session session=HibernateUtils.getcurrentSession();
		//书写hql语句
		String hql="from User where user_code=?";
		//获得操作对象那
		Query qy = session.createQuery(hql);
		//添加条件
		qy.setParameter(0, user_code);
		//得到结果集合
		User user=(User) qy.uniqueResult();
		return user;
	}

}
