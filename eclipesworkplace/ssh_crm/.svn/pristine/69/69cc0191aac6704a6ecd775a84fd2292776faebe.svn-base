package com.heima.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heima.dao.Userdao;
import com.heima.domain.Customer;
import com.heima.domain.User;
import com.heima.service.Userservice;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demotest {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	@Test
	public void fun2(){
		Configuration cof=new Configuration ().configure();//加载配置文件
		SessionFactory sf=cof.buildSessionFactory();
		Session session = sf.openSession();
	     Customer c=new Customer();
	     c.setCust_name("liuzihao");
	     Transaction tx = session.beginTransaction();
	     session.save(c);
	     tx.commit();
	     session.close();	
	}
	@Test//配置hibernate.xml
	public void fun0(){
		//生成加载机制并且自动加载名为 hibernate.cfg.xml的文件里面的配置信息（主配置文件）
		Configuration cf=new Configuration().configure();
		//生成session工厂
		SessionFactory sf = cf.buildSessionFactory();
		//获得session
		Session session = sf.openSession();
		//开启事务并且获得事务
		Transaction ts = session.beginTransaction();
		//---------------------------------
		User u=new User();
		u.setUser_code("tom");
		u.setUser_name("汤姆");
		u.setUser_password("123456");
		session.save(u);
		//---------------------------------
		ts.commit();
		session.close();
		sf.close();
	}
	
	@Test//将hibernate.xml与spring结合
	public void fun3(){
		/*//生成加载机制并且自动加载名为 hibernate.cfg.xml的文件里面的配置信息（主配置文件）
		Configuration cf=new Configuration().configure();
		//生成session工厂
		SessionFactory sf = cf.buildSessionFactory();*/
		//获得session
		Session session = sf.openSession();
		//开启事务并且获得事务
		Transaction ts = session.beginTransaction();
		//---------------------------------
		User u=new User();
		u.setUser_code("罗拉");
		u.setUser_name("lory");
		u.setUser_password("123456");
		session.save(u);
		//---------------------------------
		ts.commit();
		session.close();
	}
	//spring整合hibernate操作数据库
	@Resource(name="userdao")
	private Userdao userdao ;
	@Test
	public void fun4(){
		User user = userdao.getUserByuserCode("tom");
		System.out.println(user);
		
	}
	
	
	
	//测试使用xml的方法配置aop事务 并且整合spring
	@Resource(name="userservice")
	private Userservice userservice;
	@Test
	public void fun5(){
		User u=new User();
		u.setUser_code("haohao");
		u.setUser_name("浩浩");
		u.setUser_password("123456");
		userservice.save(u);
	}
}
