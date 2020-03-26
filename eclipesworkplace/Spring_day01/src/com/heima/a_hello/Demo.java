package com.heima.a_hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heima.bean.User;

public class Demo {
 @Test
 public void demo(){
	 //创建容器对象
	 ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	 //向容器中索要user
	 User user = (User) ac.getBean("user");
	 User user2 = (User) ac.getBean("user");
	 User user3 = (User) ac.getBean("user");
	 //打印user
	 System.out.println(user3);
	 
	  
 }
 //引用注入
 @Test
 public void demo1(){
	 //创建容器对象
	 ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	 User user= (User) ac.getBean("user");
	 System.out.println(user);

 }
//带有参数的构造方法注入
 @Test
 public void demo2(){
	 ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	 User user= (User) ac.getBean("user1");
	 System.out.println(user);
 }
 /*=====================复杂数据类型注入====================================*/
 //数组的注入
 @Test
 public void demo3(){
	 
 }
}
