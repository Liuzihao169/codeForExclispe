package com.heima.a_hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heima.bean.User;

public class Demo {
 @Test
 public void demo(){
	 //������������
	 ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	 //����������Ҫuser
	 User user = (User) ac.getBean("user");
	 User user2 = (User) ac.getBean("user");
	 User user3 = (User) ac.getBean("user");
	 //��ӡuser
	 System.out.println(user3);
	 
	  
 }
 //����ע��
 @Test
 public void demo1(){
	 //������������
	 ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	 User user= (User) ac.getBean("user");
	 System.out.println(user);

 }
//���в����Ĺ��췽��ע��
 @Test
 public void demo2(){
	 ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	 User user= (User) ac.getBean("user1");
	 System.out.println(user);
 }
 /*=====================������������ע��====================================*/
 //�����ע��
 @Test
 public void demo3(){
	 
 }
}
