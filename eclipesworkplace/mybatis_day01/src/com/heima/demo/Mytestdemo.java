package com.heima.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.heima.bean.User;

public class Mytestdemo {
	//通过ID 查询 
	@Test
	public void findNamebyId() throws IOException{
		//加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//获得sessionFactory
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
		//获得session
		SqlSession Session = sessionfactory.openSession();
		//执行sql语句
		 User u = Session.selectOne("text.findbyid", 1);
		 System.out.println(u);
		//然后提交事务
	}
	
	//通过模糊查询  打印结果
	@Test
	public void findbylikename() throws IOException{
		//加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//获得sessionFactory
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
		//获得session
		SqlSession Session = sessionfactory.openSession();
		//执行sql语句
		List<User> list = Session.selectList("text.findbylike", "王");
		for(User u:list){
			System.out.println(u);
		}
		//然后提交事务
	}
	//
	//添加user
		@Test
		public void adduser() throws IOException{
			//加载配置文件
			InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
			//获得sessionFactory
			SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
			//获得session
			SqlSession Session = sessionfactory.openSession();
			 User u=new User();
			 u.setUsername("liu");
			 u.setId(7);
			 u.setAddress("江西");
			 Session.insert("text.adduser", u);
			 Session.commit();
		}
		//返回id
				@Test
				public void adduserCallbackId() throws IOException{
					//加载配置文件
					InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
					//获得sessionFactory
					SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
					//获得session
					SqlSession Session = sessionfactory.openSession();
					 User u=new User();
					 u.setUsername("liuzihao");
					 u.setAddress("江西");
					 Session.insert("text.adduserCallbackId", u);
					 Session.commit();
					 System.out.println(u.getId());
				}
	//更新操作
				@Test
				public void updateuser() throws IOException{
					//加载配置文件
					InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
					//获得sessionFactory
					SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
					//获得session
					SqlSession Session = sessionfactory.openSession();
					
					 User u=new User();
					 u.setId(28);
					 u.setUsername("liuzihao282828");
					 u.setAddress("江西2222222");
					 Session.update("text.updateuser", u);
					 Session.commit();
				}	
				
		//删除
				@Test
				public void deleteuser() throws IOException{
					//加载配置文件
					InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
					//获得sessionFactory
					SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
					//获得session
					SqlSession Session = sessionfactory.openSession();
					
					Session.delete("text.deleteuser", 28);
					 Session.commit();
				}		
}
