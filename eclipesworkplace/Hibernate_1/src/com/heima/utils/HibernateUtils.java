package com.heima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static  SessionFactory sessionFactory ;
	/*
	 * 保证此次代只运行一次，能够使得session在整个web应用下就是加载一次*/
	 static{
		//创建并且读取指定的配置文件
		 Configuration conf=new Configuration().configure();
		 //创建工厂sessionFactory
		  sessionFactory = conf.buildSessionFactory();
		 //通过工厂获得session
	 }
	public static Session getopeanSession(){
		
		 Session session=sessionFactory.openSession();
		 return session;
		
	}
	
	public static Session getcurrentSession(){
		
		 Session session=sessionFactory.getCurrentSession();
		 return  session;
		
	}
}
