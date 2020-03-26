package com.heima.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.heima.bean.Orders;
import com.heima.bean.QueryVo;
import com.heima.bean.User;
import com.heima.dao.mapper.OrderMapper;
import com.heima.dao.mapper.UserMapper;

public class MybatisMapperdemotext {
	@Test
	public void mybatiesMapper() throws IOException {
		// 加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 获得sessionFactory
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
		// 获得session
		SqlSession Session = sessionfactory.openSession();
		UserMapper mapper = Session.getMapper(UserMapper.class);
		User user = mapper.findbyid(1);
		System.out.println(user);
	}

	@Test
	public void mybatiesMapper1() throws IOException {
		// 加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 获得sessionFactory
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
		// 获得session
		SqlSession Session = sessionfactory.openSession();
		UserMapper mapper = Session.getMapper(UserMapper.class);

		User u = new User();
		u.setUsername("liummmmmmmmmmm");
		u.setAddress("江西");
		mapper.setuser(u);
		Session.commit();
	}

	@Test
	public void mybatiesMapper2() throws IOException {
		// 加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 获得sessionFactory
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
		// 获得session
		SqlSession Session = sessionfactory.openSession();
		UserMapper mapper = Session.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User u = new User();
		u.setUsername("王");
		vo.setUser(u);
		List<User> list = mapper.findbylikeQueryVo(vo);
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void mybatiesMapper3() throws IOException {
		// 加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 获得sessionFactory
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
		// 获得session
		SqlSession Session = sessionfactory.openSession();
		OrderMapper mapper = Session.getMapper(OrderMapper.class);

		List<Orders> list = mapper.findAllorder();
		for (Orders order : list) {
			System.out.println(order);
		}
	}

	@Test
	public void mybatiesMapper4() throws IOException {
		// 加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 获得sessionFactory
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
		// 获得session
		SqlSession Session = sessionfactory.openSession();
		UserMapper mapper = Session.getMapper(UserMapper.class);
		User u = new User();
	//	u.setSex("1");
		u.setUsername("张小明");
		List<User> list = mapper.findbySexandUsername(u);
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void mybatiesMapper5() throws IOException {
		// 加载配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 获得sessionFactory
		SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
		// 获得session
		SqlSession Session = sessionfactory.openSession();
		UserMapper mapper = Session.getMapper(UserMapper.class);
		QueryVo vo=new QueryVo();
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		vo.setIdsList(list);
		List<User> listuser = mapper.findbyIds(vo);
		for (User user : listuser) {
			System.out.println(user);
		}}
		@Test
		public void mybatiesMapper6() throws IOException {
			// 加载配置文件
			InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
			// 获得sessionFactory
			SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
			// 获得session
			SqlSession Session = sessionfactory.openSession();
			UserMapper mapper = Session.getMapper(UserMapper.class);
			
			List<Integer> list=new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			list.add(3);
			List<User> listuser = mapper.findbyIds(list);
			for (User user : listuser) {
				System.out.println(user);
			}
			
	}	//一对一的查询
		//	<!-- public List<Orders>findOrders(); -->
		@Test
		public void mybatiesMapper7() throws IOException {
			// 加载配置文件
			InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
			// 获得sessionFactory
			SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
			// 获得session
			SqlSession Session = sessionfactory.openSession();
			OrderMapper mapper = Session.getMapper(OrderMapper.class);

			List<Orders> list = mapper.findOrders();
			for (Orders order : list) {
				System.out.println(order);
			}
		}
   //<!-- 	public List <User>findUsers(); -->
		@Test
		public void mybatiesMapper8()throws IOException {
			// 加载配置文件
			InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
			// 获得sessionFactory
			SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
			// 获得session
			SqlSession Session = sessionfactory.openSession();
			UserMapper mapper = Session.getMapper(UserMapper.class);
			
			List<Integer> list=new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			list.add(3);
			List<User> listuser = mapper.findbyIds(list);
			for (User user : listuser) {
				System.out.println(user);
			}}
		@Test
		public void mybatiesMapper9()throws IOException {
				// 加载配置文件
				InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
				// 获得sessionFactory
				SqlSessionFactory sessionfactory = new SqlSessionFactoryBuilder().build(in);
				// 获得session
				SqlSession Session = sessionfactory.openSession();
				UserMapper mapper = Session.getMapper(UserMapper.class);
				List<User> listuser = mapper.findUsers();
				for (User user : listuser) {
					System.out.println(user);
				}}
}
