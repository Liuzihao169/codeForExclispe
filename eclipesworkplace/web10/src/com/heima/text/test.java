package com.heima.text;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.heima.domain.Customer;

public class test {
    @Test
     public void fun1(){
	      
	  
			//创建并且读取指定的配置文件
			 Configuration conf=new Configuration().configure();
			 //创建工厂sessionFactory
			 SessionFactory SessionFactory = conf.buildSessionFactory();
			 //通过工厂获得session
			 Session session=SessionFactory.openSession();
			 //开启并且获得事物，这是推荐的一种方法
			 Transaction tx = session.beginTransaction();
			 Customer cus=new Customer();
			 cus.setCust_name("刘子豪大大");
			 session.save(cus);
			 session.close();
			 SessionFactory.close(); 
			 }
   @Test
 public void test2(){
		//创建并且读取指定的配置文件
		 Configuration conf=new Configuration().configure();
		 //创建工厂sessionFactory
		 SessionFactory SessionFactory = conf.buildSessionFactory();
		 //通过工厂获得session
		 Session session=SessionFactory.openSession();
		 //开启并且获得事物，这是推荐的一种方法
		 Transaction tx = session.beginTransaction();
		 
		 Customer cus=new Customer();
		 Customer customer = session.get(Customer.class, 1l);
		 System.out.println(customer);
		 tx.commit();
		 session.close();
		 SessionFactory.close();
		 }
		
   @Test
 public void test3(){
		//创建并且读取指定的配置文件
		 Configuration conf=new Configuration().configure();
		 //创建工厂sessionFactory
		 SessionFactory SessionFactory = conf.buildSessionFactory();
		 //通过工厂获得session
		 Session session=SessionFactory.openSession();
		 //开启并且获得事物，这是推荐的一种方法
		 Transaction tx = session.beginTransaction();
		 
		 Customer cus=new Customer();
		 Customer customer = session.get(Customer.class, 1l);
		 customer.setCust_name("liuizhao");
		 session.update(customer);
		 System.out.println(customer);
		 tx.commit();
		 session.close();
		 SessionFactory.close();
		 }
   
   //删除
   @Test
 public void test4(){
		//创建并且读取指定的配置文件
		 Configuration conf=new Configuration().configure();
		 //创建工厂sessionFactory
		 SessionFactory SessionFactory = conf.buildSessionFactory();
		 //通过工厂获得session
		 Session session=SessionFactory.openSession();
		 //开启并且获得事物，这是推荐的一种方法
		 Transaction tx = session.beginTransaction();
		 
		 Customer cus=new Customer();
		 Customer customer = session.get(Customer.class, 1l);
		session.delete(customer);
		 System.out.println(customer);
		 tx.commit();
		 session.close();
		 SessionFactory.close();
		 }
	}
    
       
    


