package com.heima.demotest;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heima.mapper.UserMapper;
import com.heima.pojo.User;
import com.heima.pojo.UserExample;

public class JunitTest {
	@Test
	public void test(){
		//加载配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	//	 UserMapper usermapp=(UserMapper) ac.getBean("MapperFactoryBean");
		 UserMapper usemapper=ac.getBean(UserMapper.class);
		 UserExample userexample=new UserExample();
		 //String name="明";
		 userexample.createCriteria().andUsernameLike("%明%");
		 //可以任意的拼接条件
		 int countByExample = usemapper.countByExample(userexample);
		 System.out.println(countByExample);
				 
		  
	/*	  for(User user:selectByExample){
		 System.out.println(user);
	}
		*/  }
}
