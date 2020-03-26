package com.heima.service.imple;

import com.heima.dao.Userdao;
import com.heima.domain.User;
import com.heima.service.Userservice;

public class UserserviceImple implements Userservice{
	private Userdao userdao;
	@Override
	public User getUserByCodepassword(User u) {
		//根据用户名 判断用户名是否存在 ，如果不存在那么返回错误信息
	     User ExitU = userdao.getUserByuserCode(u.getUser_code());
	     System.out.println(ExitU+"11");
	     if(ExitU==null){
	    	 throw new RuntimeException("用户名错误");
	     }
		//如果用户存在那么 根据用户名，比对密码是否一致 不相同 返回登陆页面并且提示错误
	     if(!u.getUser_password().equals(ExitU.getUser_password())){
	    	 throw new RuntimeException("密码错误");
	     }
		//都正确 返回user  
		return u;
	}

	@Override
	public void save(User u) {
		//校验 登陆名 user_code 是否存在 如果如果存在 那么返回错误信息
		User exituser = userdao.getUserByuserCode(u.getUser_code());
		//如果是空那么抛出错误返回信息
		if(exituser!=null){
			throw new RuntimeException("该用户名已经存在");
		}
		userdao.save(u);
		
	}
	//使用set注入的方式注入userdao属性
	public void setUserdao(Userdao userdao) {
		this.userdao = userdao;
	}

	
}
