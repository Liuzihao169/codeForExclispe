package com.heima.service.imple;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.heima.dao.Userdao;
import com.heima.dao.imple.UserdaoImple;
import com.heima.domain.User;
import com.heima.service.Userservice;
import com.heima.utils.HibernateUtils;

public class UserserviceImple implements Userservice {

	private Userdao userdao ;

	@Override
	public User login(User user) {
		//service需要开启事物
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
	    User u_coed=userdao .login(user.getUser_code());
	     ts.commit();
		//判断用户名是否存在，如果用户名不存在， 返回错误
	    if(u_coed==null){
	    	throw new RuntimeException("用户名不存在");
	    	}
	    if (!user.getUser_password().equals(u_coed.getUser_password())){
	    	throw new RuntimeException("密码错误");
	    }
		
		//如果用户名存在的话判断是否密码匹配，匹配返回user， 否则那么就抛出密码错误的错误
		return user;
	}

	public void setUserdao(Userdao userdao) {
		this.userdao = userdao;
	}

	

}
