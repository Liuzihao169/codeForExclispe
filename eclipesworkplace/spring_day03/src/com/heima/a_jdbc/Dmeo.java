package com.heima.a_jdbc;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heima.bean.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
 @RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration("classpath:applicationContext.xml")
public class Dmeo {
	 //此处使用注解出入
	 @Resource(name="dao")
	 private dao daointer;
	@Test
	public void fun1() throws Exception{
		ComboPooledDataSource datasource=new ComboPooledDataSource();
		datasource.setDriverClass("com.mysql.jdbc.Driver");
		datasource.setJdbcUrl("jdbc:mysql:///web10");
		datasource.setUser("root");
		datasource.setPassword("root");
		JdbcTemplate jt=new JdbcTemplate(datasource);
        String sql="INSERT INTO t_user VALUES(NULL,'jack')"	;
        jt.update(sql);
	}
	@Test
	public  void fun2(){
		User user=new User();
		user.setName("tom");
		daointer.save(user);
	}
	@Test
	public  void fun3(){
		daointer.delete(3);
	}
	@Test
	public  void fun4(){
		User user=new User();
		user.setName("mama");
		user.setId(2);
		daointer.update(user);
	}
	@Test
	public  void fun5(){
		User find = daointer.find(2);
		System.out.println(find);
	}
	@Test
	public  void fun6(){
		Integer findAllcount = daointer.findAllcount();
		System.out.println(findAllcount);
	}
	@Test
	public  void fun7(){
		List<User> findall = daointer.findall();
		System.out.println(findall);
	}
	
}
