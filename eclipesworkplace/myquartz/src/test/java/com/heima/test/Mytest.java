package com.heima.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
	/*
	 * 
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration("classpath:com/heima/springaop/applicationContext.xml")*/
	//要用main方法才可以调度任务
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
	
}
