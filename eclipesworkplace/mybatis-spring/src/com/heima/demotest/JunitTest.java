package com.heima.demotest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heima.dao.mapper.UserMapper;
import com.heima.pojo.User;

public class JunitTest {
	@Test
	public void test(){
		//加载配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	 UserMapper usermapp=(UserMapper) ac.getBean("MapperFactoryBean");
		UserMapper bean = ac.getBean(UserMapper.class);
		 User findbyid = bean.findbyid(1);
		 System.out.println(findbyid);
	}
}
