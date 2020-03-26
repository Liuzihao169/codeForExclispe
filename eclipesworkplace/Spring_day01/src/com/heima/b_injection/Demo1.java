package com.heima.b_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
	 @Test
	 public void demo1(){
		 //创建容器对象
		 ApplicationContext ac= new ClassPathXmlApplicationContext("com/heima/b_injection/applicationContext.xml");
		 CollectionBean cb=(CollectionBean) ac.getBean("collectionBean");
		 System.out.println(cb);
	 }
}
