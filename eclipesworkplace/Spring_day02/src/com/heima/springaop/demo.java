package com.heima.springaop;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heima.service.seviceInter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/heima/springaop/applicationContext.xml")
public class demo {
	@Resource(name="serviceimpl")
	//使用接口声明成员变量 jdk不支持类型注入
	private seviceInter user;
	
	@Test
	public void fun(){
		/*ApplicationContext ac= new ClassPathXmlApplicationContext("com/heima/springaop/applicationContext.xml");
		Serviceimple serv=(Serviceimple) ac.getBean("serviceimpl");*/
              user.save();
             
	}
	

}
