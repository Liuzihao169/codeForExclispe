package com.heima.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.heima.client.HelloService;

public class sayHelloDemo {
		public static void main(String[] args) {
			ApplicationContext cxf=new ClassPathXmlApplicationContext("cxf.xml");
			HelloService proxy = (HelloService) cxf.getBean("myClient");
			String sayHello = proxy.sayHello("�Һ���ô�Һ�");
			System.out.println(sayHello);
		}
}
