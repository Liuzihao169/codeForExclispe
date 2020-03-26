package com.heima.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.heima.domain.Role;
import com.heima.domain.User;
import com.heima.utils.HibernateUtils;

public class Many2Manytest {
 @Test
 public void fun1(){
	 //获得session
	  Session getopeanSession = HibernateUtils.getopeanSession();
	 //开启事务
	  Transaction beginTransaction = getopeanSession.beginTransaction();
	 //执行操作
	  User u1=new User();
	  User u2=new User();
	  u1.setUser_name("刘子豪");
	  u2.setUser_name("刘大大2");
	  Role rr1=new Role();
	  rr1.setRole_name("打工仔");
	  Role rr2=new Role();
	  rr2.setRole_name("搬砖工");
	  
	  
	  u1.getRoles().add(rr1);
	  u1.getRoles().add(rr2);
	  u2.getRoles().add(rr1);
	  u2.getRoles().add(rr2);
	  
	  getopeanSession.save(u1);
	  getopeanSession.save(u2);
	/*  getopeanSession.save(rr1);
	  getopeanSession.save(rr2);
	  */
	 //提交事务
	  beginTransaction.commit();
	 //结束资源
	  getopeanSession.close(); 
 }
 //解除搬砖工的角色
 @Test
 public void fun2(){
	 //获得session
	  Session getopeanSession = HibernateUtils.getopeanSession();
	 //开启事务
	  Transaction beginTransaction = getopeanSession.beginTransaction();
	 //执行操作
	  User user = getopeanSession.get(User.class, 1l);
	  System.out.println(user.getUser_name());
	  Role role = getopeanSession.get(Role.class, 1l);
	  //user.getRoles().remove(role);
	  getopeanSession.delete(user);
	 //两个都是持久化状态所以不用deleat
	  
	  
	 //提交事务
	  beginTransaction.commit();
	 //结束资源
	  getopeanSession.close(); 
 }
 
}
