package com.heima.a_annotion;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heima.bean.User;
//获得容器applicationContext容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定默认加载的配置文件applicationcontext.xml
@ContextConfiguration("classpath:applicationContext.xml")
public class demo {
	//将user注入到user中
	@Resource(name="user")
	private User user;
	@Test
	public void fun(){
		//要使用子类才会close构造方法
		System.out.println(user);
	}

}
