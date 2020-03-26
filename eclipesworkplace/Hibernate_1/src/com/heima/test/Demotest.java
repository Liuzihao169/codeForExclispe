package com.heima.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.heima.domain.Customer;
import com.heima.utils.HibernateUtils;

public class Demotest {
	//通用list方法查询到结果集 一个list解决全部问题
 
	@Test
	public void fun1(){
		Configuration cof=new Configuration ().configure();//加载配置文件
		SessionFactory sf=cof.buildSessionFactory();
		Session session = sf.getCurrentSession();
	     Customer c=new Customer();
	     c.setCust_name("liuzihao222");
	     Transaction tx = session.beginTransaction();
	     session.save(c);
	     c.setCust_name("持久化修改的测试");
	     tx.commit();
	     session.close();	
	}
	
	@Test
	public void fun(){
		Configuration cof=new Configuration ().configure();//加载配置文件
		SessionFactory sf=cof.buildSessionFactory();
		Session session = sf.getCurrentSession();
	     Transaction tx = session.beginTransaction();
	     Customer cus= session.get(Customer.class, 1l);
	     String cust_name = cus.getCust_name();
	     System.out.println(cust_name);
	      cus.setCust_name("持久化修改的测试");
	     tx.commit();
	     session.close();	
	}
	
	//批量查找 Hql里面不包括sql语句
	@Test 
	public void fun2(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		String Hql="from Customer";
		Query qy=session.createQuery(Hql);
		//qy.uniqueResult()这是一个的结果集
		List<Customer>list=qy.list();
	   System.out.println(list);
	   ts.commit();
	}
	//特定查找？号查找
	@Test
	public void fun3(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		String Hql="from Customer where id=?";
	    //获得操作对象
		Query qy=session.createQuery(Hql);
		//从0开始取数字
		qy.setParameter(0, 1l);//存取特定的
		//qy.uniqueResult()这是一个的结果集
		List<Customer>list=qy.list();
	   System.out.println(list);
	   ts.commit();
	}
	@Test//命名占位符
	public void fun4(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		String Hql="from Customer where id=:cus";
	    //获得操作对象
		Query qy=session.createQuery(Hql);
		qy.setParameter("cus", 2l);//存取特定的
		//qy.uniqueResult()这是一个的结果集
		List<Customer>list=qy.list();
	   System.out.println(list);
	   ts.commit();
	}
	@Test//分页
	public void fun5(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		String Hql="from Customer ";
	    //获得操作对象
		Query qy=session.createQuery(Hql);
	     qy.setFirstResult(0);
	     qy.setMaxResults(2);
		//qy.uniqueResult()这是一个的结果集
		List<Customer>list=qy.list();
	   System.out.println(list);
	   ts.commit();
	 
	}
	//Criteria(Hibernate 自带是数据库查询语言，面对对象)
	@Test//全局查找
	public void fun6(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);//告诉要查询的类的class
		List<Customer> list = criteria.list();
		System.out.println(list+"111");
	     ts.commit();
	  
	}
	@Test//局部特定查找，采用add方法
	public void fun7(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);//告诉要查询的类的class
		criteria.add(Restrictions.eq("cust_id", 2l));
		List<Customer> list = criteria.list();
		System.out.println(list+"111");
	     ts.commit();
	}
	@Test//局部特定查找，采用add方法
	public void fun8(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);//告诉要查询的类的class
	//	criteria.add(Restrictions.eq("cust_id", 2l));
		criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		List<Customer> list = criteria.list();
		System.out.println(list+"111");
	     ts.commit();
	}
	@Test//聚合函数查找
	public void fun8_1(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);//告诉要查询的类的class
	//	criteria.add(Restrictions.eq("cust_id", 2l));
	/*	criteria.setFirstResult(0);
		criteria.setMaxResults(2);
		List<Customer> list = criteria.list();
		System.out.println(list+"111");*/
		criteria.setProjection(Projections.rowCount());
		Long lo = (Long) criteria.uniqueResult();
      System.out.println(lo);
	     ts.commit();
	}
	
	@Test//sql原生的的查找
	public void fun9(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		String sql="select* from cst_customer";
	 SQLQuery querysql = session.createSQLQuery(sql);
	 querysql.addEntity(Customer.class);
	    List<Customer> list = querysql.list();
	    System.out.println(list);
	    ts.commit();
	}
	
	@Test//hql连接查询
	public void fun1_1(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		String hql=" from Customer c inner join c.linkMans";
        Query createQuery = session.createQuery(hql);
        List <Object[]>list = createQuery.list();
        for(Object[]obj:list){
        	System.out.println(Arrays.toString(obj));
        }
	    ts.commit();
	}
	
	@Test//hql连接查询 迫切连接查询
	public void fun1_2(){
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		String hql=" from Customer c inner join  fetch c.linkMans";
        Query createQuery = session.createQuery(hql);
        List <Customer>list = createQuery.list();
        for(Customer cus:list){
        	System.out.println(cus);
        }
	    ts.commit();
	}
	
	/*
	 *离线criteria 操作*/
	@Test
	public void fun1_3(){
	    //------------------------web/service
		//创建离线criteria
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.idEq(2l));
		//把dc穿到dao层中
		//---------------------------
		Session session=HibernateUtils.getcurrentSession();
		Transaction ts = session.beginTransaction();
		//-----------------------------
		//与当前session绑定
		   Criteria criteria = dc.getExecutableCriteria(session);
		   List<Customer> list = criteria.list();
		   System.out.println(list);
	
	    ts.commit();
	}
	@Test
	public void fun1_4(){
		Session session=HibernateUtils.getcurrentSession();
		//--------------------------开启事务
		Transaction tx = session.beginTransaction();
		//从第零位开始
		String hql="from Customer where cust_id=?";
		Query qy = session.createQuery(hql);
		qy.setParameter(0, 3l);
		List <Customer>list = qy.list();
		System.out.println(list);
		
		//事务的提交
		tx.commit();
		
	}
	
}
