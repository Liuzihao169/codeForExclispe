package day25.Proxy.target;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class Proxttext {
 @Test
 		public void text(){
	      
	 //��ö�̬����
	 Targetintetfence obj =(Targetintetfence) Proxy.newProxyInstance(
				Target.class.getClassLoader(), 
				new Target().getClass().getInterfaces(), 
				//new Class[]{Targetintetfence.class},
				new InvocationHandler(){//ʵ��Ҫ���õķ���
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					// TODO Auto-generated method stub/*
					
					
					/*invoke �Ǵ���ִ�д������ķ���
					 * 1.method ����Ŀ�������ֽ������
					 * 2.args����Ŀ�귽���Ĳ���*/
					System.out.println("���Ǵ���");
					//ִ��Ŀ����󷽷�
					 method.invoke(new Target(), args);
					return null;
				}});    
	 				
	         obj.mehtod1("niiubi");//����ʵ��ͬһ�ӿڵĴ���ķ�����
	 
		 }
		}
